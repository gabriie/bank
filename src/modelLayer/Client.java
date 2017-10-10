package modelLayer;

public class Client extends Entity {
	int idClient;
	String nameClient;
	String cardNr;
	int cnp;
	String adress;
	
	public Client(){
		
	}
	
	public Client(int idClient,String nameClient,String cardNr, int cnp, String adress){
		this.idClient=idClient;
		this.nameClient=nameClient;
		this.cardNr=cardNr;
		this.cnp=cnp;
		this.adress=adress;
	}

	public String getCardNr() {
		return cardNr;
	}

	public void setCardNr(String CardNr) {
		this.cardNr = cardNr;
	}

	public int getCnp() {
		return cnp;
	}

	public void setCnp(int cnp) {
		this.cnp = cnp;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}
}
