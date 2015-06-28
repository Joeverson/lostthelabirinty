package templates;

import javax.persistence.*;

@Entity
public class Monster extends Container{	
	private String name;
	@Transient
	private int x;
	@Transient
	private int y;
	@Transient
	private int lv;
	@Transient
	private int hp;
	@Transient
	private boolean boss = false;


	public Monster(){}
	
	public Monster(String name, int nivel) {
		// TODO Auto-generated constructor stub
		super.type = "monster";
		super.msg = "Um monstro!!";

		this.name = name;
		this.lv = nivel; 
		this.hp = nivel*2;
	}
	
	public void iAmBoss(){
		if(this.boss)
			this.lv += 10;
	}

	//força para ataque
	public int force() {
		// TODO Auto-generated method stub
		return this.lv*2;
	}

	//retorna a energia do monstro
	public int getHp() {
		// TODO Auto-generated method stub
		return this.hp;
	}	

	public String type() {
		// TODO Auto-generated method stub
		return super.type;
	}


	public String msg() {
		// TODO Auto-generated method stub
		return super.msg;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public String getName() {
		return name;
	}

	
}
