package DAODb4o;

import java.util.ArrayList;
import java.util.Random;

import com.db4o.query.Query;

import templates.Weapon;
import templates.Warrior;

public class DAOWeapon extends DAO<Weapon>{

	public DAOWeapon() {}

	@SuppressWarnings("unchecked")
	//update status warrior
	public int updateMyWeapon (Warrior w){
		try{			
			Query q = manager.query();
			q.constrain(Warrior.class);
			q.descend("name").constrain(w.getName());
			q.descend("arma").constrain(w.getArma());
			Weapon result = (Weapon) q.execute(); 
			System.out.println(">>> arma encontrada - name: "+result.getName());
			
			result.setLv(w.getArma().getLv());
			result.setName(w.getArma().getName());
			
			DAO.begin();
			update(result);
			DAO.commit();
			
			return  1;
			

		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public Weapon read(Object chave) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
