package ce1002.e6.s107502558;

public class Hero extends Role{

	public static int WeaponAtk = 0;
	private String Weapon;

	public Hero(String name, int hp, int atk, String weapon, int weaponAtk2) {
		// TODO 自動產生的建構子 Stub
		super.Atk=atk;
		super.Hp=hp;
		super.Name=name;
		Weapon=weapon;
		this.WeaponAtk=weaponAtk2;
	}

	public String getName() {
		// TODO 自動產生的方法 Stub
		return Name;
	}

	public int getAtk() {
		// TODO 自動產生的方法 Stub
		return Atk;
	}

	public int getWeaponAtk() {
		// TODO 自動產生的方法 Stub
		return WeaponAtk;
	}

	public int getHp() {
		// TODO 自動產生的方法 Stub
		return Hp;
	}

	public String getWeapon() {
		// TODO 自動產生的方法 Stub
		return Weapon;
	}

	public void setHp(int i) {
		// TODO 自動產生的方法 Stub
		Hp=i;
	}

}
