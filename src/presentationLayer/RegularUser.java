package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;

public class RegularUser {

	protected JFrame frmRegularuser;
	protected JTable tableUserClients;
	protected JTextField textFieldUserClientFindById;
	protected JTable table;
	protected JTextField textFieldUserAccountFindById;
	protected JTextField textFieldUserTransferFrom;
	protected JTextField textFieldUserTransferTo;
	protected JTextField textFieldUserTransferAmount;
	protected JTextField textField;
	protected JTextField textField_1;
	protected JTextField textField_2;
	protected JTable tableUserTransfer;
	protected JTextField textFieldUserTransferFindById;
	protected JTextField textFieldUserClientDelete;
	protected JTextField textFieldUserClientId;
	protected JTextField textFieldUserClientName;
	protected JTextField textFieldUserClientCardNumber;
	protected JTextField textFieldUserClientCnp;
	protected JTextField textFieldUserClientAdress;
	protected JTextField textFieldUserAccountId;
	protected JTextField textFieldUserAccountIdClient;
	protected JTextField textFieldUserAccountType;
	protected JTextField textFieldUserAccountAmount;
	protected JTextField textFieldUserAccountDate;
	protected JTextField textFieldUserAccountNumber;
	protected JButton btnUsersLogout;
	protected JButton btnUserClientCreate ;
	protected JButton btnUserClientListAll;
	protected JButton btnUserClientUpdate;
	protected JButton btnUserClientDelete;
	protected JButton btnUserClientFindById;
	protected JLayeredPane lPaneUserClient;
	protected JButton btnUserAccountCreate;
	protected JButton btnUserClientOK;
	protected JButton btnUserAccountOK;
	protected JButton btnUserAccountOK2;
	protected JButton btnUserAccountListAll;
	protected JButton btnUSerAccountUpdate;
	protected JButton btnUserAccountDelete;
	protected JButton btnUserAccountFindById;
	protected JLayeredPane lPaneUserAccount;
	protected JButton btnUserTransfer;
	protected JButton btnUserTransferListAll;
	protected JButton btnUserTransferFindById;
	protected JButton btnUserBill;
	protected JButton btnUserClientOK2;
	protected JTextField textFieldUserAccountDelete;
	private JTable tableBill;
	/**
	 * Create the application.
	 */
	public RegularUser() {
		initialize();
//		frmRegularuser.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {

		frmRegularuser = new JFrame();
		frmRegularuser.setTitle("RegularUser");
		frmRegularuser.setBounds(100, 100, 801, 801);
		frmRegularuser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegularuser.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 785, 754);
		frmRegularuser.getContentPane().add(tabbedPane);
		
