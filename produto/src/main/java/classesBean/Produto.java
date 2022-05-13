package classesBean;

public class Produto {

	private String productName; // PK
	private String description;
	private String targetMarket;
	private String stack;
	
	public Produto( ) {
		
	}

	public Produto(String productName, String description, String targetMarket, String stack) {
		this.productName = productName;
		this.description = description;
		this.targetMarket = targetMarket;
		this.stack = stack;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(String array) {
		this.targetMarket = array;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String array) {
		this.stack = array;
	}

}
