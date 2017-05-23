package domain;

public class NoteBook implements Equipment {
	String model;
	double price;

	public NoteBook(String model, double price) {

		this.model = model;
		this.price = price;
	}

	public String getDescription() {
		return "" + model + " ¼Û¸ñÎª£º" + price;

	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}

