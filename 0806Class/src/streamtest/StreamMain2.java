package streamtest;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMain2 {

	public static void main(String[] args) {
		
		String [] ar= {"김좌진","김원봉","남자현","안중근","신재호", "안창호","홍범도","윤봉길","이봉창","안근"};
		
		//스트림으로 변환
		Stream<String> stream = Arrays.stream(ar);
		
		//모든 데이터 출력
		//stream.forEach(name -> {System.out.println(name);});
		
		
		System.out.println("==========================================");
		
		//중복 제거
		//stream.distinct().forEach(name -> {System.out.println(name);});
		
		//중복제거, 앞에 2개 건너띄기, 3개만 표시해라
		//stream.distinct().skip(2).limit(3).forEach(name -> {System.out.println(name);});
		
		
		//김으로 시작하는 데이터만 찾아서 출력
		stream.filter(name->name.startsWith("김")).forEach(name -> {System.out.println(name);});
		
		
		stream = Arrays.stream(ar);
		//이름이 세자가 아닌 데이터만 출력 
		stream.filter(name->name.length() !=3).forEach(name->System.out.println(name));
	}
}
