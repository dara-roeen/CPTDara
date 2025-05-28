import arc.*;

public class lib {
	
	public static void Menu(Console con, char chKey) {
		// Function will serve purpose of drawing out a main menu and giving function to each option
		// Initialize Logo
		// Add keyboard input for play game (p), view leader-board (v) & quit (q)
		
		while(true) {
			if(chKey == 'q' || chKey == 'Q') {
				con.closeConsole();
			} else {
				continue;
			}
		}
	}
}
