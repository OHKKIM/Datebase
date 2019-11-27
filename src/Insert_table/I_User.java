package Insert_table;
import java.sql.*;

public class I_User
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
			sql.append("insert into User(U_id, pw, U_name, U_phone)");
			sql.append("values ('rlawpdud', 'kim', '김제영', '010-3232-9797'),"); 
			sql.append("('qkrtlsgud', 'park', '박신형', '010-5454-7878'),");
			sql.append("('dkswpgus', 'ahn', '안제현', '010-5959-8253'),"); 
			sql.append("('rlawlsdh', 'kim', '김진오', '010-4646-0202'),");
			sql.append("('dldmsxor', 'lee', '이은택', '010-1616-2020'),");
			sql.append("('dltkddnr', 'lee', '이상욱', '010-6868-3535'),");
			sql.append("('rlasmdghks', 'kim', '김능환', '010-9494-2323'),");
			sql.append("('shtjdud', 'ro', '노서영', '010-9494-5353'),");
			sql.append("('rlatjdqls', 'kim', '김성빈', '010-8383-4040'),");
			sql.append("('rlackdgus', 'kim', '김창현', '010-1717-6161')");
			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}