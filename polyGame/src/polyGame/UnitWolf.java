package polyGame;

import java.util.Vector;

public class UnitWolf extends Unit implements skillUsable {

	UnitWolf() {
		name = "늑대";
	}

	public void skill(Vector<Player> playerList, int index) {
		System.out.println("적 전체에게 공격력의 절반의 물리데미지");

		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).curhp -= power / 2;
		}

	}
}
