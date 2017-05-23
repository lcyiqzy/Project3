package domain;

public class Architect extends Designer {
	int stock;
	

	public Architect() {

	}

	public Architect(int id, String name, int age, double salary, int memberId,  Equipment equipments,
			double bouns, int stock) {
		super(id, name, age, salary, memberId, equipments, bouns);
		this.stock = stock;
		
	}

	

	public Architect(int id, String name, int age, double salary, double bouns, int stock) {
		super(id, name, age, salary, bouns);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String toString() {
		return id + "\t" + name + "\t" + age + "\t" + salary + "\t" + "¼Ü¹¹Ê¦" + "\t" + getStatus() + "\t" + bouns + "\t"
				+ stock + "\t";
	}
}