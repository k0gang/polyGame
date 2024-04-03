package polyGame;

import java.util.Vector;

public class Knight extends Unit implements skillUsable {

	Knight() {
		name = "기사";
		maxhp = 1000;
		curhp = 1000;
		power = 45;
		stun = false;
		silence = false;
	}

	public void skill(Vector<Unit> unitList, int index) {
		System.out.println("기사의 심장 꿰뚫기!");
		Unit m = unitList.get(index);
		System.out.println("[" + m.name + "]에게 [" + power + "X2] 의 데미지");

		m.curhp -= power * 2;
		if (m.curhp <= 0) {
			System.out.println("[" + m.name + "]이 쓰러졌다!");
			m.curhp = 0;
		}
	}
}
