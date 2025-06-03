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
		Console con = new Console("Gambling; The Game", 1280, 720);
		int intMoney = 1000;
		int intBet = 0;
		int[][] intDeck = new int[52][3];
		int[][] intHand = new  int[5][2];
		// First column is for the rank and second is for suit
		
		lib.Menu(con);
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
		String strName;
		con.drawString("What is your Name?", 500, 315);
		strName = con.readLine();
		// Saves the user's name to memory to be used later when the data gets written to the scoreboard
		con.clear();
		con.setDrawColor(greenblue);
		con.fillRoundRect(420, 310, 380, 50, 30, 30);
		con.setDrawColor(Color.WHITE);
		con.drawString("How Much Do You Want to Bet?", 440, 315);
		intBet = con.readInt();
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

		}
	}
}
