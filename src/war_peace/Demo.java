package war_peace;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException {
        File f1 = new File("Vojna_i_mir.txt");
        String warPeace = Files.readString(Path.of(f1.getPath()));
        findComas(warPeace);
    }

    private static void findComas(String warPeace) throws InterruptedException {
        Scanner sc;
        int threads = 4;
        ArrayList<Thread> thread = new ArrayList<>();
        int text = warPeace.length();
        int separator = text/threads;
        int j = 0;
        TotalCommas totalCommas = new TotalCommas();
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            int startText = j*separator;
            int endText = (j+1)*separator;
            String parOfText = warPeace.substring(startText, endText);
            sc = new Scanner(parOfText);
            thread.add(new Counter(sc, totalCommas));
            j++;
        }
        for(Thread counter : thread) {
            counter.start();
        }
        for(Thread counter : thread) {
            counter.join();
        }
        System.out.println("Reading with " + threads + " threads for: " + (System.currentTimeMillis() - start) + " with total commas " + totalCommas.getTotalComas());
    }
}
