package DAOjpa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import templates.Monster;
import templates.Warrior;

public class DAOMonsters extends DAO<Monster>{

	public DAOMonsters() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public Monster getOneMonsterAleatory(){
		ArrayList<Monster> monsters;
		Random rnd = new Random();
		DAOMonsters dao = new DAOMonsters();
		List<Monster> q;
		
		try{			
			if((q = dao.readAll()) != null){				
				return q.get(rnd.nextInt(q.size()));
			}
			System.out.println("não encontrou nenhum monstro no banco"+dao.readAll().toString());
			return null;
		}catch(NoResultException e){
			return null;
		}
	}
}
