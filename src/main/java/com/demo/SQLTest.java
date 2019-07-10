package com.demo;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 
import com.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import com.demo.mapper.DataMapper;
 
@Component
public class SQLTest {
 
	@Autowired
	DataMapper dataMapper;
 
	//自动载入，程序启动时候就运行啦。。。。
	@Autowired
	public void run() {
		test_query();
 
		test_insert();
		test_query();
 
		test_update();
		test_query();
 
		test_multi_query();
 
		test_multi_insert();
		test_multi_query();		
 
		test_delete();
		test_query();
 
		test_multi_delete();
		test_multi_query();
 
		/*test_exe_procedure(true);
		test_exe_procedure(false);*/
	}
 
	private void test_query()
	{
		System.out.println("test_query...");	
		Integer EMPNO =7788;
		List<Employee> empList =dataMapper.test_query(EMPNO);
		Employee.Print(empList);
		return;
	}
 
	private void test_insert()
	{
		System.out.println("test_insert...");	
		Employee emp = new Employee();
		emp.setEMPNO(7979);
		emp.setENAME("ENAME");
		emp.setJOB("JOB");
		emp.setMGR(7566);
		emp.setHIREDATE(new Date());
		emp.setSAL(8799.76);
		emp.setCOMM(235.65);
		emp.setDEPTNO(20);
		dataMapper.test_insert(emp);
	}
 
	private void test_update()
	{
		System.out.println("test_update...");	
		dataMapper.test_update(7979, 555.25);
	}
 
	private void test_delete()
	{
		System.out.println("test_delete...");
		dataMapper.test_delete(7979);
	}
 
	private void test_multi_insert()
	{
		System.out.println("test_multi_insert...");	
		Employee emp1 = new Employee();
		emp1.setEMPNO(7980);
		emp1.setENAME("ENAME1");
		emp1.setJOB("JOB1");
		emp1.setMGR(7566);
		emp1.setHIREDATE(new Date());
		emp1.setSAL(8799.76);
		emp1.setCOMM(235.65);
		emp1.setDEPTNO(30);
 
		Employee emp2 = new Employee();
		emp2.setEMPNO(7981);
		emp2.setENAME("ENAME2");
		emp2.setJOB("JOB2");
		emp2.setMGR(7566);
		emp2.setHIREDATE(new Date());
		emp2.setSAL(8799.76);
		emp2.setCOMM(235.65);
		emp2.setDEPTNO(30);
 
		Employee emp3 = new Employee();
		emp3.setEMPNO(7979);
		emp3.setENAME("ENAME");
		emp3.setJOB("JOB2");
		emp3.setMGR(7566);
		emp3.setHIREDATE(new Date());
		emp3.setSAL(8799.76);
		emp3.setCOMM(235.65);
		emp3.setDEPTNO(20);
 
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		dataMapper.test_multi_insert(empList);
	}
 
	private void test_multi_query()
	{
		System.out.println("test_multi_query...");	
		int[] DEPTNOArr = { 20, 30 };
		List<Employee> empList  =  dataMapper.test_multi_query(DEPTNOArr);
		Employee.Print(empList);
		return;		
	}
 
	private void test_multi_delete()
	{
		System.out.println("test_multi_delete...");	
		List<Integer> EMPNOList = new ArrayList<Integer>();		
		EMPNOList.add(7980);
		EMPNOList.add(7981);
		dataMapper.test_multi_delete(EMPNOList);
		return;		
	}
 
}