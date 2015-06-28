package controllers;

import java.awt.List;
import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import DAOjpa.DAO;
import DAOjpa.DAOMonsters;
import DAOjpa.DAOWarrior;
import DAOjpa.DAOWeapon;
import templates.Exit;
import templates.Monster;
import templates.ObjectLabirinty;
import templates.Warrior;
import templates.Weapon;
import templates.wall;


public class GenerateLabirinty {
	protected static ObjectLabirinty[][] labirinties;
	
	//classe de abstrção do banco de dados (monstros)
	private static DAOMonsters daomonsters = new DAOMonsters();

	//nivel de labirinto -- tamando do quadrado
	protected static int lvLabirinty;

	//localização para manipulação de ponteiro
	protected static int x;
	protected static int y;

	// obj guerreiro 
	private static Warrior warrior;

	public GenerateLabirinty() {}

	//metodo para gerar o labirinto
	public static void generate(int i, Warrior w){
		//passando o guerreiro para a classe
		warrior = w;
		lvLabirinty = i + 7;
		
		
		
		//criando o labirinto
		createLabireinty(lvLabirinty);

		// gerando paredes
		addWall();

		// adiciona a saida do jogo para poder passar para a proxima fase
		addExit();

		// ver todas as posições do labirinto 
		//viewLab();

		// adiciona o jogador
		addWarrior(warrior);
		
		//adicionando monstros
		addMonster();
		
		//seta o labirinto já com o guerreiro no jogo
		Move.setLabirinty(labirinties);

		// seta o guerreiro que esta no labirinto
		Move.setWarrior(warrior);

		System.out.println("guerreiro esta no x = "+warrior.getX());
		System.out.println("guerreiro esta no y = "+warrior.getY());
	}

	//metodo para gerar o labirinto novo a cada saida
	public static void reloadLabirintyLevel(Warrior w){
		warrior = w;
		lvLabirinty += 5;
		
		//criando o labirinto
		createLabireinty(lvLabirinty);

		// gerando paredes
		addWall();

		// adiciona a saida do jogo para poder passar para a proxima fase
		addExit();

		// ver todas as posições do labirinto 
		//viewLab();

		// adiciona o jogador
		addWarrior(warrior);
		
		//adicionando monstros
		addMonster();

		//seta o labirinto já com o guerreiro no jogo
		Move.setLabirinty(labirinties);
	}


	//adicionar paredes
	public static void addWall(){
		int quantWallForLines = lvLabirinty/2;		
		Random rnd = new Random();		

		for(int k = 0; k < lvLabirinty; k++){			
			for(int j = 0; j < quantWallForLines; j++){
				labirinties[k][rnd.nextInt(quantWallForLines)].setContaint(new wall());
			}
		}

	}

	public static void createLabireinty(int i){		
		labirinties = new ObjectLabirinty[i][i];

		for(int k = 0; k < i; k++){			
			for(int j = 0; j < i; j++){
				labirinties[k][j] = new ObjectLabirinty();
				
				// gerando as barreiras do labirinto
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
				}else if(k == ( i - 1 )){ //parte lateral Direita					
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderRight(true);
				}else if(j == ( i - 1 )){ //parte inferior					
					labirinties[k][j].setBorder(true);
					labirinties[k][j].setBorderBottom(true);
				}
			}
		}

	}

	//colocar player no jogo
	public static void addWarrior(Warrior w){
		Random rnd = new Random();		
		int x , y;


		while(true){
			x = rnd.nextInt(lvLabirinty);
			y = rnd.nextInt(lvLabirinty);

			//para evitar que o warrior seja colocado fora dos limites
			if(x == 0 || x == lvLabirinty-1 || y == 0 || y == lvLabirinty-1) continue;
			
			
			if(labirinties[x][y].getContaint() == null){
				labirinties[x][y].setContaint(w);

				//Seta as posições do guerreiro
				warrior.setX(x);
				warrior.setY(y);

				break;
			}
			System.out.println("conflito na posição ao colocar o warrior!!");// teste p tirar isso
		}
	}

	//colocar a saida no jogo
	public static void addExit(){
		Random rnd = new Random();
		int x;
		int y;

		while(true){
			x = rnd.nextInt(lvLabirinty);
			y = rnd.nextInt(lvLabirinty);

			//para evitar que o warrior seja colocado fora dos limites
			if(x == 0 || x == lvLabirinty-1 || y == 0 || y == lvLabirinty-1) continue;
			
			if(labirinties[x][y].getContaint() == null){				
				labirinties[x][y].setContaint(new Exit());
				System.out.println("o exit tá no de x = "+x+" y = "+y);
				break;
			}
			
			System.out.println("conflito ao colocar a saida no labirinto!");
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

	// passa os comandos de walk
	public static String go(String step){
		return Commands.steps(step);
	}
	
	// cria monstros com aleatorios pegando os nomes que estão no banco de dados
	public static void addMonster(){
			
		int quantWallForLines = lvLabirinty/3;		
		Random rnd = new Random();
		
		//pega um monstro aleatorio criado no banco 
		Monster obj = daomonsters.getOneMonsterAleatory();
		
		if(obj != null){
			obj.setLv(lvLabirinty);
			
			for(int k = 0; k < lvLabirinty; k++){			
				for(int j = 0; j < quantWallForLines; j++){
					labirinties[k][rnd.nextInt(quantWallForLines)].setContaint(obj);					
				}
			}
			
			System.out.println("monstro "+obj.getName()+" adicionado! com hp: "+obj.getHp());
		}
			
	}


}
