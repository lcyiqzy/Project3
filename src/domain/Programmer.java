package domain;

public class Programmer extends Employee {

	int memberId;
	Status status= Status.FREE;
	Equipment equipments;

	public Programmer() {

	}
	public Programmer(int id, String name, int age, double salary){
		super(id, name, age, salary);
	}

	public Programmer(int id, String name, int age, double salary, int memberId,  Equipment equipments) {
		super(id, name, age, salary);
		this.memberId = memberId;
		
		this.equipments = equipments;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipments() {
		return equipments;
	}

	public void setEquipments(Equipment equipments) {
		this.equipments = equipments;
	}
	@Override
	public String toString() {
		return id + "\t" + name + "\t" + age + "\t" + salary + "\t"+"≥Ã–Ú‘±"+"\t"+getStatus()+"\t"+"\t";
	}
}