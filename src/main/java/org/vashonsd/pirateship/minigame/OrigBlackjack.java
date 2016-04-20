package org.vashonsd.pirateship.minigame;

import java.io.IOException;

import org.vashonsd.pirateship.io.StringRead;
import org.vashonsd.pirateship.minigame.playingcards.Card;
import org.vashonsd.pirateship.minigame.playingcards.Deck;
import org.vashonsd.pirateship.minigame.playingcards.Hand;

public class OrigBlackjack 
{
	 private static final int HEARTS = 0;
	    private static final int DIAMONDS = 1;
	    private static final int SPADES = 2;
	    private static final int CLUBS = 3;
	    
	    private static final int JACK = 11;
	    private static final int QUEEN = 12;
	    private static final int KING = 13;
	    private static final int ACE = 14;
	    
	    // The starting bankroll for the player.
	    private static final int STARTING_BANKROLL = 100;
	    private double bankroll;
	    
	    private StringRead reader;
	    
	    public int doubleDown = 1;
	    
	    /**
	     * Ask the player for a move, hit or stand.
	     * 
	     * @return A lowercase string of "hit" or "stand"
	     * to indicate the player's move.
	     */
	    private String getPlayerMove() throws IOException
	    {
	        while(true)
	        {
	        	System.out.println("Enter move (hit/stand/double down): ");
	            String move = reader.read();
	            move = move.toLowerCase();
	            
	            if(move.equals("hit") || move.equals("stand") || move.equals("double down"))
	            {
	                return move;
	            }
	            System.out.println("Please try again."); 
	        }
	    }
	    
	    /**
	     * Play the dealer's turn.
	     * 
	     * The dealer must hit if the value of the hand is less
	     * than 17. 
	     * 
	     * @param dealer The hand for the dealer.
	     * @param deck The deck.
	     * @throws IOException 
	     */
	    private void dealerTurn(Hand dealer, Deck deck) throws IOException
	    {
	        while(true)
	        {
	            System.out.println("Dealer's hand");
	            System.out.println(dealer);
	            
	            int value = dealer.getValue();
	            System.out.println("Dealer's hand has value " + value);
	            
	            System.out.println("Enter to continue...");
	            reader.read();
	            
	            if(value < 17)
	            {
	                System.out.println("Dealer hits");
	                Card c = deck.deal();
	                dealer.addCard(c);
	                
	                System.out.println("Dealer card was " + c);
	                
	                if(dealer.busted())
	                {
	                    System.out.println("Dealer busted!");
	                    break;
	                }
	            }
	            else
	            {
	                System.out.println("Dealer stands.");
	                break;
	            }
	        }
	    }
	    
	    /**
	     * Play a player turn by asking the player to hit
	     * or stand.
	     * 
	     * Return whether or not the player busted.
	     */
	    private boolean playerTurn(Hand player, Deck deck) throws IOException
	    {
	        while(true)
	        {
	            String move = getPlayerMove();
	            
	            if(move.equals("hit"))
	            {
	                Card c = deck.deal();
	                System.out.println("Your card was: " + c);
	                player.addCard(c);
	                System.out.println("Player's hand");
	                System.out.println(player);
	                
	                if(player.busted())
	                {
	                    return true;
	                }
	            }
	            
	            if(move.equals("stand"))
	            {
	                // If we didn't hit, the player chose to 
	                // stand, which means the turn is over.
	                return false;
	            }
	            
	            if(move.equals("double down"))
	            {
	                Card c = deck.deal();
	                System.out.println("Your card was: " + c);
	                player.addCard(c);
	                System.out.println("Player's hand");
	                System.out.println(player);
	                doubleDown++;
	                
	                return false;
	            }
	            
	        }
	    }
	    
	    /**
	     * Determine if the player wins. 
	     * 
	     * If the player busted, they lose. If the player did 
	     * not bust but the dealer busted, the player wins.
	     * 
	     * Then check the values of the hands.
	     * 
	     * @param player The player hand.
	     * @param dealer The dealer hand.
	     * @return
	     */
	    private boolean playerWins(Hand player, Hand dealer)
	    {
	        if(player.busted())
	        {
	            return false;
	        }
	        
	        if(dealer.busted())
	        {
	            return true;
	        }
	        
	        return player.getValue() > dealer.getValue();
	    }
	    
	    /**
	     * Check if there was a push, which means the player and
	     * dealer tied.
	     * 
	     * @param player The player hand.
	     * @param dealer The dealer hand.
	     * @return
	     */
	    private boolean push(Hand player, Hand dealer)
	    {
	        return player.getValue() == dealer.getValue();
	    }
	    
	    /**
	     * Find the winner between the player hand and dealer
	     * hand. Return how much was won or lost.
	     */
	    private double findWinner(Hand dealer, Hand player, int bet)
	    {
	        if(playerWins(player, dealer))
	        {
	            System.out.println("Player wins!");
	            
	            if(player.hasBlackjack())
	            {
	                return 1.5 * bet;
	            }
	            
	            return bet;
	        }
	        else if(push(player, dealer))
	        {
	            System.out.println("You push");
	            return 0;
	        }
	        else
	        {
	            System.out.println("Dealer wins");
	            return -bet;
	        }
	    }
	    
