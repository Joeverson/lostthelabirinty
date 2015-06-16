package controllers;

import java.awt.List;
import java.util.Random;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import models.Exit;
import models.ObjectLabirinty;
import models.Warrior;
import models.wall;


public class GenerateLabirinty {
	private static ObjectLabirinty[][] labirinties;
	//nivel de labirinto -- tamando do quadrado
	private static int lvLabirinty;

	//localização do guerreiro
	private static int x;
	private static int y;

	private static String warrior = "maria";

	//lista de comandos
	private static final String[] commandsSteps = {"left","right","top","bottom","leftTop","rightTop","bottomTop","bottomTop"}; 


	public GenerateLabirinty() {}

	//metodo para gerar o labirinto
	public static void generate(int i){
		lvLabirinty = i;
		labirinties = new ObjectLabirinty[i][i];

		for(int k = 0; k < i; k++){			
			for(int j = 0; j < i; j++){
				labirinties[k][j] = new ObjectLabirinty();
				
				if(k == 0 && j == 0){ //parte superior esquerdo
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderLeft(true);
					labirinties[k][j].setBorderTop(true);
				}else if(k == 0 && j == i){ //parte inferior esquerdo
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderLeft(true);
					labirinties[k][j].setBorderBottom(true);
				}else if(k == i && j == 0){ //parte inferior esquerdo
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderTop(true);
					labirinties[k][j].setBorderRight(true);
				}else if(k == i && j == i){ //parte inferior esquerdo
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderBottom(true);
					labirinties[k][j].setBorderRight(true);
				}else if(k == 0){ //parte lateral esquerda
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderLeft(true);
				}else if(j == 0){ //parte superior
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderTop(true);
				}else if(j == i){ //parte lateral Direita
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderRight(true);
				}else if(k == i){ //parte inferior
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderBottom(true);
				}
			}
		}

		// gerando paredes
		//addWall();

		//addExit();
		
		viewLab();
		
		// adiciona o jogador
		addWarrior(warrior);

		System.out.println("guerreiro esta no x = "+x);
		System.out.println("guerreiro esta no y = "+y);
	}


	//adicionar paredes
	public static void addWall(){
		int quantWallForLines = lvLabirinty/2;		
		Random rnd = new Random();
		System.out.println(lvLabirinty);

		for(int k = 0; k < lvLabirinty; k++){			
			for(int j = 0; j < quantWallForLines; j++){
				labirinties[k][rnd.nextInt(quantWallForLines)].setContaint(new wall());
			}
		}

	}

	//colocar player no jogo
	public static void addWarrior(String name){
		Random rnd = new Random();
		
		while(true){
			x = rnd.nextInt(lvLabirinty);
			y = rnd.nextInt(lvLabirinty);
			
			if(labirinties[x][y].getContaint() == null){
				labirinties[x][y].setContaint(new Warrior(x,y,name));			

				break;
			}
			System.out.println("ocupado!!");
		}
	}

	//colocar player no jogo
	public static void addExit(){
		Random rnd = new Random();
		int xExit;
		int yExit;

		while(true){
			xExit = rnd.nextInt(lvLabirinty);
			yExit = rnd.nextInt(lvLabirinty);

			if(labirinties[xExit][yExit].getContaint() == null){
				labirinties[xExit][yExit].setContaint(new Exit());
				break;
			}
		}
	}

	// para testes de visualizações
	public static void viewLab(){		
		for(int k = 0; k < lvLabirinty; k++){			
			for(int j = 0; j < lvLabirinty; j++){				
				if( (wall) labirinties[k][j].getContaint() != null){
					//System.out.println(((wall) labirinties[k][j].getContaint()).msg());
					System.out.println("Posições de x = "+k+" y = "+j);
				}

			}
		}
	}


	//chamada de acçoes de passos
	public static void steps(String steps){
		switch(steps){
		case "left":
			goLeft();
			break;
		case "right":
			goRight();
			break;
		case "top":
			goTop();
			break;
		case "bottom":
			goBottom();
			break;
		default:
			System.out.println("Comando invalido! \n de um dos seguintes comandos:\n\n");
			for(int h = 0; h < commandsSteps.length; h++){
				System.out.println(" \t- "+commandsSteps[h]+"\n");
			}
		}
	}


