import java.sql.*;
import java.util.Scanner;

public class index
{
    private static void init() throws Exception {
    	Connection con = null;
        Statement stmt = null;
    	try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
			"jdbc:mysql://192.168.56.102:4567/Leisure_reserve","DBuser","1234");
			stmt = con.createStatement();
        }catch(Exception e){ System.out.println(e);}
    }

	public static void main(String[] args) throws Exception
	{
	    init();
	    Scanner menu = new Scanner(System.in);
	    Scanner id_string = new Scanner(System.in);
	
	    int num = 0;
	    String str;
	
	    while (true) {
	    	System.out.println(" 1. select test ");
	        System.out.println("------------------------------------------------------------");
	    	System.out.print("Enter Function :");
	
	        num = menu.nextInt();
	       
	        switch (num) {
	        case 1:
	            System.out.println("레저별 프로그램 선택 : ");
	            str=id_string.next();
	            select_test(str);
	            break;
	
	        }
	    }
	}
	
	public static void select_test(String str) {
		
	    try{
	    	Connection con = null;
	        Statement stmt = null;
	    	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
			"jdbc:mysql://192.168.56.102:4567/Leisure_reserve","DBuser","1234");
			stmt = con.createStatement();
	       
	        StringBuffer sql = new StringBuffer();
	        //sql.append("select MovieName from Movie where MovieNum =(select TheaterNum from Screening where MovieNum =(select TheaterNum from Theater where T_Name = " + "\"Chungju_CBNU\""+" ))");
	        sql.append("select P_name, information from Program\r\n" + 
	        		"where P_name = any(select P_name from Leisure where Event = \""+str+"\") ");
	        ResultSet rs=stmt.executeQuery(sql.toString());
	       
	        while(rs.next())
	        System.out.println(rs.getString("P_name")+"	"+rs.getString("Information"));
	       
	        con.close();
	       }catch(Exception e){ System.out.println(e);}
	}
} 