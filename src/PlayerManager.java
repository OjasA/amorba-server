import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlayerManager {
	private int nextPlayerID = 0;
	private int xMax;
	private int yMax;
	private static Map<String, String> players;
	private static ArrayList<String> openPlayers = new ArrayList();

	public PlayerManager(int x, int y) {
		players = new HashMap<String, String>();
		yMax = y;
		xMax = x;
	}

	public PlayerManager(int x, int y, int begID) {
		players = new HashMap<String, String>();
		yMax = y;
		xMax = x;
		nextPlayerID = begID;
	}

	public int addNewPlayer(String name, int size, Point location) { // return
																		// -1 if
																		// call
																		// is
																		// invalid,
																		// otherwise
																		// return
																		// ID
		if ((location.getX() <= xMax) && (location.getY() <= yMax)) {
			return -1;
		}
		players.put("" + nextPlayerID, (size + ";(" + location.getX() + ","
				+ location.getY() + ")"));
		return nextPlayerID++;
	}

	public static int getPlayersSize() {
		return players.size();
	}

	public static int getPlayerID(int id) {
		return Integer.parseInt(players.get("" + id));
	}
	
	public static void submitOpenPlayer(String id) {
		openPlayers.add(id);
	}

}
