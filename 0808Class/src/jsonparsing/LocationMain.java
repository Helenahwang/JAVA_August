package jsonparsing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class LocationMain {

	public static void main(String[] args) {
		
		Thread th = new Thread() {
		public void run() {
			//스레드로 수행할 내용
			try {
				URL url = new URL("https://apis.daum.net/local/v1/search/category.json?apikey=465b06fae32febacbc59502598dd7685&code=AT4&location=37.514322572335935,127.06283102249932&radius=20000"
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
				System.out.println(json);
				
				
				//JSON 문자열 파싱
				JSONObject main = new JSONObject(json); //{          }  
				System.out.println(main); //{"channel":{"item":[{"address":"서울 강남구 청담동 99-21","distance":"
				
				
				
				//channel 키의 객체를 JSONObject 타입으로 가져오기 //channel 포함 밑으로
				JSONObject channel = main.getJSONObject("channel"); //{          }  
				System.out.println(channel); //{"channel":{"item":[{"address":"서울 강남구 청담동 99-21","distance":"
				
				
				//item 키의 객체를 JSONArray 타입으로 가져오기 // item 포함 밑으로
				JSONArray item = channel.getJSONArray("item"); //[          ] 
				System.out.println(item); //{"item":[{"address":"서울 강남구 청담동 99-21","distance":"1979","placeUrl
				
				
				//배열을 순회
				int i=0;
				while(i<item.length()) {
					JSONObject loc = item.getJSONObject(i); //{          } // item 밑으로
					//System.out.println(loc); // {"address":"서울 강남구 청담동 99-21","distance":"1979","placeUrl":"http://place.map.dau
					
					String title = loc.getString("title"); // : item밑으로 title만 가져온다.
					System.out.println(title);
					
					String add = loc.getString("address");// : item밑으로 address만 가져온다.
					System.out.println(add);
					
					String latlong = loc.getString("latitude")+" , "+loc.getString("longitude");
					System.out.println(latlong);

					System.out.println();
					
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
