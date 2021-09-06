import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    private static final Scanner in = new Scanner(System.in);

    private static int inputNumber() {
        System.out.println("Enter number of array: ");
        
        int result = Integer.parseInt(in.nextLine().trim());
        return result;
    }

    private static int[] generateArray(int n) {
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, n + 1);
            a[i] = randomNum;
        }
        
        return a;
    }

    private static void bubbleSort(int[] a) {
        System.out.print("Unsorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    private static void printSorted(int[] a) {
        System.out.print("Sorted array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = inputNumber();
        int[] a = generateArray(n);
        bubbleSort(a);
        printSorted(a);
    }
}