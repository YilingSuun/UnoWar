package student;

public class AI {
    /**
     * @param hand a hand with full of cards the AI is allowed to play
     * @param cardPile the AI is playing on
     * @return a card from the hand to mark it as the card the AI intends to play.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (int i = 0; i < hand.getSize(); i++) {
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
        return "Random Card AI";
    }

    /**
     * this function sort the card in hand.
     * @param hand the hand
     */
    public void sortHand(Hand hand) {
        for (int i = 0; i < hand.getSize() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < hand.getSize(); j++) {
                if (hand.get(j).getRankNum() < hand.get(minIndex).getRankNum()) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                Card temp = new Card(hand.get(i).getRankNum(), hand.get(i).getSuitNum());
                hand.set(new Card(hand.get(minIndex).getRankNum(), hand.get(minIndex).getSuitNum()), i);
                hand.set(new Card(temp.getRankNum(), temp.getSuitNum()), minIndex);
            }
        }
    }
}
