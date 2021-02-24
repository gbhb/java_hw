/* Assignment 11
 * course : ce1002
 * student id  :107502558
 * name :/呂旻翰
 */
package ce1002.a11.s107502558;

import java.awt.event.ContainerListener;
import java.awt.event.ContainerAdapter;;

//可以有動作的實體
abstract class Entity {
	int hp;
	int id;
}
class Magic{
	String Magic;
	int damage;
	int costmp;
}
class Material{
	String Material;
}
class Weapon{
	String Weapon;
	int damage;
	int costsp;
}
//人類
abstract class Human extends Entity {
	String name;
	Human(String name,int hp,int id){
	this.name=name;
	super.hp=hp;
	super.id=id;
	}
}

//戰士
class Warrior extends Human implements ICanHoldWeapon {
	

	Warrior(String name, int hp, int id) {
		super(name, hp, id);
		// TODO 自動產生的建構子 Stub
	}

	int StaminaPoint;
	final int MaxStaminaPoint=10;

	void AdvanceSwordAttack(Monster monster){}

	@Override
	public void PickUpWeapon(Weapon weapon){}

	@Override
	public void ThrowWeapon(Weapon weapon){}
}

//巫師
class Wizard extends Human implements ICanUseMagic {
	

	Wizard(String name, int hp, int id) {
		super(name, hp, id);
		// TODO 自動產生的建構子 Stub
	}

	int MagicPoint;
	final int MaxMagicPoint=10;

	void ManaImpact(Monster monster){}

	@Override
	public void LaunchMagic(Magic Magic){}

	@Override
	public void LearnMagic(Magic Magic){}

	@Override
	public void CraftMagicWeapon(Magic Magic){}
}

//僧侶
class Monk extends Human implements ICanHoldWeapon, ICanUseMagic {
	

	Monk(String name, int hp, int id) {
		super(name, hp, id);
		// TODO 自動產生的建構子 Stub
	}

	int MagicPoint;
	final int MaxMagicPoint=10;
	int StaminaPoint;
	final int MaxStaminaPoint=10;
	void HolyHealing(Human Human) {
		Human.hp++;
	}
	@Override
	public void PickUpWeapon(Weapon weapon) {}

	@Override
	public void ThrowWeapon(Weapon weapon) {}
	@Override
	public void LaunchMagic(Magic Magic) {}

	@Override
	public void LearnMagic(Magic Magic) {}

	@Override
	public void CraftMagicWeapon(Magic Magic) {}
}

//怪物
abstract class Monster extends Entity {
	Monster(int hp,int id){
		super.hp=hp;
		super.id=id;
		}
}

//哥布林
class Goblin extends Monster implements ICanHoldMaterial{
	Goblin(int hp, int id) {
		super(hp, id);
		// TODO 自動產生的建構子 Stub
	}

	@Override
	public void ThrowMaterial(Material Material) {}
}

//哥布林巫師
class GoblinWizard extends Monster implements ICanUseMagic,ICanHoldMaterial{
	GoblinWizard(int hp, int id) {
		super(hp, id);
		// TODO 自動產生的建構子 Stub
	}

	int MagicPoint;
	final int MaxMagicPoint=10;

	void ManaImpact(Monster monster) {}
	@Override
	public void ThrowMaterial(Material Material) {}
	@Override
	public void LaunchMagic(Magic Magic) {}

	@Override
	public void LearnMagic(Magic Magic) {}

	@Override
	public void CraftMagicWeapon(Magic Magic) {
	}
}

//哥布林戰士
class GoblinWarrior extends Monster implements ICanHoldWeapon,ICanHoldMaterial{
	GoblinWarrior(int hp, int id) {
		super(hp, id);
		// TODO 自動產生的建構子 Stub
	}

	int StaminaPoint;
	final int MaxStaminaPoint=10;
	@Override
	public
	void ThrowMaterial(Material Material) {
	}
	@Override
	public
	void PickUpWeapon(Weapon weapon) {
	}

	@Override
	public
	void ThrowWeapon(Weapon weapon) {
	}
}

//食人妖
class Ogre extends Monster implements ICanHoldMaterial{
	Ogre(int hp, int id) {
		super(hp, id);
		// TODO 自動產生的建構子 Stub
	}

	@Override
	public
	void ThrowMaterial(Material Material) {
	}
}

//史萊姆
class Smile extends Monster implements ICanHoldMaterial{
	Smile(int hp, int id) {
		super(hp, id);
		// TODO 自動產生的建構子 Stub
	}

	@Override
	public
	void ThrowMaterial(Material Material) {
	}
}


//可以掉素材
interface ICanHoldMaterial {
	abstract void ThrowMaterial(Material Material);
}
//可以裝備武器
interface ICanHoldWeapon {
	abstract void PickUpWeapon(Weapon weapon);

	abstract void ThrowWeapon(Weapon weapon);

}

//可以使用魔術
interface ICanUseMagic{
	abstract void LaunchMagic(Magic Magic);
	abstract void CraftMagicWeapon(Magic Magic);
	abstract void LearnMagic(Magic Magic);
}
