package Create_table;
import java.sql.*;

public class C_Program
{
	public static void main(String args[])
	{
		Connection con = null;
        Statement stmt = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
			"jdbc:mysql://192.168.56.102:4567/Leisure_reserve","DBuser","1234");
			stmt = con.createStatement();
			
			StringBuffer sql = new StringBuffer();
			sql.append("create table Program");
			sql.append("(P_name VARCHAR(40),"); 
			sql.append("P_date DATE NOT NULL,");
			sql.append("Address VARCHAR(40) NOT NULL,"); 
			sql.append("Time TIME NOT NULL,"); 
			sql.append("Price VARCHAR(40) NOT NULL,"); 
			sql.append("Information TEXT,");
			sql.append("PRIMARY KEY (P_name))");
			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}