package Insert_table;
import java.sql.*;

public class I_Manages
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
			sql.append("insert into Manages(F_name, P_name)");
			sql.append("values ('�źϼ�������', '�Ѱ� ũ�����Ʈ'),"); 
			sql.append("('�źϼ�������', '�Ѱ� ����Ʈ'),");
			sql.append("('���ȸ���ī��ü����', '���ȴ뱳�� ī����'),"); 
			sql.append("('���ܺ�����������', '�� ī��Ÿ������'),");
			sql.append("('����ü����', 'ī�� ����'),");
			sql.append("('�޼������հ�������', '������ī��'),");
			sql.append("('�޼������հ�������', '������ī����Ʈ'),");
			sql.append("('�޼������հ�������', '������ī�е麸��'),");
			sql.append("('������Ʈ������', '���� ũ�����Ʈ'),");
			sql.append("('��Ʈ�Ͽ콺', '���� ź ī��'),");
			sql.append("('��Ʈ�Ͽ콺', '���� ź ����Ʈ'),");
			sql.append("('��Ʈ�Ͽ콺', '���� ź �е麸��'),");
			sql.append("('�����������Ÿ��', '�������� ī��'),");
			sql.append("('���ֺ�����������', '���ִ� ī��'),");
			sql.append("('���ֺ�����������', '���ִ� ����Ʈ'),");
			sql.append("('���ֺ�����������', '���ִ� �е麸��'),");
			sql.append("('���ֺ�����������', '���ִ� ����������'),");
			sql.append("('����ȣ��������ȭ���սü�', 'ī���̷α���'),");
			sql.append("('����ȣ��������ȭ���սü�', '�����ϵ��ٺ�Ʈ'),");
			sql.append("('����ȣ��������ȭ���սü�', '�����������'),");
			sql.append("('�۵���ī��ü����', '��ī�൵'),");
			sql.append("('�۵���ī��ü����', '�۰���Ʈ��'),");
			sql.append("('��������ī��ü����', '������ ī��'),");
			sql.append("('��������ī��ü����', '������ ����ŷ��Ʈ'),");
			sql.append("('�ƶ󸶸���', '��4 ũ�����Ʈ'),");
			sql.append("('�ƶ��ذ�����������', '����� ī��õ'),");
			sql.append("('�ƶ��ذ�����������', '����� ����Ʈõ'),");
			sql.append("('�ƶ��ذ�����������', '����� ����������õ'),");
			sql.append("('�ƶ��ذ�����������', '����� ���ͺ�Ʈõ'),");
			sql.append("('��η�������', '���� ī��'),");
			sql.append("('�����ؾ緹��������', '������ ī��'),");
			sql.append("('�����ؾ緹��������', '������ ����Ʈ'),");
			sql.append("('�����ؾ緹��������', '������ �е麸��'),");
			sql.append("('������������', '������ ī��'),");
			sql.append("('������������', '������ ����Ʈ'),");
			sql.append("('������������', '������ �е麸��'),");
			sql.append("('�ؾ纣��Ʈ��', 'EXPO ī��'),");
			sql.append("('��ȣȰ����', '���� ����'),");
			sql.append("('��ȣȰ����', '���� ī��'),");
			sql.append("('��ȣȰ����', '���ڰ���Ʈ')");
			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}