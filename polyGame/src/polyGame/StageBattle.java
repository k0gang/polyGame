package polyGame;

import java.util.Random;
import java.util.Vector;

public class StageBattle extends Stage {
	private UnitManager unitManager = new UnitManager();
	private Vector<Player> playerList = null;
	private Vector<Unit> monList = null;
	private Random ran = new Random();
	private int monDead = 0;
	private int playerDead = 0;
	
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
	
	public void print_character() {
		System.out.println("=====[BATTLE]=====");
		System.out.println("=====[PLAYER]=====");
		for(int i=0; i<playerList.size(); i++)
			playerList.get(i).printData();
		System.out.println("=====[MONSTER]=====");
		for(int i=0; i<monList.size(); i++)
			monList.get(i).printData();
	}
	
	
	
	@Override
	public boolean update() {
		
		return false;
	}
	
}
