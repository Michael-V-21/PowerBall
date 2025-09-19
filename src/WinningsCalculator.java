public class WinningsCalculator
{
    public static int calculateWinnings(int whiteMatches, boolean powerMatch)
    {
        if (whiteMatches == 5 && powerMatch)
            return 100000000;
        if (whiteMatches == 5)
            return 1000000;
        if (whiteMatches == 4 && powerMatch)
            return 50000;
        if (whiteMatches == 4)
            return 100;
        if (whiteMatches == 3 && powerMatch)
            return 100;
        if (whiteMatches == 3)
            return 7;
        if (whiteMatches == 2 && powerMatch)
            return 7;
        if (whiteMatches == 1 && powerMatch)
            return 4;
        if (powerMatch)
            return 4;

        return 0;
    }
}