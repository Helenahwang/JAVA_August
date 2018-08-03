package contact;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class ContactMain {

	public static void main(String[] args) {
		
		//인터페이스나 클래스를 상속한 경우에는 상위 인터페이스나 클래스 이름으로 변수를 만들고, 하위 클래스의 인스턴스를 생성해서 대입한다.
		//ContactDao : interface, ContactDaoImpl : 하위클래스
		ContactDao dao = new ContactDaoImpl();
		Contact contact = new Contact();
		contact.setNum(2);
		contact.setName("이혜영");
		contact.setPhone("01012342524");
		contact.setEmail("bdkc@gmail.com");
		
		//현재 시간을 저장한 캘린더 생성
		Calendar cal = Calendar.getInstance();
		//cal.set(Calendar.YEAR, 1970);
		cal.set(1975, 2, 27);
		
		Date birthday = new Date(cal.getTimeInMillis());
		contact.setBirthdate(birthday);
		
		
		//데이터를 삽입하는 메소드 호출
		//boolean result = dao.insertContact(contact);
		
		//데이터를 수정하는 메소드 호출
		//boolean result = dao.updateContact(contact);
		
		//데이터를 삭제하는 메소드 호출
		boolean result = dao.deleteContact(6);
		
		
		// 모든 데이터 확인하는 메소드 호출
		//List<Contact> ls=dao.allContact(contact);
		//System.out.print(ls);
		//for(Contact ct : ls) {
		//	System.out.println(ct);
		//}
		
		
		List<Contact> lss=dao.selectnameContact("문");
		//System.out.print(lss);
		for(Contact ct : lss) {
			System.out.println(ct);
		}
		
		
		if(result == true) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		

	}

}
