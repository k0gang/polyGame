package polyGame;

import java.util.Vector;

public class UnitWolf extends Unit implements skillUsable {

	UnitWolf() {
		name = "늑대";
	}

	public void skill(Vector<Unit> playerList, int index) {
		System.out.println("늑대 전용 스킬 발동!");
		System.out.println("적 전체에게 공격력의 절반의 물리데미지");

		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).curhp -= power / 2;
			System.out.println("[" + playerList.get(i).name + "] 에게 [" + power + "/2]의 데미지");
			if (playerList.get(i).curhp <= 0) {
				System.out.println("[" + playerList.get(i).name + "] 가 쓰러졌다!");
				playerList.get(i).curhp = 0;
			}
		}
	}
}