		JPanel panelUserClients = new JPanel();
		tabbedPane.addTab("Clients", null, panelUserClients, null);
		panelUserClients.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 48, 667, 376);
		panelUserClients.add(scrollPane);
		
		tableUserClients = new JTable();
		tableUserClients.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name of Client", "Card Number", "CNP", "Adress"
			}
		));
		scrollPane.setViewportView(tableUserClients);
		
		btnUserClientCreate = new JButton("Create");
		btnUserClientCreate.setBounds(52, 459, 120, 25);
		panelUserClients.add(btnUserClientCreate);
		
		btnUserClientListAll = new JButton("ListAll");
		btnUserClientListAll.setBounds(52, 498, 120, 25);
		panelUserClients.add(btnUserClientListAll);
		
		btnUserClientUpdate = new JButton("Update");
		btnUserClientUpdate.setBounds(54, 536, 120, 25);
		panelUserClients.add(btnUserClientUpdate);
		
		btnUserClientDelete = new JButton("Delete");
		btnUserClientDelete.setBounds(54, 574, 120, 25);
		panelUserClients.add(btnUserClientDelete);
		
		btnUserClientFindById = new JButton("FindById");
		btnUserClientFindById.setBounds(54, 612, 120, 25);
		panelUserClients.add(btnUserClientFindById);
		
		textFieldUserClientFindById = new JTextField();
		textFieldUserClientFindById.setColumns(10);
		textFieldUserClientFindById.setBounds(199, 613, 116, 22);
		panelUserClients.add(textFieldUserClientFindById);
		
		lPaneUserClient = new JLayeredPane();
		lPaneUserClient.setBounds(354, 437, 365, 248);
		panelUserClients.add(lPaneUserClient);
		lPaneUserClient.setVisible(false);
		
		
		JLabel lblUserClientId = new JLabel("Id");
		lblUserClientId.setBounds(12, 28, 56, 16);
		lPaneUserClient.add(lblUserClientId);
		
		JLabel lblUserClientName = new JLabel("Name");
		lblUserClientName.setBounds(12, 54, 56, 16);
		lPaneUserClient.add(lblUserClientName);
		
		JLabel lblUserClientCnp = new JLabel("CNP");
		lblUserClientCnp.setBounds(12, 112, 56, 16);
		lPaneUserClient.add(lblUserClientCnp);
		
		JLabel lblUserClientCardNumber = new JLabel("Card Number");
		
		lblUserClientCardNumber.setBounds(12, 83, 97, 16);
		lPaneUserClient.add(lblUserClientCardNumber);
		
		JLabel lblUserClientAdress = new JLabel("Adress");
		lblUserClientAdress.setBounds(12, 141, 56, 16);
		lPaneUserClient.add(lblUserClientAdress);
		
		textFieldUserClientId = new JTextField();
		textFieldUserClientId.setBounds(150, 25, 116, 22);
		lPaneUserClient.add(textFieldUserClientId);
		textFieldUserClientId.setColumns(10);
		
		textFieldUserClientName = new JTextField();
		textFieldUserClientName.setBounds(150, 51, 116, 22);
		lPaneUserClient.add(textFieldUserClientName);
		textFieldUserClientName.setColumns(10);
		
		textFieldUserClientCardNumber = new JTextField();
		textFieldUserClientCardNumber.setBounds(150, 80, 116, 22);
		lPaneUserClient.add(textFieldUserClientCardNumber);
		textFieldUserClientCardNumber.setColumns(10);
		
		textFieldUserClientCnp = new JTextField();
		textFieldUserClientCnp.setBounds(150, 109, 116, 22);
		lPaneUserClient.add(textFieldUserClientCnp);
		textFieldUserClientCnp.setColumns(10);
		
		textFieldUserClientAdress = new JTextField(); 
		textFieldUserClientAdress.setBounds(150, 138, 116, 22);
		lPaneUserClient.add(textFieldUserClientAdress);
		textFieldUserClientAdress.setColumns(10);
		
		btnUserClientOK = new JButton("OK");
		btnUserClientOK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUserClientOK.setBounds(12, 186, 129, 25);
		lPaneUserClient.add(btnUserClientOK);
		btnUserClientOK.setVisible(false);
		
		btnUserClientOK2 = new JButton("OK");
		btnUserClientOK2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUserClientOK2.setBounds(150, 185, 116, 26);
		lPaneUserClient.add(btnUserClientOK2);
		btnUserClientOK2.setVisible(false);
		
		textFieldUserClientDelete = new JTextField();
		textFieldUserClientDelete.setBounds(199, 575, 116, 22);
		panelUserClients.add(textFieldUserClientDelete);
		textFieldUserClientDelete.setColumns(10);
		
		JPanel panelUserAccounts = new JPanel();
		tabbedPane.addTab("Accounts", null, panelUserAccounts, null);
		panelUserAccounts.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(57, 50, 657, 385);
		panelUserAccounts.add(scrollPane_1);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Id Customer", "Account Number", "Type", "Amount", "Date "
			}
		));
		scrollPane_1.setViewportView(table);
		
		btnUserAccountCreate = new JButton("Create");
		btnUserAccountCreate.setBounds(57, 468, 120, 25);
		panelUserAccounts.add(btnUserAccountCreate);
		
		btnUserAccountListAll = new JButton("ListAll");
		btnUserAccountListAll.setBounds(57, 507, 120, 25);
		panelUserAccounts.add(btnUserAccountListAll);
		
		btnUSerAccountUpdate = new JButton("Update");
		btnUSerAccountUpdate.setBounds(59, 545, 120, 25);
		panelUserAccounts.add(btnUSerAccountUpdate);
		
		btnUserAccountDelete = new JButton("Delete");
		btnUserAccountDelete.setBounds(59, 583, 120, 25);
		panelUserAccounts.add(btnUserAccountDelete);
		
		btnUserAccountFindById = new JButton("FindById");
		btnUserAccountFindById.setBounds(59, 621, 120, 25);
		panelUserAccounts.add(btnUserAccountFindById);
		
		textFieldUserAccountFindById = new JTextField();
		textFieldUserAccountFindById.setColumns(10);
		textFieldUserAccountFindById.setBounds(204, 622, 116, 22);
		panelUserAccounts.add(textFieldUserAccountFindById);
		
		lPaneUserAccount = new JLayeredPane();
		lPaneUserAccount.setBounds(361, 448, 352, 250);
		panelUserAccounts.add(lPaneUserAccount);
		lPaneUserAccount.setVisible(false);
		
		JLabel lblUserAccountId = new JLabel("Id");
		lblUserAccountId.setBounds(12, 13, 56, 16);
		lPaneUserAccount.add(lblUserAccountId);
		
		JLabel lblUserAccountIdClient = new JLabel("IdClient");
		lblUserAccountIdClient.setBounds(12, 42, 56, 16);
		lPaneUserAccount.add(lblUserAccountIdClient);
		
		JLabel lblUserAccountType = new JLabel("Type");
		lblUserAccountType.setBounds(12, 77, 56, 16);
		lPaneUserAccount.add(lblUserAccountType);
		
		JLabel lblUserAccountAmount = new JLabel("Amount");
		lblUserAccountAmount.setBounds(12, 106, 56, 16);
		lPaneUserAccount.add(lblUserAccountAmount);
		
		JLabel lblUserAccountDate = new JLabel("Date");
		lblUserAccountDate.setBounds(12, 135, 56, 16);
		lPaneUserAccount.add(lblUserAccountDate);
		
		JLabel lblUserAccountNumber = new JLabel("Account Number");
		lblUserAccountNumber.setBounds(12, 164, 104, 16);
		lPaneUserAccount.add(lblUserAccountNumber);
		
		textFieldUserAccountId = new JTextField();
		textFieldUserAccountId.setBounds(153, 10, 116, 22);
		lPaneUserAccount.add(textFieldUserAccountId);
		textFieldUserAccountId.setColumns(10);
		
		textFieldUserAccountIdClient = new JTextField();
		textFieldUserAccountIdClient.setBounds(153, 39, 116, 22);
		lPaneUserAccount.add(textFieldUserAccountIdClient);
		textFieldUserAccountIdClient.setColumns(10);
		
		textFieldUserAccountType = new JTextField();
		textFieldUserAccountType.setBounds(153, 74, 116, 22);
		lPaneUserAccount.add(textFieldUserAccountType);
		textFieldUserAccountType.setColumns(10);
		
		textFieldUserAccountAmount = new JTextField();
		textFieldUserAccountAmount.setBounds(153, 103, 116, 22);
		lPaneUserAccount.add(textFieldUserAccountAmount);
		textFieldUserAccountAmount.setColumns(10);
		
		textFieldUserAccountDate = new JTextField();
		textFieldUserAccountDate.setBounds(153, 132, 116, 22);
		lPaneUserAccount.add(textFieldUserAccountDate);
		textFieldUserAccountDate.setColumns(10);
		
		textFieldUserAccountNumber = new JTextField();
		textFieldUserAccountNumber.setBounds(153, 161, 116, 22);
		lPaneUserAccount.add(textFieldUserAccountNumber);
		textFieldUserAccountNumber.setColumns(10);
		
		btnUserAccountOK = new JButton("OK");
		btnUserAccountOK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUserAccountOK.setBounds(12, 212, 257, 25);
		lPaneUserAccount.add(btnUserAccountOK);
		btnUserAccountOK.setVisible(false);
		
		btnUserAccountOK2 = new JButton("OK");
		btnUserAccountOK2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUserAccountOK2.setBounds(12, 212, 257, 25);
		lPaneUserAccount.add(btnUserAccountOK2);
		
		textFieldUserAccountDelete = new JTextField();
		textFieldUserAccountDelete.setBounds(204, 584, 116, 22);
		panelUserAccounts.add(textFieldUserAccountDelete);
		textFieldUserAccountDelete.setColumns(10);
		btnUserAccountOK2.setVisible(false);
		
		JPanel panelUserTransfers = new JPanel();
		tabbedPane.addTab("Transfers", null, panelUserTransfers, null);
		panelUserTransfers.setLayout(null);
		
		JLabel lblUserTransferFrom = new JLabel("From Id:");
		lblUserTransferFrom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserTransferFrom.setBounds(39, 93, 100, 35);
		panelUserTransfers.add(lblUserTransferFrom);
		
		JLabel lblUserTransferTo = new JLabel("To Id:");
		lblUserTransferTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserTransferTo.setBounds(39, 141, 100, 35);
		panelUserTransfers.add(lblUserTransferTo);
		
		JLabel lblUserTransferAmount = new JLabel("Amount:");
		lblUserTransferAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserTransferAmount.setBounds(39, 189, 100, 35);
		panelUserTransfers.add(lblUserTransferAmount);
		
		btnUserTransfer = new JButton("Transfer");

		btnUserTransfer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUserTransfer.setBounds(39, 262, 327, 25);
		panelUserTransfers.add(btnUserTransfer);
		
		textFieldUserTransferFrom = new JTextField();
		textFieldUserTransferFrom.setBounds(250, 101, 116, 22);
		panelUserTransfers.add(textFieldUserTransferFrom);
		textFieldUserTransferFrom.setColumns(10);
		
		textFieldUserTransferTo = new JTextField();
		textFieldUserTransferTo.setBounds(250, 149, 116, 22);
		panelUserTransfers.add(textFieldUserTransferTo);
		textFieldUserTransferTo.setColumns(10);
		
		textFieldUserTransferAmount = new JTextField();
		textFieldUserTransferAmount.setBounds(250, 197, 116, 22);
		panelUserTransfers.add(textFieldUserTransferAmount);
		textFieldUserTransferAmount.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(39, 333, 677, 189);
		panelUserTransfers.add(scrollPane_2);
		
		tableUserTransfer = new JTable();
		tableUserTransfer.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Source Account", "Destination Account", "Amount", "Transfer Date"
			}
		));
		scrollPane_2.setViewportView(tableUserTransfer);
		
		btnUserTransferListAll = new JButton("ListAll");
		btnUserTransferListAll.setBounds(39, 575, 120, 25);
		panelUserTransfers.add(btnUserTransferListAll);
		
	    btnUserTransferFindById = new JButton("FindById");
		btnUserTransferFindById.setBounds(39, 613, 120, 25);
		panelUserTransfers.add(btnUserTransferFindById);
		
		textFieldUserTransferFindById = new JTextField();
		textFieldUserTransferFindById.setColumns(10);
		textFieldUserTransferFindById.setBounds(184, 614, 116, 22);
		panelUserTransfers.add(textFieldUserTransferFindById);
		
		JPanel panelUserBills = new JPanel();
		tabbedPane.addTab("Process Bills", null, panelUserBills, null);
		panelUserBills.setLayout(null);
		
		JLabel lblUserBillClient = new JLabel("Client:");
		lblUserBillClient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserBillClient.setBounds(37, 84, 100, 35);
		panelUserBills.add(lblUserBillClient);
		
		JLabel lblUserBill = new JLabel("Bill:");
		lblUserBill.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserBill.setBounds(37, 132, 100, 35);
		panelUserBills.add(lblUserBill);
		
		JLabel lblUserBillAccount = new JLabel("Account:");
		lblUserBillAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserBillAccount.setBounds(37, 180, 100, 35);
		panelUserBills.add(lblUserBillAccount);
		
		btnUserBill = new JButton("Pay Bill");
		btnUserBill.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUserBill.setBounds(37, 271, 327, 25);
		panelUserBills.add(btnUserBill);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(248, 92, 116, 22);
		panelUserBills.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(248, 140, 116, 22);
		panelUserBills.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(248, 188, 116, 22);
		panelUserBills.add(textField_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(37, 342, 703, 170);
		panelUserBills.add(scrollPane_3);
		
		tableBill = new JTable();
		tableBill.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idFactura", "idClient", "comments", "paid", "amountFactura"
			}
		));
		scrollPane_3.setViewportView(tableBill);
		
		btnUsersLogout = new JButton("LOGOUT");
		btnUsersLogout.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tabbedPane.addTab("Logout", null, btnUsersLogout, null);
		
	}
	public void getVisible(){
		lPaneUserClient.setVisible(true);
	}
	public void getInvisible(){
		lPaneUserClient.setVisible(false);
	}
	public void getVisible2(){
		lPaneUserAccount.setVisible(true);
	}
	public void getInvisible2(){
		lPaneUserAccount.setVisible(false);
	}
}
