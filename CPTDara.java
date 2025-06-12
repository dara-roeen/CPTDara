// Dara Roeen
// Gambling: The Game
// 2025/06/12
// 1.34

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
			Console con = new Console("Gambling: The Game", 1280, 720);
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
			// Call the menu function to handle all cases and break to access the main game.
			lib.Menu(con);
			while(true) {
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
					// Saves the user's name to memory to be used later when the data gets written to the scoreboard
					strName = con.readLine();
					if(strName.equals("statitan")) {
						intMoney = 1000000;
						con.setDrawColor(space);
						con.fillRect(0, 0, 1280, 40);
						con.setDrawColor(Color.WHITE);
						con.drawString(String.format("Bank: $%d",intMoney), 1050, 0);
						con.drawString(String.format("Pot: $%d",intBet), 900, 0);
					}
					// This if statement checks for the secret code name "statitan and gives $1 million cash if it is entered"
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
					intDeck[i][2] = (int) (Math.random()*100+1);
				}
				// This last for loop fills the final column with random numbers so the array can be bubble sorted and randomized.
				intDeck = lib.BubbleDeck(intDeck);
				// Pass the deck onto the bubble sort array to be shuffled
				for(int i = 0; i < 5; i++) {
				intHand[i][0] = intDeck[i][0];
				intHand[i][1] = intDeck[i][1];
				}
				// Add the first 5 cards of the deck to the player hand.
		
				lib.DrawCards(con, intHand);
				// passes the hand to the DrawCards function which sets the whole board

				con.setDrawColor(Color.BLACK);
				con.fillRoundRect(410, 105, 400, 60, 30, 30);
				con.setDrawColor(greenblue);
				con.fillRoundRect(415, 110, 390, 50, 30, 30);
				con.setDrawColor(Color.WHITE);
				con.drawString("Would you like to discard any cards?", 420, 115);
				// asks for the cards they want to get rid of and redraw.
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
				// This for loop loops through each card that was given to be discarded and grabs a new card from the hand if so

				con.setBackgroundColor(tropical);
				lib.DrawCards(con, intHand);
				// print out the new ranks of the cards in the replaced hand with the suit
				
				con.sleep(500);
				intMult = lib.Hand(intHand);
				// Pass the array for the hand to the function to calculate the return value for the multiplier.
				con.setDrawColor(Color.BLACK);
				con.fillRoundRect(400, 105, 480, 60, 30, 30);
				con.setDrawColor(greenblue);
				con.fillRoundRect(405, 110, 470, 50, 30, 30);
				con.setDrawColor(Color.WHITE);
				// draw the box for the text to be displayed.
				if(intMult == 0) {
					con.drawString(String.format("High Card/Less than jacks pair, $%d lost.",intBet), 420, 115);
				} else if(intMult == 1) {
					con.drawString(String.format("Jacks or Better Pair, same bet returned."), 420, 115);
				} else if(intMult == 2) {
					con.drawString(String.format("Two Pair, $%d gained.",intBet*2), 420, 115);
				} else if(intMult == 3) {
					con.drawString(String.format("Three of a Kind, $%d gained.",intBet*3), 420, 115);
				} else if(intMult == 4) {
					con.drawString(String.format("Straight, $%d gained.",intBet*4), 420, 115);
				} else if(intMult == 6) {
					con.drawString(String.format("Flush, $%d gained.",intBet*6), 420, 115);
				} else if(intMult == 9) {
					con.drawString(String.format("Full House, $%d gained.",intBet*9), 420, 115);
				} else if(intMult == 25) {
					con.drawString(String.format("Four of a Kind, $%d gained.",intBet*25), 420, 115);
				} else if(intMult == 50) {
					con.drawString(String.format("Straight Flush, $%d gained.",intBet*50), 420, 115);
				} else if(intMult == 800) {
					con.drawString(String.format("Royal Flush, $%d gained.",intBet*800), 420, 115);
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
					con.setDrawColor(Color.BLACK);
					con.fillRoundRect(490, 305, 320, 60, 30, 30);
					con.setDrawColor(greenblue);
					con.fillRoundRect(495, 310, 310, 50, 30, 30);
					con.setDrawColor(Color.WHITE);
					con.drawString("Ouch, you lost. Any Words?", 500, 315);
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
				con.setDrawColor(Color.BLACK);
				con.fillRoundRect(490, 305, 180, 60, 30, 30);
				con.setDrawColor(greenblue);
				con.fillRoundRect(495, 310, 170, 50, 30, 30);
				con.setDrawColor(Color.WHITE);
				con.drawString("Continue? (y/n)", 500, 315);
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
