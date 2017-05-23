package view;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;
import domain.Status;
import service.Data;
import service.DataAnalysis;
/*
listSvc和teamSvc属性：供类中的方法使用
enterMainMenu ()方法：主界面显示及控制方法。
以下方法仅供enterMainMenu()方法调用：
listAllEmployees ()方法：以表格形式列出公司所有成员
addMember ()方法：实现添加成员操作
deleteMember ()方法：实现删除成员操作

 */
import service.NameListService;
import service.TeamException;
import service.TeamService;
import tools.TSUtility;

public class TeamView {
	NameListService listSvc = new NameListService();
	TeamService teamSvc = new TeamService();
	DataAnalysis da = new DataAnalysis();

	public void enterMainMenu() {
		boolean flag = true;

		do {

			System.out.println("-----------------------------------开发团队调度软件------------------------------------");
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态 \t奖金 \t股票\t领用设备");

			 Employee[] emp =listSvc.getAllEmployees();
			 for(Employee p : emp){
				 
				System.out.println(p);
			 }

			System.out.println("1-团队列表 \t 2-添加团队成员 \t 3-删除团队成员\t 4-退出  \t请选择(1-4)： _");
			System.out.println();
			char a = TSUtility.readMenuSelection();
			switch (a) {
			case '1':
				listAllEmployees();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.print("请输入是否退出 Y/N： ");
				char judge = TSUtility.readConfirmSelection();
				if (judge == 'Y') {
					flag = false;
				}
				break;
			}

		} while (flag);
	}

	public void listAllEmployees() {
		Programmer[] ps = teamSvc.getTeam();
		System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t状态 \t奖金 \t股票");
		System.out.println();
		for (int i = 0; i < ps.length; i++) {
			System.out.println(ps[i].getMemberId() + "/" + ps[i].toString());
		}

	}

	public void addMember() {

		System.out.println("请输入要添加的员工： ");
		int num = TSUtility.readInt();
		Employee e = null;
		try {
			e = listSvc.getEmployee(num);
		} catch (TeamException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
			return;
		}

		if (e.getId() != 1 && ((Programmer) e).getStatus() == Status.FREE) {

			try {
				teamSvc.addMember(e);
			} catch (TeamException ex) {
				System.out.println(ex.getMessage());
			}
		} else
			System.out.println("该员工不符合要求或已被添加，请重新输入！");

	}

	public void deleteMember() {
		int num = 0;
		for (;;) {
			System.out.println("------------------- 删除成员  --------------------");
			System.out.println();
			System.out.println("请输入要删除的成员的TeamID： ");
			num = TSUtility.readInt();
			try {
				teamSvc.removeMember(num - 1);
			} catch (TeamException ex) {
				System.out.println(ex.getMessage());
			}
			break;
		}
	}

	public static void main(String[] args) {
		TeamView tv = new TeamView();
		tv.enterMainMenu();
	}

}
