package controllers;

import java.io.ObjectInputStream.GetField;

import templates.Container;
import templates.Exit;
import templates.ObjectLabirinty;
import templates.Warrior;
import templates.wall;

public class Move{

	private static ObjectLabirinty[][] labirinties;
	private static Warrior warrior;

	private static int x;
	private static int y;

	//variaveis de msg para o sys
	private static String msgExit = "Finalmente, achei a saida deste labirinto!";
	private static String msgLivre = "Esta livre o caminho.";


	public Move() {
		// TODO Auto-generated constructor stub
	}

	public static void setLabirinty(ObjectLabirinty[][] obj){
		labirinties = obj;
	}

	public static void setWarrior(Warrior w){
		warrior = w;
		x = warrior.getX();
		y = warrior.getY();
		Commands.setWarrior(warrior);
	}


	public static String status(){
		int lv, force, hp;

		if(warrior == null){
			lv = 1;
			force = 0;
			hp = 0;
		}else{
			lv = warrior.getLv();
			force = warrior.force();
			hp = warrior.getHp();
		}			

		return "Coord X: "+x+"\nCoord Y: "+y+"\n\nLV: "+lv+ "\nHP: "+ hp + "\nWeapon:  "+ force ;
	}


	// funções de navegação



	//left
	public static String goLeft(Warrior w){	
		if(labirinties[(x-1)][y].getContaint() == null && !labirinties[(x-1)][y].isBorder()){
			labirinties[x-1][y].setContaint(w);
			//nova posição do guerreiro
			w.setX(x-1);
			w.setY(y);


			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			// decrementando a posição x do guerreiro
			x--;
			Commands.setWarrior(warrior);

			System.out.println("......................\n\nguerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
			return msgLivre;

		}else{
			if(labirinties[(x-1)][y].isBorderLeft() && labirinties[(x-1)][y].isBorderTop()){
				return "aqui é a borda lateral Superior esquerda!";
			}else if(labirinties[(x-1)][y].isBorderLeft() && labirinties[(x-1)][y].isBorderBottom()){
				return "aqui é a borda lateral inferior esquerda!";
			}else if(labirinties[(x-1)][y].isBorderLeft()){
				return "aqui é a borda lateral esquerda!";					
			}else{
				Container obj = ( Container ) labirinties[x-1][y].getContaint();

				if(obj.type == "exit"){
					EventsLabrinty.levelUp(warrior);
					return msgExit;
				}

				return obj.msg;
			}
		}			
	}

	//right
	public static String goRight(Warrior w){
		if(labirinties[(x+1)][y].getContaint() == null && !labirinties[(x+1)][y].isBorder()){
			labirinties[x+1][y].setContaint(w);

			//nova posição do guerreiro
			w.setX(x+1);
			w.setY(y);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			//imcrementando a posição x do guerreiro
			x++;
			Commands.setWarrior(warrior);
			System.out.println("......................\n\nguerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
			return msgLivre;

		}else{
			if(labirinties[x+1][y].isBorderRight() && labirinties[x+1][y].isBorderTop()){
				return "aqui é a borda lateral Superior direito!";
			}else if(labirinties[x+1][y].isBorderRight() && labirinties[x+1][y].isBorderBottom()){
				return "aqui é a borda lateral inferior direito!";
			}else if(labirinties[x+1][y].isBorderRight()){
				return "aqui é a borda lateral direito!";
			}else{

				Container obj = ( Container ) labirinties[x+1][y].getContaint();

				if(obj.type == "exit"){
					EventsLabrinty.levelUp(warrior);
					return msgExit;
				}
				
				return obj.msg;
			}
		}
	}

	//top
	public static String goTop(Warrior w){
		if(labirinties[(x)][y-1].getContaint() == null && !labirinties[(x)][y-1].isBorder()){
			labirinties[x][y-1].setContaint(w);

			//nova posição do guerreiro
			w.setX(x);
			w.setY(y-1);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			// decrementando o valor da posição y
			y--;
			Commands.setWarrior(warrior);
			System.out.println("......................\n\nguerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
			return msgLivre;

		}else{
			if(labirinties[x][y-1].isBorderRight() && labirinties[x][y-1].isBorderTop()){
				return "aqui é a borda lateral Superior direito!";
			}else if(labirinties[x][y-1].isBorderTop() && labirinties[x][y-1].isBorderLeft()){
				return "aqui é a borda  Superior Esquerdo!";
			}else if(labirinties[x][y-1].isBorderTop()){
				return "aqui é a borda Superior!";
			}else{
				Container obj = (Container) labirinties[x][y-1].getContaint();

				if(obj.type == "exit"){
					EventsLabrinty.levelUp(warrior);
					return msgExit;
				}
				
				return obj.msg;
			}

		}
	}


	//bottom
	public static String goBottom(Warrior w){						
		if(labirinties[(x)][y+1].getContaint() == null && !labirinties[(x)][y+1].isBorder()){
			labirinties[x][y+1].setContaint(w);

			//nova posição do guerreiro
			w.setX(x);
			w.setY(y+1);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			//incrementando o valor da posição y
			y++;
			Commands.setWarrior(warrior);
			System.out.println("......................\n\nguerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
			return msgLivre;

		}else{				
			if(labirinties[x][y+1].isBorderRight() && labirinties[x][y+1].isBorderBottom()){
				return "aqui é a borda lateral Inferior direito!";
			}else if(labirinties[x][y+1].isBorderBottom() && labirinties[x][y+1].isBorderLeft()){
				return "aqui é a borda lateral Inferior Esquerdo!";
			}else if(labirinties[x][y+1].isBorderBottom()){
				return "aqui é a borda Inferior!";
			}else{
				Container obj = ( Container ) labirinties[x][y+1].getContaint();

				if(obj.type == "exit"){
					EventsLabrinty.levelUp(warrior);
					return msgExit;
				}
				
				return obj.msg;
			}
		}			
	}


	// direções diagonais de movimentos

	//diagonal left top
	public static String goTopLeft(Warrior w){
		if(labirinties[(x-1)][y-1].getContaint() == null && !labirinties[(x-1)][y-1].isBorder()){
			labirinties[x-1][y-1].setContaint(w);

			//nova posição do guerreiro
			w.setX(x-1);
			w.setY(y-1);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			// decrementando o valor da posição y
			y--;
			x--;
			Commands.setWarrior(warrior);
			System.out.println("......................\n\nguerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
			return msgLivre;

		}else{
			if(labirinties[x-1][y-1].isBorderRight() && labirinties[x-1][y-1].isBorderTop()){
				return "aqui é a borda lateral Superior direito!";
			}else if(labirinties[x-1][y-1].isBorderTop() && labirinties[x-1][y-1].isBorderLeft()){
				return "aqui é a borda  Superior Esquerdo!";
			}else if(labirinties[x-1][y-1].isBorderTop()){
				return "aqui é a borda Superior!";
			}else{
				Container obj = (Container) labirinties[x-1][y-1].getContaint();

				if(obj.type == "exit"){
					EventsLabrinty.levelUp(warrior);
					return msgExit;
				}

				return obj.msg;
			}

		}
	}

	//diagonal top right
	public static String goTopRight(Warrior w){
		if(labirinties[(x+1)][y-1].getContaint() == null && !labirinties[(x+1)][y-1].isBorder()){
			labirinties[x+1][y-1].setContaint(w);

			//nova posição do guerreiro
			w.setX(x+1);
			w.setY(y-1);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			//imcrementando a posição x do guerreiro
			x++;
			y--;
			Commands.setWarrior(warrior);
			System.out.println("......................\n\nguerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
			return msgLivre;

		}else{
			if(labirinties[x+1][y-1].isBorderRight() && labirinties[x+1][y-1].isBorderTop()){
				return "aqui é a borda lateral Superior direito!";
			}else if(labirinties[x+1][y-1].isBorderRight() && labirinties[x+1][y-1].isBorderBottom()){
				return "aqui é a borda lateral inferior direito!";
			}else if(labirinties[x+1][y-1].isBorderRight()){
				return "aqui é a borda lateral direito!";
			}else{

				Container obj = ( Container ) labirinties[x+1][y-1].getContaint();

				if(obj.type == "exit"){
					EventsLabrinty.levelUp(warrior);
					return msgExit;
				}
				
				return obj.msg;
			}
		}
	}

	
	//diagonal bottom left	
	public static String goBottomLeft(Warrior w){						
		if(labirinties[(x-1)][y+1].getContaint() == null && !labirinties[(x-1)][y+1].isBorder()){
			labirinties[x-1][y+1].setContaint(w);

			//nova posição do guerreiro
			w.setX(x-1);
			w.setY(y+1);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			//incrementando o valor da posição y
			y++;
			x--;
			Commands.setWarrior(warrior);
			System.out.println("......................\n\nguerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
			return msgLivre;

		}else{				
			if(labirinties[x-1][y+1].isBorderRight() && labirinties[x-1][y+1].isBorderBottom()){
				return "aqui é a borda lateral Inferior direito!";
			}else if(labirinties[x-1][y+1].isBorderBottom() && labirinties[x-1][y+1].isBorderLeft()){
				return "aqui é a borda lateral Inferior Esquerdo!";
			}else if(labirinties[x-1][y+1].isBorderBottom()){
				return "aqui é a borda Inferior!";
			}else{
				Container obj = ( Container ) labirinties[x-1][y+1].getContaint();

				if(obj.type == "exit"){
					EventsLabrinty.levelUp(warrior);
					return msgExit;
				}
				
				return obj.msg;
			}
		}			
	}
	
	
	// diagonal bottom right
	public static String goBottomRight(Warrior w){						
		if(labirinties[(x+1)][y+1].getContaint() == null && !labirinties[(x+1)][y+1].isBorder()){
			labirinties[x+1][y+1].setContaint(w);

			//nova posição do guerreiro
			w.setX(x+1);
			w.setY(y+1);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			//incrementando o valor da posição y
			y++;
			x++;
			Commands.setWarrior(warrior);
			System.out.println("......................\n\nguerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
			return msgLivre;

		}else{				
			if(labirinties[x+1][y+1].isBorderRight() && labirinties[x+1][y+1].isBorderBottom()){
				return "aqui é a borda lateral Inferior direito!";
			}else if(labirinties[x+1][y+1].isBorderBottom() && labirinties[x+1][y+1].isBorderLeft()){
				return "aqui é a borda lateral Inferior Esquerdo!";
			}else if(labirinties[x+1][y+1].isBorderBottom()){
				return "aqui é a borda Inferior!";
			}else{
				Container obj = ( Container ) labirinties[x+1][y+1].getContaint();

				if(obj.type == "exit"){
					EventsLabrinty.levelUp(warrior);
					return msgExit;
				}

				return obj.msg;
			}
		}			
	}
}
