package service;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Department;
import model.Employee;

public class EmployeeService {
	public static void main(String[] args) {
		insert("1","tom",new BigInteger("5020"),1);
		insert("6","小mi",new BigInteger("8420"),1);
		//find("1");
		//findAll();
		//update("1");
		//delete("1");
	}
	//获取实体管理器工厂
	public static EntityManagerFactory getEntityManagerFactory() {
		//创建实体管理器工厂
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa_link");
		return entityManagerFactory;
	}
	//获取实体管理器
	public static  EntityManager getEntityManager(EntityManagerFactory entityManagerFactory) {
		//创建实体管理器
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	//向员工表中添加数据
	public static void insert(String eid,String ename,BigInteger salary,int deptId) {
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		manager.getTransaction().begin();
		//创建对象
		Employee e = new Employee();
		e.setEid(eid);
		e.setEname(ename);
		e.setSalary(salary);
		//获取参照表对象
		Department department = manager.find(Department.class,deptId);
		e.setDepartment(department);
		
		//添加
		manager.persist(e);
		//关闭事务
		manager.getTransaction().commit();
		//关闭
		manager.close();
		factory.close();
	}
	//查找单个
	public static void find(String id) {
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		Employee emp = manager.find(Employee.class,id);
		System.out.println(emp);
		manager.close();
		factory.close();
	}
	//查找所有
	public static void findAll() {
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		List<Employee> list = manager.createQuery("select e from Employee d ",Employee.class).getResultList();
		for(Employee e:list) {
			System.out.println(e);
		}
		manager.close();
		factory.close();
	}
	//更新
	public static void update(String id) {
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		manager.getTransaction().begin();
		Employee emp = manager.find(Employee.class, id);
		
		emp.setEname("修改后");
		manager.persist(emp);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
	//删除
	public static void delete(String id) {
		EntityManagerFactory factory = getEntityManagerFactory();
		EntityManager manager = getEntityManager(factory);
		manager.getTransaction().begin();
		Employee employee = manager.find(Employee.class,id);
		manager.remove(employee);
		manager.getTransaction().commit();
		manager.clear();
		factory.close();
	}
}



