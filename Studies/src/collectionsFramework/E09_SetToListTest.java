package collectionsFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class E09_SetToListTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		List list = Arrays.asList(1,2,1,2,3,1,1); // Turn array into list

		// Remove duplicate values from list --> 대부분의 컬렉션 클래스들은 상호 변환이 가능하다		
		Set set = new HashSet(list); // HashSet(Collection c) 생성자 사용
		
		System.out.println(list);
		System.out.println(set); // [1, 2, 3] printed
	}
}