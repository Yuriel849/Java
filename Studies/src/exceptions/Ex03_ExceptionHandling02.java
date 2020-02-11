package exceptions;

import java.io.File;

// 예외 처리하기
class Ex03_ExceptionHandling02 {
	public static void main(String[] args) {
		// command line에서 입력받은 값을                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      이름으로 갖는 파일을 생성한다.
		File f = createFile(args[0]);
		// 원래는 실행할 때 command line에서 main(매개변수)로 실행해야... (incomplete)
		System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
	} /// main()의 끝.

	static File createFile(String fileName) {
		try {
			if(fileName == null || fileName.equals(""))
				throw new Exception("파일이름이 유효하지 않습니다.");
		} catch (Exception e) {
			// fileName이 부적절한 경우, 파일이름을 '제목없음.txt'로 한다.
			fileName = "제목없음.txt";
		} finally {
			File f = new File(fileName); // File클래스의 객체를 만든다.
			createNewFile(f); // 생성된 객체를 이용해서 파일을 생성한다.
			return f;
		}
	} // createFile 메서드의 끝.
	
	static void createNewFile(File f) {
		try {
			f.createNewFile(); // 파일을 생성한다.
		} catch (Exception e) { } // createNewFile 메서드의 끝.
	}
}