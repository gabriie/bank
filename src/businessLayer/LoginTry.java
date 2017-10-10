package businessLayer;

import java.sql.ResultSet;

import dataAccesLayer.AccountGateway;
import dataAccesLayer.EmployeeGateway;
import modelLayer.Employee;

public class LoginTry {

    private Employee user=new Employee();

	 public Employee login(String a, String b){
		 
		 Repository rep=new Repository();	
		EmployeeGateway eg=new EmployeeGateway();
		 ResultSet result=eg.findAll();
		 
		 try{
			 while (result.next()){
				 if(result.getString("username").equals(a)&&result.getString("passwordEmployee").equals(b)){
					 return new Employee(result.getInt("idEmployee"),
							 			result.getString("nameEmployee"),
							 			result.getBoolean("function"),
							 			result.getString("username"),
							 			result.getString("passwordEmployee"));
				 } 
			 }
			 
		 }catch(Exception e){
			 System.out.println("Error connection!" +e);
		 }
		 return user;
	 }
}
