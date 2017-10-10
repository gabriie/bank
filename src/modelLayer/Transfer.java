package modelLayer;

public class Transfer extends Entity {
	
	private int idTransfer;
	private int account_s;
	private int account_d;
	private int amountTransfer;
	private long dateOfTransfer;
	
	public Transfer(){
		
	}
	
	public Transfer(int idTransfer,int account_s, int account_d, int amountTransfer, long dateOfTransfer){
	this.idTransfer=idTransfer;
	this.account_s=account_s;
	this.account_d=account_d;
	this.amountTransfer=amountTransfer;
	this.dateOfTransfer=dateOfTransfer;
	
	}

	public int getIdTransfer() {
		return idTransfer;
	}

	public void setIdTransfer(int idTransfer) {
		this.idTransfer = idTransfer;
	}

	public int getAccount_s() {
		return account_s;
	}

	public void setAccount_s(int account_s) {
		this.account_s = account_s;
	}

	public int getAccount_d() {
		return account_d;
	}

	public void setAccount_d(int account_d) {
		this.account_d = account_d;
	}

	public int getAmountTransfer() {
		return amountTransfer;
	}

	public void setAmountTransfer(int amountTransfer) {
		this.amountTransfer = amountTransfer;
	}

	public long getDateOfTransfer() {
		return dateOfTransfer;
	}

	public void setDateOfTransfer(long dateOfTransfer) {
		this.dateOfTransfer = dateOfTransfer;
	}
}
