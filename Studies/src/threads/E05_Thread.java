package threads;

// 데몬쓰레드

class E05_Thread implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new E05_Thread());
		t.setDaemon(true); // 이 부분이 없으면 run()에서는 무한반복이 돌기 떄문에 종료되지 않는다.
		t.start();
		
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println(i);
			
			if(i == 5) { autoSave = true; }
		}
		
		System.out.println("프로그램을 종료합니다.");
	} // main() 끝.

	public void run() {
		while(true) {
			try {
				Thread.sleep(3 * 1000); // 3초마다 작동한다.
			} catch (InterruptedException e) {}
			// autoSave의 값이 true이면 autoSave()를 호출한다.
			if(autoSave) {
				autoSave();
			}
		}
	} // run() 끝.
	
	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	} // autoSave() 끝.
}