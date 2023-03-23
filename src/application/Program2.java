package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmnetDao();

		System.out.println("=== TEST 1: department findById =====");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n=== TEST 2: department findAll =====");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TEST 3: Department Insert =====");
		Department newDepartment = new Department(null, "Informática");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n=== TEST 4: department Update =====");
		Department dep = departmentDao.findById(8);
		dep.setName("Games");
		departmentDao.update(dep);
		System.out.println("Update completed! ");

		System.out.println("\n=== TEST 6: Department Delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed! ");

		sc.close();
	}

}
