import java.util.*;
public class Lottery
{
    private static final int WHITE_MAX = 69;
    private static final int POWER_MAX = 26;
    private static final Random random = new Random();

    public static Ticket generateRandomTicket()
    {
        Set<Integer> whiteBalls = new HashSet<>();
        while (whiteBalls.size() < 5) {
            whiteBalls.add(random.nextInt(WHITE_MAX) + 1);
        }
        int powerBall = random.nextInt(POWER_MAX) + 1;
        return new Ticket(new ArrayList<>(whiteBalls), powerBall);
    }

    public int checkMatches(Ticket playerTicket, Ticket winningTicket)
    {
        int whiteMatches = 0;
        for (int num : playerTicket.getWhiteBalls())
        {
            if (winningTicket.getWhiteBalls().contains(num))
            {
                whiteMatches++;
            }
        }
        boolean powerMatch = playerTicket.getPowerBall() == winningTicket.getPowerBall();
        return WinningsCalculator.calculateWinnings(whiteMatches, powerMatch);
    }
}