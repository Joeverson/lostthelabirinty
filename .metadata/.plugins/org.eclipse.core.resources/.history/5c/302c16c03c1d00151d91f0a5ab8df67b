package aplications;

import DAOjpa.DAO;
import DAOjpa.DAOMonsters;
import templates.Monster;

public class AplGerarMonsters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAOMonsters dao = new DAOMonsters();
		System.out.println("Crinado e inserindo base de dados no banco...\n\n");
		DAO.begin();
		dao.create(new Monster("crab-black", 1));
		dao.create(new Monster("fox-white", 2));
		dao.create(new Monster("birds", 3));
		DAO.commit();
		System.out.println("Fim da inserção no banco.");
	}

}
