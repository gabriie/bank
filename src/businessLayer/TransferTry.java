package businessLayer;

import java.sql.ResultSet;

import dataAccesLayer.AccountGateway;
import modelLayer.Account;
import modelLayer.Transfer;

public class TransferTry {
	 private Account acc=new Account();

	 public Account transfer(int a){

		 AccountGateway ag=new AccountGateway();
		 ResultSet result=ag.findAll();
		 try{
			 while (result.next()){
				 if(result.getInt("amountAccount")>=a){
					 
					 return new Account(result.getInt("idAccount"),result.getInt("idCustomer"),result.getString("typeAccount"),
							 result.getInt("amountAccount")-a,result.getString("DateOfAccount"), result.getString("accountNumber"));
				 } 
			 }
			 
		 }catch(Exception e){
			 System.out.println("Error connection!" +e);
		 }
		 return acc;
	 }
}
