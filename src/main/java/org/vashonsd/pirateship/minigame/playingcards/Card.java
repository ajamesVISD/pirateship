package org.vashonsd.pirateship.minigame.playingcards;

public class Card
{
	// These constants represent the possible suits and 
	// can be used to index into the suits array to get
	// their string representation.
    private static final int HEARTS = 0;
    private static final int DIAMONDS = 1;
    private static final int SPADES = 2;
    private static final int CLUBS = 3;
    
    // These constants represent the ranks of the non-number
    // cards, or cards above 10. To maintain the ordering after
    // 2-10, the integer values are 11, 12, 13, and 14 and 
    // also allow us to index into the ranks array to get their
    // String representation.
    private static final int JACK = 11;
    private static final int QUEEN = 12;
    private static final int KING = 13;
    private static final int ACE = 14;

    // Instance variables
    
    // This represents the rank of the card, the value from 2 to Ace.
    private int rank;
    
    // This represents the suit of the card, one of hearts, diamonds, spades or clubs.
    private int suit;
    
    // This represents the value of the card, which is 10 for face cards or 11 for an ace.
    private int value;
    
    // This String array allows us to easily get the String value of a Card from its rank.
    // There are two Xs in the front to provide padding so numbers have their String representation
    // at the corresponding index. For example, the String for 2 is at index 2.
    private String[] ranks = {"X", "X", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    
    private String[] rankStrings = {"X", "X", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace"};
    
    // The String array allow us to easily get the String value of the Card for its suit. This
    // is the same order as the suits above so we can index into this array.
    private String[] suits = {"H", "D", "S", "C"};
    
    /**
     * This is the constructor to create a new Card. To create a new card
     * we pass in its rank and its suit.
     * 
     * @param r	The rank of the card, as an int.
     * @param s	The suit of the card, as an int.
     */
    public Card(int r, int s)
    {
        rank = r;
        suit = s;
    }
    
    // Getter Methods
    
    /**
     * This returns the rank of the card as an integer.
     * 
     * @return rank of card as an int.
     */
    public int getRank()
    {
        return rank;
    }
    
    /**
     * This returns the suit of the card as an integer.
     * 
     * @return suit of card as an int.
     */
    public int getSuit()
    {
        return suit;
    }
    
    /**
     * This returns the value of the card as an integer.
     * 
     * For facecards the value is 10, which is different
     * than their rank underlying value. For aces the default
     * value is 11.
     * 
     * @return The value of the card as an int.
     */
    public int getValue()
    {
        int value = rank;
        if(rank > 10)
        {
            value = 10;
        }
        
        if(rank == ACE)
        {
            value = 11;
        }
        
        return value;
    }
    
    /**
     * This utility method converts from a rank integer to a String.
     * 
     * @param r	The rank.
     * @return	String version of rank.
     */
    public String rankToString()
    {
        return ranks[rank];
    }
    
    public String getRankName()
    {
    	return rankStrings[rank];
    }
    
    /**
     * This utility method converts from a suit integer to a String.
     * 
     * @param s	The suit.
     * @return	String version of suit.
     */
    public String suitToString()
    {
        return suits[suit];
    }
    
    
    /**
     * This returns the String representation of a card which 
     * will be two characters. For example, the two of hearts would
     * return 2H. Face cards have a short string so the ace of
     * spades would return AS.
     * 
     * @return String representation of Card.
     */
    public String toString()
    {
        // Get a string for rank
        String rankString = ranks[rank];
        
        // Get a string for the suit
        String suitString = suits[suit];
        
        // combine those
        return rankString + suitString;
    }

    
}

