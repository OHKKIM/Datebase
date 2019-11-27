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
			sql.append("values ('크루즈요트', 8, '세발 크루즈요트'),"); 
			sql.append("('크루즈요트', 8, '김4 크루즈요트'),");
			sql.append("('크루즈요트', 8, '한강 크루즈요트'),"); 
			sql.append("('딩기요트', 2, '감자 딩기'),");
			sql.append("('카약', 1, '감자 카약'),");
			sql.append("('카약', 1, '카주 진약'),");
			sql.append("('카약', 1, '마 카약타러가자'),");
			sql.append("('카약', 1, '상주는 카약'),");
			sql.append("('카약', 1, '광안대교와 카약을'),");
			sql.append("('카약', 1, '대프리카약'),");
			sql.append("('카약', 1, '열린 카약'),");
			sql.append("('카약', 1, '녹차엔 카약'),");
			sql.append("('카약', 1, '송카약도'),");
			sql.append("('카약', 1, '수영강 카약'),");
			sql.append("('카약', 1, '세가지맛 카약'),");
			sql.append("('카약', 1, '카약이로구나'),");
			sql.append("('카약', 1, '울산바위 카약'),");
			sql.append("('카약', 1, '사람인 카약천'),");
			sql.append("('카약', 1, 'EXPO 카약'),");
			sql.append("('카약', 1, '내가 탄 카약'),");
			sql.append("('고무보트', 8, '감자고무보트'),");
			sql.append("('고무보트', 8, '상주는 고무보트'),");
			sql.append("('고무보트', 8, '대프리카고무보트'),");
			sql.append("('고무보트', 8, '녹차엔 고무보트'),");
			sql.append("('고무보트', 8, '송고무보트도'),");
			sql.append("('고무보트', 8, '고무엄하도다보트'),");
			sql.append("('고무보트', 8, '울산바위 고무보트'),");
			sql.append("('고무보트', 8, '사람인 고무보트천'),");
			sql.append("('고무보트', 8, '내가 탄 고무보트'),");
			sql.append("('고무보트', 8, '한강 고무보트'),");
			sql.append("('패들보드', 1, '상주는 패들보드'),");
			sql.append("('패들보드', 1, '대프리카패들보드'),");
			sql.append("('패들보드', 1, '녹차엔 패들보드'),");
			sql.append("('패들보드', 1, '울산바위 패들보드'),");
			sql.append("('패들보드', 1, '내가 탄 패들보드'),");
			sql.append("('수상자전거', 2, '상주는 수상자전거'),");
			sql.append("('수상자전거', 2, '수라상자전거'),");
			sql.append("('수상자전거', 2, '사람인 수상자전거천'),");
			sql.append("('바이킹보트', 12, '수영강 바이킹보트'),");
			sql.append("('모터보트', 1, '사람인 모터보트천')");
			
			
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}