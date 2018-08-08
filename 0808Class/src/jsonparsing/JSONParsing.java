package jsonparsing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParsing {

	public static void main(String[] args) {

		Thread th = new Thread() {
			public void run() {
				//스레드로 수행할 내용
				try {
					URL url = new URL("http://apis.daum.net/search/book?apikey=465b06fae32febacbc59502598dd7685&output=json&q=java"
);
					HttpURLConnection con = (HttpURLConnection)url.openConnection();
					
					//옵션 설정
					//캐시 설정 여부 - 다운로드 받아놓고 다음에 다운로드 받은 데이터를 이용할 것인지 여부 설정
					con.setUseCaches(false);
					//얼마동안 접속을 시도해 볼 것인지 설정
					con.setConnectTimeout(30000);
					
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
					
					StringBuilder sb = new StringBuilder();
					while(true) {
						String line = br.readLine();
						if(line == null) {
							break;
						}
						sb.append(line);
					}
					//sb의 내용을 json에 대입
					String json = sb.toString();
					//System.out.println(json);
					
					//JSON 문자열 파싱
					JSONObject main = new JSONObject(json); //{          }  
					System.out.println(main); //{"channel":{"result":"10","item":[
					
					
					
					//channel 키의 데이터를 JSONObject 타입으로 가져오기 //channel 밑으로
					JSONObject channel = main.getJSONObject("channel"); //{          }  
					System.out.println(channel); //{"result":"10","item":[{"author":"조현준",
					
					
					//channel에서 item 키의 값을 배열로 가져오기 // item 밑으로
					JSONArray item = channel.getJSONArray("item"); //[          ] 
					System.out.println(item); //[{"author":"조현준","isbn":"1162190221",
					
					
					//배열을 순회
					int i=0;
					while(i<item.length()) {
						JSONObject book = item.getJSONObject(i); //{          } // item 밑으로
						//System.out.println(book);
						
						String author = book.getString("author"); // : item밑으로 author만 가져온다.
						System.out.println(author);
						
						String title = book.getString("title");// : item밑으로 title만 가져온다.
						System.out.println(title);
						
						
						
						i=i+1;
					}
					
					
				}catch(Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
				
				
			}
		};
		th.start();
		

	}

}
