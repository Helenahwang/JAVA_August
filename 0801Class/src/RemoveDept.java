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
			
			
			
			String sql="delete from dept"+"where deptno=?"; 
			
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,no);
			
			int r = pstmt.executeUpdate();
			
			if(r>0) {
				System.out.println("성공");
			}
			
			
		} catch (Exception e) {
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
