package dataAccesLayer;

import java.sql.*;
import modelLayer.DBConnect;
import modelLayer.Transfer;

public class TransferGateway extends Gateway<Transfer> {
	
	private DBConnect connection;
	
	public TransferGateway(){
		connection=new DBConnect();
		
	}

	public void insert(Transfer t) {
		String query = "INSERT INTO transfer (account_s, account_d, amountTransfer, dateOfTransfer)"
				+ "VALUE(?, ?, ?, ?)";		
		try{
		PreparedStatement state = connection.getConnection().prepareStatement(query);
		
		state.setInt(1, t.getAccount_s());
		state.setInt(2, t.getAccount_d());
		state.setInt(3, t.getAmountTransfer());
		state.setLong(4, t.getDateOfTransfer());
		state.executeUpdate();

	
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void update(Transfer t) {
		String query = " UPDATE `transfer` SET `account_s` = ?, `account_d` = ?, `amountTransfer` = ?,"
				+ " `dateOfTransfer` = ?WHERE `transfer`.`idTransfer` = ?;";

		try{
			PreparedStatement state = connection.getConnection().prepareStatement(query);

			state.setInt(1, t.getAccount_s());
			state.setInt(2, t.getAccount_d());
			state.setInt(3, t.getAmountTransfer());
			state.setLong(4, t.getDateOfTransfer());
			state.setInt(5, t.getIdTransfer());
			state.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Transfer e) {
		// TODO Auto-generated method stub
		
	}

	public ResultSet findById(int id) {
		String query = "SELECT * from transfer where idTransfer = ?";
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

	public ResultSet findAll() {
		String query = "SELECT * FROM transfer";					
		
		try{
			return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
}
