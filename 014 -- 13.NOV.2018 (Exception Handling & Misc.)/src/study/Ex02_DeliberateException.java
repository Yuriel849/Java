package study;

class Ex02_DeliberateException {
	public static void main(String[] args) {
		try {
//			ArithmeticException exc = new ArithmeticException("���Ƿ� �߻�������"); // ���� ��ü ����� ����
//			throw exc;
			Exception ex = new ArithmeticException("�ٽ� ���Ƿ� �߻�������");
			/* ���� �ִ� exc�� �ּ�ó�� ���ϸ� "unreachable code" ����
			 * 	>> exc�� throw�ϸ鼭 try ������ catch ������ �Ѿ�⿡ ���⸦ ���� �������� �ʴ´�.
			 */			
			throw ex;
		} catch (ArithmeticException ae) { // "catch (Exception)" �Ʒ��� ������ ���� --> Exception���� ��� ���ܸ� ó���ϱ⿡ ���� ���� �ȵȴ�.
			// ���Ⱑ ����⿡ ���� �� 20�� �ٸ� ��µȴ�.
		} catch (Exception ee) { // catch�� ��������(���⼭�� "ae")�� ���ܰ�ü�� ������ �� �ִ�.  
			System.out.println("���� �޽���: " + ee.getMessage()); // getMessage �Լ��� ���� ��ü�� ���� ���� �����´�.
			ee.printStackTrace(); // ���ܹ߻� ����� ȣ�⽺�ÿ� �־��� �޼����� ������ ���� �޼����� ȭ�鿡 ����Ѵ�.
								  // ��� �޼��忡�� ������ �ϴٰ� ������ ������ �����ش�.
		}
		System.out.println("���α׷��� ���� ����Ǿ���.");
	}
	
	// catch�������� ���� ��ü�� ����� �� �ִ� --> ���� ��ü�� �� �ȿ� ������ ��� �ִ�
	// printStackTrace --> "ȣ�� ���� ���" �޼��� --> ��� �޼��尡 ��� �޼��带 ȣ���ϴٰ� ��� ���� ������ �ΰ����踦 �����ش�.

}
