package polyGame;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	UnitManager unitManager = new UnitManager();
	Vector<Player> playerList = null;
	Vector<Unit> monList = null;
	Random ran = new Random();
	int monDead = 0;
	int playerDead = 0;
	
	@Override
	public void init() {
		unitManager.mon_list.clear();
		unitManager.monster_rand_set(4);
		playerList = null;
		playerList = unitManager.player_list;
		monList = null;
		monList = unitManager.mon_list;
		monDead = monList.size();
		playerDead = playerList.size();
	}
	
	
	
	
	@Override
	public boolean update() {
		
		return false;
	}
	
}
