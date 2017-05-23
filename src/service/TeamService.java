package service;

import domain.Employee;
/*
counter为静态变量，用来为开发团队新增成员自动生成团队中的唯一ID，即memberId。（提示：应使用增1的方式）
MAX_MEMBER表示开发团队最大成员数
team数组用来保存当前团队中的各成员对象 
total记录团队成员的实际人数

getTeam()方法：返回当前团队的所有对象
返回：包含所有成员对象的数组，数组大小与成员人数一致
addMember(e: Employee)方法：向团队中添加成员
参数：待添加成员的对象
异常：添加失败， TeamException中包含了失败原因
removeMember(memberId: int)方法：从团队中删除成员
参数：待删除成员的memberId
异常：删除失败， TeamException中包含了失败原因
另外，可根据需要自行添加其他方法或重载构造器


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
			throw new TeamException("超出成员限制，添加失败！");
		}
		Programmer p = (Programmer) e;
		team[total++] = p;
		p.setMemberId(counter++);
		p.setStatus(Status.BUSY);

	}

	public void removeMember(int memberId) throws TeamException {
		if (team[0] == null) {
			throw new TeamException("队伍中已无成员，删除失败！");
		} else if (memberId > MAX_MEMBER && memberId < 0) {
			throw new TeamException("输入的编号有误，请重新输入！");

		} else
			counter--;
		team[total--] = null;
		for (int i = memberId; i < total - 1; i++) {
			team[i] = team[i + 1];

		}
	}
}
