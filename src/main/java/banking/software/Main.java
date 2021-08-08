package banking.software;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class Main {
    private static final List<String> userOperations = List.of("Logout", "Deposit", "Withdraw", "Transfer");

    public static void main(String[] args) {
        List<Consumer> consumers = getAllConsumers();

        final Scanner sc = new Scanner(System.in);

        while (!getUserToLogIn(consumers, sc)) {
            System.out.println();
        }

        boolean exit = false;
        while (!exit) {
            int option = askUserForOperationToPerform(sc);
            if (option == 0) {
                exit = true;
            } else {
                switch (option) {
                    case 1:
                        performDeposition(sc);
                        break;
                    case 2:
                        performWithdrawal(sc);
                        break;
                    case 3:
                        performTransfer(sc);
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
        System.out.println("Exited successfully");
    }

    private static boolean getUserToLogIn(List<Consumer> consumers, Scanner sc) {
        System.out.println("Please enter the credentials: \nBank Account no:");

        long accountNo = sc.nextLong();
        Consumer currentConsumer = getConsumer(consumers, accountNo);
        if (isNull(currentConsumer)) {
            System.out.println("Bank Account number doesn't exist!");
            return false;
        }
        System.out.println("Password: ");
        String password = sc.next();
        while (!password.equals(currentConsumer.getPassword())) {
            System.out.println("Wrong password! please enter correct password");
            password = sc.next();
        }

        return true;
    }

    private static Consumer getConsumer(List<Consumer> consumers, long accountNo) {
        return consumers
                .stream()
                .filter(consumer -> consumer.getBankAccountNo() == accountNo)
                .findFirst()
                .orElse(null);
    }

    private static List<Consumer> getAllConsumers() {
        return Stream
                .of(
                        new Consumer(123, "123"),
                        new Consumer(1234, "1234"),
                        new Consumer(12345, "12345")
                )
                .collect(Collectors.toList());
    }

    private static int askUserForOperationToPerform(Scanner sc) {
        boolean isValidOptionEntered = false;
        int option = 0;
        while (!isValidOptionEntered) {
            userOperations
                    .forEach(operation -> System.out.println(userOperations.indexOf(operation) + ") " + operation));
            option = sc.nextInt();
            if (option < 0 || option > 3) {
                System.out.println("Please enter valid option!");
            } else {
                isValidOptionEntered = true;
            }
        }

        return option;
    }

    private static void performDeposition(Scanner sc) {
        System.out.println("Enter the amount you want to deposit");
        int xyz = sc.nextInt();
        System.out.println("amount " + xyz + " deposited successfully");
    }

    private static void performWithdrawal(Scanner sc) {
        System.out.println("Enter the amount you want to withdraw");
        int xyz = sc.nextInt();
        System.out.println("amount " + xyz + " withdrawn successfully");
    }

    private static void performTransfer(Scanner sc) {
        System.out.println("Enter the otp");
        int generatedOtp = new Random().nextInt(10000);
        System.out.println(generatedOtp);
        int enteredOtp = sc.nextInt();
        while (generatedOtp != enteredOtp) {
            System.out.println("Enter the correct otp!");
            enteredOtp = sc.nextInt();
        }

        System.out.println("otp verification successful !!!");
        System.out.println("Enter the amount and bank account to transfer");
        int amount = sc.nextInt();
        long accountNo = sc.nextLong();
        Consumer transferToAccount = getConsumer(getAllConsumers(), accountNo);
        while (isNull(transferToAccount)) {
            System.out.println("Enter the correct bank account no!");
            accountNo = sc.nextLong();
            transferToAccount = getConsumer(getAllConsumers(), accountNo);
        }

        System.out.println("amount: " + amount + " transferred successful to account " + transferToAccount.getBankAccountNo());
    }
}

class Consumer {
    private final long bankAccountNo;
    private final String password;

    public Consumer(long bankAccountNo, String password) {
        this.bankAccountNo = bankAccountNo;
        this.password = password;
    }

    public long getBankAccountNo() {
        return bankAccountNo;
    }

    public String getPassword() {
        return password;
    }
}
