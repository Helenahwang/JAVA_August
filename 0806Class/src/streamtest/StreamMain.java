package streamtest;

import java.util.ArrayList;
import java.util.List;

public class StreamMain {

	public static void main(String[] args) {
		
		// 배열은 [인덱스]를 통해서 각각의 데이터에 접근한다.
		int[] ar = {10, 30, 20};
		
		for(int i=0; i<ar.length; i++) {
			System.out.println(ar[i]);
		}
		
		//ar의 모든 요소를 tmp에 대입해서 하나씩 수행한다.
		//for-each를 이용한 배열의 데이터 접근
		//빠른 열거 => iterator랑 비슷
		for(int tmp : ar) {
			System.out.println(tmp);
		}
		
		
		
		System.out.println("============================================");
		
		
		// List는 get(인덱스)를 통해서 각각의 데이터에 접근한다.
		List<Integer> list = new ArrayList<>();
		
		list.add(30);
		list.add(70);
		list.add(40);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(int tmp : list) {
			System.out.println(tmp);
		}

	}

}
