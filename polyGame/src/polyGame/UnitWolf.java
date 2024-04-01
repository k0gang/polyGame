package polyGame;

public class UnitWolf extends Unit{

	UnitWolf(){
		name = "늑대";
	}
	
	public void skill() {
		System.out.println("적 전체에게 공격력의 절반의 물리데미지");
	}
}
