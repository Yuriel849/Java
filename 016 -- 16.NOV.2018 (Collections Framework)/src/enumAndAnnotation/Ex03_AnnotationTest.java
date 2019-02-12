package enumAndAnnotation;
@interface MyAnno {
	int value();
	int count() default 1;	
}

//@MyAnno --> ����� �⺻���� �������� �ʾұ⿡ ����
//@MyAnno(count=1) // MyAnno �ֳ����̼� ������ �� count()���� �⺻���� �������� �ʾұ⿡ ����
				   // �ֳ����̼� ���ǿ��� "int count() default 1;"��� �⺻���� �����߱⿡ "@MyAnno"�� �ᵵ �ȴ�.
// Ư���ϰ� �޼��� �̸��� value�̰�, ��Ұ� value �ϳ��̰ų� �ٸ� ��Ҵ� �־ default���� ���ǵǾ� �ִٸ�, @MyAnno(1)�� @MyAnno(value=1)�� ����
@MyAnno(5) // @MyAnno(value=5)�� ����.
class Ex03_AnnotationTest {

}
