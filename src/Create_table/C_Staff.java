package Create_table;
import java.sql.*;

public class C_Staff
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
			sql.append("create table Staff");
			sql.append("(S_id INT(100) AUTO_INCREMENT,"); 
			sql.append("S_name VARCHAR(40) NOT NULL,");
			sql.append("Birth DATE NOT NULL,");
			sql.append("F_name VARCHAR(40) NOT NULL,");
			sql.append("PRIMARY KEY (S_id),");
			sql.append("FOREIGN KEY (F_name) REFERENCES Facility (F_name))");

			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}