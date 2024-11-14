package student;

import java.util.Objects;

public class Card {
    /**
     * The rank of the card.
     */
    private final int rank;
    /**
     * The suit of the card.
     */
    private final int suit;

    /**
     * Constructor.
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13 || suit  < 1 || suit > 4) {
            System.out.println("Invalid Card");
            this.suit = 1;
            this.rank = 1;
        } else {
            this.rank = rank;
            this.suit = suit;
        }
    }

    /**
     * @return the number representation of the cards rank
     */
    public int getRankNum() {
        return rank;
    }

    /**
     * @return the number representation of the cards suit
     */
    public int getSuitNum() {
        return suit;
    }

    /**
     * @return the string naming the cards rank
     */
    public String getRankName() {
        switch (rank) {
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "Ace";
        }
    }

    /**
     *
      * @return the string naming the cards suit
     */
    public String getSuitName() {
        switch (suit) {
            case 2:
                return "Hearts";
            case 3:
                return "Clubs";
            case 4:
                return "Diamonds";
            default:
                return "Spades";
        }
    }

    @Override
    public String toString() {
        return getRankName() + " of " + getSuitName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            Card c = (Card) obj;
            if (Objects.equals(c.getRankName(), this.getRankName())
                    && Objects.equals(c.getSuitName(), this.getSuitName())) {
                return true;
            }
        }
        return false;
    }
}
