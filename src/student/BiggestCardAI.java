package student;

public class BiggestCardAI extends AI {
    @Override
    public Card getPlay(Hand hand, CardPile cardPile)  {
        super.sortHand(hand);
        for (int i = hand.getSize() - 1; i >= 0; i--) {
            if (cardPile.canPlay(hand.get(i))) {
                return hand.get(i);
            }
        }
        return null;
    }

    /**
     * @return the name of the AI
     */
    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
