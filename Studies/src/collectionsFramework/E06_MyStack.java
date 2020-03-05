package collectionsFramework;

import java.util.Stack;

// Emulate the "forward" and "back" buttons on a web browser

class E06_MyStack {
	@SuppressWarnings("rawtypes")
	public static Stack back = new Stack();
	@SuppressWarnings("rawtypes")
	public static Stack forward = new Stack();

	public static void main(String[] args) {
		goURL("www.google.com");
		goURL("www.github.com");
		goURL("www.amazon.com");
		goURL("www.reddit.com");
				
		printStatus();
		
		goBack();
		System.out.println("= 뒤로가기 버튼을 누른 후 =");
		printStatus();
		
		goBack();
		System.out.println("= '뒤로' 버튼을 누른 후 =");
		printStatus();
		
		goForward();
		System.out.println("= '앞으로' 버튼을 누른 후 =");
		printStatus();
		
		goURL("codechobo.com");
		System.out.println("= 새로운 주소로 이동 후 =");
		printStatus();		
	} // main() 끝.
	
	public static void printStatus() {
		System.out.println("back:" + back);
		System.out.println("forward:" + forward);
		System.out.println("현재화면은 '" + back.peek() + "' 입니다.");
		System.out.println();
	} // printStatus() 끝.
	
	@SuppressWarnings("unchecked")
	public static void goURL(String url) {
		back.push(url);
		if(!forward.empty()) { forward.clear(); }
	} // goURL() 끝.
	
	@SuppressWarnings("unchecked")
	public static void goForward() {
		if(!forward.empty()) { back.push(forward.pop()); }
	} // goForward() 끝.
		
	@SuppressWarnings("unchecked")
	public static void goBack() {
		if(!back.empty()) { forward.push(back.pop()); }
	} // goBack() 끝.
}