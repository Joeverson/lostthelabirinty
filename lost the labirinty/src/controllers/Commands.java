package controllers;

import templates.Warrior;

public class Commands {
	private static Warrior warrior;
	
	public Commands() {
		// TODO Auto-generated constructor stub
	}
	
	public static void setWarrior(Warrior w){
		warrior = w;
	}

	//chamada de acçoes de passos
	public static String steps(String steps){
		switch(steps){
		case "lado e":
			return Move.goLeft(warrior);
		case "lado r":
			return Move.goRight(warrior);
		case "cima":
			return Move.goTop(warrior);					
		case "baixo":
			return Move.goBottom(warrior);					
		case "lado e cima":
			return Move.goTopLeft(warrior);					
		case "lado r cima":
			return Move.goTopRight(warrior);					
		case "lado e baixo":
			return Move.goBottomLeft(warrior);					
		case "lado r baixo":
			return Move.goBottomRight(warrior);
		case "exit":
			System.exit(0);
		case "reboot":
			System.out.println("\n\n.................... reboot of nivel .........................\n\n");
			GenerateLabirinty.reloadLabirintyLevel(warrior);		
		default:
			return "Comando invalido! \n\n";				
		}
	}

}
