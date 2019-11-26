package Create_table;
import java.sql.*;

public class Facility
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
			sql.append("create table Facility");
			sql.append("(F_name VARCHAR(40),"); 
			sql.append("Address VARCHAR(40) NOT NULL,");
			sql.append("F_phone VARCHAR(40) NOT NULL,");
			sql.append("PRIMARY KEY (F_name))");

			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}