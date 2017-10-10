package modelLayer;

public class Factura extends Entity{

	
	private int idFactura;
	private int idClient;
	private String comments;
	private String paid;
	private int amountFactura;
	
	public Factura(){
		
	}
	
	public Factura(int idFactura, int idClient, String comments, String paid, int amountFactura){
		this.idFactura=idFactura;
		this.idClient=idClient;
		this.comments=comments;
		this.paid=paid;
		this.amountFactura=amountFactura;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public int getAmountFactura() {
		return amountFactura;
	}

	public void setAmountFactura(int amountFactura) {
		this.amountFactura = amountFactura;
	}
}
