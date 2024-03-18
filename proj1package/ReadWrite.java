package proj1package;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
CSC 172 Project 1
Class BinaryTools
Elvis Imamura
Tiffany Xiang

contains methods for reading and writing files
*/

public class ReadWrite {
    public static String readFile(String filename) {
    	// reads file by filename and returns as string
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch(IOException e) {
	}
        return content.toString();
    }
    public static void writeFile(String filename, String content) {
    	// writes string contents to a specified filename
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch(IOException e) {
	}
    }
}

