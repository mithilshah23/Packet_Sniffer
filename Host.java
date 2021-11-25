import java.io.IOException;
import java.util.Scanner;

public class Host {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 to generate Normal Traffic");
        System.out.println("Enter 2 to generate Attack Traffic");
        int n = sc.nextInt();
        if (n == 1) {
            new NormalTraffic();

        } else if (n == 2) {
            new AttackTraffic();
        }
        sc.close();
    }
}
