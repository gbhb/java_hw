
/*
 * Exercise 6
 * Course: ce1002
 * Name: §fÌÉ¿«
 * Student ID: 107502558
 */
package ce1002.e6.s107502558;

import java.util.Scanner;

public class e6 {

	public static void main(String[] args) {
		var input = new Scanner(System.in);
		// Create a hero
		var hero = CreateHeroSession(input);
		// Create an enemy which is original
		var originalEnemy = CreateEnemySession(input);
		// New an enemy from original
		var enemy = new Enemy(originalEnemy.getName(), originalEnemy.getHp(), originalEnemy.getAtk(),
				originalEnemy.getDropItem());
		System.out.println("==========");
		// Start Battle
		while (BattleSession(input, hero, enemy)) {
			// Hero Win and ask if want another adventure
			if (HeroWinMessageSession(input, hero, enemy) == false) {
				// End Game
				return;
			}
			// A new Enemy and restart battle
			enemy = new Enemy(originalEnemy.getName(), originalEnemy.getHp(), originalEnemy.getAtk(),
					originalEnemy.getDropItem());
		}
		;
		// Enemy win and end game.
		EnemyWinMessageSession(hero, enemy);
		return;
	}

	private static Hero CreateHeroSession(Scanner input) {
		System.out.println("Please Crease a hero:");
		System.out.print("Name:");
		var name = input.next();
		System.out.print("Hp:");
		var hp = input.nextInt();
		System.out.print("Atk:");
		var atk = input.nextInt();
		System.out.print(name + "'s Weapon:");
		var weapon = input.next();
		System.out.print(name + "'s Weapon Atk:");
		var weaponAtk = input.nextInt();
		return new Hero(name, hp, atk, weapon, weaponAtk);
	}

	private static Enemy CreateEnemySession(Scanner input) {
		System.out.println("Please Crease a enemy:");
		System.out.print("Name:");
		var name = input.next();
		System.out.print("Hp:");
		var hp = input.nextInt();
		System.out.print("Atk:");
		var atk = input.nextInt();
		System.out.print("DropItem:");
		var item = input.next();
		return new Enemy(name, hp, atk, item);
	}

	// return true for hero win, false for enemy win
	private static boolean BattleSession(Scanner input, Hero hero, Enemy enemy) {
		System.out.println();
		System.out.println("A Wild " + enemy.getName() + " appeared!");
		while (true) {
			System.out.println("What will " + enemy.getName() + " do?");
			System.out.println(hero.getName() + "'s Hp: " + hero.getHp());
			System.out.println(enemy.getName() + "'s Hp: " + enemy.getHp());
			System.out.println("1.Attack 2.Do nothing");
			var choice = input.nextInt();
			if (choice == 1) {
				var hurtPoint = hero.getAtk() + hero.getWeaponAtk();
				enemy.setHp(enemy.getHp() - hurtPoint);
				System.out.println(hero.getName() + " use " + hero.getWeapon() + " and hurt " + enemy.getName() + " "
						+ hurtPoint + " points.");
			} else if (choice == 2) {
				System.out.println(hero.getName() + " is doing nothing.");
			}
			if (hero.getHp() <= 0)
				return false;
			if (enemy.getHp() <= 0)
				return true;
			hero.setHp(hero.getHp() - enemy.getAtk());
			System.out.println(enemy.getName() + " hurt " + hero.getName() + " " + enemy.getAtk() + " points.");
			if (hero.getHp() <= 0)
				return false;
			if (enemy.getHp() <= 0)
				return true;
		}
	}

	// return true for another adventure, false for end game
	private static boolean HeroWinMessageSession(Scanner input, Hero hero, Enemy enemy) {
		System.out.println(hero.getName() + " win!");
		System.out.println(
				enemy.getName() + " derpped item " + "\"" + enemy.getDropItem() + "\"" + " left on the ground.");
		System.out.println("Want another adventure?");
		System.out.println("1. Yes 2. No");
		var choice = input.nextInt();
		if (choice == 1) {
			return true;
		} else if (choice == 2) {
			System.out.println("Game Over");
			return false;
		}
		return false;
	}

	private static void EnemyWinMessageSession(Hero hero, Enemy enemy) {
		System.out.println(enemy.getName() + " win!");
		System.out.println(hero.getName() + " weapon" + "\"" + hero.getWeapon() + "\"" + " left on the ground.");
		System.out.println("Game Over");
	}

}
