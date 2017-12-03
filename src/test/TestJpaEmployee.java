package test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.EmployeeService;

class TestJpaEmployee {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	//插入一个
	@Test
	void testInsert() {
		//当外键部门id不存在时会设置为null
		//EmployeeService.insert("7","小纳",new BigInteger("8420"),42);
		EmployeeService.insert("8","小纳2",new BigInteger("8420"),2);
	}
	//查询所有
	@Test
	void testFindAll() {
		EmployeeService.findAll();
	}
	//查询单个
	@Test 
	void testFind() {
		EmployeeService.find("2");
	}
	//更新
	@Test
	void testUpdate() {
		EmployeeService.update("2");
	}
	//删除
	@Test
	void testDelete() {
		EmployeeService.delete("8");
	}
}
