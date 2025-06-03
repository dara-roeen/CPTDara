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

		int intMoney = 1000;
		con.setDrawColor(Color.WHITE);
		con.drawString(String.format("$%d",intMoney), 1200, 0);
		// Shows the player how much money they have at the moment
		con.sleep(5);
		// Sleep so that when play game is selected it does not interfere with the input for the name
		String strName;
		con.drawString("What is your Name?", 500, 315);
		strName = con.readLine();
		System.out.println(strName);
		//con.drawString("How Much Do You Want to Bet?");
		//con.readInt();
	}
}
