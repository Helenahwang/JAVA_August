import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataSaveMap {

	public static void main(String[] args) {
		//데이터베이스에서 데이터 읽기를 위한 변수
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		//읽어온 데이터 저장을 위한 자료구조
		ArrayList<Map<String, Object>> list = new ArrayList<>();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			
			pstmt = con.prepareStatement("select * from dept");
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				//하나의 행을 저장할 맵 객체 생성
				Map<String, Object> map1 = new HashMap<>();
				
				map1.put("deptno", rs.getInt("deptno"));
				map1.put("dname", rs.getString("dname"));
				map1.put("loc", rs.getString("loc"));
				
				//열로 저장
				list.add(map1);
			
			}
			//System.out.println(list);
			
			System.out.printf("%10s", "부서번호");
			System.out.printf("%20s", "부서이름");
			System.out.printf("%30s", "부서위치");
			System.out.println();
			
			for(Map map : list) {
				System.out.printf("%10s", map.get("deptno"));
				System.out.printf("%15s", map.get("dname"));
				System.out.printf("%15s", map.get("loc"));
				System.out.println();
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			//사용을 다한 경우 닫기
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e) {}

		}

	}

}
