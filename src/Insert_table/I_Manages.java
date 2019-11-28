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
			sql.append("values ('거북선나루터', '한강 크루즈요트'),"); 
			sql.append("('거북선나루터', '한강 고무보트'),");
			sql.append("('광안리상설카약체험장', '광안대교와 카약을'),"); 
			sql.append("('낙단보수상레저센터', '마 카약타러가자'),");
			sql.append("('남강체험장', '카주 진약'),");
			sql.append("('달성보통합관리센터', '대프리카약'),");
			sql.append("('달성보통합관리센터', '대프리카고무보트'),");
			sql.append("('달성보통합관리센터', '대프리카패들보드'),");
			sql.append("('목포요트마리나', '세발 크루즈요트'),");
			sql.append("('보트하우스', '내가 탄 카약'),");
			sql.append("('보트하우스', '내가 탄 고무보트'),");
			sql.append("('보트하우스', '내가 탄 패들보드'),");
			sql.append("('삼락수상레포츠타운', '세가지맛 카약'),");
			sql.append("('상주보수상레저센터', '상주는 카약'),");
			sql.append("('상주보수상레저센터', '상주는 고무보트'),");
			sql.append("('상주보수상레저센터', '상주는 패들보드'),");
			sql.append("('상주보수상레저센터', '상주는 수상자전거'),");
			sql.append("('세종호수공원문화복합시설', '카약이로구나'),");
			sql.append("('세종호수공원문화복합시설', '고무엄하도다보트'),");
			sql.append("('세종호수공원문화복합시설', '수라상자전거'),");
			sql.append("('송도상설카약체험장', '송카약도'),");
			sql.append("('송도상설카약체험장', '송고무보트도'),");
			sql.append("('수영강상설카약체험장', '수영강 카약'),");
			sql.append("('수영강상설카약체험장', '수영강 바이킹보트'),");
			sql.append("('아라마리나', '김4 크루즈요트'),");
			sql.append("('아라서해갑문인증센터', '사람인 카약천'),");
			sql.append("('아라서해갑문인증센터', '사람인 고무보트천'),");
			sql.append("('아라서해갑문인증센터', '사람인 수상자전거천'),");
			sql.append("('아라서해갑문인증센터', '사람인 모터보트천'),");
			sql.append("('용두레저센터', '열린 카약'),");
			sql.append("('울주해양레포츠센터', '울산바위 카약'),");
			sql.append("('울주해양레포츠센터', '울산바위 고무보트'),");
			sql.append("('울주해양레포츠센터', '울산바위 패들보드'),");
			sql.append("('율포레저센터', '녹차엔 카약'),");
			sql.append("('율포레저센터', '녹차엔 고무보트'),");
			sql.append("('율포레저센터', '녹차엔 패들보드'),");
			sql.append("('해양베스트관', 'EXPO 카약'),");
			sql.append("('향호활동장', '감자 딩기'),");
			sql.append("('향호활동장', '감자 카약'),");
			sql.append("('향호활동장', '감자고무보트')");
			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}