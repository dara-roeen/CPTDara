import arc.*;

public class lib {
	
	public static void Menu(Console con, chKey) {
		// Function will serve purpose of drawing out a main menu and giving function to each option
		// Initialize Logo
		// Add keyboard input for play game (p), view leader-board (v) & quit (q)
		char chKey = con.currentChar();
		con.println(chKey);
	}
}

