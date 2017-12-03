#####jpa_link环境搭建:
 1.在persistence.xml中的持久化单元中,声明需要持久化的类,并且需要写出数据库的基本信息.
 2.在使用的时候,首先创建实体管理工厂:
 EntityManagerFactory
       entityManagerFactory = Persistence.createEntityManagerFactory("jpa_link");
 3.然后,根据工厂创建实体管理器:
 		EntityManager entityManager = entityManagerFactory.createEntityManager();
 4.然后开启事务.
 5.执行需求.
 6.提交事务.
 7.关闭工厂和管理器. 