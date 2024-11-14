package student;

public class Hand {
    /**
     * an array represent the cards in hand.
     */
    private Card[] handOfCards;
    /**
     * the hand's size.
     */
    private int size;
    /**
     * the deck that currently played.
     */
    private Deck deck;

    /**
     * Constructor, create an array to store cards of the given size.
     * @param deck the deck that currently played
     * @param size the hand's size
     */
    public Hand(Deck deck, int size) {
        this.size = size;
        this.deck = deck;
        this.handOfCards = new Card[size];
        for (int i = 0; i < size; i++) {
            handOfCards[i] = this.deck.draw();
        }
    }

    /**
     * @return the hand's size
     */
    public int getSize() {
        return size;
    }

    /**
     * Get the card at the given index in this hand.
     * @param i the index
     * @return the card at the given index
     */
    public Card get(int i) {
        if (i < 0 || i >= size) {
            System.out.println("Invalid hand index!");
            return handOfCards[0];
        }
        return handOfCards[i];
    }

    /**
     * set a new card on the hand at the index.
     * @param card new card
     * @param index the index on the hand
     */
    public void set(Card card, int index) {
        this.handOfCards[index] = card;
    }

    /**
     * remove a given card from the hand and If the card is found in the hand it
     * should be removed,a replacement card should be drawn from the deck.
     * @param card the removed card
     * @return true if the card was found
     */
    public boolean remove(Card card) {
        if (card == null) {
            return false;
        }
        for (int i = 0; i < handOfCards.length; i++) {
            if (handOfCards[i] == card) {
                handOfCards[i] = this.deck.draw();
                return true;
            }
        }
        return false;
    }
}