	// funções de navegação

	
	
	//left
	private static void goLeft(){
		Warrior w = (Warrior) labirinties[x][y].getContaint();

		if(labirinties[(x-1)][y].getContaint() == null && !labirinties[(x-1)][y].isBorder()){
			labirinties[x-1][y].setContaint(w);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			// decrementando a posição x do guerreiro
			x--;

			System.out.println("guerreiro esta no x = "+x);
			System.out.println("guerreiro esta no y = "+y);

		}else{
			if(labirinties[(x-1)][y].isBorderLeft() && labirinties[(x-1)][y].isBorderTop()){
				System.out.println("aqui é a borda lateral Superior esquerda!");
			}else if(labirinties[(x-1)][y].isBorderLeft() && labirinties[(x-1)][y].isBorderBottom()){
				System.out.println("aqui é a borda lateral inferior esquerda!");
			}else if(labirinties[(x-1)][y].isBorderLeft()){
				System.out.println("aqui é a borda lateral esquerda!");
			}else{
				System.out.println(( ( wall ) labirinties[x-1][y].getContaint() ).msg());
			}
		}
	}

	//right
	private static void goRight(){
		Warrior w = (Warrior) labirinties[x][y].getContaint();
		
		if(labirinties[(x+1)][y].getContaint() == null){
			labirinties[x+1][y].setContaint(w);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			//imcrementando a posição x do guerreiro
			x++;

			System.out.println("guerreiro esta no x = "+x);
			System.out.println("guerreiro esta no y = "+y);

		}else{
			if(labirinties[x+1][y].isBorderRight() && labirinties[x+1][y].isBorderTop()){
				System.out.println("aqui é a borda lateral Superior direito!");
			}else if(labirinties[x+1][y].isBorderRight() && labirinties[x+1][y].isBorderBottom()){
				System.out.println("aqui é a borda lateral inferior direito!");
			}else if(labirinties[x+1][y].isBorderRight()){
				System.out.println("aqui é a borda lateral direito!");
			}else{
				System.out.println(( ( wall ) labirinties[x+1][y].getContaint() ).msg());
			}
		}
	}

	//top
	private static void goTop(){
		Warrior w = (Warrior) labirinties[x][y].getContaint();

		if(labirinties[(x)][y-1].getContaint() == null){
			labirinties[x][y-1].setContaint(w);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);
			
			// decrementando o valor da posição y
			y--;

			System.out.println("guerreiro esta no x = "+x);
			System.out.println("guerreiro esta no y = "+y);

		}else{
			if(labirinties[x][y-1].isBorderRight() && labirinties[x][y-1].isBorderTop()){
				System.out.println("aqui é a borda lateral Superior direito!");
			}else if(labirinties[x][y-1].isBorderTop() && labirinties[x][y-1].isBorderLeft()){
				System.out.println("aqui é a borda lateral Superior Esquerdo!");
			}else if(labirinties[x][y-1].isBorderTop()){
				System.out.println("aqui é a borda lateral Superior!");
			}else{
				System.out.println(( ( wall ) labirinties[x][y-1].getContaint() ).msg());
			}
		}
	}


	//bottom
	private static void goBottom(){
		Warrior w = (Warrior) labirinties[x][y].getContaint();
		
		if(labirinties[(x)][y+1].getContaint() == null){
			labirinties[x][y+1].setContaint(w);

			//deixa nulo a posição anterior do guerreiro
			labirinties[x][y].setContaint(null);

			//incrementando o valor da posição y
			y++;

			System.out.println("guerreiro esta no x = "+x);
			System.out.println("guerreiro esta no y = "+y);

		}else{
			if(labirinties[x][y+1].isBorderRight() && labirinties[x][y+1].isBorderBottom()){
				System.out.println("aqui é a borda lateral Inferior direito!");
			}else if(labirinties[x][y+1].isBorderBottom() && labirinties[x][y+1].isBorderLeft()){
				System.out.println("aqui é a borda lateral Inferior Esquerdo!");
			}else if(labirinties[x][y].isBorderBottom()){
				System.out.println("aqui é a borda Inferior!");
			}else{
				System.out.println(( ( wall ) labirinties[x][y+1].getContaint() ).msg());
			}
		}
	}

}