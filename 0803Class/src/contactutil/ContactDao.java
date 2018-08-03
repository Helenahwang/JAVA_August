package contactutil;

import java.util.List;

public interface ContactDao {

	//데이터를 삽입하는 메소드
	public boolean insertContact(Contact contact1);
	
	//데이터를 수정하는 메소드
	public boolean updateContact(Contact contact2);
	
	//데이터를 삭제하는 메소드
	public boolean deleteContact(int num1);
	
	//데이터 전체를 읽어오는 메소드
	//데이터 전체를 읽어올 때는 데이터가 0개 이상이므로 List로 리턴하고 읽어올 컬럼들을 저장할 DTO 클래스나 Map으로 제네릭을 적용하면 된다.
	public List<Contact> allContact();
	
	
	//이름을 가지고 조회하는 메소드
	public List<Contact> selectnameContact(String name); //name은 primary key가 아니기 때문에 같은 이름이 여러개 있을 수 있으니까, list<contact> 로 쓴다.
	
	//번호 가지고 조회하는 메소드
	public Contact selectnumContact(int num); // num은 primary key이기 때문에 하나만 존재한다. 따라서 list가 필요하지 않다.

	
}
