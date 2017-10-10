package presentationLayer;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import businessLayer.LoginTry;
import businessLayer.Repository;
import businessLayer.TransferTry;
import dataAccesLayer.AccountGateway;
import dataAccesLayer.ClientGateway;
import dataAccesLayer.EmployeeGateway;
import dataAccesLayer.Gateway;
import dataAccesLayer.ReportGateway;
import dataAccesLayer.TransferGateway;
import modelLayer.Account;
import modelLayer.Client;
import modelLayer.Employee;
import modelLayer.Report;
import modelLayer.Transfer;
import net.proteanit.sql.DbUtils;


public class Controller {
	
	private Login loginView=new Login();
	private RegularUser userView=new RegularUser();
	private Administrator adminView=new Administrator();
	private LoginTry loginTry=new LoginTry();
	private TransferTry transferTry=new TransferTry();
	private AccountGateway aGateway=new AccountGateway();
	private TransferGateway tGateway=new TransferGateway();
	private ClientGateway cGateway=new ClientGateway();
	private EmployeeGateway eGateway=new EmployeeGateway();
    private Repository<TransferGateway, Transfer> repoT = new Repository<TransferGateway, Transfer>();
	private ArrayList<Transfer> trans = new ArrayList<Transfer>();
    private Repository<AccountGateway, Account> repoA = new Repository<AccountGateway, Account>();
    private ArrayList<Account> accounts = new ArrayList<Account>();

	public Controller(){
				
	}

	public void begin(){
		loginView.frameLogin.setVisible(true);

		  this.loginView.btnLogin.addActionListener(new ActionListener() {
			   	public void actionPerformed(ActionEvent e) {
			   		LoginTry loginTry=new LoginTry();
			   		Employee empl = loginTry.login(loginView.textFieldLoginUsername.getText(), loginView.textFieldLoginPassword.getText());
			   		
					try {
						if(empl != null){		
							if(loginView.textFieldLoginUsername.getText().equals(empl.getUsername())){		
								if(empl.getPasswordEmployee().equals(loginView.textFieldLoginPassword.getText())){	
									if(empl.isFunction()){							
										adminI();
									}else{
										regularUserI();	
									}
								}else{
									sendError("User inexistent");
								}
							}else{
								sendError("User inexistent");
							}
						}else{
							sendError("Error");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}			   		
			   	}
			   });
	}

	public void adminI(){
		adminView.initialize();
		adminView.frameAdministrator.setVisible(true);
		loginView.close();
//afis create			
		this.adminView.btnAdminCreateEmpl.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				adminView.getVisible();
				
			}
			});
		
//create employee		
		this.adminView.btnAdminEmployeeCreate2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				Employee empl;
				try{
					empl= new Employee(0,adminView.textFieldAdminEmployeeCreateName.getText(), adminView.comboBoxCreate.getAutoscrolls(), adminView.textFieldAdminEmployeeCreateUsername.getText(), adminView.textFieldAdminEmployeeCreatePassword.getText());
					eGateway.insert(empl);
					afisareEmployee(eGateway.findAll());
					adminView.textFieldAdminEmployeeCreateName.setText(null);
					adminView.getInvisible();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});

//afisare update employee		
		this.adminView.btnAdminUpdateEmpl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				adminView.getVisible2();		
			}
			});
//update employee		
		this.adminView.btnAdminEmployeeUpdate2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				Employee empl;
				try{
				empl= new Employee(Integer.parseInt(adminView.textFieldAdminEmployeeUpdateId.getText()), adminView.textFieldAdminEmployeeUpdateName.getText(), false, adminView.textFieldAdminEmployeeUpdateUsername.getText(), adminView.textFieldAdminEmployeeUpdatePassword.getText());
				eGateway.update(empl);
				afisareEmployee(eGateway.findAll());
				adminView.textFieldAdminEmployeeUpdateName.setText(null);
				adminView.getInvisible2();
					
				}catch(Exception e1){
					e1.printStackTrace();
			}
			}
		});
//delete employee
		this.adminView.btnAdminDeleteEmpl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				Employee empl;
				empl= new Employee(Integer.parseInt(adminView.textFieldAdminDelete.getText()), " ", false, " ", " ");
				try{
					eGateway.delete(empl);
					afisareEmployee(eGateway.findAll());
					adminView.textFieldAdminDelete.setText(null);
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
//listAll employee		
				this.adminView.btnAdminListAllEmpl.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					try{
						afisareEmployee(eGateway.findAll());
						
					}catch(Exception e1){
						e1.printStackTrace();
					}		
					}
				});		
