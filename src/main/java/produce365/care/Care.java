package produce365.care;

public class Care {
	
	private int id;
	private String category;
	private int cost;
	
	public Care() {}
	
	public Care(int id, String category, int cost) {
		super();
		this.id = id;
		this.category = category;
		this.cost = cost;
	}
	
	public Care(String category, int cost) {
		super();
		this.category = category;
		this.cost = cost;
	}
	
	public Care(String category) {
		super();
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Care [id=" + id + ", category=" + category + ", cost=" + cost + "]";
	}
	
	
}
