import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Font;

public class lib {
	static Color jordy = new Color(152, 185, 242);
	static Color cornflower = new Color(111, 156, 235);
	static Color greenblue = new Color(48, 107, 172);
	static Color space = new Color(20, 27, 65);
	static Color tropical = new Color(145, 142, 244);
	static Font rubik = new Font("res/Rubik-Bold.ttf", Font.PLAIN, 24);
	static Font rubikMed = new Font("res/Rubik-Bold.ttf", Font.PLAIN, 64);
	// Initialize all the colors & fonts that will be used for the theme. Colors were picked from coolors.co
	
	public static void Menu(Console con) {
		// Function will serve purpose of drawing out a main menu and giving function to each option
		// Initialize Logo
		// Add keyboard input for play game (p), view leader-board (v) & quit (q)
		BufferedImage imgLogo = con.loadImage("res/logo.png");
		con.setDrawFont(rubik);
		int intY;
		// Logo animation
		for(intY = 680; intY >= 80; intY--) {
			con.setBackgroundColor(cornflower);
			// Sets the fill color to the color of the terminal to overwrite previous draw layer and prepare for the next drawing
			con.drawImage(imgLogo, 440, intY);
			con.repaint();
			// Repaints the draw layer to load the image.
			con.sleep(3);
		}
		menu:
			while(true) {
				con.setBackgroundColor(cornflower);
				con.drawImage(imgLogo, 440, 80);
				// Redraw the logo and background for the menu loop so it does not go through the animation again
				con.setDrawColor(Color.BLACK);
				con.fillRoundRect(395, 245, 460, 260, 30, 30);
				con.setDrawColor(jordy);
				con.fillRoundRect(400, 250, 450, 250, 30, 30);
				con.setDrawColor(Color.WHITE);
				con.fillRect(460, 285, 10, 190);
				con.setDrawColor(space);
				con.drawString("Play (p)", 500, 280);
				con.drawString("View Leaderboard (v)", 500, 330);
				con.drawString("Help (h)", 500, 380);
				con.drawString("Quit (q)", 500, 430);
				con.repaint();
				// Draws the theme for the main menu and repaints layer
			
				// Loops through the conditionals for the menu screen; (p) (q) (v)
				char chKey = con.getChar();
				if(chKey == 'q' || chKey == 'Q') {
					con.closeConsole();
					// Closes console if quit is chosen.
				} else if(chKey == 'v' || chKey == 'V') {
					// Condition for viewing the leaderboard
					String[][] scoreboard = BubbleStr(HighScore());
					// Load the data from HighScore function and then pass it onto the bubble sort function to be sorted in order
					con.setBackgroundColor(greenblue);
					con.setDrawColor(Color.BLACK);
					con.fillRoundRect(395, 0, 460, 720, 30, 30);
					con.setDrawColor(jordy);
					con.fillRoundRect(400, 0, 450, 720, 30, 30);
					con.repaint();
					con.setDrawColor(Color.BLACK);
					con.drawString("Close and Return to Menu (c)", 450, 650);
					con.drawString("Leaderboard", 550, 20);
					// draws the theme for the leaderboard screen
					for(int i = 1; i <= 10; i++) {
						con.drawString(scoreboard[i-1][0], 500, 55*i);
						con.drawString(scoreboard[i-1][1], 700, 55*i);
						con.drawString(Integer.toString(i), 450, 55*i);
						// Numbers the players from 1-10
					}
					con.repaint();
					// loop through the array and print out the top 10 scores
					while(true) {
						chKey = con.getChar();
						if(chKey == 'c' || chKey == 'C') {
							continue menu;
							// continues back to the start of the label menu where the main menu gets redrawn and looped over again
						}
					}
					// this loop waits to get input (c) to close the screen and return to menu
				} else if(chKey == 'p' || chKey == 'P') {
					break menu;
				} else {
				continue menu;
				}
			}
		}
	public static String[][] HighScore() {
		TextInputFile score = new TextInputFile("score.txt");
		// Open the leaderboard file for writing

		String strTemp;
		int intCount = 0;
		while(score.eof() == false) {
			score.readLine();
			score.readLine();
			intCount++;
		}
		// Loop through the file; determine the amount of data to assign to the length of the array
		String[][] strScoreBoard = new String[intCount][2];
		// Assign the amount of data in the file to the new string array
		score.close();
		
		score = new TextInputFile("score.txt");
		// Reopen file so the pointer is back at the start of the file
			int i = 0;
		while(score.eof() == false) {
			strScoreBoard[i][0] = score.readLine();
			strScoreBoard[i][1] = score.readLine();
			i++;
		}
		// loops through the file again and assigns the line to the respective indice
		score.close();
		return strScoreBoard;
	}

