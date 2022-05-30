package classesBean;

//Classe entidade TargetMarket
public class TargetMarket {

	private int id;
	private String targetMarkets;
	private int productfk;
	
	
	//Construtor
	public TargetMarket(int id, String targetMarkets, int productfk) {
		this.id = id;
		this.targetMarkets = targetMarkets;
		this.productfk = productfk;
	}

	//Encapsulamento
	
	public TargetMarket() {

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

	public void setId(int string) {
		this.id = string;
	}

	public String getTargetMarkets() {
		return targetMarkets;
	}

	public void setTargetMarkets(String targetMarkets) {
		this.targetMarkets = targetMarkets;
	}

}
