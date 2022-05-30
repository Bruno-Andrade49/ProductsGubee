package classesBean;

//Classe entidade Stack
public class Stack {

	private int id;
	private String stacks;
	private int productfk;

	
	//Construtor
	public Stack(int id, String stacks, int productfk) {
		this.id = id;
		this.stacks = stacks;
		this.productfk = productfk;
	}

	//Encapsulamento
	
	public Stack() {

	}

	public int getProductfk() {
		return productfk;
	}

	public void setProductfk(int productfk) {
		this.productfk = productfk;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStacks() {
		return stacks;
	}

	public void setStacks(String stacks) {
		this.stacks = stacks;
	}

}
