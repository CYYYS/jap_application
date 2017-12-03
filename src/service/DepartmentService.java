package service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Department;

public class DepartmentService {
	public static void main(String[] args) {
		DepartmentService ds = new DepartmentService();
		//增加一个部门
		ds.insert(1,"会计部");
		//ds.find(2);
		//ds.findAll();
		//ds.update(1);
		//ds.delete(1);
	}
	
	//获取实体管理器工厂
	public static EntityManagerFactory getEntityManagerFactory() {
		//创建实体管理器工厂
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_link");
		return entityManagerFactory;
	}
	//获取实体管理器
	public  EntityManager getEntityManager(EntityManagerFactory entityManagerFactory) {
		//创建实体管理器
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	//添加部门
	public  void insert(int id,String name) {
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		//首先开启事务
		manager.getTransaction().begin();
		//创建Department类型的对象
		Department dept = new Department();
		dept.setId(id);
		dept.setName(name);
		//持久化实体
		manager.persist(dept);
		//提交事务
		manager.getTransaction().commit();
		manager.clear();
		factory.close();
	}
	//查询部门
	public void find(int id) {
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		Department d = manager.find(Department.class,1);
		System.out.println(d.getName());
		manager.close();
		factory.close();
	}
	//查询所有部门
	public void findAll() {
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		List<Department> resultList = manager.createQuery("select d from Department d ",Department.class).getResultList();
		for(Department dept:resultList) {
			System.out.println(dept);
		}
		manager.close();
		factory.close();
		
	}
	//更新部门
	public void update(int id) {
		//首先获取到需要修改的对象
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		Department d = manager.find(Department.class,id);
		//开启事务
		manager.getTransaction().begin();
		//修改
		d.setName("审计部");
		manager.persist(d);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	//删除部门
	public void delete(int id) {
		//首先获取到需要删除的对象
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		Department d = manager.find(Department.class,id);
		//开启事务
		manager.getTransaction().begin();
		manager.remove(d);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}
