package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import net.proteanit.sql.DbUtils;

import java.awt.Component;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Administrator {

	protected JFrame frameAdministrator;
	protected JTabbedPane tabbedPaneAdmin;
	protected JTable tableAdminEmployee;
	protected JTextField textFieldAdminFindById;
	protected JTextField textFieldAdminEmployeeCreateId;
	protected JTextField textFieldAdminEmployeeCreateName;
	protected JTextField textFieldAdminEmployeeCreateUsername;
	protected JTextField textFieldAdminEmployeeCreatePassword;
	protected JTextField textFieldAdminEmployeeUpdateId;
	protected JTextField textFieldAdminEmployeeUpdateName;
	protected JTextField textFieldAdminEmployeeUpdateUsername;
	protected JTextField textFieldAdminEmployeeUpdatePassword;
	protected JTextField textFieldAdminDelete;
	protected JTextField textFieldAdminReportStart;
	protected JTextField textFieldAdminReportEnd;
	protected JTable tableAdminReport;
	protected JButton btnAdminCreateEmpl;
	protected JLayeredPane lPaneAdminEmployeeCreate;
	protected JButton btnAdminListAllEmpl;
	protected JButton btnAdminUpdateEmpl;
	protected JButton btnAdminDeleteEmpl;
	protected JButton btnAdminFindByIdEmpl;
	protected JButton btnAdminEmployeeCreate2;
	protected JLayeredPane lPaneAdminEmployeeUpdate;
	protected JButton btnAdminEmployeeUpdate2;
	protected JButton btnAdminLogout;
	JComboBox comboBoxCreate;

	/**
	 * Create the application.
	 */
	public Administrator() {
		initialize();
//		frameAdministrator.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {

		frameAdministrator = new JFrame();
		frameAdministrator.setTitle("Administrator");
		frameAdministrator.setBounds(100, 100, 775, 775);
		frameAdministrator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAdministrator.getContentPane().setLayout(null);
		
		tabbedPaneAdmin = new JTabbedPane(JTabbedPane.TOP);
		tabbedPaneAdmin.setBounds(0, 0, 775, 775);
		frameAdministrator.getContentPane().add(tabbedPaneAdmin);
		
		JPanel panelAdminEmployee = new JPanel();
		tabbedPaneAdmin.addTab("Employee", null, panelAdminEmployee, null);
		panelAdminEmployee.setLayout(null);
		
		JScrollPane scrollPaneAdminEmployee = new JScrollPane();
		scrollPaneAdminEmployee.setBounds(43, 48, 662, 307);
		panelAdminEmployee.add(scrollPaneAdminEmployee);
		
		tableAdminEmployee = new JTable();
		scrollPaneAdminEmployee.setViewportView(tableAdminEmployee);
		
		
//
		btnAdminCreateEmpl = new JButton("Create");
		btnAdminCreateEmpl.setBounds(43, 392, 120, 25);
		panelAdminEmployee.add(btnAdminCreateEmpl);
		
		btnAdminListAllEmpl = new JButton("ListAll");
		btnAdminListAllEmpl.setBounds(43, 431, 120, 25);
		panelAdminEmployee.add(btnAdminListAllEmpl);
		
		btnAdminUpdateEmpl = new JButton("Update");
		btnAdminUpdateEmpl.setBounds(45, 469, 120, 25);
		panelAdminEmployee.add(btnAdminUpdateEmpl);
		
		btnAdminDeleteEmpl = new JButton("Delete");
		btnAdminDeleteEmpl.setBounds(45, 507, 120, 25);
		panelAdminEmployee.add(btnAdminDeleteEmpl);
		
		btnAdminFindByIdEmpl = new JButton("FindById");
		btnAdminFindByIdEmpl.setBounds(45, 545, 120, 25);
		panelAdminEmployee.add(btnAdminFindByIdEmpl);
		
		textFieldAdminFindById = new JTextField();
		textFieldAdminFindById.setBounds(190, 546, 116, 22);
		panelAdminEmployee.add(textFieldAdminFindById);
		textFieldAdminFindById.setColumns(10);
		
//
		lPaneAdminEmployeeCreate = new JLayeredPane();
		lPaneAdminEmployeeCreate.setBounds(355, 368, 350, 275);
		panelAdminEmployee.add(lPaneAdminEmployeeCreate);
		lPaneAdminEmployeeCreate.setVisible(false);
		JLabel lblAdminEmployeeCreateId = new JLabel("Id");
		lblAdminEmployeeCreateId.setBounds(12, 30, 101, 21);
		lPaneAdminEmployeeCreate.add(lblAdminEmployeeCreateId);
		
		JLabel lblAdminEmployeeCreateName = new JLabel("Name");
		lblAdminEmployeeCreateName.setBounds(12, 64, 86, 16);
		lPaneAdminEmployeeCreate.add(lblAdminEmployeeCreateName);
		
		JLabel lblAdminEmployeeCreateFunction = new JLabel("Admin");
		lblAdminEmployeeCreateFunction.setBounds(12, 93, 101, 16);
		lPaneAdminEmployeeCreate.add(lblAdminEmployeeCreateFunction);
		
		JLabel lblAdminEmployeeCreateUsername = new JLabel("Username");
		lblAdminEmployeeCreateUsername.setBounds(12, 121, 86, 16);
		lPaneAdminEmployeeCreate.add(lblAdminEmployeeCreateUsername);
		
		JLabel lblAdminEmployeeCreatePassword = new JLabel("Password");
		lblAdminEmployeeCreatePassword.setBounds(12, 150, 101, 16);
		lPaneAdminEmployeeCreate.add(lblAdminEmployeeCreatePassword);
		
		textFieldAdminEmployeeCreateId = new JTextField();
		textFieldAdminEmployeeCreateId.setBounds(150, 29, 116, 22);
		lPaneAdminEmployeeCreate.add(textFieldAdminEmployeeCreateId);
		textFieldAdminEmployeeCreateId.setColumns(10);
		
		textFieldAdminEmployeeCreateName = new JTextField();
		textFieldAdminEmployeeCreateName.setBounds(150, 61, 116, 22);
		lPaneAdminEmployeeCreate.add(textFieldAdminEmployeeCreateName);
		textFieldAdminEmployeeCreateName.setColumns(10);
		
		textFieldAdminEmployeeCreateUsername = new JTextField();
		textFieldAdminEmployeeCreateUsername.setBounds(150, 118, 116, 22);
		lPaneAdminEmployeeCreate.add(textFieldAdminEmployeeCreateUsername);
		textFieldAdminEmployeeCreateUsername.setColumns(10);
		
		textFieldAdminEmployeeCreatePassword = new JTextField();
		textFieldAdminEmployeeCreatePassword.setBounds(150, 147, 116, 22);
		lPaneAdminEmployeeCreate.add(textFieldAdminEmployeeCreatePassword);
		textFieldAdminEmployeeCreatePassword.setColumns(10);
		
//
		btnAdminEmployeeCreate2 = new JButton("Create");
		btnAdminEmployeeCreate2.setBounds(12, 194, 254, 25);
		lPaneAdminEmployeeCreate.add(btnAdminEmployeeCreate2);
		
		comboBoxCreate = new JComboBox();
		comboBoxCreate.setModel(new DefaultComboBoxModel(new String[] {"true", "false"}));
		comboBoxCreate.setBounds(150, 90, 116, 22);
		lPaneAdminEmployeeCreate.add(comboBoxCreate);
//
		
		lPaneAdminEmployeeUpdate = new JLayeredPane();
		lPaneAdminEmployeeUpdate.setBounds(355, 367, 350, 276);
		panelAdminEmployee.add(lPaneAdminEmployeeUpdate);
		lPaneAdminEmployeeUpdate.setVisible(false);
		
		JLabel lblAdminEmployeeUpdateId = new JLabel("Id");
		lblAdminEmployeeUpdateId.setBounds(12, 30, 101, 21);
		lPaneAdminEmployeeUpdate.add(lblAdminEmployeeUpdateId);
		
		JLabel lblAdminEmployeeUpdateName = new JLabel("Name");
		lblAdminEmployeeUpdateName.setBounds(12, 64, 86, 16);
		lPaneAdminEmployeeUpdate.add(lblAdminEmployeeUpdateName);
		
		JLabel lblAdminEmployeeUpdateAdmin = new JLabel("Admin");
		lblAdminEmployeeUpdateAdmin.setBounds(12, 93, 101, 16);
		lPaneAdminEmployeeUpdate.add(lblAdminEmployeeUpdateAdmin);
		
		JLabel lblAdminEmployeeUpdateUsername = new JLabel("Username");
		lblAdminEmployeeUpdateUsername.setBounds(12, 121, 86, 16);
		lPaneAdminEmployeeUpdate.add(lblAdminEmployeeUpdateUsername);
		
		JLabel lblAdminEmployeeUpdatePassword = new JLabel("Password");
		lblAdminEmployeeUpdatePassword.setBounds(12, 150, 101, 16);
		lPaneAdminEmployeeUpdate.add(lblAdminEmployeeUpdatePassword);
		
		textFieldAdminEmployeeUpdateId = new JTextField();
		textFieldAdminEmployeeUpdateId.setBounds(150, 29, 116, 22);
		lPaneAdminEmployeeUpdate.add(textFieldAdminEmployeeUpdateId);
		textFieldAdminEmployeeUpdateId.setColumns(10);
		
		textFieldAdminEmployeeUpdateName = new JTextField();
		textFieldAdminEmployeeUpdateName.setBounds(150, 61, 116, 22);
		lPaneAdminEmployeeUpdate.add(textFieldAdminEmployeeUpdateName);
		textFieldAdminEmployeeUpdateName.setColumns(10);
		
		textFieldAdminEmployeeUpdateUsername = new JTextField();
		textFieldAdminEmployeeUpdateUsername.setBounds(150, 118, 116, 22);
		lPaneAdminEmployeeUpdate.add(textFieldAdminEmployeeUpdateUsername);
		textFieldAdminEmployeeUpdateUsername.setColumns(10);
		
		textFieldAdminEmployeeUpdatePassword = new JTextField();
		textFieldAdminEmployeeUpdatePassword.setBounds(150, 147, 116, 22);
		lPaneAdminEmployeeUpdate.add(textFieldAdminEmployeeUpdatePassword);
		textFieldAdminEmployeeUpdatePassword.setColumns(10);
		
	    btnAdminEmployeeUpdate2 = new JButton("Update");
		btnAdminEmployeeUpdate2.setBounds(12, 194, 254, 25);
		lPaneAdminEmployeeUpdate.add(btnAdminEmployeeUpdate2);
		
		JComboBox comboBoxUpdate = new JComboBox();
		comboBoxUpdate.setModel(new DefaultComboBoxModel(new String[] {"Admin\t", "Regular User"}));
		comboBoxUpdate.setBounds(0, 0, 116, 22);
		lPaneAdminEmployeeUpdate.add(comboBoxUpdate);
		
		textFieldAdminDelete = new JTextField();
		textFieldAdminDelete.setBounds(190, 508, 116, 22);
		panelAdminEmployee.add(textFieldAdminDelete);
		textFieldAdminDelete.setColumns(10);
		
		JPanel panelAdminReport = new JPanel();
		tabbedPaneAdmin.addTab("Report", null, panelAdminReport, null);
		panelAdminReport.setLayout(null);
		
		JLabel lblAdminReportStart = new JLabel("Start date:");
		lblAdminReportStart.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdminReportStart.setBounds(41, 59, 182, 32);
		panelAdminReport.add(lblAdminReportStart);
		
		JLabel lblAdminReportEnd = new JLabel("End date:");
		lblAdminReportEnd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAdminReportEnd.setBounds(41, 111, 182, 32);
		panelAdminReport.add(lblAdminReportEnd);
		
		textFieldAdminReportStart = new JTextField();
		textFieldAdminReportStart.setBounds(235, 61, 146, 32);
		panelAdminReport.add(textFieldAdminReportStart);
		textFieldAdminReportStart.setColumns(10);
		
		textFieldAdminReportEnd = new JTextField();
		textFieldAdminReportEnd.setColumns(10);
		textFieldAdminReportEnd.setBounds(235, 111, 146, 32);
		panelAdminReport.add(textFieldAdminReportEnd);
		
		JButton btnAdminReportGenerate = new JButton("Generate");
		btnAdminReportGenerate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdminReportGenerate.setBounds(41, 169, 340, 25);
		panelAdminReport.add(btnAdminReportGenerate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 269, 340, 338);
		panelAdminReport.add(scrollPane);
		
		tableAdminReport = new JTable();
		tableAdminReport.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Action", "Date", "IdUser"
			}
		));
		tableAdminReport.getColumnModel().getColumn(0).setPreferredWidth(25);
		tableAdminReport.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableAdminReport.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableAdminReport.getColumnModel().getColumn(3).setPreferredWidth(50);
		scrollPane.setViewportView(tableAdminReport);
		
		JButton btnAdminReportView = new JButton("View");
		btnAdminReportView.setBounds(41, 212, 340, 25);
		panelAdminReport.add(btnAdminReportView);
		
		btnAdminLogout = new JButton("LOGOUT");
		btnAdminLogout.setFont(new Font("Tahoma", Font.PLAIN, 18));

		tabbedPaneAdmin.addTab("Logout", null, btnAdminLogout, null);
		frameAdministrator.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frameAdministrator.getContentPane()}));

	}
	public void getVisible(){
		lPaneAdminEmployeeCreate.setVisible(true);
	}
	public void getInvisible(){
		lPaneAdminEmployeeCreate.setVisible(false);
	}
	public void getVisible2(){
		lPaneAdminEmployeeUpdate.setVisible(true);
	}
	public void getInvisible2(){
		lPaneAdminEmployeeUpdate.setVisible(false);
	}
}