	    /**
	     * This plays a round of blackjack which includes:
	     * - Creating a deck
	     * - Creating the hands
	     * - Dealing the round
	     * - Playing the player turn
	     * - Playing the dealer turn
	     * - Finding the winner
	     * 
	     * @param bankroll
	     * @return The new bankroll for the player.
	     */
	    private double playRound(double bankroll) throws IOException
	    {
	        String s;
	        int bet = 0;
	        
	        while(true)
	        {
	        	System.out.println("What is your bet? ");
	        	s = reader.read();
	            bet = StringToInt(Handle(s));
	            
	            if(bet <= bankroll && bet > 0)
	            {
	                break;
	            }
	        }
	        
	        System.out.println("You bet: $" + bet);

	        Deck deck = new Deck();
	        deck.shuffle();
	        
	        Hand player = new Hand();
	        Hand dealer = new Hand();
	        
	        player.addCard(deck.deal());
	        dealer.addCard(deck.deal());
	        player.addCard(deck.deal());
	        dealer.addCard(deck.deal());
	        
	        //Card splitOne = new Card(11, 1);
	        //Card splitTwo = new Card(11, 2);
	        //player.addCard(splitOne);
	        //player.addCard(splitTwo);
	        
	        System.out.println("Player's Hand");
	        System.out.println(player);
	        
	        
	        System.out.println("Dealer's hand");
	        //System.out.println(dealer);
	        dealer.printDealerHand();
	        
	        if(player.getCard(0) == player.getCard(1))
	        {
	        	System.out.println("Would you like to split? (Y/N)");
	            String wantSplit = reader.read();
	            if(wantSplit.equalsIgnoreCase("Y"))
	            {
	                double n = split(player, dealer, bet);
	                bankroll += n;
	                
	                if(n < 0)
	                {
	                    System.out.println("You busted :(");
	                    System.out.println("You lost: $" + bet*2 + "\n" + "Current Bankroll: $" + bankroll);
	                }
	                if(n == 0)
	                {
	                    System.out.println("You broke even");
	                    System.out.println("Bankroll: " + bankroll);
	                }
	                if(n>0)
	                {
	                    System.out.println("You won both hands!");
	                    System.out.println("Bankroll: " + bankroll);
	                }
	                
	                return bankroll;
	            }
	        }
	        
	        boolean playerBusted = playerTurn(player, deck);
	        
	        if(playerBusted)
	        {
	            System.out.println("You busted :(");
	            double finalBankroll = bankroll - bet;
	            System.out.println("You lost: $" + bet + "\n" + "Current Bankroll: $" + finalBankroll);
	            return finalBankroll;
	        }

	        System.out.println("Enter for dealer turn...");
	        reader.read();
	        dealerTurn(dealer, deck);
	        
	        double bankrollChange = findWinner(dealer, player, bet);
	        
	        bankroll += bankrollChange*doubleDown;
	        
	        System.out.println("New bankroll: $" + bankroll);
	        
	        return bankroll;
	    }
	    
	    public double split(Hand player, Hand dealer, int bet) throws IOException
	    {
	        Card c = player.cardAt(0);
	        Card c2 = player.cardAt(1);
	        
	        //bet = bet*2;
	        
	        Hand left = new Hand();
	        Hand right = new Hand();
	        
	        left.addCard(c);
	        right.addCard(c2);
	        
	        Deck deck = new Deck();
	        deck.shuffle();
	        
	        left.addCard(deck.deal());
	        right.addCard(deck.deal());
	        
	        System.out.println("First Hand: " + left);
	        playerTurn(left, deck);
	        
	        System.out.println("Second Hand: " + right);
	        playerTurn(right, deck);
	        
	        System.out.println("Enter for dealer turn...");
	        reader.read();
	        dealerTurn(dealer, deck);
	        
	        double firstHand = (double) findWinner(dealer, left, bet);
	        double secondHand = (double) findWinner(dealer, right, bet);
	        
	        return firstHand + secondHand;
	    }
	    
	    
	    /**
	     * Play the blackjack game. Initialize the bankroll and keep
	     * playing roudns as long as the user wants to.
	     */
	    public void playGame() throws IOException
	    {
	        bankroll = STARTING_BANKROLL;
	        System.out.println("Starting bankroll: $" + bankroll);
	   
	        while(true)
	        {
	            bankroll = playRound(bankroll);
	            
	            doubleDown = 1;
	            
	            if(bankroll <= 0)
	            {
	                break;
	            }
	            
	            System.out.println("Would you like to play again? (Y/N)");
	            String playAgain = reader.read();
	            if(playAgain.equalsIgnoreCase("N"))
	            {
	                break;
	            }
	        }
	        
	        System.out.println("Thanks for playing!");
	    }
	    
	    public String Run()
	    {
	    	try {
				playGame();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return "Bankroll: " + bankroll;
	    }
	    
	    public String Exit() {
	    	return "Thanks for playing!" + "\n" + "You have " + bankroll + " coins left.";
	    }
	    
	    public String Handle(String s) {
	    	int bet;
			try {
				bet = Integer.parseInt(s);
			} catch (NumberFormatException err) {
				return "Sorry, you have to enter a number.";
			}
			
			if(bet <= 0)
	        {
	            System.out.println("You must bet a positive number. Try again.");
	        }
	        
	        if(bet > bankroll)
	        {
	            System.out.println("Insufficient funds. Try again.");
	        }
	        
	        return "" + bet;
	    }
	    
	    public String getPrompt() {
	    	return "Blackjack";
	    }
	    
	    public int StringToInt(String s)
	    {
	    	int ret = 0;
	    	
	    	for(int i=0; i<s.length(); i++)
	    	{
	    		ret += s.charAt(i) * Math.pow(10, i);
	    	}
	    	
	    	return ret;
	    }
		
}
