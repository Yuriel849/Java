import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class TextReader {
    /**
     * Read a line of text from standard input (the text terminal),
     * and return it as a set of words.
     *
     * @return  A set of Strings, where each String is one of the
     *          words typed by the user
     */
    public HashSet<String> read(String fileName) {
        HashSet<String> set = new HashSet<>();
        try {
            File file = new File(fileName + ".txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while((line = br.readLine()) != null) {
                String[] wordArray = line.trim().toLowerCase().split(" ");
                for(int i = 0; i < wordArray.length; i++)
                    set.add(wordArray[i]);
            }
        } catch(FileNotFoundException e) {
            System.out.println("This file cannot be found.\n");
            return null; // Exit method.
        } catch(IOException e) {
            System.out.println("There was a problem reading this file.\n");
            return null; // Exit method.
        }
        return set;
    }
}
