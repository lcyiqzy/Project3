package view;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;
import domain.Status;
import service.Data;
import service.DataAnalysis;
/*
listSvc��teamSvc���ԣ������еķ���ʹ��
enterMainMenu ()��������������ʾ�����Ʒ�����
���·�������enterMainMenu()�������ã�
listAllEmployees ()�������Ա����ʽ�г���˾���г�Ա
addMember ()������ʵ����ӳ�Ա����
deleteMember ()������ʵ��ɾ����Ա����

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

			System.out.println("-----------------------------------�����Ŷӵ������------------------------------------");
			System.out.println("ID\t����\t����\t����\tְλ\t״̬ \t���� \t��Ʊ\t�����豸");

			 Employee[] emp =listSvc.getAllEmployees();
			 for(Employee p : emp){
				 
				System.out.println(p);
			 }

			System.out.println("1-�Ŷ��б� \t 2-����Ŷӳ�Ա \t 3-ɾ���Ŷӳ�Ա\t 4-�˳�  \t��ѡ��(1-4)�� _");
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
				System.out.print("�������Ƿ��˳� Y/N�� ");
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
		System.out.println("TID/ID\t����\t����\t����\tְλ\t״̬ \t���� \t��Ʊ");
		System.out.println();
		for (int i = 0; i < ps.length; i++) {
			System.out.println(ps[i].getMemberId() + "/" + ps[i].toString());
		}

	}

	public void addMember() {

		System.out.println("������Ҫ��ӵ�Ա���� ");
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
			System.out.println("��Ա��������Ҫ����ѱ���ӣ����������룡");

	}

	public void deleteMember() {
		int num = 0;
		for (;;) {
			System.out.println("------------------- ɾ����Ա  --------------------");
			System.out.println();
			System.out.println("������Ҫɾ���ĳ�Ա��TeamID�� ");
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
