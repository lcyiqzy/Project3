package domain;

public class Printer implements Equipment {
	String type;
	String name;

	public Printer(String type, String name) {

		this.type = type;
		this.name = name;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "" + type + "Ãû³ÆÎª£º" + name;

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
