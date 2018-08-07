package lamdatest;

public class Main {

	public static void main(String[] args) {
		
		/*
		RunnableImpl rnb=new RunnableImpl();
		Thread th = new Thread(rnb);
		th.start();
		
		RunnableImpl rnb1=new RunnableImpl();
		Thread th1 = new Thread(rnb1);
		th1.start();
		*/
		
		/*
		Runnable r =new Runnable() {

			@Override
			public void run() {
				//1초마다 쉬면서 1부터 10까지 출력
				int i=1;
				while(i<=10) {	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("i:"+i);
					i=i+1;
				}
			}
		};
		
		Thread th=new Thread(r);
		th.start();
		
		*/
		
		Runnable r =() -> {
				//1초마다 쉬면서 1부터 10까지 출력
				int i=1;
				while(i<=10) {	
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("i:"+i);
					i=i+1;
				}
			
		};
		
		Thread th=new Thread(r);
		th.start();
		
		
		
		
		
		
	}
				

}
