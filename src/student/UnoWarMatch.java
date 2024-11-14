package student;

public class UnoWarMatch {
    /**
     * the first AI.
     */
    private AI ai1;
    /**
     * the second AI.
     */
    private AI ai2;
    /**
     * Constructor. This takes the two AIs that this UnoWarMatch
     * class is intended to compare.
     * @param ai1 the first AI
     * @param ai2 the second AI
     */
    public UnoWarMatch(AI ai1, AI ai2) {
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * @return the name of ai1
     */
    public AI getAi1() {
        return ai1;
    }

    /**
     * @return the nome of ai2
     */
    public AI getAi2() {
        return ai2;
    }

    /**
     * This function play the UnoWar game as described earlier in
     * the write-up until one of the AIs has won 10 rounds.
     * @return true if ai1 wins, and false if ai2 wins
     */
    public boolean playGame() {
        int ai1WinsRound = 0;
        int ai2WinsRound = 0;
        AI wonLastRound = ai1;
        while (ai1WinsRound != 10 && ai2WinsRound != 10) {
            //Create a new deck and each person should get 5 hand-cards.
            Deck deck = new Deck();
            deck.shuffle();
            Hand hand1 = new Hand(deck, 5);
            //Get the top card.
            Hand hand2 = new Hand(deck, 5);
            CardPile pile = new CardPile(deck.draw());
            if (wonLastRound == ai1) {
                while (ai1.getPlay(hand1, pile) != null && ai2.getPlay(hand2, pile) != null) {
                    //ai1's turn
                    Card choice1 = ai1.getPlay(hand1, pile);
                    hand1.remove(choice1);
                    pile.play(choice1);
                    if (ai2.getPlay(hand2, pile) != null) {
                        //ai2's turn
                        Card choice2 = ai2.getPlay(hand2, pile);
                        hand2.remove(choice2);
                        pile.play(choice2);
                    }
                }
            }
            if (wonLastRound == ai2) {
                while (ai2.getPlay(hand2, pile) != null && ai1.getPlay(hand1, pile) != null) {
                    //ai2's turn
                    Card choice2 = ai2.getPlay(hand2, pile);
                    hand2.remove(choice2);
                    pile.play(choice2);
                    if (ai1.getPlay(hand1, pile) != null) {
                        //ai1's turn
                        Card choice1 = ai1.getPlay(hand1, pile);
                        hand1.remove(choice1);
                        pile.play(choice1);
                    }
                }
            }
            //Check if one AI get 10 points.
            if (ai1.getPlay(hand1, pile) == null) {
                ai2WinsRound++;
                wonLastRound = ai2;
            } else if (ai2.getPlay(hand2, pile) == null) {
                ai1WinsRound++;
                wonLastRound = ai1;
            }
        }
        return (ai1WinsRound == 10);
    }

    /**
     * This method should have the AIs play each other nTrials times,
     * and report the percent of 11 times AI 1 beat AI2 as a double.
     * @param nTrials the times that was played
     * @return the percent of 11 times AI 1 beat AI2 as a double
     */
    public double winRate(int nTrials) {
        int ai1WinSum = 0;
        for (int i = 0; i < nTrials; i++) {
            if (playGame()) {
                ai1WinSum++;
            }
        }
        return (double) ai1WinSum / nTrials;
    }
}
