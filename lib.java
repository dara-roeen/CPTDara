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
		//con.setDrawColor(Color.BLACK);
		//con.fillRect(0, 0, 1280, 720);
		//con.setDrawColor(Color.WHITE);
		// Sets the fill color to the color of the terminal to overwrite previous draw layer and prepare for the next drawing
		con.drawImage(imgLogo, 540, intY);
		con.repaint();
		// Repaints the draw layer to load the image.
		con.sleep(3);
		}
		con.setDrawColor(Color.WHITE);
		con.drawString("Play", 500, 240);
		con.drawString("View Leaderboard", 500, 280);
		con.drawString("Quit", 500, 320);
		con.repaint();
		
		// Loops through the conditionals for the menu screen; (p) (q) (v)
		while(true) {
			char chKey = con.getChar();
			if(chKey == 'q' || chKey == 'Q') {
				con.closeConsole();
				// Closes console if quit is chosen.
			} else if(chKey == 'v' || chKey == 'V') {

			} else {
				continue;
			}
		}
	}
}
