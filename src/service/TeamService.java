package service;

import domain.Employee;
/*
counterΪ��̬����������Ϊ�����Ŷ�������Ա�Զ������Ŷ��е�ΨһID����memberId������ʾ��Ӧʹ����1�ķ�ʽ��
MAX_MEMBER��ʾ�����Ŷ�����Ա��
team�����������浱ǰ�Ŷ��еĸ���Ա���� 
total��¼�Ŷӳ�Ա��ʵ������

getTeam()���������ص�ǰ�Ŷӵ����ж���
���أ��������г�Ա��������飬�����С���Ա����һ��
addMember(e: Employee)���������Ŷ�����ӳ�Ա
����������ӳ�Ա�Ķ���
�쳣�����ʧ�ܣ� TeamException�а�����ʧ��ԭ��
removeMember(memberId: int)���������Ŷ���ɾ����Ա
��������ɾ����Ա��memberId
�쳣��ɾ��ʧ�ܣ� TeamException�а�����ʧ��ԭ��
���⣬�ɸ�����Ҫ��������������������ع�����


 */
import domain.Programmer;
import domain.Status;

public class TeamService {
	public int counter = 1;
	final int MAX_MEMBER = 5;
	int total = 0;

	Programmer[] team = new Programmer[MAX_MEMBER];

	public Programmer[] getTeam() {
		Programmer[] members = new Programmer[total];
		for (int i = 0; i < total; i++) {
			members[i] = team[i];
		}
		return members;
	}

	public void addMember(Employee e) throws TeamException {
		if (total > MAX_MEMBER - 1) {
			throw new TeamException("������Ա���ƣ����ʧ�ܣ�");
		}
		Programmer p = (Programmer) e;
		team[total++] = p;
		p.setMemberId(counter++);
		p.setStatus(Status.BUSY);

	}

	public void removeMember(int memberId) throws TeamException {
		if (team[0] == null) {
			throw new TeamException("���������޳�Ա��ɾ��ʧ�ܣ�");
		} else if (memberId > MAX_MEMBER && memberId < 0) {
			throw new TeamException("����ı���������������룡");

		} else
			counter--;
		team[total--] = null;
		for (int i = memberId; i < total - 1; i++) {
			team[i] = team[i + 1];

		}
	}
}
