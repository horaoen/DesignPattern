package DAO;

import java.util.HashSet;
import java.util.Set;


public class DAOApp {

	public static void main(String[] args) {
		mainOOP(args);
		//mainOIP(args);
		//mainDAODP(args);
		//mainDAODP1(args);
	}
	
	public static void mainOOP(String[] args) {
		System.out.println("面向对象编程");
		DAOImpl daoImpl = new DAOImpl();//面向对象:DAOImpl类对象 编程，最差——不能应对需求变化
		daoImpl.delete(1);
		daoImpl.insert(1, "DAOOOP");
		daoImpl.query(1);
	}

	public static void mainOIP(String[] args) {
		System.out.println("\n\n面向接口编程");
		IDAO iDao = new DAOImpl();//面向接口：IDAO接口 编程，较好的，需要修改的地方有，但是不会影响客户端（业务层）
		iDao.delete(2);
		iDao.insert(2, "DAOOIP");
		iDao.query(2);
	}
	
	public static void mainDAODP(String[] args) {
		System.out.println("\n\n面向模式编程");
		IDAO iDao=DAOFactory.getInstance().getIDAO("IDao");//面向模式编程,没有具体类名DAOImpl，只有接口IDao--更好的
		iDao.deleteById(3);
		VO vo = new VO(3, "DAOODPP");
		iDao.insertToDB(vo);
		iDao.queryById(3);
		vo.setName("daoodpp");
		iDao.updateById(3, vo);
	}
	
	public static void mainDAODP1(String[] args) {

		try{
			ICityDAO iCityDAO=DAOFactory.getInstance().getICityDAO("ICityDao");//面向模式编程1
			System.out.println("\n\n面向模式编程1");
			System.out.println("\n******City******");
			Set<Integer> set = new HashSet<Integer>();
			set.add(3);
			iCityDAO.doRemoveBatch(set);
			City city = new City(3, "chuzhou", "anhui");
			iCityDAO.doCreate(city);
			city=iCityDAO.findById(3);
			System.out.println(city.toString());
			city.setProvince("jiangsu");
			System.out.println(iCityDAO.doUpdate(city));
			city=iCityDAO.findById(3);
			System.out.println(city.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("\n******River******");
		try{
			IRiverDAO iRiverDAO=DAOFactory.getInstance().getIRiverDAO("IRiverDao");//面向模式编程1
			Set<Integer> set = new HashSet<Integer>();
			set.add(3);
			iRiverDAO.doRemoveBatch(set);
			River river = new River(3, "chuzhou", "anhui");
			iRiverDAO.doCreate(river);
			river=iRiverDAO.findById(3);
			System.out.println(river.toString());
			river.setProvince("jiangsu");
			System.out.println(iRiverDAO.doUpdate(river));
			river=iRiverDAO.findById(3);
			System.out.println(river.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println("\n******Lake******");
		try{
			ILakeDAO iLakeDAO=DAOFactory.getInstance().getILakeDAO("ILakeDao");//面向模式编程1
			Set<Integer> set = new HashSet<Integer>();
			set.add(3);
			iLakeDAO.doRemoveBatch(set);
			Lake lake = new Lake(3, "chuzhou", "anhui");
			iLakeDAO.doCreate(lake);
			lake=iLakeDAO.findById(3);
			System.out.println(lake.toString());
			lake.setProvince("jiangsu");
			System.out.println(iLakeDAO.doUpdate(lake));
			lake=iLakeDAO.findById(3);
			System.out.println(lake.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
