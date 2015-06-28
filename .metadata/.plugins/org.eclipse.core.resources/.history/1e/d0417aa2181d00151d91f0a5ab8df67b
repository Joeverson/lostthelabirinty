package templates;

import javax.persistence.*;

@Entity
public class Weapon extends Container{
	private String name;	
	private int reqLv;	
	private int lv;


	public Weapon(){}

	public Weapon(int nivel) {
		// TODO Auto-generated constructor stub
		super.type = "weapon";
		super.msg = "uau uma arma!!";

		this.lv = nivel;
	}

	// setando o nivel da arma.. mais usada no warrior pois ele irá almentar sua força de acordo com o lv dele	
	public void setLv(int lv) {
		this.lv = lv;
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
