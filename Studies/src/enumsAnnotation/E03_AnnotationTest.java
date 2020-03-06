package enumsAnnotation;

@interface MyAnno {
	int value();
	int count() default 1;	
}

//@MyAnno --> Error because no value is provided for element "value" (count has default value)
@MyAnno(5) // == @MyAnno(value=5) --> If element name is "value" and any other element has specified default values, can omit "value="
class E03_AnnotationTest {

}