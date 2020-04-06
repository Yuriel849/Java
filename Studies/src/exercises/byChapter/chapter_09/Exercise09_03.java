package exercises.byChapter.chapter_09;

class Exercise09_03 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.8\\work\\PathSeparateTest.java"; // �̽������� ���� "\\"�� "\" �ϳ��� ����ȴ�
		String path = "";
		String fileName = "";
		
		int pos = fullPath.lastIndexOf("\\");
		if(pos != -1) {
			path = fullPath.substring(0, pos);
			fileName = fullPath.substring(pos);
		}
		
		System.out.println("fullPath : " + fullPath);
		System.out.println("path : " + path);
		System.out.println("fileName : " + fileName);
	} // main() ��.
} // Ŭ���� ��.