package polyGame;

import java.util.Vector;

public class UnitOrc extends Unit implements skillUsable{

	UnitOrc() {
		name = "오크";
	}

	public void skill(Vector<Unit> UnitList, int index) {
		Player target = (Player) UnitList.get(index);
		target.curhp -= power*2;
		target.stun = true;
		System.out.println("오크 전용 스킬 발동!");
		System.out.println("[" + target.name + "] 에게 [" + power + "X2] 의 데미지와 기절효과!");
		if(target.curhp <= 0) {
			System.out.println("[" + target.name + "]가 쓰러졌다!");
			target.curhp = 0;
		}
	}
}
