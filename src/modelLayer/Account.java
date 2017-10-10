package modelLayer;

public class Account extends Entity  {
	private int idAccount;
	private int idCustomer;
	private String typeAccount;
	private int amountAccount;
	private String dateOfAccount;
	private String accountNumber;
	
	public Account(){
		
	}
	
	public Account(int idAccount,int idCustomer, String typeAccount, int amountAccount, String dateOfAccount, String accountNumber){
		this.idAccount=idAccount;
		this.idCustomer=idCustomer;
		this.typeAccount=typeAccount;
		this.amountAccount=amountAccount;
		this.dateOfAccount=dateOfAccount;
		this.accountNumber=accountNumber;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getIdCustomer(){
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer){
		this.idCustomer=idCustomer;
	}
	
	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

	public int getAmountAccount() {
		return amountAccount;
	}

	public void setAmountAccount(int amountAccount) {
		this.amountAccount = amountAccount;
	}

	public String getDateOfAccount() {
		return dateOfAccount;
	}

	public void setDateOfAccount(String dateOfAccount) {
		this.dateOfAccount = dateOfAccount;
	}
	public String toString(){
		return this.idAccount+"  "+this.idCustomer+"  "+this.typeAccount+"  "+this.amountAccount+"  "+this.dateOfAccount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
