package classesBean;

import java.util.List;

public class Produto {

	private String productName; // PK
	private String description;
	
	//Array que relaciona os TargetMarket a Produto
	private List<TargetMarket> targetMarket;
	
	//Array que relaciona as stacks a Produto
	private List<Stack> stack;
	
	//Classe entidade Produto
	public Produto( ) {
		
	}

	//Construtor
	public Produto(String productName, String description, List<TargetMarket> targetMarket, List<Stack> stack) {
		this.productName = productName;
		this.description = description;
		this.targetMarket = targetMarket;
		this.stack = stack;
	}

	//Encapsulamentos
	
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

	public List<TargetMarket> getTargetMarket() {
		return targetMarket;
	}

	public void setTargetMarket(List<TargetMarket> targetMarket) {
		this.targetMarket = targetMarket;
	}

	public List<Stack> getStack() {
		return stack;
	}

	public void setStack(List<Stack> stack) {
		this.stack = stack;
	}
	
	
	
	

}
