package controllers;

import java.util.Random;

import DAOjpa.DAO;
import DAOjpa.DAOWarrior;
import DAOjpa.DAOWeapon;
import templates.Warrior;
import templates.Weapon;
/*
 * coisas para fazer...
 * 
 * --verificar se o guerreiro já existe no banco, caso sim traga as informações dele e monte no labirinto
 * -- caso não tenha crie um e jogue-o no db
 * 
 * */
public class EventsLabrinty {

	private static Warrior warrior;
	private static int lv;
	private static DAOWarrior daowarrior = new DAOWarrior();
	private static DAOWeapon daoweapon = new DAOWeapon();
	
	
	
	public EventsLabrinty() {
		// TODO Auto-generated constructor stub
	}
	
	//evento que sube o lv do guerreiro e recarega o labirinto
	public static void levelUp(Warrior warrior){
		Random rnd = new Random();
		//atualizando guerreiro
		warrior.setLv(warrior.getLv()+1);
		warrior.setHp(warrior.getHp()+2);
		// atualizando arma
		warrior.getArma().setLv(warrior.getLv());
		warrior.getArma().setName(warrior.getName()+"-"+rnd.nextInt(100*warrior.getX()));
		
		// gravando atualizações no banco
		DAO.begin();
		daowarrior.updateMyWarrior(warrior);
		daoweapon.updateMyWeapon(warrior);
		DAO.commit();
		
		GenerateLabirinty.reloadLabirintyLevel(warrior);
	}
	
	//call for creare labirinty
	public static void GenerateLab(){
		GenerateLabirinty.generate(lv, warrior);
	}
	
	public static void createWarrior(String str){
		Warrior w;			
		
		DAO.begin();
		
		if((w = daowarrior.findMyWarrior(str)) == null){
			w = new Warrior(str);
			daowarrior.create(w);
			
			//dando arma inicial para o guerreiro
			Weapon weapon = new Weapon(w.getLv());
			daoweapon.create(weapon);
			w.setArma(weapon);
			
			DAO.commit();
		}
		
		//atribuindo novo guerreiro	
		warrior = w;
		lv = w.getLv();
	}
}
