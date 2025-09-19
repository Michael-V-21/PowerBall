import java.util.*;
public class Ticket
{
    private final List<Integer> whiteBalls;
    private final int powerBall;

    public Ticket(List<Integer> whiteBalls, int powerBall)
    {
        this.whiteBalls = new ArrayList<>(whiteBalls);
        this.powerBall = powerBall;
    }

    public List<Integer> getWhiteBalls()
    {
        return whiteBalls;
    }

    public int getPowerBall()
    {
        return powerBall;
    }

    @Override
    public String toString() {
        return "White Balls: " + whiteBalls + " | PowerBall: " + powerBall;
    }

}