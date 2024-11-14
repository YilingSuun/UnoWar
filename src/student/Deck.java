package student;

public class Deck {
    /**
     * the array of cards in deck.
     */
    private Card[] cards;

    /**
     * Constructor, which create 52 sorted card.
     */
    public Deck() {
        cards = new Card[52];
        int i = 0;
        while (i < 52) {
            for (int j = 1; j <= 13; j++) {
                for (int k = 1; k <= 4; k++) {
                    cards[i] = new Card(j, k);
                    i++;
                }
            }
        }
    }

    /**
     * Shuffle the deck of Card’s that is represented by the array you made in the
     * constructor. The algorithm exchanges randomly chosen pairs of array elements,
     * and works in O(n) time for an array of size n.
     */
    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int j = (int) (Math.random() * 52);
            Card temp = new Card(cards[i].getRankNum(), cards[i].getSuitNum());
            cards[i] = new Card(cards[j].getRankNum(), cards[j].getSuitNum());
            cards[j] = temp;
        }
    }

    /**
     * Draw and return the next card. Whatever card is drawn should not be
     * drawn again until the deck is shuffled again.
     * @return the next card
     */
    public Card draw() {
        if (isEmpty()) {
            cards = new Deck().cards;
            this.shuffle();
            //create a temp with original length.
            Card[] temp = new Card[cards.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = new Card(cards[i].getRankNum(), cards[i].getSuitNum());
            }
            //create the deck after drawing
            cards = new Card[temp.length - 1];
            for (int i = 0; i < temp.length - 1; i++) {
                cards[i] = new Card(temp[i].getRankNum(), temp[i].getSuitNum());
            }
            return temp[temp.length - 1];
        } else {
            //create a copy temp with original length.
            Card[] temp = new Card[cards.length];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = new Card(cards[i].getRankNum(), cards[i].getSuitNum());
            }
            if (cards.length == 1) {
                temp = new Card[1];
                temp[0] = new Card(cards[0].getRankNum(), cards[0].getSuitNum());
                cards = new Card[0];
                return temp[0];
            } else {
                //create the deck after drawing
                cards = new Card[temp.length - 1];
                for (int i = 0; i < temp.length - 1; i++) {
                    cards[i] = new Card(temp[i].getRankNum(), temp[i].getSuitNum());
                }
                return temp[temp.length - 1];
            }
        }
    }

    /**
     * @return the number of cards remaining before the next reshuffle
     */
    public int cardsRemaining() {
        return cards.length;
    }

    /**
     * @return whether the deck is empty or not
     */
    public boolean isEmpty() {
        return cards.length == 0;
    }
}
