package stream;

import java.io.File;
import java.util.stream.Stream;

class Ex02_Stream {
	public static void main(String[] args) {
		File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"), new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt") };

		System.out.println("1. Print all file names and extensions");
		Stream<File> fileStream = Stream.of(fileArr);
		// Change Stream<File> to Stream<String> with .map()
		Stream<String> filenameStream = fileStream.map(File::getName); // filenameStream only has file names
		filenameStream.forEach(System.out::println); // Print the names of all files

		System.out.println("\n2. Print only file extensions");
		fileStream = Stream.of(fileArr);
		fileStream.map(File::getName)
				  .filter(s -> s.indexOf('.') != -1)
				  .map(s -> s.substring(s.indexOf('.') + 1)) // Take only file extensions
				  .map(String::toUpperCase) // Change all Strings to capital letters
				  .distinct()
				  .forEach(System.out::print); // Prints "JAVABAKTXT" (print(), so no new line)

		System.out.println("\n\n3. Print only file names");
		Stream.of(fileArr).map(File::getName)
						  .filter(s -> s.indexOf('.') != -1)
						  .peek(System.out::println) // .peek -> similar to .forEach(), but not a final operation
						  .map(s -> s.substring(0, s.indexOf('.'))) // Take only file names
						  .peek(System.out::println)
						  .forEach(System.out::println);
	}
}