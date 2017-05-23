package domain;

public class Designer extends Programmer {
	double bouns;

	public Designer() {

	}

	public Designer(int id, String name, int age, double salary, int memberId,  Equipment equipments,
			double bouns) {
		super(id, name, age, salary, memberId, equipments);
		this.bouns = bouns;
		// TODO Auto-generated constructor stub
	}

	public Designer(int id, String name, int age, double salary, double bouns) {
		super(id, name, age, salary);
		this.bouns = bouns;
	}

	public double getBouns() {
		return bouns;
	}

	public void setBouns(double bouns) {
		this.bouns = bouns;
	}
	public String toString() {
		return id + "\t" + name + "\t" + age + "\t" + salary + "\t"+"…Ëº∆ ¶"+"\t"+getStatus()+"\t"+bouns+"\t";
	}
}