package htmlparsing;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class HTMLMain {

	public static void main(String[] args) {
		
		Thread th = new Thread() {
			public void run() {
				//스레드로 수행할 내용
				try {
					
					//URL url = new URL("http://www.kma.go.kr/weather/forecast/mid-term-xml.jsp?stnId=109");
					
					//URL url = new URL("https://www.daum.net");
					
					URL url = new URL("https://tv.naver.com/");
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					
					//옵션 설정
					//캐시 설정 여부 - 다운로드 받아놓고 다음에 다운로드 받은 데이터를 이용할 것인지 여부 설정
					con.setUseCaches(false);
					//얼마동안 접속을 시도해 볼 것인지 설정
					con.setConnectTimeout(30000);
					
					
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					
					
					//다운로드 받는 문자열을 중간 저장할 인스턴스를 생성
					//String에 바로 추가하면 메모리 낭비가 발생한다.
					//String은 자기 자신에게 추가할수 없기 때문에 기존 내용을 복사해서 추가하기 때문에
					StringBuilder sb = new StringBuilder();
					while(true) {
						//한줄을 읽기
						String line = br.readLine();
						
						//읽은 게 없으면 종료
						if(line == null) {
							break;
						}
						sb.append(line+"\n");
					}
					//다 읽은 데이터는 String으로 변환
					String html = sb.toString();
					
					//sb 메모리 정리
					sb=null;
				
					//연결 객체 정리
					br.close();
					con.disconnect();
					
					//System.out.println(html);
					
					Document doc = Jsoup.parse(html);
					
					//h2 태그 전체를 가져온다.
					//Elements elements = doc.getElementsByTag("h2");
					
					//클래스 이름 가지고 찾을 때
					//Elements elements = doc.getElementsByClass("screen_out");
					
					Elements elements = doc.getElementsByTag("tooltip");
					
					
					int i=0;
					while(i<elements.size()) {
						//데이터 1개 가져오기
						Element element=elements.get(i);
						
						//태그 안의 내용 출력
						System.out.println(element.text());
						
						i=i+1;
						
					}
					
					Element element = doc.getElementById("mainServiceTitle");
					System.out.println("ID : " +element.text()); //반복문 돌릴 필요가 없다. 왜냐면 ID는 하나이기 때문에
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
				
			}
		};
		th.start();

	}

}
