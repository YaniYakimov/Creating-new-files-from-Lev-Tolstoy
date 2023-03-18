package new_files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        File f1 = new File("Vojna_i_mir.txt");
        String warPeace = Files.readString(Path.of(f1.getPath()));
        Scanner sc = new Scanner(warPeace);
        long startTime = System.currentTimeMillis();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                File f = new File("_.txt");
                if(!f.exists()) {
                    f = new File(words[i].length() + ".txt");
                    f.createNewFile();
                }

                if(f.getName().equals(words[i].length() + ".txt")) {
                    Files.write(f.toPath(), (words[i] + " ").getBytes(), StandardOpenOption.APPEND);
                }
                else{
                    Files.write(f.toPath(), words[i].getBytes());
                }
            }
            System.out.println();
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
