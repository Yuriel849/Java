import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

/**
 * A file reading class.
 *
 * @author Yuriel
 * @version 2020.12.17.
 */
public class TextReader {
    /**
     * Read from a txt file and return it as a set of words.
     * Nothing is done (method returns null) if FileNotFoundException or IOException occurs.
     * @param fileName The name of the txt file that should be read.
     * @return  A set of Strings, where each String is one of the words in the txt file that is read.
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