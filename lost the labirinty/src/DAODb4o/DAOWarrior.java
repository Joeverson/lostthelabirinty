package DAODb4o;

import java.awt.List;

import com.db4o.query.Query;

import templates.Warrior;

public class DAOWarrior extends DAO<Warrior>{

	public DAOWarrior() {
		// TODO Auto-generated constructor stub
	}
	
	public Warrior findMyWarrior (String str){
		try{	
			Query q = manager.query();
			q.constrain(Warrior.class);
			q.descend("nome").constrain(str);			
			return (Warrior) q.execute();			
			
		}catch(Exception e){
			return null;
		}
	}
	
	//update status warrior
	public void updateMyWarrior (Warrior w){
		try{
			Query q = manager.query();
			q.constrain(Warrior.class);
			q.descend("name").constrain(w.getName());
			
			Warrior newWar = (Warrior) q.execute();
			System.out.println("atualizando o "+newWar.getName()+" No db4o");
			newWar.setLv(w.getLv());
			newWar.setHp(w.getHp());
			
			//gravando no banco
			DAO.begin();
			update(newWar);
			DAO.commit();
			
										
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Warrior read(Object chave) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
