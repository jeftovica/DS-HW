package task2;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class FileUtils {
    public static ArrayList<String> readFile(String fileName) throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<String>();
        Scanner reader;

        try {
            File file = new File(fileName);
            reader = new Scanner(file);

            while(reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }

            reader.close();
        } catch(FileNotFoundException error) {
            error.printStackTrace();
        }

        return lines;

    }
}
