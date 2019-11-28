import java.sql.*;

import java.util.Scanner;

public class index
{
	public static Connection con = null;
	public static Statement stmt = null;
	public static String ID = null;
	public static String PW = null;
	public static int R_cnt = 0;
	public static Scanner str_scan = new Scanner(System.in);
	public static Scanner line_scan = new Scanner(System.in);
	public static Scanner int_scan = new Scanner(System.in);
	
	private static void init() throws Exception {
    	
		try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
			"jdbc:mysql://192.168.56.102:4567/Leisure_reserve","DBuser","1234");
			stmt = con.createStatement();
        }catch(Exception e){ System.out.println(e);}
    }

	public static void main(String[] args) throws Exception {
	    init();
	    	
	    String num = "0";
	    
	    while (true) {
	    	try{
		    	System.out.println("\n");
		    	System.out.println("+-----------------------------+-----------------------------+");
		    	System.out.printf("|       User = %-15s|       Reservations = %-7d|\n", ID, R_cnt);
		    	System.out.println("+-----------------------------+-----------------------------+");
		    	System.out.println(" 1. Login 			6. Leisure Sport list");
		    	System.out.println(" 2. Logout			7. Region list");
		    	System.out.println(" 3. My information		8. Reserve");
		    	System.out.println(" 4. Leisure Program list	9. Cancel");
		    	System.out.println(" 5. Leisure Facility list	10. Reservation Information");
		    	System.out.println(" 				99. Reservation Information");
		        System.out.println("+-----------------------------------------------------------+");
		    	System.out.print(" Enter Function : ");
		
		        num = line_scan.nextLine();
		    	
		        switch (num) {
		        case "1":
		        	if(ID!=null & PW!=null) {
		        		System.out.println(" Already Login! ");
		        	} else {
		        		System.out.print(" ID : ");
			            String t_ID=str_scan.next();
			            System.out.print(" PW : ");
			            String t_PW=str_scan.next();
			            Login(t_ID, t_PW);
		        	}
		            break;
		        case "2":
		            Logout();
		            break;
		        case "3":
		            My_info();
		            break;
		        case "4":
		            Program();
		            break;   
		        case "5":
		            Facility();
		            break;
		        case "6":
		            Leisure();
		            break;
		        case "7":
		            Address();
		            break;
		        case "8":
		        	System.out.print(" Program name : ");
		            String P_name=line_scan.nextLine();
		        	System.out.print(" Reservation personnel : ");
		            int R_num=int_scan.nextInt();
		            Reserve(P_name, R_num);
		            break;
		        case "9":
		        	Cancel();
		            break;
		        case "10":
		        	Reservation_Infor();
		            break;
		        case "99":
		        	System.out.println(" Terminate program! ");
		        	System.exit(0);
		            break;
		        default:
		        	System.out.println(" Invalid input! ");
		        	break;
		        }
	    	}catch(Exception e){ System.out.println(e);}
	    }
	}
	
	public static void Login(String t_ID, String t_PW) {
		
		try{
	    	StringBuffer sql = new StringBuffer();
	    	StringBuffer sql2 = new StringBuffer();
	    	StringBuffer sql3 = new StringBuffer();
	    	String c_ID = null;
	    	String c_PW = null;
	    		    	
		    sql.append("select U_id from User where U_id = \""+t_ID+ "\" ");
		    ResultSet rs=stmt.executeQuery(sql.toString());
		    while(rs.next())
		    	c_ID = rs.getString("U_id");
		    		   
			sql2.append("select Pw from User where U_id = \""+t_ID+"\";");
			rs=stmt.executeQuery(sql2.toString());
			while(rs.next())
				c_PW = rs.getString("Pw");
			System.out.println("+---------------+");
			if(c_ID!=null) {    
				if(c_PW.equals(t_PW)) { 
					ID = t_ID;
					PW = t_PW;
					sql3.append("select count(*) from Reserve where U_id = \""+c_ID+ "\" ");
				    rs=stmt.executeQuery(sql3.toString());
				    while(rs.next())
				    	R_cnt = rs.getInt(1);
					System.out.println(" Login Success! ");
				}
				else { System.out.println(" Wrong PASSWORD! ");}
			}
			else { System.out.println(" Wrong ID! ");}
			System.out.println("+---------------+");
			
		    rs.close();
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void Logout() {
		
		try{
			System.out.println("+---------------+");
	    	if(ID==null & PW==null) System.out.println(" Not logged in! Please Login! ");
	    	else {
				ID = null;
		    	PW = null;
		    	if(ID==null) {
		    		if(PW==null) {
		    			System.out.println(" Logout Success! ");
		    			R_cnt = 0;}
		    		else
		    			System.out.println(" PW init failed! ");
		    	}else { System.out.println(" ID init failed! ");}
	    	}
	    	System.out.println("+---------------+");
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void My_info() {
		   
		try{
			String Yes;
			String Change;
			
			if(ID!=null) {
				StringBuffer sql = new StringBuffer();
				StringBuffer sql2 = new StringBuffer();
		        
		    	sql.append("select * from User where U_id = \""+ID+"\"");
		        ResultSet rs=stmt.executeQuery(sql.toString());
		        
		        System.out.println("+-----------------------------------------------+");
		        System.out.println(" U_id\t\tPw\tU_name\tU_phone");
		        System.out.println("+-----------------------------------------------+");
		        while(rs.next())
		        	System.out.printf(" %-12s	%-5s	%-5s	%s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
		        
		        System.out.println("+-----------------------------------------------+");
		        System.out.print(" Do you want to change your phone number? [y/n] ");
		        Yes = str_scan.next();
		        
		        if(Yes.equals("y")) {
		        	System.out.print(" Phone number to change : ");
			        Change = line_scan.nextLine();
		        	sql2.append("Update User set U_phone = \""+Change+"\"where U_id = \""+ID+"\"");
			        stmt.executeUpdate(sql2.toString());
			        System.out.println("+-----------------------------------------------+");
			        System.out.println(" Change Success! ");
		        }
		        else { System.out.println(" Not Change! ");}
		              
		        rs.close();
			}else { System.out.println(" Please Login! ");}
			System.out.println("+-----------------------------------------------+");
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void Program() {
	   
		try{
			String Yes;
			String Watch;
			StringBuffer sql = new StringBuffer();
			StringBuffer sql2 = new StringBuffer();
			
	    	sql.append("select * from Program");
	        ResultSet rs=stmt.executeQuery(sql.toString());
	        
	        System.out.println("+-------------------------------------------------------------+");
	        System.out.println(" Program name\tDate\t\tAddress\tTime\t\tprice");
	        System.out.println("+-------------------------------------------------------------+");
	        while(rs.next())
	        	System.out.printf(" %-10s	%-10s	%s	%-10s	%-10s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
	        			rs.getString(5), rs.getString(6));
	        
	        System.out.println("+----------------------------------------------------------------------+");
	        System.out.print(" Do you want to see what facility the program is at? [y/n] ");
	        Yes = str_scan.next();
	        
	        if(Yes.equals("y")) {
	        	System.out.print(" Program name : ");
		        Watch = line_scan.nextLine();
	        	sql2.append("select * from Facility where F_name =");
	        	sql2.append("any(select F_name from Manages where P_name =");
	        	sql2.append("any(select P_name from Program where P_name = \""+Watch+"\"))");
		        rs=stmt.executeQuery(sql2.toString());
		        
		        System.out.println("+----------------------------------------------------------------------+");
		        System.out.println(" Facility name\t\tAddress\t\t\t\tFacility phone");
		        System.out.println("+----------------------------------------------------------------------+");
		        while(rs.next())
		        	System.out.printf(" %-26s	%-25s	%-10s\n", rs.getString(1), rs.getString(2), rs.getString(3));
		        System.out.println("+----------------------------------------------------------------------+");
	        }
	        else { System.out.println("+----------------------------------------------------------------------+");}
	        
	        rs.close();
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void Facility() {
		   
		try{
			String Yes;
			String Watch;
			StringBuffer sql = new StringBuffer();
			StringBuffer sql2 = new StringBuffer();
	        
	    	sql.append("select * from Facility");
	        ResultSet rs=stmt.executeQuery(sql.toString());
	        
	        System.out.println("+----------------------------------------------------------------------+");
	        System.out.println(" Facility name\t\tAddress\t\t\t\tFacility phone");
	        System.out.println("+----------------------------------------------------------------------+");
	        while(rs.next())
	        	System.out.printf(" %-26s	%-25s	%-10s\n", rs.getString(1), rs.getString(2), rs.getString(3));
	        
	        System.out.println("+----------------------------------------------------------------------+");
	        System.out.print(" Do you want to see the staff working in the facility? [y/n] ");
	        Yes = str_scan.next();
	        
	        if(Yes.equals("y")) {
	        	System.out.print(" Facility name : ");
		        Watch = line_scan.nextLine();
	        	sql2.append("select S_name, Birth from Staff where F_name = \""+Watch+"\"");
		        rs=stmt.executeQuery(sql2.toString());
		        
		        System.out.println("+--------------------+");
		        System.out.println(" name\tBirth");
		        System.out.println("+--------------------+");
		        while(rs.next())
		        	System.out.printf(" %-5s	%s\n", rs.getString(1), rs.getString(2));
		        System.out.println("+--------------------+");
	        }
	        else { System.out.println("+----------------------------------------------------------------------+");}
	        
	        rs.close();
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void Leisure() {
		   
		try{
			StringBuffer sql = new StringBuffer();
	        
	    	sql.append("select distinct Event, Limit_num from Leisure");
	        ResultSet rs=stmt.executeQuery(sql.toString());
	       
	        System.out.println("+------------------------+");
	        System.out.println(" Leisure event\tLimit_num");
	        System.out.println("+------------------------+");
	        while(rs.next())
	        	System.out.printf(" %-15s	%-2s\n", rs.getString(1), rs.getString(2));
	        System.out.println("+------------------------+");
	        
	        rs.close();
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void Address() {
		   
		try{
			StringBuffer sql = new StringBuffer();
	        
	    	sql.append("select distinct Address from Program");
	        ResultSet rs=stmt.executeQuery(sql.toString());
	        
	        System.out.println("+-------+");
	        System.out.println(" Region");
	        System.out.println("+-------+");
	        while(rs.next())
	        	System.out.printf(" %-5s\n", rs.getString(1));
	        System.out.println("+-------+");
	        
	        rs.close();
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void Reserve(String t_P_name, int R_num) {
		   
		try{
	    	if(ID!=null) {
				StringBuffer sql = new StringBuffer();
		    	StringBuffer sql2 = new StringBuffer();
		    	StringBuffer sql3 = new StringBuffer();
		    	StringBuffer sql4 = new StringBuffer();
		    	String c_P_name = null;
		    	String t_P_date = null;
		    	
		    	sql.append("select P_name from Program where P_name = \""+t_P_name+"\"");
		        ResultSet rs=stmt.executeQuery(sql.toString());
		        while(rs.next())
		        	c_P_name = rs.getString("P_name");
		        
		        if(c_P_name!=null) {
		        	System.out.println("+-------------------------------------------------------------+");
		        	System.out.println(" Selected program");
		        	System.out.println("+-------------------------------------------------------------+");
		        	System.out.println(" Program name\tDate\t\tAddress\tTime\t\tprice");		       
			    	System.out.println("+-------------------------------------------------------------+");
			    	sql2.append("select * from Program where P_name = \""+c_P_name+"\"");
			        rs=stmt.executeQuery(sql2.toString());
			    	while(rs.next())
			        	System.out.printf(" %-10s	%-10s	%s	%-10s	%-10s\n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
			        			rs.getString(5), rs.getString(6));
			    	System.out.println("--------------------------------------------------------------+");
			    	
			    	sql3.append("select P_date from Program where P_name = \""+c_P_name+"\"");
			        rs=stmt.executeQuery(sql3.toString());
			        while(rs.next())
			        	t_P_date = rs.getString("P_date");
			        
			        sql4.append("insert into Reserve(R_num, R_date, U_id, P_name)");
			        sql4.append("values (\""+R_num+"\", \""+t_P_date+"\", \""+ID+"\", \""+c_P_name+"\")");
			        stmt.executeUpdate(sql4.toString());
			        System.out.println(" Reserve Success! ");
			        R_cnt++;
		        }
		        else { System.out.println(" Wrong Program name! ");}
		        
		        rs.close();
	    	}
	    	else { System.out.println(" Please Login! ");}
	        	        
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void Cancel() {
		   
		try{
			String Choice;
			String c_Choice = null;
			
	    	if(ID!=null) {
	    		if(R_cnt != 0) {
		    		StringBuffer sql = new StringBuffer();
			    	StringBuffer sql2 = new StringBuffer();
			    	StringBuffer sql3 = new StringBuffer();
			    	
			    	sql.append("select P_name, R_date, R_num from Reserve where U_id = \""+ID+"\"");
			        ResultSet rs=stmt.executeQuery(sql.toString());
			        
			        System.out.println("+-----------------------------------------------+");
			        System.out.println(" Reservation information !! Cancel !!");
			        System.out.println("+-----------------------------------------------+");
			        System.out.println(" Name	 	Date		Number of people");
			        System.out.println("+-----------------------------------------------+");
			        while(rs.next())
				        System.out.printf(" %-10s	%-10s	%-2s\n", rs.getString(1), rs.getString(2), rs.getString(3));
			    	
			        System.out.println("+-----------------------------------------------+");
			        System.out.print(" Program name to cancel : ");
			        Choice = line_scan.nextLine();
			        sql2.append("select P_name from Reserve");
			        sql2.append(" where U_id = \""+ID+"\" and P_name = \""+Choice+"\"");
			        rs=stmt.executeQuery(sql2.toString());
			        while(rs.next())
			        	c_Choice = rs.getString("P_name");
			        
			        if(c_Choice != null) {
					    sql3.append("delete from Reserve");
					    sql3.append("where U_id = \""+ID+"\" and P_name = \""+Choice+"\"");
					    stmt.executeUpdate(sql3.toString());
					    System.out.println(" Cancel Success! ");
					    R_cnt--;
			    		
					    rs.close();
			        } else { System.out.println(" Wrong Program name! ");}
	    		} else { System.out.println(" No Reservation History! ");}
	    	}else { System.out.println(" Please Login! ");}
	    	
		}catch(Exception e){ System.out.println(e);}
	}
	
	public static void Reservation_Infor() {
		   
		try{
			if(ID!=null) {
		    	StringBuffer sql = new StringBuffer();
		    	StringBuffer sql2 = new StringBuffer();
		    	
		    	sql.append("select P_name, R_date, R_num from Reserve where U_id = \""+ID+"\"");
		        ResultSet rs=stmt.executeQuery(sql.toString());
		        
		        System.out.println("+-----------------------------------------------+");
		        System.out.println(" Reservation information");
		        System.out.println("+-----------------------------------------------+");
		        System.out.println(" Name	 	Date		Number of people");
		        System.out.println("+-----------------------------------------------+");
	        	while(rs.next())
			        System.out.printf(" %-10s	%-10s	%-2s\n", rs.getString(1), rs.getString(2), rs.getString(3));
	        	
	        	System.out.println("+-----------------------------------------------+");
	        	sql2.append("select sum(Price) from Program where P_name = ");
	        	sql2.append("any(select P_name from Reserve where U_id = \""+ID+"\")");
		        rs=stmt.executeQuery(sql2.toString());
		        while(rs.next())
			        System.out.println(" Total price : "+rs.getInt(1)+"¿ø");
			        		
	        	rs.close();
			}
	    	else { System.out.println(" Please Login! ");}
			
		}catch(Exception e){ System.out.println(e);}
	}
} 