package study;

import java.io.File;

//���� �����ϱ� (���ܸ� ó���ϴ� ���� �ƴ϶� �ش� �޼��带 ȣ���� ������ ó���ϵ��� ����)
class Ex04_ExceptionHandling03 {
	public static void main(String[] args) {
		try {
			File f = createFile(args[0]);
			System.out.println(f.getName() + "������ ���������� �����Ǿ����ϴ�.");
		} catch (Exception e) {
			System.out.println(e.getMessage() + " �ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
		}
	} // main()�� ��.

	static File createFile(String fileName) throws Exception { // createFile���� ���� �߻��ϸ� �޼��带 ȣ���� ������ ó���ؾ� �Ѵ�.
		if(fileName == null || fileName.equals(""))
			throw new Exception("�����̸��� ��ȿ���� �ʽ��ϴ�.");
		File f = new File(fileName);
		// File ��ü�� createNewFile �޼��带 �̿��ؼ� ���� ������ �����Ѵ�.
		f.createNewFile();
		return f; // ������ ��ü�� ������ ��ȯ�Ѵ�.
	} // createFile �޼����� ��.
} // Ŭ������ ��.
