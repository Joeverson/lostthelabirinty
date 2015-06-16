package models;

public class Warrior implements Container{
	private int x;
	private int y;
	private String name;
	//private Weapon arma;
	
	public Warrior(int x, int y, String name) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.name = name;
	}

	@Override
	public String type() {
		// TODO Auto-generated method stub
		return "warrior";
	}

	@Override
	public String msg() {
		// TODO Auto-generated method stub
		return "hi, my name is "+this.name;
	}
	

}