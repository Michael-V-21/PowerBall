import java.util.*;

public class PowerBallSimulator
{
    private static final int Ticket_Cost = 2;

    public static void main (String[] args)
    {
        System.out.println(" ");
        System.out.println("Welcome to my PowerBall Simulator \n");

        Scanner scanner = new Scanner(System.in);
        int totalSpent = 0;
        int totalWinnings = 0;

        boolean keepGoing = true;
        while (keepGoing)
        {
            System.out.println("Choose from the options below:");
            System.out.println("1. Pick your numbers");
            System.out.println("2. Generate X random tickets");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            if (choice == 1)
            {
                Ticket playerTicket = customTicket(scanner);
                Ticket winningTicket = Lottery.generateRandomTicket();

                int winnings = new Lottery().checkMatches(playerTicket, winningTicket);
                totalSpent += Ticket_Cost;
                totalWinnings += winnings;

                System.out.println("Ticket: " + playerTicket);
                System.out.println("Winning Ticket: " + winningTicket);
                System.out.println("Winnings: $" + winnings);
                System.out.println("====================================================== \n");

            }
            else if (choice == 2)
            {
                System.out.println("How many tickets would you like to generate?");
                int count = scanner.nextInt();

                Ticket winningTicket = Lottery.generateRandomTicket();
                int sessionWinnings = 0;
                for (int i = 0; i < count; i++)
                {
                    Ticket playerTicket = Lottery.generateRandomTicket(); //
                    int winnings = new Lottery().checkMatches(playerTicket, winningTicket);
                    sessionWinnings += winnings;
                }

                totalSpent += count * Ticket_Cost;
                totalWinnings += sessionWinnings;

                System.out.println("Winning Ticket: " + winningTicket);
                System.out.println("Spent $" + (count * Ticket_Cost) + " on tickets & won $" + sessionWinnings);
                System.out.println("====================================================== \n");

            }
            else if (choice == 3)
            {
                keepGoing = false;
                int totalLost = (totalSpent - totalWinnings);

                System.out.println("Session Summary");
                System.out.println("Total Spent: $" + totalSpent);
                System.out.println("Total Winnings: $" + totalWinnings);
                System.out.println("Total Lost: " + totalLost);
            }
            else
            {
                System.out.println("Invalid response, try again");
            }
        }

    }

    public static Ticket customTicket(Scanner scanner)
    {
        Set<Integer> whiteBalls = new HashSet<>();
        while (whiteBalls.size() < 5) {
            System.out.println("Enter white ball number " + whiteBalls.size() + " (1-69): ");
            int num = scanner.nextInt();

            if (num < 1 || num > 69) {
                System.out.println("Invalid input, try again");
            } else if (whiteBalls.contains(num)) {
                System.out.println("Duplicate values, try again");
            } else {
                whiteBalls.add(num);
            }
        }
        System.out.println("Enter PowerBall Number (1-26): ");
        int powerBall = scanner.nextInt();
        while (powerBall < 1 || powerBall > 26)
        {
            System.out.println("Invalid input, try again");
            powerBall = scanner.nextInt();
        }

        return new Ticket(new ArrayList<>(whiteBalls), powerBall);
    }

}
