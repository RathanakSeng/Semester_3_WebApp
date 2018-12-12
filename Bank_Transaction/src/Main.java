import java.util.Scanner;

public class Main
{
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        Integer creditId, debitId;
        Double cash;

        System.out.print("Enter your id: ");
        debitId = input.nextInt();

        System.out.print("Enter the id of the receiver: ");
        creditId = input.nextInt();

        System.out.print("Enter the amount of money: ");
        cash = input.nextDouble();

        BankManager.transfer(debitId, creditId, cash);

    }
}
