package service;

import domain.Architect;
import domain.Designer;
/*
employees用来保存所有公司员工对象
getAllEmployees ()方法：获取当前所有员工。
返回：包含所有员工对象的数组
getEmployee(id : int)方法：获取指定ID的员工对象。
参数：指定员工的ID
返回：指定员工对象
异常：找不到指定的员工
另外，可根据需要自行添加其他方法或重载构造器

 */
import domain.Employee;
import domain.Equipment;
import domain.NoteBook;
import domain.PC;
import domain.Printer;
import domain.Programmer;
import domain.Status;

public class NameListService {
	Employee employees[];
	Equipment equipments[];

	public NameListService() {

		employees = new Employee[12];
		equipments= new Equipment[12];
		String[] eq = new String[12];

		for (int i = 1; i < 12; i++) {
			eq[i] = Data.EQIPMENTS[i][0];
		}

		for (int i = 1; i < 12; i++) {
			if (eq[i] == "21") {
				equipments[i] = new PC(Data.EQIPMENTS[i][1], Data.EQIPMENTS[i][2]);

			}
			if (eq[i] == "22") {
				equipments[i] = new NoteBook(Data.EQIPMENTS[i][1], Double.parseDouble(Data.EQIPMENTS[i][2]));
			}
			if (eq[i] == "23") {
				equipments[i] = new Printer(Data.EQIPMENTS[i][1], Data.EQIPMENTS[i][2]);
			}
		}

		String[] em = new String[12];

		for (int i = 0; i < 12; i++) {
			em[i] = Data.EMPLOYEES[i][0];

		}

		for (int i = 0; i < 12; i++) {
			if (em[i] == ("10")) {
				employees[i] = new Employee(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2],
						Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]));

			}
			if (em[i] == ("11")) {
				employees[i] = new Programmer(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2],
						Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]), 0,
						 equipments[i]);

			}
			if (em[i] == ("12")) {
				employees[i] = new Designer(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2],
						Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]), 0,
						 equipments[i], Double.parseDouble(Data.EMPLOYEES[i][5]));

			}
			if (em[i] == ("13")) {
				employees[i] = new Architect(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2],
						Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]), 0,
						 equipments[i], Double.parseDouble(Data.EMPLOYEES[i][5]),
						Integer.parseInt(Data.EMPLOYEES[i][6]));

			}
		}

	}

	public Employee[] getAllEmployees() {

		return employees;
	}

	public Employee getEmployee(int id) throws TeamException {

		for (Employee employee : employees) {
			if (id == employee.getId()) {
				return employee;
			}
		}

		throw new TeamException("找不到指定员工！");
	}
}
