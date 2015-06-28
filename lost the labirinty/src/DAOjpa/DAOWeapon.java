package DAOjpa;

import java.util.ArrayList;
import java.util.Random;

import templates.Weapon;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import templates.Warrior;

public class DAOWeapon extends DAO<Weapon>{

	public DAOWeapon() {}

	@SuppressWarnings("unchecked")
	//update status warrior
	public int updateMyWeapon (Warrior w){
		try{			
			Query select =  manager.createQuery("SELECT arm FROM Warrior w INNER JOIN Weapon arm on (w.ARMA_id_container = arm.id_container) WHERE w.name = '"+ w.getName() +"'");
			System.out.println(">>>"+select.getSingleResult().toString());
			Query q = manager.createQuery("UPDATE Weapon w SET w.lv = "+w.getArma().getLv()+" , w.name = "+w.getArma().getName()+" WHERE ARMA_id_container = '"+ select.getSingleResult().toString()+"'");
			return  q.executeUpdate();
			

		}catch(NoResultException e){
			return 0;
		}
	}


}
