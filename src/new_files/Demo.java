package new_files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        File f1 = new File("Vojna_i_mir.txt");
        String warPeace = Files.readString(Path.of(f1.getPath()));
        Scanner sc = new Scanner(warPeace);
        long startTime = System.currentTimeMillis();
        Map<Integer, Set> words = new HashMap<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] allWords = line.split(" ");
            for (int i = 0; i < allWords.length; i++) {
                if(!words.containsKey(allWords[i].length())) {
                    words.put(allWords[i].length(), new HashSet<String>());
                }
                words.get(allWords[i].length()).add(allWords[i]);
            }
        }
        for(Map.Entry<Integer, Set> entry : words.entrySet()) {
            File f = new File("_.txt");
            if(!f.exists()) {
                f = new File(entry.getKey() + ".txt");
                f.createNewFile();
            }
            for(Object string : entry.getValue()) {
                Files.write(f.toPath(), (string + " ").getBytes(), StandardOpenOption.APPEND);
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
