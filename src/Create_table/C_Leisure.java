package Create_table;
import java.sql.*;

public class C_Leisure
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
			sql.append("create table Leisure");
			sql.append("(Event VARCHAR(40) NOT NULL,"); 
			sql.append("Limit_num INT(100) NOT NULL,");
			sql.append("P_name VARCHAR(40) NOT NULL,");
			sql.append("PRIMARY KEY (Event, P_name),");
			sql.append("FOREIGN KEY (P_name) REFERENCES Program (P_name))");
			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}