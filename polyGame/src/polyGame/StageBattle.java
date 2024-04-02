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

	private void print_character() {
		System.out.println("=====[BATTLE]=====");
		System.out.println("=====[PLAYER]=====");
		for (int i = 0; i < playerList.size(); i++)
			playerList.get(i).printData();
		System.out.println("=====[MONSTER]=====");
		for (int i = 0; i < monList.size(); i++)
			monList.get(i).printData();
	}

	public void player_attack(int index) {
		Player p = playerList.get(index);
		if (p.curhp <= 0)
			return;
		System.out.println("=====[메뉴 선택]=====");
		System.out.println("[" + p.name + "] [1.어택] [2.스킬]");
		int sel = GameManager.sc.nextInt();
		if (sel == 1) {
			while (true) {
				int idx = ran.nextInt(monList.size());

				if (monList.get(idx).curhp > 0) {
					p.attack(monList.get(idx));
					break;
				}
			}
		} else if (sel == 2) {
			// 스킬
		}
	}

	public void monster_attack(int index) {
		Unit m = monList.get(index);
		if (m.curhp <= 0)
			return;
		while (true) {
			int skill = ran.nextInt(5);
			if (skill == 0) {
				// 스킬
			} else {
				int idx = ran.nextInt(playerList.size());
				if (playerList.get(idx).curhp > 0) {
					m.attack(playerList.get(idx));
					break;
				}
			}
		}
	}

	public void check_live() {
		int num = 0;
		for (int i = 0; i < playerList.size(); i++)
			if (playerList.get(i).curhp <= 0)
				num += 1;
		playerDead = playerList.size() - num;

		num = 0;
		for (int i = 0; i < monList.size(); i++)
			if (monList.get(i).curhp <= 0)
				num += 1;
		monDead = monList.size() - num;
	}

	@Override
	public boolean update() {
		boolean run = true;
		int p_index = 0;
		int m_index = 0;
		boolean turn = true;

		while (run) {
			if (turn) {
				print_character();
				if (p_index < playerList.size()) {
					player_attack(p_index);

					p_index += 1;
				} else {
					turn = !turn;
					p_index = 0;
				}
			} else if (!turn) {
				if (m_index < monList.size()) {
					monster_attack(m_index);

					m_index += 1;
				} else {
					turn = !turn;
					m_index = 0;
				}
			}
			check_live();
			if (monDead <= 0 || playerDead <= 0)
				break;
		}
		GameManager.nextStage = "LOBBY";
		return false;
	}
}
