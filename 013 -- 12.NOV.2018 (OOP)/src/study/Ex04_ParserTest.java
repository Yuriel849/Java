package study;

interface Parseable {
	// ���� �м��۾��� �����Ѵ�.
	public abstract void parse(String fileName);
}

class ParserManager {
	// ����Ÿ���� Parseable �������̽���.
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		} else {
			return new HTMLParser();
			/* �Ʒ� �ڵ��� �������
			 * 	>> Parseable p = new HTMLParser();
			 * 	>> return p;
			 */
		}
	}
}

class XMLParser implements Parseable {
	public void parse(String fileName) {
		/* ���� �м��۾��� �����ϴ� �ڵ带 ���´�. */
		System.out.println(fileName + " - XML parsing completed.");
	}
}

class HTMLParser implements Parseable {
	public void parse(String fileName) {
		/* ���� �м��۾��� �����ϴ� �ڵ带 ���´�. */
		System.out.println(fileName + " - HTML parsing completed.");
	}
}

class Ex04_ParserTest {
	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML"); // parser ���������� XMLParser ��ü�� �����ϰ� �ȴ�
		parser.parse("document.xml"); // XMLParser.parse("document.xml")�� �����ϴ�
		parser = ParserManager.getParser("HTML");
		parser.parse("document.html");
	}
}
