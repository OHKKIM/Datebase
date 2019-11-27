package Insert_table;
import java.sql.*;

public class I_Reserve
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
			sql.append("insert into Reserve(R_num, R_date, U_id, P_name)");
			sql.append("values (1, '2020-07-21', 'rlawpdud', '울산바위 패들보드')"); 

			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}