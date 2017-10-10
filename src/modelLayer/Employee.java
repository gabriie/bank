package modelLayer;

public class Employee extends Entity{
	int idEmployee;
	String nameEmployee;
	boolean function;
	String username;
	String passwordEmployee;
	
	public Employee(){
		
	}
	
	public Employee(int idEmployee,String nameEmployee,boolean function, String username, String passwordEmployee){
		this.idEmployee=idEmployee;
		this.nameEmployee=nameEmployee;
		this.function=function;
		this.username=username;
		this.passwordEmployee=passwordEmployee;
	}

	public boolean isFunction() {
		return function;
	}

	public void setFunction(boolean function) {
		this.function = function;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordEmployee() {
		return passwordEmployee;
	}

	public void setPasswordEmployee(String passwordEmployee) {
		this.passwordEmployee = passwordEmployee;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getNameEmployee() {
		return nameEmployee;
	}

	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}
}
