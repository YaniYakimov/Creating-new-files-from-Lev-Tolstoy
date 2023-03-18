package war_peace;

import java.util.Scanner;

public class Counter extends Thread{
    TotalCommas totalCommas;
    int commas;
    Scanner sc;
    public Counter(Scanner scanner, TotalCommas totalCommas) {
        this.sc = scanner;
        this.totalCommas = totalCommas;
    }
    @Override
    public void run() {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == ',') {
                    commas++;
                }
            }
        }
        totalCommas.add(this.commas);
    }
}