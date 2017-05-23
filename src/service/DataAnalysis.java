package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Equipment;
import domain.NoteBook;
import domain.PC;
import domain.Printer;
import domain.Programmer;
import domain.Status;

public class DataAnalysis {
	Employee ep = new Employee();

	public void Display(){
		String[] eq = new String[12];

		for (int i = 1; i < 12; i++) {
			eq[i] = Data.EQIPMENTS[i][0];
		}
		Equipment equipments[] = new Equipment[12];

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

		// Employee : 10, id, name, age, salary
		// Programmer: 11, id, name, age, salary
		// Designer : 12, id, name, age, salary, bonus
		// Architect : 13, id, name, age, salary, bonus, stock

		Employee employees[] = new Employee[12];

		for (int i = 0; i < 12; i++) {
			if (em[i] == ("10")) {
				employees[i] = new Employee(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2],
						Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]) );
				System.out.println(employees[i].toString() );
			}
			if (em[i] == ("11")) {
				employees[i] = new Programmer(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2],
						Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]),0,equipments[i]);
				System.out.println(employees[i].toString() + "\t"+equipments[i].getDescription());
			}
			if (em[i] == ("12")) {
				employees[i] = new Designer(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2],
						Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]),
						0,equipments[i],Double.parseDouble(Data.EMPLOYEES[i][5]));
				System.out.println(employees[i].toString()+ "\t"+equipments[i].getDescription());

			}
			if (em[i] == ("13")) {
				employees[i] = new Architect(Integer.parseInt(Data.EMPLOYEES[i][1]), Data.EMPLOYEES[i][2],
						Integer.parseInt(Data.EMPLOYEES[i][3]), Double.parseDouble(Data.EMPLOYEES[i][4]),0,equipments[i],
						Double.parseDouble(Data.EMPLOYEES[i][5]), Integer.parseInt(Data.EMPLOYEES[i][6]));
				System.out.println(employees[i].toString()+ equipments[i].getDescription());
			}
		}

		/*
		 * for (Employee a : employees) {
		 * 
		 * if (a instanceof Architect) { System.out.println(a.getId() + "\t" +
		 * a.getName() + "\t" + a.getAge() + "\t" + a.getSalary() + "\t" +
		 * "架构师\t" + ((Architect) a).getBouns() + "\t" + ((Architect)
		 * a).getStock()+"\t"); } else if (a instanceof Designer) {
		 * System.out.println(a.getId() + "\t" + a.getName() + "\t" + a.getAge()
		 * + "\t" + a.getSalary() + "\t" + "设计师\t" + ((Designer) a).getBouns());
		 * } else if (a instanceof Programmer) { System.out.println(a.getId() +
		 * "\t" + a.getName() + "\t" + a.getAge() + "\t" + a.getSalary() +
		 * "\t程序员"); } else if (a instanceof Employee) {
		 * System.out.println(a.getId() + "\t" + a.getName() + "\t" + a.getAge()
		 * + "\t" + a.getSalary() + ""); }
		 * 
		 * }
		 */

	}

}