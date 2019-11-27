package Create_table;
import java.sql.*;

public class C_User
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
			sql.append("create table User");
			sql.append("(U_id VARCHAR(40),"); 
			sql.append("Pw VARCHAR(40) NOT NULL,");
			sql.append("U_name VARCHAR(40) NOT NULL,"); 
			sql.append("U_phone VARCHAR(40) NOT NULL,");
			sql.append("PRIMARY KEY (U_id))");
			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}