import java.lang.*;

public class DropChecker extends Thread {
	
	public void run() {
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int currentID;
		for (int i = 0; i < PlayerManager.getPlayersSize(); i++) {
			currentID = PlayerManager.getPlayerID(i);
			if (currentID == -1) {
				
			}
		}
		
	}
}
