import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveDept {

	public static void main(String[] args) {
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("deptno:");
		int no=sc.nextInt();
		sc.nextLine();
		System.out.println("부서번호 : "+no);
		sc.close();
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
			
			//autocommit 해제
			con.setAutoCommit(false);
			
			
			
			//String sql="delete from dept where deptno=?"; 
			
			String sql="delete from dept"+" where deptno=?"; //예약어 앞에 띄어쓰기 주의
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,no);
			
			
			//pstmt = con.prepareStatement("delete from dept where deptno =" + no + "");
			
			//sql 실행
			int r = pstmt.executeUpdate();
			//실행하고 나면 영향받은 행의 개수를 리턴한다.
			//조건에 맞는 데이터가 없으면 실패하는 것이 아니고 삭제하는 행의 개수가 0이다.
			//실패하면 예외가 발생하므로 catch로 간다.
			
			if(r>0) {
				System.out.println("성공");
				con.commit();//autocommit이 해제되었기 때문에, commit()을 꼭 써줘야 한다.
			}else {
				System.out.println("삭제하려는 행이 존재하지 않는다."); 
			}
			
			
		} catch (Exception e) {
			
			try {
				//작업도중 예외가 발생한 경우 rollback을 호출
				con.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			//예외가 발생한 지점을 역추적
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null ) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		

	}

}
