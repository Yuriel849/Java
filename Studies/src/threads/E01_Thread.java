package threads;

/* TWO ways to create a thread
 * 	>> Inherit Thread class and "public void run()"
 * 	>> Implement Runnable interface and "public void run()"
 */

class E01_Thread {
	public static void main(String[] args) {
		// 1st way to create a thread --> Thread constructor
		ThreadEx01 t1 = new ThreadEx01();

		// 2nd way to create a thread --> Instance of Runnable type, then Thread(Runnable) constructor
		Runnable r = new ThreadEx02();
		Thread t2 = new Thread(r); // 생성자 --> Thread(Runnable target)
		
		t1.start();
//		t1.start(); --> start()는 쓰레드 객체 당 단 한 번만 실행 가능 --> 다시 start()하려면 쓰레드 객체를 다시 생성해야!
		t2.start();
		
		// 쓰레드 실행 중 에러/예외가 발생해도 그 쓰레드만 영향을 받지, 다른 쓰레드는 영향 받지 않는다.
		
		for(int i = 0; i < 5; i++) {
			System.out.println("0." + Thread.currentThread().getName());
		}
	} // main() 끝. --> 하지만 main 외 다른 쓰레드가 실행 중임으로 프로그램이 종료되지 않는다.
}

// 쓰레드를 만들면 쓰레드가 할 일을 제공해야 한다 --> 할 일을 명시한 곳이 run()

class ThreadEx01 extends Thread { // Thread 클래스를 상속 받아서 run() 오버라이딩
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("1." + getName()); // superclass Thread의 getName() 바로 호출
		}
	}
}

class ThreadEx02 implements Runnable { // Runnable 인터페이스를 구현 --> Runnable에는 추상메서드 run()만 있다
	public void run() {
		for(int i = 0; i < 5; i++) { // Thread.currentThread() -->  현재 실행중인 Thread를 반환한다.
			System.out.println("2." + Thread.currentThread().getName());
			/* ThreadEx02는 Thread클래스와 연결고리가 없다!
			 * 	>> 그래서 바로 접근하지 못하고 Thread클래스의 currentThread() 메서드 사용한다.
			 * 	>> currentThread()가 현재 실행중인 Thread를 반환하면, 이제 그것을 이용해서 Thread 클래스에 접근할 수 있다.
			 */
		}
	}
}