	public static String[][] BubbleStr(String[][] strArray) {
		int intLength = strArray.length;
		// use strArray.length to determine the length of the array
		String strNameTemp, strScoreTemp;
		for(int intCount = 0; intCount < intLength - 1; intCount++) {
			for(int i = 0; i < intLength - 1; i++) {
				if( (Integer.parseInt(strArray[i][1])) < (Integer.parseInt(strArray[i+1][1])) ) {
					// convert the score into integer data and compare the size
					// does not check if the first value is greater BUT checks if it is smaller so that it gets sorted as largest to smallest.
					strNameTemp = strArray[i][0];
					strArray[i][0] = strArray[i+1][0];
					strArray[i+1][0] = strNameTemp;
					// swap the player names
					strScoreTemp = strArray[i][1];
					strArray[i][1] = strArray[i+1][1];
					strArray[i+1][1] = strScoreTemp;
				}
			}
		}
		return strArray;
	}

	public static int[][] BubbleDeck(int[][] intArray) {
		int intLength = intArray.length;
		// Just like BubbleStr find the length of the array being sorted
		int intRankTemp, intSuitTemp, intRandTemp;
		for(int intCount = 0; intCount < intLength - 1; intCount++) {
			for(int i = 0; i < intLength - 1; i++) {
				if( (intArray[i][2]) > (intArray[i+1][2]) ) {
					// compare the size of the two integers
					intRankTemp = intArray[i][0];
					intArray[i][0] = intArray[i+1][0];
					intArray[i+1][0] = intRankTemp;
					// swap rank of the cards
					intSuitTemp = intArray[i][1];
					intArray[i][1] = intArray[i+1][1];
					intArray[i+1][1] = intSuitTemp;
					// swap the suit of the cards
					intRandTemp = intArray[i][2];
					intArray[i][2] = intArray[i+1][2];
					intArray[i+1][2] = intRandTemp;
					// swap the random integer attached to the cards
				}
			}
		}
		return intArray;
	}

	public static int[][] BubbleHand(int[][] intArray) {
		int intLength = intArray.length;
		// Find length
		int intRankTemp, intSuitTemp;
		for(int intCount = 0; intCount < intLength - 1; intCount++) {
			for(int i = 0; i < intLength - 1; i++) {
				if( (intArray[i][0]) > (intArray[i+1][0]) ) {
					// compare the size of the two integers
					intRankTemp = intArray[i][0];
					intArray[i][0] = intArray[i+1][0];
					intArray[i+1][0] = intRankTemp;
					// swap rank of the cards
					intSuitTemp = intArray[i][1];
					intArray[i][1] = intArray[i+1][1];
					intArray[i+1][1] = intSuitTemp;
					// swap the suit of the cards
				}
			}
		}
		return intArray;
	}

	public static int Hand(int[][] intHand) {
		// There are 10 possible hands in video poker and this playset is going by jacks or better.
		// This method will identify what hand it is and the correpsonding multiplier to the pot to return.
		// It will start from the highest scoring hand and go down to the lowest as to not skip over higher ranking hands
		intHand = BubbleHand(intHand);
		boolean boolFlush = false;
		boolean boolStraight = false;
		boolean boolJack = false;
		int intMatch = 0; 
		//int intPairNum;
		// Sort the hand to make it easier to read the hand
		for(int i = 0; i < 5; i++) {
		System.out.println(intHand[i][0]);
		}
		if(intHand[0][1] == intHand[1][1] && intHand[1][1] == intHand[2][1] && intHand[2][1] == intHand[3][1] && intHand[3][1] == intHand[4][1]) {
			boolFlush = true;
			// This conditional checks for the requirement of a flush and sets a boolean to true if it is
		} 
		if(intHand[0][0] == intHand[1][0] - 1 && intHand[1][0] == intHand[2][0] - 1 && intHand[2][0] == intHand[3][0] - 1 && intHand[3][0] == intHand[4][0] - 1) {
			boolStraight = true;
			// This conditional checks for a straight and sets a boolean true if it is
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(intHand[i][0] == intHand[j][0] && intHand[i][1] != intHand[j][1]) {
					// Compares each card to each other and if they have the same rank but NOT the same suit (prevents the same card being flagged as another card) it increments the amount of matches
					intMatch++;
					if(intHand[i][0] >= 10) {
						boolJack = true;
						// this is for the case if the one pair is picked and it must be determined if the pair has jacks or better
					}
					// 2 matches == one pair
					// 4 matches == two pair
					// 6 matches == three of a kind
					// 8 matches == full house
					// 12 matches == four of a kind
				}
			}
		} 

