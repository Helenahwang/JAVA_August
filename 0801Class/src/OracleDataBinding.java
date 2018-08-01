import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class OracleDataBinding {

	public static void main(String[] args) {


		//데이터베이스 연결 변수 선언
		//반드시 close()를 호출해야 하므로 finally에서 close()를 호출
		Connection con=null;

		//SQL 실행변수
		PreparedStatement pstmt = null;

		
		
		//키보드로부터 입력을 받을 수 있는 개체 생성
		Scanner sc = new Scanner(System.in);
	
		System.out.print("부서번호:");
		int deptno = sc.nextInt();
		sc.nextLine(); // 남아있는 Enter를 제거하기 위한 코드
		
		System.out.print("부서이름:");
		String dname = sc.nextLine();
		
		System.out.print("지역:");
		String loc =sc.nextLine();
		
		sc.close();

	
		
		try {

			//사용하고자 하는 드라이버 클래스는 로드 데이터베이스 종류에 따라 다르다
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//확인하기 위한 코드, 이 코드가 출력되지 않으면 드라이버 이름을 확인해보고 드라이버이름이 틀리지 않았다면 ojdbc6.jar가 Referenced Libraries에 포함되어 있는지 확인
			System.out.println("오라클 드라이버 로드 성공");

			//데이터베이스 연결
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.234:1521:xe","scott","tiger");
			
			
			
			//pstmt = con.prepareStatement("insert into dept(deptno, dname, loc)" + "values(" + deptno + ",'"+dname+"','"+loc+"')");

			
			String sql = "insert into dept(deptno, dname, loc)" + "values(?,?,?)";
			//pstmt 생성 - 다른 데이터를 바인딩할 수 있는 PreparedStatement
			pstmt = con.prepareStatement(sql);
			
			//데이터바인딩
			pstmt.setInt(1,  deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			
			
			int r=pstmt.executeUpdate();
			if(r>0) {
				System.out.println("삽입 성공");
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