//findById employee		
		this.adminView.btnAdminFindByIdEmpl.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				try{
					afisareEmployee(eGateway.findById(Integer.valueOf(adminView.textFieldAdminFindById.getText())));
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
//logout
		this.adminView.btnAdminLogout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				logout();
			}
		});
	}
		//////
	//REGULAR USER///
	    /////
	public void regularUserI(){
		
		userView.initialize();
		userView.frmRegularuser.setVisible(true);
		loginView.close();
		
	
		////CLIENT//
//afisare create Client
		this.userView.btnUserClientCreate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				userView.getVisible();
				userView.btnUserClientOK.setVisible(true);
				userView.btnUserClientOK2.setVisible(false);
			}
			});
		
//create Client		
		this.userView.btnUserClientOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){

				Client clt;
				try{
					clt= new Client(0,userView.textFieldUserClientName.getText(), userView.textFieldUserClientCardNumber.getText(), Integer.parseInt(userView.textFieldUserClientCnp.getText()), userView.textFieldUserClientAdress.getText());
					cGateway.insert(clt);
					afisareClient(cGateway.findAll());
					userView.textFieldUserClientName.setText(null);
					userView.getInvisible();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
// afisare update Client
		this.userView.btnUserClientUpdate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				userView.getVisible();
				userView.btnUserClientOK2.setVisible(true);
				userView.btnUserClientOK.setVisible(false);
			}
			});
		
//update Client		
		this.userView.btnUserClientOK2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				Client clt;

				try{
					clt= new Client(Integer.valueOf(userView.textFieldUserClientId.getText()),userView.textFieldUserClientName.getText(),
							userView.textFieldUserClientCardNumber.getText(), Integer.parseInt(userView.textFieldUserClientCnp.getText()),
							userView.textFieldUserClientAdress.getText());
					cGateway.update(clt);
					afisareClient(cGateway.findAll());
					userView.textFieldUserClientName.setText(null);
					userView.getInvisible();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
//delete Client
		this.userView.btnUserClientDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				Client c;
				c= new Client(Integer.parseInt(userView.textFieldUserClientDelete.getText()), "", "", 0, "");
				try{
					cGateway.delete(c);
					afisareClient(cGateway.findAll());
					userView.textFieldUserClientDelete.setText(null);
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
//findById
		this.userView.btnUserClientFindById.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){

				try{
					afisareClient(cGateway.findById(Integer.parseInt(userView.textFieldUserClientFindById.getText())));
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
//listAll Client
		this.userView.btnUserClientListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				afisareClient(cGateway.findAll());
				
			}catch(Exception e1){
				e1.printStackTrace();
			}		
			}
		});	
		/////ACCOUNT///
		
//afisare create account
		this.userView.btnUserAccountCreate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				userView.getVisible2();
				userView.btnUserAccountOK.setVisible(true);
				userView.btnUserAccountOK2.setVisible(false);
			}
			});
		
//create Account	
		this.userView.btnUserAccountOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){

				Account a;
				try{
					a= new Account(0, Integer.parseInt(userView.textFieldUserAccountIdClient.getText()),userView.textFieldUserAccountType.getText(),
							Integer.parseInt(userView.textFieldUserAccountAmount.getText()), userView.textFieldUserAccountDate.getText(), userView.textFieldUserAccountNumber.getText());
					aGateway.insert(a);
					afisareAccount(aGateway.findAll());
					userView.getInvisible2();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
//afisare update Account
		this.userView.btnUSerAccountUpdate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				userView.getVisible2();
				userView.btnUserAccountOK2.setVisible(true);
				userView.btnUserAccountOK.setVisible(false);
			}
			});
		
//update Account	
		this.userView.btnUserAccountOK2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				Account a;

				try{
					a=  new Account(Integer.parseInt(userView.textFieldUserAccountId.getText()), Integer.parseInt(userView.textFieldUserAccountIdClient.getText()),userView.textFieldUserAccountType.getText(),
							Integer.parseInt(userView.textFieldUserAccountAmount.getText()), userView.textFieldUserAccountDate.getText(), userView.textFieldUserAccountNumber.getText());
					aGateway.update(a);
					afisareAccount(aGateway.findAll());
					userView.getInvisible2();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
//delete Account
		this.userView.btnUserAccountDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				Account a;
				a= new Account(Integer.parseInt(userView.textFieldUserAccountDelete.getText()), 0, "", 0, "", "");
				try{
					aGateway.delete(a);
					afisareAccount(aGateway.findAll());
					userView.textFieldUserAccountDelete.setText(null);
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		
//findById Account
		this.userView.btnUserAccountFindById.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){

				try{
					afisareAccount(aGateway.findById(Integer.parseInt(userView.textFieldUserAccountFindById.getText())));
					
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
//listAll Accounts
		this.userView.btnUserAccountListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				afisareAccount(aGateway.findAll());
				
			}catch(Exception e1){
				e1.printStackTrace();
			}		
			}
		});	
		
