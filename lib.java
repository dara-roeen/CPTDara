import arc.*;
import java.awt.image.BufferedImage;

public class lib {
	
	public static void Menu(Console con) {
		// Function will serve purpose of drawing out a main menu and giving function to each option
		// Initialize Logo
		// Add keyboard input for play game (p), view leader-board (v) & quit (q)
		BufferedImage imgLogo = con.loadImage("/home/dara/Documents/GitHub/CPTDara/res/logo.png");
		int intY;
		// Logo animation
		for(intY = 680; intY >= 80; intY--) {
		con.drawImage(imgLogo, 540, intY);
		// Repaints the draw layer to load the image.
		con.repaint();
		con.sleep(5);
		}
		
		while(true) {
			char chKey = con.getChar();
			if(chKey == 'q' || chKey == 'Q') {
				con.closeConsole();
			} else {
				continue;
			}
		}
	}
}
