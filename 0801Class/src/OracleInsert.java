import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class OracleInsert {

	public static void main(String[] args) {


		//데이터베이스 연결 변수 선언
		//반드시 close()를 호출해야 하므로 finally에서 close()를 호출
		Connection con=null;

		//SQL 실행변수
		PreparedStatement pstmt = null;


		try {

			//사용하고자 하는 드라이버 클래스는 로드 데이터베이스 종류에 따라 다르다
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//확인하기 위한 코드, 이 코드가 출력되지 않으면 드라이버 이름을 확인해보고 드라이버이름이 틀리지 않았다면 ojdbc6.jar가 Referenced Libraries에 포함되어 있는지 확인
			System.out.println("오라클 드라이버 로드 성공");

			//데이터베이스 연결
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.234:1521:xe","scott","tiger");


			//SQL 실행 객체를 생성
			//pstmt = con.prepareStatement("insert into dept(deptno, dname, loc)"+"values(80, '영업','부산')");
			//pstmt = con.prepareStatement("update dept set dname='서비스', loc='서울' where deptno=80");
			pstmt = con.prepareStatement("delete from dept where deptno=80");
			
			
			//SQL을 실행 - select를 제외한 구문 실행
			//r에 저장되는 값은 영향받은 행의 개수
			int r = pstmt.executeUpdate(); //r이 0보다 큰값으로 리턴되면, 데이터베이스에 삽입이 성공된 것이다.

			if(r>0) {
				System.out.println("삽입성공");
			}



		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//연결이 되어 있으면 반드시 연결 해체
			try {
				if(pstmt != null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e) {}
		}

	
	
	}

}


