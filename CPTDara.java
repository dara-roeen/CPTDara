import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class CPTDara {

	static Color jordy = new Color(152, 185, 242);
	static Color cornflower = new Color(111, 156, 235);
	static Color greenblue = new Color(48, 107, 172);
	static Color space = new Color(20, 27, 65);
	static Color tropical = new Color(145, 142, 244);
	static Font rubik = new Font("res/Rubik-Bold.ttf", Font.PLAIN, 24);
	// Initialize all the colors & fonts that will be used for the theme. Colors were picked from coolors.co

public static void main(String[] args) {
		while(true) {
			Console con = new Console("Gambling; The Game", 1280, 720);
			int intMoney = 1000;
			int intBet = 0;
			int intMult;
			int intDiscLen;
			int[][] intDeck = new int[52][3];
			int[][] intHand = new  int[5][2];
			// First column is for the rank and second is for suit
			String strCont;
			String strDiscard = "";
			String strName = null;
			lib.Menu(con);
			while(true) {
				// Call the menu function to handle all cases and break to access the main game.
				con.setDrawFont(rubik);
				con.setBackgroundColor(tropical);
				con.setDrawColor(Color.BLACK);
				con.fillRoundRect(415, 305, 390, 60, 30, 30);
				con.setDrawColor(greenblue);
				con.fillRoundRect(420, 310, 380, 50, 30, 30);
				con.setDrawColor(space);
				con.fillRect(0, 0, 1280, 40);
				con.setDrawColor(Color.BLACK);
				con.fillRect(0, 40, 1280, 10);
				con.repaint();
				// Draws all of the UI for the game section
		
				con.setDrawColor(Color.WHITE);
				con.drawString(String.format("Bank: $%d",intMoney), 1050, 0);
				con.drawString(String.format("Pot: $%d",intBet), 900, 0);
				// Shows the player how much money they have at the moment
				con.sleep(5);
				// Sleep so that when play game is selected it does not interfere with the input for the name
				if(strName == null) {
					con.drawString("What is your Name?", 500, 315);
					strName = con.readLine();
					// Saves the user's name to memory to be used later when the data gets written to the scoreboard
				}
				// if conditional checks if name has not been written to already
				con.clear();
				con.setDrawColor(greenblue);
				con.fillRoundRect(420, 310, 380, 50, 30, 30);
				con.setDrawColor(Color.WHITE);
					con.drawString("How Much Do You Want to Bet?", 440, 315);
					intBet = con.readInt();
					if(intBet > intMoney || intBet < 0) {
						// condition if the player enters too much money that they do not have
						while(true) {
							con.clear();
							con.setDrawColor(greenblue);
							con.fillRoundRect(420, 310, 380, 50, 30, 30);
							con.setDrawColor(Color.WHITE);
							con.drawString("Invalid Bet, Try Again.", 480, 315);
							intBet = con.readInt();
							if(intBet > intMoney || intBet < 0) {
								continue;
							} else {
								break;
							}
						} 
						// this while loop loops over until the player enters a valid amount of money
					}
				intMoney = intMoney - intBet;
				con.setDrawColor(space);
				con.fillRect(0, 0, 1280, 40);
				con.setDrawColor(Color.WHITE);
				con.drawString(String.format("Bank: $%d",intMoney), 1050, 0);
				con.drawString(String.format("Pot: $%d",intBet), 900, 0);
				// Subtracts the bet amount from the total money
		
		
				con.clear();
				con.setDrawColor(greenblue);
				con.fillRoundRect(420, 310, 380, 50, 30, 30);
				con.setDrawColor(tropical);
				con.fillRect(0, 50, 1280, 720);
				// Clear the board to display the cards
				for(int i = 0; i < 52; i++) {
					if(i < 13) {
						intDeck[i][0] = i+1;
					} else if(i < 26) {
						intDeck[i][0] = i-12;
					} else if(i < 39) {
						intDeck[i][0] = i-25;
					} else {
						intDeck[i][0] = i-38;
					}
				}
				// This for loop fills the first column of the deck with the 1-13 for each number and face card.
				for(int i = 0; i < 52; i++) {
					if(i < 13) {
						intDeck[i][1] = 1;
					} else if(i < 26) {
						intDeck[i][1] = 2;
					} else if(i < 39) {
						intDeck[i][1] = 3;
					} else {
						intDeck[i][1] = 4;
					}
				}
				// This for loop fills the second column which classifies the cards by suite.
				for(int i = 0; i < 52; i++) {
					intDeck[i][2] = (int) (Math.random()*1000+1);
				}
				// This last for loop fills the final column with random numbers so the array can be bubble sorted and randomized.
				intDeck = lib.BubbleDeck(intDeck);
				// Pass the deck onto the bubble sort array to be shuffled
				for(int i = 0; i < 5; i++) {
				intHand[i][0] = intDeck[i][0];
				intHand[i][1] = intDeck[i][1];
				}
				// Passes the first 5 cards to the hand array.
		
				con.setDrawColor(Color.WHITE);
				con.drawString(String.format("%d, suite: %d",intHand[0][0], intHand[0][1]), 200, 215);
				con.drawString(String.format("%d, suite: %d",intHand[1][0], intHand[1][1]), 400, 215);
				con.drawString(String.format("%d, suite: %d",intHand[2][0], intHand[2][1]), 600, 215);
				con.drawString(String.format("%d, suite: %d",intHand[3][0], intHand[3][1]), 800, 215);
				con.drawString(String.format("%d, suite: %d",intHand[4][0], intHand[4][1]), 1000, 215);


				// TEST //
				lib.DrawCards(con, intHand);
				// TEST //


				// print out the ranks of the hand with the suit
				con.drawString("1", 200, 250);
				con.drawString("2", 400, 250);
				con.drawString("3", 600, 250);
				con.drawString("4", 800, 250);
				con.drawString("5", 1000, 250);
				// print the number below the card for when the player wants to swap out the cards.

				con.drawString("Would you like to discard any cards?", 400, 400);
				strDiscard = con.readLine();
				con.clear();
				intDiscLen = strDiscard.length();
				for(int i = 0; i < intDiscLen; i++) {
					if(strDiscard.charAt(i) == '1') {
						intHand[0][0] = intDeck[i+5][0];
						intHand[0][1] = intDeck[i+5][1];
					} else if(strDiscard.charAt(i) == '2') {
						intHand[1][0] = intDeck[i+5][0];
						intHand[1][1] = intDeck[i+5][1];
					} else if(strDiscard.charAt(i) == '3') {
						intHand[2][0] = intDeck[i+5][0];
						intHand[2][1] = intDeck[i+5][1];
					} else if(strDiscard.charAt(i) == '4') {
						intHand[3][0] = intDeck[i+5][0];
						intHand[3][1] = intDeck[i+5][1];
					} else if(strDiscard.charAt(i) == '5') {
						intHand[4][0] = intDeck[i+5][0];
						intHand[4][1] = intDeck[i+5][1];
					}
				}

				con.setBackgroundColor(tropical);
				con.setDrawColor(Color.WHITE);
				con.drawString(String.format("%d, suite: %d",intHand[0][0], intHand[0][1]), 200, 215);
				con.drawString(String.format("%d, suite: %d",intHand[1][0], intHand[1][1]), 400, 215);
				con.drawString(String.format("%d, suite: %d",intHand[2][0], intHand[2][1]), 600, 215);
				con.drawString(String.format("%d, suite: %d",intHand[3][0], intHand[3][1]), 800, 215);
				con.drawString(String.format("%d, suite: %d",intHand[4][0], intHand[4][1]), 1000, 215);
				// print out the new ranks of the cards in the replaced hand with the suit
				con.drawString("1", 200, 250);
				con.drawString("2", 400, 250);
				con.drawString("3", 600, 250);
				con.drawString("4", 800, 250);
				con.drawString("5", 1000, 250);
				
				con.sleep(500);
				intMult = lib.Hand(intHand);
				// Pass the array for the hand to the function to calculate the return value for the multiplier.
				con.drawString("Bet Returned", 480, 350);
				if(intMult == 0) {
					con.drawString(String.format("High Card/Less than jacks pair, %d lost.",intBet), 480, 300);
				} else if(intMult == 1) {
					con.drawString(String.format("Jacks or Better Pair, same bet returned."), 480, 300);
				} else if(intMult == 2) {
					con.drawString(String.format("Two Pair, %d gained.",intBet*2), 480, 300);
				} else if(intMult == 3) {
					con.drawString(String.format("Three of a Kind, %d gained.",intBet*3), 480, 300);
				} else if(intMult == 4) {
					con.drawString(String.format("Straight, %d gained.",intBet*4), 480, 300);
				} else if(intMult == 6) {
					con.drawString(String.format("Flush, %d gained.",intBet*6), 480, 300);
				} else if(intMult == 9) {
					con.drawString(String.format("Full House, %d gained.",intBet*9), 480, 300);
				} else if(intMult == 25) {
					con.drawString(String.format("Four of a Kind, %d gained.",intBet*25), 480, 300);
				} else if(intMult == 50) {
					con.drawString(String.format("Straight Flush, %d gained.",intBet*50), 480, 300);
				} else if(intMult == 800) {
					con.drawString(String.format("Royal Flush, %d gained.",intBet*800), 480, 300);
				}
				// If conditional goes through each case and gives a custom message corresponding on what hand you get.
				intBet = intBet*intMult;
				// Get the value of the multiplier and calculate the bet amount
				intMoney = intMoney + intBet;
				intBet = 0;
				// Change the values of the bet and money to reflect the money returned
				con.setDrawColor(space);
				con.fillRect(0, 0, 1280, 40);
				con.setDrawColor(Color.WHITE);
				con.drawString(String.format("Bank: $%d",intMoney), 1050, 0);
				con.drawString(String.format("Pot: $%d",intBet), 900, 0);
				if(intMoney == 0) {
					con.drawString("Ouch, you lost. Any Words", 480, 400);
					TextOutputFile leaderboard = new TextOutputFile("score.txt", true);
					// Open the score.txt files to write and append to last line
					leaderboard.println(strName);
					leaderboard.println(intMoney);
					leaderboard.close();
					// print the name and amount of money had and close the file
					con.sleep(1000);
					con.readLine();
					break;
				}
					// If the player has 0 dollars stop break the loop and end the game to prevent debt.
				con.drawString("Continue? (y/n)", 480, 400);
				strCont = con.readLine();
				if(strCont.equalsIgnoreCase("y")) {
					continue;
				} else if(strCont.equalsIgnoreCase("n")) {
					TextOutputFile leaderboard = new TextOutputFile("score.txt", true);
					// Open the score.txt files to write and append to last line
					leaderboard.println(strName);
					leaderboard.println(intMoney);
					leaderboard.close();
					// print the name and amount of money had and close the file
					break;
				} else {
					continue;
					// the game never stops, only denial ensures your escape...
				}
				// These else if and if conditionals check for the input the player gave to continue or not.
			}
		}
	}
}
