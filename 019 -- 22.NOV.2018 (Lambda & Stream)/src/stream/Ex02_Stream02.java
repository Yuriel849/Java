package stream;

import java.io.File;
import java.util.stream.Stream;

// map ����

class Ex02_Stream02 {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt") };
		
		Stream<File> fileStream = Stream.of(fileArr);
		
		// map()���� Stream<File>�� Stream<String>���� ��ȯ
		Stream<String> filenameStream = fileStream.map(File::getName);
//		filenameStream.forEach(System.out::println);// ��� ������ �̸��� ���
		
//		fileStream = Stream.of(fileArr); // ��Ʈ���� �ٽ� ����
//		
//		fileStream.map(File::getName) // Stream<File> --> Stream<String> ��ȯ
//				  .filter(s -> s.indexOf('.') != -1)
//				  .map(s -> s.substring(s.indexOf('.') + 1)) // Ȯ���ڸ� ����
//				  .map(String::toUpperCase) // ��� �빮�ڷ� ��ȯ
//				  .distinct() // �ߺ� ����
//				  .forEach(System.out::print); // JAVABAKTXT ���
//		
//		System.out.println();
		
		fileStream = Stream.of(fileArr); // ��Ʈ���� �ٽ� ����
		filenameStream = fileStream.map(File::getName);
		
		filenameStream.filter(s -> s.indexOf('.') != -1)
//					  .peek(System.out::println)
					  .map(s -> s.substring(0, s.indexOf('.'))) // �����̸����� Ȯ���ڸ� ����
//					  .peek(System.out::println);
					  .forEach(System.out::println);
	}
}
