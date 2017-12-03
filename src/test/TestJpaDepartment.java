package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import service.DepartmentService;

class TestJpaDepartment {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	//测试增加一个部门
	@Test
	void testInsert() {
		DepartmentService ds = new DepartmentService();
		ds.insert(5, "会议室");
	}
	//查询所有
	@Test
	void testFindAll() {
		DepartmentService ds = new DepartmentService();
		ds.findAll();
	}
	@Test
	void testFind() {
		DepartmentService ds = new DepartmentService();
		ds.find(5);
	}
	@Test
	void testUpdate() {
		DepartmentService ds = new DepartmentService();
		ds.update(1);
	}
	@Test
	void testDelete() {
		DepartmentService ds = new DepartmentService();
		ds.delete(5);
	}
	

}
