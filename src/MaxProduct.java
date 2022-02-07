import java.util.Scanner;

/**
 * Maximum product of given Number.
 * 1. Break the number N
 *  case1: Into combination of factors with 2 or 3
 *
 */
public class MaxProduct {

    public static void main(String[] args) {

        String input;
        do {
            System.out.println("Enter the number 1 to N (&)  0 to quit");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            int maxProduct;
            try{
                maxProduct   = breakInteger(Integer.parseInt(input));
            }catch (NumberFormatException e){
                System.out.print(0);
                break;
            }


            maxProduct = breakInteger(Integer.parseInt(input));
             System.out.println("Max product: " + maxProduct);

        } while (Integer.parseInt(input)!=0);

    }

    private static int breakInteger(int N) {
        // base case 2 = 1 + 1 
        if (N == 2)
            return 1;

        // base case 3 = 2 + 1 
        if (N == 3)
            return 2;

        int maxProduct=-1;

        // breaking based on mod with 3 
        switch (N % 3)
        {
            // If divides evenly, then break into all 3 
            case 0:
                maxProduct = power(3, N/3);
                break;

            // If division gives mod as 1, then break as 
            // 4 + power of 3 for remaining part 
            case 1:
                maxProduct = 2 * 2 * power(3, (N/3) - 1);
                break;

            // If division gives mod as 2, then break as 
            // 2 + power of 3 for remaining part 
            case 2:
                maxProduct = 2 * power(3, N/3);
                break;
        }
        return maxProduct;
    }

    private static int power(int x, int a) {
        int res = 1;
        while (a>0)
        {
            if ((a & 1)>0)
                res = res * x;
            x = x * x;
            a >>= 1;
        }
        return res;
    }
}
