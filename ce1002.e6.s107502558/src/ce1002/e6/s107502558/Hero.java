package ce1002.e6.s107502558;

public class Hero extends Role{

	public static int WeaponAtk = 0;
	private String Weapon;

	public Hero(String name, int hp, int atk, String weapon, int weaponAtk2) {
		// TODO �۰ʲ��ͪ��غc�l Stub
		super.Atk=atk;
		super.Hp=hp;
		super.Name=name;
		Weapon=weapon;
		this.WeaponAtk=weaponAtk2;
	}

	public String getName() {
		// TODO �۰ʲ��ͪ���k Stub
		return Name;
	}

	public int getAtk() {
		// TODO �۰ʲ��ͪ���k Stub
		return Atk;
	}

	public int getWeaponAtk() {
		// TODO �۰ʲ��ͪ���k Stub
		return WeaponAtk;
	}

	public int getHp() {
		// TODO �۰ʲ��ͪ���k Stub
		return Hp;
	}

	public String getWeapon() {
		// TODO �۰ʲ��ͪ���k Stub
		return Weapon;
	}

	public void setHp(int i) {
		// TODO �۰ʲ��ͪ���k Stub
		Hp=i;
	}

}
