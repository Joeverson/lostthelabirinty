package templates;

import javax.persistence.*;

@Entity
public class Warrior extends Container{	
	private String name;
	//private Bag bag;
	private Weapon arma;
	private int hp;
	private int lv = 1;
	private int x;
	private int y;
	
	public Warrior(){}

	public Warrior(String name) {
		this.name = name;
		super.msg = "hi, my name is "+this.name;
		super.type = "warrior";
		this.hp = 5;
	}

	public Warrior(int x, int y, String name) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.name = name;
		super.msg = "hi, my name is "+this.name;
		super.type = "warrior";
		this.hp = 5;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName(){
		return this.name;
	}

	public int getLv() {
		return this.lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}


	public String type() {
		// TODO Auto-generated method stub
		return super.type;
	}


	public String msg() {
		// TODO Auto-generated method stub
		return super.msg;
	}

	//força para ataque
	public int force() {
		// TODO Auto-generated method stub
		return this.lv*3;
	}

	//retorna a energia do guerreiro
	public int getHp() {
		// TODO Auto-generated method stub
		return this.hp;
	}
	
	//atualiza a energia
	public void setHp(int newHP) {
		// TODO Auto-generated method stub
		this.hp = newHP;
	}

	public Weapon getArma() {
		return arma;
	}

	public void setArma(Weapon arma) {
		this.arma = arma;
	}
	
	

}
