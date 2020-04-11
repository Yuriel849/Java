package threads;

import javax.swing.JOptionPane;

// E03_Thread03와 비교!!

class E02_Thread {
	public static void main(String[] args) throws Exception {
		// JOptionPane is for creating a simple popup window.
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000); // 1초 간 시간을 지연한다.
			} catch (Exception e) {}
		}
	} // main() 끝.
}