		if(boolFlush == true && boolStraight == true) {
			// In poker, if the hand is both a flush and a straight it is either a royal flush or a straight flush so this checks the booleans that were turned on earlier
			if(intHand[4][0] == 13) {
				return 800;
				// If the last card in the sorted array is an ace and the hand has the modifier of being a straight and flush that means it is a royal flush and the corresponding multiplier of 800 is returned
			} else {
				return 50;
				// 50 is the multiplier of a straight flush
			}
		} else if(intMatch == 12) {
			return 25;
			// 25; four of a kind
		} else if(intMatch == 8) {
			return 9;
			// 9; full house
		} else if(boolFlush == true) {
			return 6;
			// 6; flush
		} else if(boolStraight == true) {
			return 4;
			// 4; straight
		} else if(intMatch == 6) {
			return 3;
			// 3; three of a kind
		} else if(intMatch == 4) {
			return 2;
			// 2; two pair
		} else if(intMatch == 2 && boolJack == true) {
			return 1;
			// 1; jacks or better one pair
		} else {
			return 0;
			// whoops, looks like you lost your money :(
		}
	}

	public static void DrawCards(Console con, int[][] intHand) {
		BufferedImage imgBack = con.loadImage("res/back.png");
		BufferedImage imgFront = con.loadImage("res/front.png");
		BufferedImage imgDiamond = con.loadImage("res/diamond.png");
		BufferedImage imgClub = con.loadImage("res/club.png");
		BufferedImage imgHeart = con.loadImage("res/heart.png");
		BufferedImage imgSpade = con.loadImage("res/spade.png");
		// load all images onto memory
		con.drawImage(imgBack, 50, 215);
		con.drawImage(imgBack, 290, 215);
		con.drawImage(imgBack, 530, 215);
		con.drawImage(imgBack, 770, 215);
		con.drawImage(imgBack, 1010, 215);
		con.repaint();
		// Draw all the back graphics for the image
		con.sleep(500);
		// Sleep between the drawing so a smooth animation is made
		con.setDrawColor(tropical);
		con.fillRect(0, 50, 1280, 720);
		con.setDrawColor(Color.BLACK);
		con.drawImage(imgFront, 50, 215);
		con.drawImage(imgFront, 290, 215);
		con.drawImage(imgFront, 530, 215);
		con.drawImage(imgFront, 770, 215);
		con.drawImage(imgFront, 1010, 215);
		con.repaint();
		// Draw the front of the cards

		con.setDrawFont(rubikMed);
		// set to medium sized font
		for(int i = 0; i < 5; i++) {
			if(intHand[i][1] == 1) {
				con.drawImage(imgDiamond, 80+(240*i), 250);
				con.drawImage(imgDiamond, 195+(240*i), 425);
				// diamonds
			} else if(intHand[i][1] == 2) {
				con.drawImage(imgClub, 80+(240*i), 250);
				con.drawImage(imgClub, 195+(240*i), 425);
				// clubs
			} else if(intHand[i][1] == 3) {
				con.drawImage(imgHeart, 80+(240*i), 250);
				con.drawImage(imgHeart, 195+(240*i), 425);
				// hearts
			} else if(intHand[i][1] == 4) {
				con.drawImage(imgSpade, 80+(240*i), 250);
				con.drawImage(imgSpade, 195+(240*i), 425);
				// spades
			}
			if(intHand[i][0] < 10) {
				con.drawString(String.format("%d", intHand[i][0]), 140 + (240*i), 320);
			} else if(intHand[i][0] == 10) {
				con.drawString("J", 140 + (240*i), 320);
			} else if(intHand[i][0] == 11) {
				con.drawString("Q", 140 + (240*i), 320);
			} else if(intHand[i][0] == 12) {
				con.drawString("K", 140 + (240*i), 320);
			} else if(intHand[i][0] == 13) {
				con.drawString("A", 140 + (240*i), 320);
			}
			// if conditions to check if the card if it is a face card and whether to print a letter or the number
		}
		// Loops through the suit of each hand and prints out the corresponding graphic
		con.setDrawFont(rubik);
		con.drawString("1", 160, 550);
		con.drawString("2", 400, 550);
		con.drawString("3", 640, 550);
		con.drawString("4", 880, 550);
		con.drawString("5", 1120, 550);
		// print the number below the card for when the player wants to swap out the cards


	}
	// This function is used for drawing the cards as graphics
}
