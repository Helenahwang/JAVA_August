package contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactDaoImpl implements ContactDao {
	
	//모든 메소드에서 공통으로 사용할 변수 선언
	//드라이버 클래스 로드 및 데이터베이스 연동
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;// select 구문의 결과를 저장하기 위한 변수
	
	//데이터베이스 연결을 수행해주는 메소드
	private void connect() {
		
		try {
		
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott","tiger");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	//데이터베이스 자원을 해제해주는 메소드
	private void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}catch(Exception e) {}
	}
	
	
	
	
	
	
	
	//가장 큰 num을 찾아오는 메소드
	//sql : select max(num) from contact;
	private int getMaxNum() {
		int result = -1;

		
		try {
			

			connect();
			
			//가장 큰 글번호를 찾아오는 sql을 실행하는 객체 생성
			pstmt = con.prepareStatement("select max(num) from contact");
			
			//sql 실행
			rs=pstmt.executeQuery();
			
			
			//결과 읽기
			while(rs.next()) { //if(rs.next()) 도 가능
				//select 절의 첫번째 컬럼의 값을 정수로 읽어서 result에 저장
				result = rs.getInt(1);
			}
			

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			close();
		}
		

		
		return result;
	}
	
	
	
	

	@Override
	public boolean insertContact(Contact contact1) {
		
		boolean result = false;
		


		try {

			int MaxNum =getMaxNum(); //getMaxNum() 메소드 내부에 close( )가 있어서 닫히기 때문에, 외부에서 쓰려면 MaxNum 변수를 이용해서 아래 MaxNum+1로 이용할 수 있다.
			
			connect();

			String sql="insert into contact(num, name, phone, email, birthday)"+" values(?,?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, MaxNum+1); //최고값을 안받으려면 contact1.getName()
			pstmt.setString(2, contact1.getName());
			pstmt.setString(3, contact1.getPhone());
			pstmt.setString(4, contact1.getEmail());
			pstmt.setDate(5, contact1.getBirthdate());
			
			//select를 제외한 구문은 executeUpdate로 실행
			//실행결과를 영향받은 행의 개수를 정수로 리턴
			
			int r=pstmt.executeUpdate();
			
			if(r==1) {
				result = true;
			}
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {

			close();
		}
		
		
		
		
		
		return result;
	}

	@Override
	public boolean updateContact(Contact contact2) {
		
		boolean result = false;
		
		connect();
		try {
			pstmt = con.prepareStatement("update contact set email=?, name=?, phone=?, birthday=?  where num=?");
			
			pstmt.setInt(5, contact2.getNum());
			pstmt.setString(1, contact2.getEmail());
			pstmt.setString(2, contact2.getName());
			pstmt.setString(3, contact2.getPhone());
			pstmt.setDate(4, contact2.getBirthdate());
			
			
			
			int r=pstmt.executeUpdate();
			
			if(r>0) {
				result=true;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			close();
			
		}
		
		
		
		
		return result;
	}

	@Override
	public boolean deleteContact(int num1) {

		boolean result = false;
		
		connect();
		
		try {
			pstmt = con.prepareStatement("delete from contact where num=?");
			
			pstmt.setInt(1, num1);
			
			
			int r=pstmt.executeUpdate();
			
			if(r>0) {
				result=true;
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			close();
			
		}
		

		return result;
		
				
	}

	@Override
	public List<Contact> allContact(Contact contact3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> selectnameContact(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact selectnumContact(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
