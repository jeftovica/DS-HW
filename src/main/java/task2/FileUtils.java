package task2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

        public static ArrayList<String> readFile(String filePath) throws IOException {

                    File file = new File(filePath);
                    List<String> lines = Files.readAllLines(file.toPath());
                    return new ArrayList<>(lines);
                }
            }

            // ArrayList<String> lines = new ArrayList<String>();
            //BufferedReader reader = null;
            //try {
            //  reader = new BufferedReader(new FileReader(filePath));
            // String line = reader.readLine();
            //while (line != null) {
            //  lines.add(line);
            //line = reader.readLine();
            // }
            //} catch (IOException e) {
            //  System.err.println("Error reading file: " + e.getMessage());
            //} finally {
            //  if (reader != null) {
            //     try {
            //       reader.close();
            // } catch (IOException e) {
            //   System.err.println("Error closing file: " + e.getMessage());
            //}
            //}
            //}
            //return lines;
        }