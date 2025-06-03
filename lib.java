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
					String[][] scoreboard = HighScore();
					// Load the data from HighScore function
					con.setBackgroundColor(greenblue);
					con.setDrawColor(Color.BLACK);
					con.fillRoundRect(395, 0, 460, 720, 30, 30);
					con.setDrawColor(jordy);
					con.fillRoundRect(400, 0, 450, 720, 30, 30);
					con.repaint();
					con.setDrawColor(Color.WHITE);
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

	//public static String[][] BubbleStr(String[][] array) {
	
	//}

}
