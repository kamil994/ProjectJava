package Lekcja0.Zad0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan=new Scanner(System.in);
        String a=scan.nextLine();
        System.out.println(a);

        StringBuilder builder=new StringBuilder();
        builder.append(97);
        builder.append('c');
        builder.append("text");
        System.out.println(builder);

        // I'm looking for file'spath
        Path fileOut = Paths.get("outputFile.txt");
        // I'm creating buffered writer
        BufferedWriter out = Files.newBufferedWriter(fileOut,UTF_8);
        // In such way I can write strings, chars etc.
        out.write("Hello there,");
        out.write("General Kenobi");
        // Finally I'm closing a file
        out.close();

        File text=new File("test.txt");
        Scanner scanner=new Scanner(text);

        int lineNumber=0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("[line " + lineNumber+"]: "+ line);
            lineNumber++;
        }




    }
}
