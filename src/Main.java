import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Main main = new Main();
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
////        String b = scanner.nextLine();
//        System.out.println(main.getIncome(a));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int a = scanner.nextInt();
        boolean isPrime = true;

        if (a <= 1) {
            isPrime = false;
        } else {
            for (int b = 2; b <= Math.sqrt(a); b++) {
                if (a % b == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println("PRIME");
        } else {
            System.out.println("NOT PRIME");
        }


    }

}
