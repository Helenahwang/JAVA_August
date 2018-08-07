package lamdatest2;

//리턴타입이 없는 메소드
interface T{
	public void method(int n);
}

//리턴타입이 있는 메소드
interface V{
	public int add(int n1, int n2);
}


public class LamdaMain {

	public static void main(String[] args) {
		//위와 같은 인터페이스 T를 구현해서 사용해야 하는 경우
		
		T t=(n)->{
			System.out.println("n:"+n);
		};
		
		t.method(10);
		
		
		V v=(n1, n2)->{
			return n1+n2;
			
		};

		System.out.println(v.add(100,3000));
	}

}


