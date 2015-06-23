package templates;

public class Monster extends Container{	
	private String name;
	private int x;
	private int y;
	private int lv;
	private int hp;


	public Monster(int nivel) {
		// TODO Auto-generated constructor stub
		super.type = "monster";
		super.msg = "Um monstro!!";

		this.lv = nivel; 
		this.hp = nivel*2;
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

}
