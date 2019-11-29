package moon.game.monsters;

public class Skeleton extends Monster {
	private static final String name = "스켈레톤";
	private static final int monsterNo = 1;

	
	public Skeleton() {}
	public Skeleton(int hp, int atk_low, int atk_high, int agi, int def) {
		super(hp, atk_low, atk_high, agi, def);
	}


	@Override
	public void attack(Monster m) {
		// TODO Auto-generated method stub
		
	}
}
