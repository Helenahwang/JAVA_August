import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeleteMain {

	public static void main(String[] args) {
		
		Connection con = null;
		CallableStatement call = null;

		try {
			//데이터베이스 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//데이터베이스 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			
			call = con.prepareCall("{call deleteDeptProc(?)}");
			
			call.setInt(1, 60);
			
			
			//삽입 구문 실행
			int r = call.executeUpdate();
			if(r>0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(call != null) {
					call.close();
				}
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	

	}

}
