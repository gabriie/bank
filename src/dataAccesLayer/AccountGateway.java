package dataAccesLayer;

import java.sql.*;
import modelLayer.DBConnect;
import modelLayer.Account;


public class AccountGateway extends Gateway<Account> {
	
	private DBConnect connection;
	
	public AccountGateway(){
			connection=new DBConnect();
	}
	
	public void insert(Account account){
			PreparedStatement  state=null;
			String query = " INSERT INTO account ( idCustomer, typeAccount, amountAccount, dateOfAccount, accountNumber)"
							+ "VALUE(?, ?, ?, ?, ?)";
			
			try{
				state = connection.getConnection().prepareStatement(query);
				
				state.setInt(1, account.getIdCustomer());
				state.setString(2, account.getTypeAccount());
				state.setInt(3, account.getAmountAccount());
				state.setString(4, account.getDateOfAccount());
				state.setString(5, account.getAccountNumber());
				state.executeUpdate();

			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	public void update(Account account){
		String query = " UPDATE `account` SET `idCustomer` = ?, `typeAccount` = ?, `amountAccount` = ?,"
				+ " `dateOfAccount` = ?, `accountNumber` = ? WHERE `account`.`idAccount` = ?;";
		
		try{
			PreparedStatement state = connection.getConnection().prepareStatement(query);
		
			state.setInt(1, account.getIdCustomer());
			state.setString(2, account.getTypeAccount());
			state.setInt(3, account.getAmountAccount());
			state.setString(4, account.getDateOfAccount());
			state.setString(5, account.getAccountNumber());
			state.setInt(6, account.getIdAccount());
			state.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
}
	public void delete(Account account){
		
		String query = "DELETE from account where idAccount = ?";
		
		try{
		PreparedStatement state = connection.getConnection().prepareStatement(query);

		state.setInt(1, account.getIdAccount());
		state.executeUpdate();
	
		} catch(SQLException e){
			e.printStackTrace();
		}	
	}

	
	public ResultSet findById(int id){
		
		String query = "SELECT * from account where idAccount = ?";
		PreparedStatement state=null;
		ResultSet rs=null;
		try{
	    state = connection.getConnection().prepareStatement(query);
		state.setInt(1, id);
		rs=state.executeQuery();
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}	
		return rs;
	}
	
	public ResultSet findAll(){
		
		String query = "SELECT * from account";					
		
		try{
			return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}	
	}

	
	public ResultSet findByCustomer(int nr) {
		String query = "SELECT * FROM account WHERE idCustomer = ?";
		
		try{
		PreparedStatement state = connection.getConnection().prepareStatement(query);

		state.setInt(1, nr);
		state.executeUpdate();
		
		return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}	
	}

}
