import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();

        Account munozAccount = new Account(
                250,
                "Maria",
                "Munoz",
                "Jane Street",
                "Vaughan",
                "ON"
        );
        System.out.println(munozAccount);

        System.out.print("Enter deposit amount: ");
        munozAccount.deposit(sc.nextDouble());
        System.out.println("Balance is: " + money.format(munozAccount.getBalance()));

        System.out.print("Enter withdrawal amount: ");
        munozAccount.withdrawal(sc.nextDouble());
        System.out.println("Balance is: " + money.format(munozAccount.getBalance()));

        System.out.print("Enter new street: ");
        String street = sc.next();
        System.out.print("Enter new city: ");
        String city = sc.next();
        System.out.print("Enter new province: ");
        String province = sc.next();
        munozAccount.setAddress(street, city, province);
        System.out.println(munozAccount);
    }

}
