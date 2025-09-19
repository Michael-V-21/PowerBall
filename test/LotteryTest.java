import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class LotteryTest
{
    @Test
    void testCheckMatches() {
        Lottery lottery = new Lottery();

        // Winning ticket
        Ticket winningTicket = new Ticket(List.of(1, 2, 3, 4, 5), 10);

        // Player tickets
        Ticket playerTicket1 = new Ticket(List.of(1, 2, 3, 4, 5), 10); // 5 white + power
        assertEquals(100000000, lottery.checkMatches(playerTicket1, winningTicket));

        Ticket playerTicket2 = new Ticket(List.of(1, 2, 3, 4, 5), 11); // 5 white
        assertEquals(1000000, lottery.checkMatches(playerTicket2, winningTicket));

        Ticket playerTicket3 = new Ticket(List.of(1, 2, 3, 4, 6), 10); // 4 white + power
        assertEquals(50000, lottery.checkMatches(playerTicket3, winningTicket));

        Ticket playerTicket4 = new Ticket(List.of(1, 2, 3, 4, 6), 11); // 4 white
        assertEquals(100, lottery.checkMatches(playerTicket4, winningTicket));

        Ticket playerTicket5 = new Ticket(List.of(1, 2, 3, 6, 7), 10); // 3 white + power
        assertEquals(100, lottery.checkMatches(playerTicket5, winningTicket));

        Ticket playerTicket6 = new Ticket(List.of(1, 2, 3, 6, 7), 11); // 3 white
        assertEquals(7, lottery.checkMatches(playerTicket6, winningTicket));

        Ticket playerTicket7 = new Ticket(List.of(1, 2, 6, 7, 8), 10); // 2 white + power
        assertEquals(7, lottery.checkMatches(playerTicket7, winningTicket));

        Ticket playerTicket8 = new Ticket(List.of(1, 6, 7, 8, 9), 10); // 1 white + power
        assertEquals(4, lottery.checkMatches(playerTicket8, winningTicket));

        Ticket playerTicket9 = new Ticket(List.of(6, 7, 8, 9, 10), 10); // only power
        assertEquals(4, lottery.checkMatches(playerTicket9, winningTicket));

        Ticket playerTicket10 = new Ticket(List.of(6, 7, 8, 9, 10), 11); // none
        assertEquals(0, lottery.checkMatches(playerTicket10, winningTicket));
    }
}