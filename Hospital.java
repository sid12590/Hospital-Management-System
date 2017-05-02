import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Hospital{
static String userid="system", password = "tiger";
static String url = "jdbc:odbc:dsn1";
static Statement stmt;
static Connection con;
public static  void main(String args[])
{

JOptionPane.showMessageDialog(null,"Jsz's Hospital");
int choice = -1;



choice = getChoice();
if (choice != 0){
getSelected(choice);
}
while ( choice !=  0);
System.exit(0);

}

public static int getChoice()
{
String choice;
int ch;
choice = JOptionPane.showInputDialog(null,
"1. Patient Registration\n"+
"2. Inpatient Registration\n"+
"3. Discharge Form\n"+
"4. Creation\n"+
"0. Exit\n\n"+
"Enter your choice");
ch = Integer.parseInt(choice);
return ch;
}

public static void getSelected(int ch){
	switch(ch){
case 1:Patient p1=new Patient();
       break;
case 2:Inpatient s2=new Inpatient();
       break;
case 3:Discharge s3=new Discharge();
       break;
case 4:Hospitalsys s4=new Hospitalsys();
       break;

default:System.err.println("SQLException: " );
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
con = DriverManager.getConnection(url,
userid, password);

} catch(SQLException ex) {
System.err.println("SQLException: " + ex.getMessage());
}

return con;
}


}
