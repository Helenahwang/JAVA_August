import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleSelect {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		//select 구문의 결과를 저장하기 위한 변수
		ResultSet rs = null;
		
		try {
			//오라클 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//데이터베이스 연결
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
			
			//sql 실행 객체 생성
			//pstmt=con.prepareStatement("select deptno, dname, loc from dept");
			pstmt=con.prepareStatement("select * from dept"); // *도 쓸수 있다.
			
			//select 하는 sql 실행
			rs=pstmt.executeQuery();
			
			//데이터 전체 읽기
			while(rs.next()) {
//				System.out.print(rs.getInt("deptno")+":"); //데이터형태(컬럼이름)
//				System.out.print(rs.getString("dname")+":");
//				System.out.print(rs.getString("loc")+"\n");	
				
				System.out.print(rs.getInt(1)+":"); //데이터형태(컬럼넘버)
				System.out.print(rs.getString(2)+":");
				System.out.print(rs.getString(3)+"\n");	
				
				
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(Exception e) {}
		}

	}

}
