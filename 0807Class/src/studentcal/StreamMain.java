package studentcal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = dao.fetch();
		
		//System.out.println(list);
		
		for(StudentVO tmp : list) {
			System.out.println(tmp);
		}
		
		System.out.println("===================================================================================");
		
		//Stream 생성
		Stream<StudentVO> stream = list.stream();
		
		//데이터를 전부 출력
		//stream.forEach(data -> System.out.println(data));
		
		//데이터 2개를 건너띄고 3개 출력
		//stream.skip(2).limit(3).forEach(data -> System.out.println(data));
		
		
		//남자인 데이터만 출력
		//stream.filter(data->data.getGender().equals("남자")).forEach(data -> System.out.println(data));
		
		//데이터 정렬하기 - score, 숫자는 뺄셈으로 계산
		//stream.sorted((d1, d2)->d1.getScore()-d2.getScore()).forEach(data -> System.out.println(data));
		
		//데이터 정렬하기 - 이름
		//stream.sorted((d1, d2)->d1.getName().compareTo(d2.getName())).forEach(data->System.out.println(data));
		
		//count 써보기
		//long cnt=stream.count();
		//System.out.println(cnt);
		
		//Optional<StudentVO> vo=stream.findFirst();
		//System.out.println(vo);
		
		
		//Optional로 리턴되는 데이터는 한번 더 가공을 해야 .getAge( )같은 것을 쓸 수 있다.
		//StudentVO vo1 = stream.findFirst().get();
		//System.out.println(vo1);
		//System.out.println(vo1.getAge());
		
		//score의 합계 구하기
		//숫자데이터가 아니면 바로 합계를 구할 수 없기 때문에 map메소드를 이용해서 숫자 데이터로 변경한 후 합계를 구해야 한다.
		//int sum=stream.mapToInt(StudentVO::getScore).sum();
		//System.out.println("합계 :"+sum);
		
		//score의 평균 구하기
		//double ave=stream.mapToDouble(StudentVO::getScore).average().getAsDouble();
		//System.out.println("평균 : "+ave);
		
		//성별이 남자인 데이터의 평균 점수를 구하는데 소수 1째 자리에서 반올림해서 정수 부분만 출력
		//double ave=stream.filter(data->data.getGender().equals("남자")).mapToDouble(StudentVO::getScore).average().getAsDouble();
		//System.out.println(ave);
		//System.out.println(Math.round(ave)); // (int)(ave+0.5)도 가능
		
		//성별이 여자인 데이터만 가지고 List를 생성
		//List<StudentVO> list1 = stream.filter(data->data.getGender().equals("여자")).collect(Collectors.toList());
		
		//for(StudentVO st : list1) {
		//	System.out.println(st);
		//}
		
		
		//학번과 점수만을 갖는 Map 으로 생성
		//Map<Integer, Integer> map1 =stream.collect(Collectors.toMap(StudentVO::getNum, StudentVO::getScore)); //Map 쓸때 중복된 데이터 쓰지를 못한다.
		//Map<Integer, Integer> map2 = stream.collect(Collectors.toMap(StudentVO::getNum, data->data.getScore()));
		
		//System.out.println(map2);
		
		//성별이 남자이고 score가 90이상인 데이터의 List를 생성해서 출력
		//List<StudentVO> list1 = stream.filter(data->data.getGender().equals("남자") && data.getScore() >= 90).collect(Collectors.toList());
		//for(StudentVO vo : list1) {
		//	System.out.println(vo);
		//}
		
		//groupingBy에 작성한 함수의 결과를 Key로 하고, 원래 데이터의 List값으로 해서 Map으로 리턴한다.
		//Map<String,List<StudentVO>> map1=stream.collect(Collectors.groupingBy(StudentVO::getGender));
		//System.out.println(map1);
		
		// 모든 정보
		//Map<String, IntSummaryStatistics> map1=stream.collect(Collectors.groupingBy(StudentVO::getGender, Collectors.summarizingInt(StudentVO::getScore)));
		//System.out.println(map1);
		
		//gender 별로 score의 합계를 정수로 출력
		//Map<키 타입, 값 타입> 
		Map<String, Integer> map= stream.collect(Collectors.groupingBy(StudentVO::getGender, Collectors.summingInt(StudentVO::getScore)));
		System.out.println(map);
		
		//Map의 데이터 전부 출력하기
		Set<String> keySet = map.keySet();
		for(String key : keySet) {
			System.out.println(key+":"+map.get(key));
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
