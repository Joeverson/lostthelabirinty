package controllers;

import java.io.ObjectInputStream.GetField;
import models.Exit;

import models.ObjectLabirinty;
import models.Warrior;
import models.wall;
import models.Container;

public class Move{
	
	private static ObjectLabirinty[][] labirinties;
	private static Warrior warrior;
	
	private static int x;
	private static int y;

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
	}
	
	
	public static String status(){
		return "Coord X: "+x+"\nCoord Y: "+y;
	}
	

	//chamada de acçoes de passos
		public static String steps(String steps){
			switch(steps){
				case "left":
					return goLeft(warrior);
				case "right":
					return goRight(warrior);
				case "top":
					return goTop(warrior);					
				case "bottom":
					return goBottom(warrior);					
				default:
					return "Comando invalido! \n\n";				
			}
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

				System.out.println("guerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
				return "ainda bem ta livre aqui!";

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
						warrior.setLv(warrior.getLv()+1);
						GenerateLabirinty.reloadLabirintyLevel(warrior);
						return "Parabens vc tá livre";
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

				System.out.println("guerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
				return "ainda bem ta livre aqui!";

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
						warrior.setLv(warrior.getLv()+1);
						GenerateLabirinty.reloadLabirintyLevel(warrior);
						return "Parabens vc tá livre";
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

				System.out.println("guerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
				return "ainda bem ta livre aqui!";

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
						warrior.setLv(warrior.getLv()+1);
						GenerateLabirinty.reloadLabirintyLevel(warrior);
						return "Parabens vc tá livre";
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

				System.out.println("guerreiro esta no x = "+x+"\nguerreiro esta no y = "+y);
				return "ainda bem ta livre aqui!";

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
						warrior.setLv(warrior.getLv()+1);
						GenerateLabirinty.reloadLabirintyLevel(warrior);
						return "Parabens vc tá livre";
					}
						
					return obj.msg;
				}
			}			
		}

}
