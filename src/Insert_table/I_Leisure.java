package Insert_table;
import java.sql.*;

public class I_Leisure
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
			sql.append("insert into Leisure(Event, Limit_num, P_name)");
			sql.append("values ('ũ�����Ʈ', 8, '���� ũ�����Ʈ'),"); 
			sql.append("('ũ�����Ʈ', 8, '��4 ũ�����Ʈ'),");
			sql.append("('ũ�����Ʈ', 8, '�Ѱ� ũ�����Ʈ'),"); 
			sql.append("('�����Ʈ', 2, '���� ����'),");
			sql.append("('ī��', 1, '���� ī��'),");
			sql.append("('ī��', 1, 'ī�� ����'),");
			sql.append("('ī��', 1, '�� ī��Ÿ������'),");
			sql.append("('ī��', 1, '���ִ� ī��'),");
			sql.append("('ī��', 1, '���ȴ뱳�� ī����'),");
			sql.append("('ī��', 1, '������ī��'),");
			sql.append("('ī��', 1, '���� ī��'),");
			sql.append("('ī��', 1, '������ ī��'),");
			sql.append("('ī��', 1, '��ī�൵'),");
			sql.append("('ī��', 1, '������ ī��'),");
			sql.append("('ī��', 1, '�������� ī��'),");
			sql.append("('ī��', 1, 'ī���̷α���'),");
			sql.append("('ī��', 1, '������ ī��'),");
			sql.append("('ī��', 1, '����� ī��õ'),");
			sql.append("('ī��', 1, 'EXPO ī��'),");
			sql.append("('ī��', 1, '���� ź ī��'),");
			sql.append("('����Ʈ', 8, '���ڰ���Ʈ'),");
			sql.append("('����Ʈ', 8, '���ִ� ����Ʈ'),");
			sql.append("('����Ʈ', 8, '������ī����Ʈ'),");
			sql.append("('����Ʈ', 8, '������ ����Ʈ'),");
			sql.append("('����Ʈ', 8, '�۰���Ʈ��'),");
			sql.append("('����Ʈ', 8, '�����ϵ��ٺ�Ʈ'),");
			sql.append("('����Ʈ', 8, '������ ����Ʈ'),");
			sql.append("('����Ʈ', 8, '����� ����Ʈõ'),");
			sql.append("('����Ʈ', 8, '���� ź ����Ʈ'),");
			sql.append("('����Ʈ', 8, '�Ѱ� ����Ʈ'),");
			sql.append("('�е麸��', 1, '���ִ� �е麸��'),");
			sql.append("('�е麸��', 1, '������ī�е麸��'),");
			sql.append("('�е麸��', 1, '������ �е麸��'),");
			sql.append("('�е麸��', 1, '������ �е麸��'),");
			sql.append("('�е麸��', 1, '���� ź �е麸��'),");
			sql.append("('����������', 2, '���ִ� ����������'),");
			sql.append("('����������', 2, '�����������'),");
			sql.append("('����������', 2, '����� ����������õ'),");
			sql.append("('����ŷ��Ʈ', 12, '������ ����ŷ��Ʈ'),");
			sql.append("('���ͺ�Ʈ', 1, '����� ���ͺ�Ʈõ')");
			
			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}