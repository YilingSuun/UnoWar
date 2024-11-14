package student;

public class Tournament {
    /**
     * This is the main function to run the whole game.
     * @param args argument
     */
    public static void main(String[] args) {
        AI r1 = new AI();
        AI r2 = new AI();
        AI s1 = new SmallestCardAI();
        AI s2 = new SmallestCardAI();
        AI b1 = new BiggestCardAI();
        AI b2 = new BiggestCardAI();
        UnoWarMatch match1 = new UnoWarMatch(r1, r2);
        UnoWarMatch match2 = new UnoWarMatch(r1, s1);
        UnoWarMatch match3 = new UnoWarMatch(r1, b1);
        UnoWarMatch match4 = new UnoWarMatch(s1, r1);
        UnoWarMatch match5 = new UnoWarMatch(s1, s2);
        UnoWarMatch match6 = new UnoWarMatch(s1, b1);
        UnoWarMatch match7 = new UnoWarMatch(b1, r1);
        UnoWarMatch match8 = new UnoWarMatch(b1, s1);
        UnoWarMatch match9 = new UnoWarMatch(b1, b2);
        UnoWarMatch[] arrMatch = {match1, match2, match3,
                                  match4, match5, match6,
                                  match7, match8, match9};
        for (int i = 0; i < 9; i++) {
            System.out.println(arrMatch[i].getAi1() + " vs "
                    + arrMatch[i].getAi2() + " winRate: "
                    + arrMatch[i].winRate(1000));
        }
    }
}
