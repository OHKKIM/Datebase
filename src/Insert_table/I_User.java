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
			sql.append("values ('rlawpdud', 'kim', '������', '010-3232-9797'),"); 
			sql.append("('qkrtlsgud', 'park', '�ڽ���', '010-5454-7878'),");
			sql.append("('dkswpgus', 'ahn', '������', '010-5959-8253'),"); 
			sql.append("('rlawlsdh', 'kim', '������', '010-4646-0202'),");
			sql.append("('dldmsxor', 'lee', '������', '010-1616-2020'),");
			sql.append("('dltkddnr', 'lee', '�̻��', '010-6868-3535'),");
			sql.append("('rlasmdghks', 'kim', '���ȯ', '010-9494-2323'),");
			sql.append("('shtjdud', 'ro', '�뼭��', '010-9494-5353'),");
			sql.append("('rlatjdqls', 'kim', '�輺��', '010-8383-4040'),");
			sql.append("('rlackdgus', 'kim', '��â��', '010-1717-6161')");
			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}