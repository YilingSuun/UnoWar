package student;

public class CardPile {
    /**
     * the top card in pile of cards that have been played.
     */
    private Card topCard;
    /**
     * the size of pile card.
     */
    private int size;

    /**
     * This should create a new card pile with the
     * given card as the initial top card.
     * @param topCard initial top card
     */
    public CardPile(Card topCard) {
        this.topCard = topCard;
        size = 1;
    }

    /**
     * This method should check if the input card is legal to play on the current stack.
     * @param card the input card
     * @return true if the input card is legal to play on the current stack
     */
    public boolean canPlay(Card card) {
        if (card == null) {
            return false;
        } else {
            return card.getRankNum() >= topCard.getRankNum()
                    || card.getSuitNum() == topCard.getSuitNum();
        }
    }

    /**
     * Adds another card to the card pile, making this the new top card.
     * @param card another card
     */
    public void play(Card card) {
        if (!canPlay(card)) {
            System.out.println("Illegal move detected!");
        } else {
            topCard = card;
            size++;
        }
    }

    /**
     * @return  the number of cards in the CardPile
     */
    public int getNumCards() {
        return size;
    }

    /**
     * @return the current top card for this CardPile
     */
    public Card getTopCard() {
        return topCard;
    }
}
