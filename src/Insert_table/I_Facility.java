package Insert_table;
import java.sql.*;

public class I_Facility
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
			sql.append("insert into Facility(F_name, Address, F_phone)");
			sql.append("values ('목포요트마리나', '전남목포시삼학로88-56', '061-641-8989'),"); 
			sql.append("('아라마리나', '경기김포시고촌읍아라육로270번길73', '031-324-1349'),");
			sql.append("('거북선나루터', '서울시용산구이촌로72길62', '02-243-6843'),"); 
			sql.append("('향호활동장', '강원강릉시주문진읍동해대로4940', '033-341-6547'),");
			sql.append("('남강체험장', '경남진주시강남로320', '055-567-2348'),");
			sql.append("('낙단보수상레저센터', '경북상주시낙동면낙동리211', '054-351-3468'),");
			sql.append("('상주보수상레저센터', '경북상주시도남동120-7', '051-352-4526'),");
			sql.append("('광안리상설카약체험장', '부산시수영구남천동광안해변로54번길222', '051-521-2468'),");
			sql.append("('달성보통합관리센터', '대구시달성군논공읍하리685-7', '053-563-4782'),");
			sql.append("('용두레저센터', '충남보령시남포면열린바다로65', '041-423-5612'),");
			sql.append("('율포레저센터', '전남보성군회천면우암길38', '061-621-4574'),");
			sql.append("('송도상설카약체험장', '부산시서구송도해변로100', '051-524-6784'),");
			sql.append("('수영강상설카약체험장', '부산시수영구수영동541', '051-521-7813'),");
			sql.append("('삼락수상레포츠타운', '부산시사상구삼락동29-6', '051-523-7461'),");
			sql.append("('세종호수공원문화휴게복합시설', '세종시연기면세종리114-380', '044-451-3645'),");
			sql.append("('울주해양레포츠센터', '울산시울주군서생면해맞이로1560', '052-543-3951'),");
			sql.append("('아라서해갑문인증센터', '인천시서구정서진1로41', '032-312-7531'),");
			sql.append("('해양베스트관', '전남여수시덕충동2000', '061-681-2157'),");
			sql.append("('보트하우스', '충북충주시중앙탑면중앙탑길150', '043-238-2834')");
						
			stmt.executeUpdate(sql.toString());
			con.close();
		}catch(Exception e){ System.out.println(e);}
	}
}