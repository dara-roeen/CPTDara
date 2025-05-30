import arc.*;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class lib {
	
	public static void Menu(Console con) {
		// Function will serve purpose of drawing out a main menu and giving function to each option
		// Initialize Logo
		// Add keyboard input for play game (p), view leader-board (v) & quit (q)
		BufferedImage imgLogo = con.loadImage("/home/dara/Documents/GitHub/CPTDara/res/logo.png");
		int intY;
		// Logo animation
		for(intY = 680; intY >= 80; intY--) {
			con.setBackgroundColor(Color.BLACK);
			// Sets the fill color to the color of the terminal to overwrite previous draw layer and prepare for the next drawing
			con.drawImage(imgLogo, 540, intY);
			con.repaint();
			// Repaints the draw layer to load the image.
			con.sleep(3);
		}
		con.setDrawColor(Color.WHITE);
		con.drawString("Play (p)", 500, 240);
		con.drawString("View Leaderboard (v)", 500, 280);
		con.drawString("Quit (q)", 500, 320);
		con.drawString("Help (h)", 500, 360);
		con.repaint();
		
		// Loops through the conditionals for the menu screen; (p) (q) (v)
		while(true) {
			char chKey = con.getChar();
			if(chKey == 'q' || chKey == 'Q') {
				con.closeConsole();
				// Closes console if quit is chosen.
			} else if(chKey == 'v' || chKey == 'V') {
				String[] scoreboard = HighScore();
				con.setBackgroundColor(Color.BLACK);
				con.repaint();
				for(int i = 0; i < 10; i++) {
					con.drawString(scoreboard[i], 500, 20*i);
					con.repaint();
				}


			} else {
				continue;
			}
		}
	}

	public static String[] HighScore() {
		TextInputFile score = new TextInputFile("score.txt");

		String strTemp;
		int intCount = 0;
		while(score.eof() == false) {
			strTemp = score.readLine();
			intCount++;
		}
		// Loop through the file; determine the amount of data to assign to the array
		String[] strScoreBoard = new String[intCount];
		// Assign the amount of data in the file to the new string array
		score.close();
		

		score = new TextInputFile("score.txt");
		for(int i = 0; i < intCount; i++) {
			strScoreBoard[i] = score.readLine();
		}
		score.close();
		return strScoreBoard;
	}
}