//transaction
		this.userView.btnUserTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transfer t;
				Account a = null;
				Account b = null;
				ResultSet result1=aGateway.findAll();
			try{
				while(result1.next()){
					if(Integer.parseInt(userView.textFieldUserTransferFrom.getText())==result1.getInt("idAccount")){
						if (result1.getInt("amountAccount") <= Integer.parseInt(userView.textFieldUserTransferAmount.getText())){
							a=new Account(Integer.parseInt(userView.textFieldUserTransferFrom.getText()),
									result1.getInt("idCustomer"),
									result1.getString("typeAccount"),
									result1.getInt("amountAccount"),
									result1.getString("dateOfAccount"),
									result1.getString("accountNumber"));
							sendError("Sold insuficient!");
			//		result1.close();
					break;
				}
					}	
					try{
						if(Integer.parseInt(userView.textFieldUserTransferFrom.getText())==result1.getInt("idAccount")){
							a=new Account(Integer.parseInt(userView.textFieldUserTransferFrom.getText()),
									result1.getInt("idCustomer"),
									result1.getString("typeAccount"),
									result1.getInt("amountAccount")-Integer.parseInt(userView.textFieldUserTransferAmount.getText()),
									result1.getString("dateOfAccount"),
									result1.getString("accountNumber"));
		
						aGateway.update(a);
						}
				}catch(Exception e1){
					e1.printStackTrace();
				}
				try{
						if(Integer.parseInt(userView.textFieldUserTransferTo.getText())==result1.getInt("idAccount")){
								b=new Account(result1.getInt("idAccount"),
										result1.getInt("idCustomer"),
										result1.getString("typeAccount"),
										result1.getInt("amountAccount")+Integer.parseInt(userView.textFieldUserTransferAmount.getText()),
										result1.getString("dateOfAccount"),
										result1.getString("accountNumber"));		
					aGateway.update(b);
						}				
				}catch(Exception e1){
						e1.printStackTrace();
			}
				}

				t= new Transfer(0, Integer.parseInt(userView.textFieldUserTransferFrom.getText()),
						Integer.parseInt(userView.textFieldUserTransferTo.getText()),
						Integer.parseInt(userView.textFieldUserTransferAmount.getText()), System.currentTimeMillis());
							
				tGateway.insert(t);
				afisareAccount(aGateway.findAll());
				afisareTransfer(tGateway.findAll());
				
			}catch(Exception e1){
				e1.printStackTrace();
			}		
			}
		});	
		
//logout 		
		this.userView.btnUsersLogout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg1){
				logout();
			}
		});
	}	

	private void afisareEmployee(ResultSet result){

		try {
			adminView.tableAdminEmployee.setModel(DbUtils.resultSetToTableModel(result));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void afisareClient(ResultSet result){
		try {

			userView.tableUserClients.setModel(DbUtils.resultSetToTableModel(result));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void afisareAccount(ResultSet result){

		try {
			userView.table.setModel(DbUtils.resultSetToTableModel(result));
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void afisareTransfer(ResultSet result){
		
		try {
			userView.tableUserTransfer.setModel(DbUtils.resultSetToTableModel(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ArrayList<String> employeeList(ResultSet result){
		
		ArrayList<String> list=new ArrayList<String>();
		Employee employee;
		try {
			while(result.next()){
				employee=new Employee(result.getInt("idEmployee"),result.getString("nameEmployee"),result.getBoolean("function"), result.getString("username"), result.getString("password"));
				list.add(employee.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	public void sendError(String s){
		this.loginView.textFieldLoginPassword.setText("");
		this.loginView.labelmessage.setText(s);
		this.loginView.frameMsg.setVisible(true);
	}
	public void logout(){
		this.userView.frmRegularuser.setVisible(false);
		this.adminView.frameAdministrator.setVisible(false);
		this.loginView.frameLogin.setVisible(true);
	}
	
}
