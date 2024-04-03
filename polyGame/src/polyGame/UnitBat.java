package polyGame;

import java.util.Vector;

public class UnitBat extends Unit implements skillUsable {

	UnitBat() {
		name = "박쥐";
	}

	public void skill(Vector<Unit> UnitList, int index) {
		Player target = (Player) UnitList.get(index);
		target.silence = true;
		System.out.println("박쥐 전용 스킬 발동!");
		System.out.println("[" + target.name + "]에게 침묵효과!");
	}
}
