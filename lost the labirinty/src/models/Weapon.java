package models;

public class Weapon extends Container{
	private String name;	
	private int reqLv;
	private int force;
	private int lv;



	public Weapon(int nivel) {
		// TODO Auto-generated constructor stub
		super.type = "weapon";
		super.msg = "uau uma arma!!";

		this.lv = nivel;
	}

	//força para ataque
	public int force() {
		// TODO Auto-generated method stub
		return this.lv*2+2;
	}

	public String type() {
		// TODO Auto-generated method stub
		return super.type;
	}


	public String msg() {
		// TODO Auto-generated method stub
		return super.msg;
	}	

}
