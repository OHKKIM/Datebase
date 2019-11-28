package Insert_table;
import java.sql.*;

public class I_Staff
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
			sql.append("insert into Staff(S_name, Birth, F_name)");
			sql.append("values ('김민준', '1985-12-05', '목포요트마리나'),"); 
			sql.append("('신서연', '1989-04-17', '목포요트마리나'),");
			sql.append("('박서준', '1983-04-25', '아라마리나'),"); 
			sql.append("('지서윤', '1984-11-14', '아라마리나'),");
			sql.append("('이예준', '1977-05-22', '거북선나루터'),");
			sql.append("('추지우', '1980-07-17', '거북선나루터'),");
			sql.append("('홍도윤', '1980-11-20', '향호활동장'),");
			sql.append("('김서현', '1980-05-08', '향호활동장'),");
			sql.append("('남시우', '1981-10-31', '남강체험장'),");
			sql.append("('방민서', '1980-09-02', '남강체험장'),");
			sql.append("('노주원', '1979-05-12', '낙단보수상레저센터'),");
			sql.append("('최하은', '1985-02-06', '낙단보수상레저센터'),");
			sql.append("('서지호', '1982-07-04', '상주보수상레저센터'),");
			sql.append("('소하윤', '1984-01-31', '상주보수상레저센터'),");
			sql.append("('전하준', '1981-02-19', '광안리상설카약체험장'),");
			sql.append("('송윤서', '1981-02-23', '광안리상설카약체험장'),");
			sql.append("('도지후', '1987-09-01', '달성보통합관리센터'),");
			sql.append("('유지민', '1990-06-11', '달성보통합관리센터'),");
			sql.append("('안준서', '1985-08-04', '용두레저센터'),");
			sql.append("('김지유', '1994-11-06', '용두레저센터'),");
			sql.append("('유준우', '1982-07-03', '율포레저센터'),");
			sql.append("('도채원', '1983-04-15', '율포레저센터'),");
			sql.append("('송현우', '1975-10-11', '송도상설카약체험장'),");
			sql.append("('송현우', '1975-10-11', '송도상설카약체험장'),");
			sql.append("('소지훈', '1982-02-28', '수영강상설카약체험장'),");
			sql.append("('전지윤', '1986-01-21', '수영강상설카약체험장'),");
			sql.append("('최도현', '1988-05-05', '삼락수상레포츠타운'),");
			sql.append("('서은서', '1991-04-05', '삼락수상레포츠타운'),");
			sql.append("('방건우', '1987-01-01', '세종호수공원문화복합시설'),");
			sql.append("('노수아', '1990-10-19', '세종호수공원문화복합시설'),");
			sql.append("('김우진', '1979-06-24', '울주해양레포츠센터'),");
			sql.append("('남예원', '1989-04-29', '울주해양레포츠센터'),");
			sql.append("('추민재', '1990-08-06', '아라서해갑문인증센터'),");
			sql.append("('홍다은', '1990-05-27', '아라서해갑문인증센터'),");
			sql.append("('지현준', '1989-08-09', '해양베스트관'),");
			sql.append("('이예은', '1989-01-12', '해양베스트관'),");
			sql.append("('신선우', '1987-11-28', '보트하우스'),");
			sql.append("('박수빈', '1987-06-08', '보트하우스')");
	
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}