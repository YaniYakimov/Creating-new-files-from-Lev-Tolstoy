package war_peace;

public class TotalCommas {
    int totalComas = 0;
    public synchronized void add(int number) {
        totalComas += number;
    }

    public int getTotalComas() {
        return totalComas;
    }
}
