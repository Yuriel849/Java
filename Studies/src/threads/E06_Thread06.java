package threads;

// sleep() 테스트

class E06_Thread06 {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		MyThread t = new MyThread();
		t.start();
		
		// main 쓰레드를 3초 간 멈췄다가...
		Thread.sleep(3 * 1000);
		// ...3초 후에 t 쓰레드를 깨운다
		System.out.println("main 쓰레드가 깨웁니다.");
		t.sleep(500); // t라고 써도 실행주체인 main이 잔다
		 // sleep() only affects thread calling method, cannot be used by one thread on another
		t.interrupt();
	} // main() 끝.
}

class MyThread extends Thread {
	public void run() {
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) { }
		// 문제가 생긴 것이 아니라 예외를 발생시켜서 깨우는 것이기에 catch문 내용이 없어도 된다.
		
		System.out.println("일어났습니다.");
	} // run() 끝.
}