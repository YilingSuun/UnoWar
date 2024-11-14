package student;

public class SmallestCardAI extends AI {
    @Override
    public Card getPlay(Hand hand, CardPile cardPile)  {
        sortHand(hand);
        return super.getPlay(hand, cardPile);
    }

    /**
     * @return the name of the AI
     */
    @Override
    public String toString() {
        return "Smallest Card AI";
    }
}
