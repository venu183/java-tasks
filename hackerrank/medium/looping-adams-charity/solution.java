import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            long totalCoins = 0;
            
            for (int i = 1; i <= n; i++) {
                totalCoins += (long) i * i;
            }
            
            System.out.println(totalCoins);
        }
        sc.close();
    }
}
