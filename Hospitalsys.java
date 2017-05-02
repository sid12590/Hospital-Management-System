import javax.swing.JOptionPane;
import java.sql.*;

public class Hospitalsys{
	
	static String userid="system", password = "tiger";
	static String url = "jdbc:odbc:dsn1";	
	static Statement stmt;
	static Connection con;
	public static void main(String args[]){

		JOptionPane.showMessageDialog(null,"WELCOME to JSZ's Hospital DataBase");
		int choice = -1;
		
		do{
			choice = getChoice();
			if (choice != 0){
				getSelected(choice);
			}
		
		}while ( choice != 0);
			System.exit(0);
	}

	public static int getChoice()
	{
		String choice;
		int ch;
		choice = JOptionPane.showInputDialog(null,
			"1. Patient Registration\n"+
			
			"2. Enter Physician Details\n"+
			
            "3. Inpatient Registration\n"+
            
            "4. Enter Department Details\n"+
            
			"5. Enter Employee Details\n"+
			
			"6. Enter Treatment Details\n"+
			
			"7. Discharge Form\n"+
			
			"0. Exit\n\n"+
			
			"Enter your choice");
		ch = Integer.parseInt(choice);
		return ch;

	}

	public static void getSelected(int choice)
	{
		
    	if(choice==1)
    	{
			createPatient();
		}
		if(choice==2)
		{
			createPhysician();
		}
		if(choice==3)
		{
			createInpatient();
		}
		if(choice==4)
		{
			createDepartment();
		}
		if(choice==5)
		{
			createEmployee();
		}
		if(choice==6)
		{
			createTreatment();
		}
		if(choice==7)
		{
			createDischarge();
		}
	}

	public static Connection getConnection()
	{
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	

		} catch(java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}

		try {
			con = DriverManager.getConnection(url, userid, password);

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		return con;
	}
	
	/*CREATE TABLE Patient (
		    
		);*/
	public static void createPatient()
	{
		Connection con = getConnection();
		
		String createString;
		createString = "create table Patient(" +
							"Blood_grp varchar(10), "+
							"Fname varchar(20),"+"Lname varchar(20),"+"Addr varchar(50),"+"age int,"+"sex varchar(1),"+"Patient_no int primary key )";
		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);
			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		JOptionPane.showMessageDialog(null,"Table Created Successfully...");
		/*Patient f1=new Patient();*/
	}
	

	/*CREATE TABLE Inpatient(
		);*/
	
	public static void createInpatient()
	{
		Connection con = getConnection();
		
		String createString;
		createString = "create table Inpatient(" +
							"inid int primary key, " +"foreign key(inid) references Patient(patient_no),"+
							"date_admtd varchar(10), "+
							"date_dschrd varchar(10),"+"phy_admtdby int,"+"foreign key(phy_admtdby) references physician(phyid),"+"room_no int,"+"bed_no int)" ;
		

		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);

			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		/*Inpatient f2=new Inpatient();*/
		JOptionPane.showMessageDialog(null,"Table Created Successfully");
		
	}
	
	/*PHYSICIAN*/
	
	public static void createPhysician()
	{
		Connection con = getConnection();
		
		String createString;
		createString = "create table Physician(" +
							"phyid int primary key," +
							"Fname varchar(10),"+"Lname varchar(10),"+"Addr varchar(50),"+"ph_no int,"+"speciality varchar(20))";
		

		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);

			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		
		JOptionPane.showMessageDialog(null,"Table created successfully");
		/*Physician f3=new Physician();*/
	}
	
		public static void createDischarge()
	{
		Connection con = getConnection();
		
		String createString;
		createString = "create table Discharge(" +
							"rno int primary key, "+"foreign key(rno) references Treatment(trecord),"+
							"Fname varchar(10),"+"Lname varchar(10),"+"charges int,"+"nod int,"+"medicalcharge int)";
		

		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);

			stmt.close();
			con.close();

		} catch(SQLException ex) 
		{
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null,"Table Created Successfully"); 
		/*Discharge f4=new Discharge();*/
		Patient f1=new Patient();
		
	}
	
	
	
	public static void createEmployee()
	{
		Connection con = getConnection();
		
		String createString;
		createString = "create table Employee(" +
							"empid int,"+
							"Fname varchar(10),"+"Lname varchar(10),"+"Addr varchar(50),"+"job_type varchar(20),"+"salary int,"+"deptno int,"+"foreign key(deptno) references department(deptno),"
							+"assngd_patno int,"+"foreign key(assngd_patno) references Inpatient(inid))";
		

		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);

			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null,"Table created Successfully");
		/*Employee f5=new Employee();*/
	}
	
	public static void createDepartment()
	{
		Connection con = getConnection();
		
		String createString;
		createString = "create table Department(" +
							"deptno int primary key, " +
							"dname varchar(20),"+"manager varchar(15))";
		

		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);

			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null,"Table created successfully");
		/*Department f6=new Department();*/
	}
	
	public static void createTreatment()
	{
		Connection con = getConnection();
		
		String createString;
		createString = "create table Treatment(" +
							"trecord int primary key,"+"phytrby int,"+"foreign key(phytrby) references Physician(phyid),"+
							"pat_no int,"+"foreign key(pat_no) references Inpatient(inid),"+"descr varchar(20),"+"cost int,"+"sdate varchar(10),"+"result varchar(10))";
		

		try {
			stmt = con.createStatement();
	   		stmt.executeUpdate(createString);

			stmt.close();
			con.close();

		} catch(SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		JOptionPane.showMessageDialog(null,"Table created successfully ");
		/*Treatment f7=new Treatment();*/
	}
		
}//End of class
