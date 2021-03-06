
public class TestMain {

	public static void main(String[] args) {
		
		//생성자를 이용해서 객체를 생성
		//T obj1 = new T();
		//T obj2 = new T();
		
		
		//싱글톤 패턴을 적용할 클래스의 객체 만들기
		T obj1 = T.getInstance();
		T obj2 = T.getInstance(); // 같은 해쉬코드를 가진다.
		
		
		
		//해시코드 출력
		//System.out.println(obj1.hashCode());
		System.out.println(System.identityHashCode(obj1));
		
		//System.out.println(obj2.hashCode());
		System.out.println(System.identityHashCode(obj2));
		
		int a=10;
		int b=10;
		
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		
		
	}

}
