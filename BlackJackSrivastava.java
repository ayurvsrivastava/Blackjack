import java.util.*;
import java.util.Random;
import javax.swing.JOptionPane;
public class BlackJackSrivastava {
	//All of The public variables that are needed for this code to work...
	Random rand = new Random();
	public String name;
	String cardOne, cardTwo, cardThree, cardFour, cardFive;
	String dOne, dTwo, dThree, dFour, dFive;
	String value;
	int coins = 100;
	int bet;
	int reply;
	int pValue, pValue1, pValue2, pValue3, pValue4;
	int dValue, dValue1, dValue2, dValue3, dValue4;
	int pTotal = 0;
	int dTotal = 0;
	int card, suit;
	public String confirmation;
	public boolean confirm = false;
	ArrayList<String> spades = new ArrayList<String>();
	ArrayList<String> diamonds = new ArrayList<String>();
	ArrayList<String> clubs = new ArrayList<String>();
	ArrayList<String> hearts = new ArrayList<String>();
	
	//Sets up the Welcome Screen
	public void welcome() {
		name = JOptionPane.showInputDialog("Hey! Welcome To Black Jack! \nWhats your name?");
		if (name == null) {
			reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
			if (reply == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			if (reply == JOptionPane.NO_OPTION) {
				name = JOptionPane.showInputDialog("Hey! Welcome To Black Jack! \nWhats your name?");
			}
		}
	}
	
	//Describes all the Rules of The game
	public void rules() {
		JOptionPane.showMessageDialog(null, "Black Jack is really simple, " + name + "!\nAll you have to do is get 21 or as close as you can. All face cards except Aces are worth 10. Every card is worth their respective value\ni.e. 2's are worth 2, and 3's are worth 3. Aces are worth 11 unless you pass 21. Then the Aces are worth 1!\nThe dealer will always hit before 16, and if you go past 21 then you bust!");
	}
	
	//Uses JOptionPane to ask the user for a certain amount of coins to bet
	public void bet() {
		System.out.println(bet);
		//Needed in case user inputs a non-integer into input box
		try {
			bet = Integer.parseInt(JOptionPane.showInputDialog("You have " + coins + " coins\nHow much would you like to bet?"));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bet an Actual Amount...");
			System.exit(0);
		}
		if ((bet <= 0)) {
			JOptionPane.showMessageDialog(null, "Bet an Actual Amount...");
			System.exit(0);
		}
		if (bet  > coins) {
			JOptionPane.showMessageDialog(null, "You Don't have that many coins...");
			System.exit(0);
		}
		reply = JOptionPane.showConfirmDialog(null, "You have bet " + bet + " coins. Would you like to change it?");
		if (reply == JOptionPane.YES_OPTION) {
			try {
				bet = Integer.parseInt(JOptionPane.showInputDialog("You have " + coins + " coins\nHow much would you like to bet?"));
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Bet an Actual Amount...");
				System.exit(0);
			}
			if ((bet <= 0)) {
				JOptionPane.showMessageDialog(null, "Bet an Actual Amount...");
				System.exit(0);
			}
			if (bet  > coins) {
				JOptionPane.showMessageDialog(null, "You Don't have that many coins...");
				System.exit(0);
			}
		}
		if (reply == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Lets Play!");
		}
		if (reply == JOptionPane.CANCEL_OPTION) {
			reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?");
			if (reply == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			if (reply == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Awesome!!");
				return;
			}
		}
	}
	
	//Creates 5 cards with their values stored for the players.
	public void dealPlayer() {
		//Selects random numbers between 1 and 52 because it is more random than sorting an array several times/
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			cardOne = "spades";
		}
		if(suit == 2) {
			cardOne = "diamonds";
		}
		if(suit == 3) {
			cardOne = "clubs";
		}
		if(suit == 4) {
			cardOne = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			pValue = pValue + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			} 
		} else if (card == 1) {
			pValue = pValue + 11;
			value = "ace";
		} else {
			pValue = pValue + card;
			value = String.valueOf(card);
		}
		cardOne = value + " of " + cardOne;
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			cardTwo = "spades";
		}
		if(suit == 2) {
			cardTwo = "diamonds";
		}
		if(suit == 3) {
			cardTwo = "clubs";
		}
		if(suit == 4) {
			cardTwo = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			pValue1 = pValue1 + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			}
		}  else if (card == 1) {
			pValue1 = pValue1 + 11;
			value = "ace";
		} else {
			pValue1 = pValue1 + card;
			value = String.valueOf(card);
		}
		cardTwo = value + " of " + cardTwo;
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			cardThree = "spades";
		}
		if(suit == 2) {
			cardThree = "diamonds";
		}
		if(suit == 3) {
			cardThree = "clubs";
		}
		if(suit == 4) {
			cardThree = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			pValue2 = pValue2 + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			}
		} else if (card == 1) {
			pValue2 = pValue2 + 11;
			value = "ace";
		} else {
			pValue2 = pValue2 + card;
			value = String.valueOf(card);
		}
		cardThree = value + " of " + cardThree;
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			cardFour = "spades";
		}
		if(suit == 2) {
			cardFour = "diamonds";
		}
		if(suit == 3) {
			cardFour = "clubs";
		}
		if(suit == 4) {
			cardFour = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			pValue3 = pValue3 + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			}
		} else if (card == 1) {
			pValue3 = pValue3 + 11;
			value = "ace";
		} else {
			pValue3 = pValue3 + card;
			value = String.valueOf(card);
		}
		cardFour = value + " of " + cardFour;
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			cardFive = "spades";
		}
		if(suit == 2) {
			cardFive = "diamonds";
		}
		if(suit == 3) {
			cardFive = "clubs";
		}
		if(suit == 4) {
			cardFive = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			pValue4 = pValue4 + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			}
		} else if (card == 1) {
			pValue4 = pValue4 + 11;
			value = "ace";
		} else {
			pValue4 = pValue4 + card;
			value = String.valueOf(card);
		}
		cardFive = value + " of " + cardFive;
	}
	
	//does the exact same thing as dealPlayer just for the dealer so that it can run through for him as well
	public void dealDealer() {
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			dOne = "spades";
		}
		if(suit == 2) {
			dOne = "diamonds";
		}
		if(suit == 3) {
			dOne = "clubs";
		}
		if(suit == 4) {
			dOne = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			dValue = dValue + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			}
		} else if (card == 1) {
			dValue = dValue + 11;
			value = "ace";
		} else {
			dValue = dValue + card;
			value = String.valueOf(card);
		}
		dOne = value + " of " + dOne;
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			dTwo = "spades";
		}
		if(suit == 2) {
			dTwo = "diamonds";
		}
		if(suit == 3) {
			dTwo = "clubs";
		}
		if(suit == 4) {
			dTwo = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			dValue1 = dValue1 + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			}
		} else if (card == 1) {
			dValue1 = dValue1 + 11;
			value = "ace";
		} else {
			dValue1 = dValue1 + card;
			value = String.valueOf(card);
		}
		dTwo = value + " of " +  dTwo;
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			dThree = "spades";
		}
		if(suit == 2) {
			dThree = "diamonds";
		}
		if(suit == 3) {
			dThree = "clubs";
		}
		if(suit == 4) {
			dThree = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			dValue2 = dValue2 + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			}
		}  else if (card == 1) {
			dValue2 = dValue2 + 11;
			value = "ace";
		} else {
			dValue2 = dValue2 + card;
			value = String.valueOf(card);
		}
		dThree = value + " of " + dThree;
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			dFour = "spades";
		}
		if(suit == 2) {
			dFour = "diamonds";
		}
		if(suit == 3) {
			dFour = "clubs";
		}
		if(suit == 4) {
			dFour = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			dValue3 = dValue3 + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			}
		} else if (card == 1) {
			dValue3 = dValue3 + 11;
			value = "ace";
		} else {
			dValue3 = dValue3 + card;
			value = String.valueOf(card);
		}
		dFour = value + " of " + dFour;
		suit = rand.nextInt(4) + 1;
		if(suit == 1) {
			dFive = "spades";
		}
		if(suit == 2) {
			dFive = "diamonds";
		}
		if(suit == 3) {
			dFive = "clubs";
		}
		if(suit == 4) {
			dFive = "hearts";
		}
		card = rand.nextInt(13) + 1;
		if (card > 10) {
			dValue4 = dValue4 + 10;
			if ( card == 11 ) {
				value = "jack";
			} else if ( card == 12) {
				value = "queen";
			} else {
				value = "king";
			}
		} else if (card == 1) {
			dValue4 = dValue4 + 11;
			value = "ace";
		} else {
			dValue4 = dValue4
					+ card;
			value = String.valueOf(card);
		}
		dFive = value + " of " + dFive;
	}
	
	//Actually instigates the playing of the game and allows for users the user to play BlackJack in a JOptionPane.
	public void play() {
		pTotal = pValue + pValue1;
		dTotal = dValue + dValue1;
		reply = JOptionPane.showConfirmDialog(null, "Your Cards are "+ cardOne + " and " + cardTwo + "\nAnd your total is " + pTotal + "\nThe dealers cards are " + dOne + " and " + dTwo + "\nAnd their total is" +  dTotal + "\nWould you like to hit?"); 
		if (reply == JOptionPane.YES_OPTION) {
			pTotal = pTotal + pValue2;
			if (pTotal > 21) {
				JOptionPane.showMessageDialog(null, "You Lost :'(... Your Total was " + pTotal + "\nAnd The dealers was " + dTotal);
				coins = coins - bet;
				return;
			}
			if (dTotal < 16) {
				dTotal = dTotal + dValue2;
				if (dTotal > 21) {
					JOptionPane.showMessageDialog(null, "You Win!!!");
					coins = coins + bet;
					return;
				}
			}
				reply = JOptionPane.showConfirmDialog(null, "Your Cards are "+ cardOne + " and " + cardTwo + " and " + cardThree +"\nAnd your total is " + pTotal + "\nThe dealers cards are " + dOne + " and " + dTwo + " and " + dThree + "\nAnd their total is" +  dTotal + "\nWould you like to hit?");
				if (reply == JOptionPane.YES_OPTION) {
					pTotal = pTotal + pValue3;
					if(pTotal > 21) {
						JOptionPane.showMessageDialog(null, "You Lost :'(... Your Total was " + pTotal + "\nAnd The dealers was " + dTotal);
						coins = coins - bet;
						return;
					} else if (dTotal < 16) {
						dTotal = dTotal + dValue3;
						if (dTotal > 21) {
							JOptionPane.showMessageDialog(null, "You Win!!!");
							coins = coins + bet;
							return;
						}
					} else if (dTotal > 21) {
						JOptionPane.showMessageDialog(null, "You Win!!!");
						coins = coins + bet;
						return;
					}
					if (pTotal < 21) {
						if (dTotal < 21) {
						reply = JOptionPane.showConfirmDialog(null, "Your Cards are "+ cardOne + " and " + cardTwo + " and " + cardThree  + cardFour +"\nAnd your total is " + pTotal + "\nThe dealers cards are " + dOne + " and " + dTwo + " and " + dThree + dFour + "\nAnd their total is" +  dTotal + "\nWould you like to hit?");
						}
					}
					if (reply == JOptionPane.YES_OPTION) {
						pTotal = pTotal + pValue4;
						if(pTotal > 21) {
							JOptionPane.showMessageDialog(null, "You Lost :'(... Your Total was " + pTotal + "\nAnd The dealers was " + dTotal);
							coins = coins - bet;
							return;
						} else if (dTotal < 16) {
							dTotal = dTotal + dValue4;
							if (dTotal > 21) {
								JOptionPane.showMessageDialog(null, "You Win!!!");
								coins = coins + bet;
								return;
							}
						} else if (dTotal > 21) {
							JOptionPane.showMessageDialog(null, "You Win!!!");
							coins = coins + bet;
							return;
						}
					}
					if (reply == JOptionPane.CANCEL_OPTION) {
						reply = JOptionPane.showConfirmDialog(null, "Are you sure you would like to cancel?");
						if (reply == JOptionPane.YES_OPTION) {
							System.exit(0);
						}
						if(reply == JOptionPane.NO_OPTION) {
							JOptionPane.showMessageDialog(null, "Awesome!");
							return;
						}
					}
					if (reply == JOptionPane.NO_OPTION) {
						if (dTotal < 16) {
							dTotal = dTotal + dValue4;
						}
						if (pTotal > 21) {
							JOptionPane.showMessageDialog(null, "You Lost :'(... Your Total was " + pTotal + "\nAnd The dealers was " + dTotal);
							coins = coins - bet;
							return;
						}
						else if (dTotal > 21) {
							JOptionPane.showMessageDialog(null, "You Win!!!");
							coins = coins + bet;
							return;
						}
						else if (pTotal > dTotal) {
							JOptionPane.showMessageDialog(null, "You Win!!!");
							coins = coins + bet;
							return;
						}
						else if (dTotal > pTotal) {
							JOptionPane.showMessageDialog(null, "You Lost :'(... Your Total was " + pTotal + "\nAnd The dealers was " + dTotal);
							coins = coins - bet;
							return;
						}
						else if (dTotal == pTotal) {
							JOptionPane.showMessageDialog(null, "You Tied...");
							return;
						}
 					}
				}
				if (reply == JOptionPane.CANCEL_OPTION) {
					reply = JOptionPane.showConfirmDialog(null, "Are you sure you would like to cancel?");
					if (reply == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
					if(reply == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Awesome!");
						return;
					}
				}
				if (reply == JOptionPane.NO_OPTION) {
					if (dTotal < 16) {
						dTotal = dTotal + dValue3;
					}
					if (dTotal < 16) {
						dTotal = dTotal + dValue4;
					}
					if (dTotal > 21 ) {
						JOptionPane.showMessageDialog(null, "You Win!!!");
						coins = coins + bet;
						return;
					}
					else if (pTotal < dTotal) {
						JOptionPane.showMessageDialog(null, "You Lost :'(... Your Total was " + pTotal + "\nAnd The dealers was " + dTotal);
						coins = coins - bet;
						return;
					} else if (pTotal > dTotal) {
						coins = coins + bet;
						JOptionPane.showMessageDialog(null, "You Win!!!");
						return;
					} else {
						JOptionPane.showMessageDialog(null, "You Tied...");
						return;
					}
				}
		}
		if (reply == JOptionPane.CANCEL_OPTION) {
			reply = JOptionPane.showConfirmDialog(null, "Are you sure you would like to cancel?");
			if (reply == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			if(reply == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Awesome!");
				return;
			}
		}
		if (reply == JOptionPane.NO_OPTION) {
			if (dTotal < 16) {
				dTotal = dTotal + dValue2;
			}
			if (dTotal < 16) {
				dTotal = dTotal + dValue3;
			}
			if (dTotal < 16) {
				dTotal = dTotal + dValue4;
			}
			if (pTotal > 21) {
				JOptionPane.showMessageDialog(null, "You Lost :'(... Your Total was " + pTotal + "\nAnd The dealers was " + dTotal);
				coins = coins - bet;
				return;
			}
			else if (dTotal > 21) {
				JOptionPane.showMessageDialog(null, "You Win!!!");
				coins = coins + bet;
				return;
			}
			else if (pTotal > dTotal) {
				JOptionPane.showMessageDialog(null, "You Win!!!");
				coins = coins + bet;
				return;
			}
			else if (dTotal > pTotal) {
				JOptionPane.showMessageDialog(null, "You Lost :'(... Your Total was " + pTotal + "\nAnd The dealers was " + dTotal);
				coins = coins - bet;
				return;
			}
			else if (dTotal == pTotal) {
				JOptionPane.showMessageDialog(null, "You Tied...");
				return;
			}
		}
	}
	
	//Main Method to Run the entire code.
	public static void main (String args[]) {
		BlackJackSrivastava run = new BlackJackSrivastava();
		run.welcome();
		run.rules();
		while (run.coins > 0) {
			run.pTotal = 0;
			run.dTotal = 0;
			run.pValue = 0;
			run.pValue1 = 0;
			run.pValue2 = 0;
			run.pValue3 = 0;
			run.pValue4 = 0;
			run.dValue = 0;
			run.dValue1 = 0;
			run.dValue2 = 0;
			run.dValue3 = 0;
			run.dValue4 = 0;
			run.bet();
			run.dealPlayer();
			run.dealDealer();
			run.play();
			System.out.println(run.pTotal);
			System.out.println(run.dTotal);
		}
		JOptionPane.showMessageDialog(null, "Guess You Lost... Get better at gambling I guess");
	}
}
