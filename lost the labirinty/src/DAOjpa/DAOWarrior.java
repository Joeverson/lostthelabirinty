package DAOjpa;

import javax.persistence.*;

import templates.Warrior;

public class DAOWarrior extends DAO<Warrior>{

	public DAOWarrior() {
		// TODO Auto-generated constructor stub
	}
	
	public Warrior findMyWarrior (String str){
		try{			
			Query q = manager.createQuery("SELECT w FROM Warrior w");
			Warrior w = (Warrior) q.getSingleResult();
			System.out.println(w.getName());
			return w;
		}catch(NoResultException e){
			return null;
		}
	}

}
