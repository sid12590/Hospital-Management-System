import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;

public class Employee extends Applet implements ActionListener{

static String userid="system", password = "tiger";
static String url = "jdbc:odbc:dsn1";
static Statement stmt;
static Connection con;

static JFrame frame;
String ward;
String days;
String fname;
String lname;
String rcpt;
String other;
String asp;
String dno;
static JPanel panel1;
static JPanel panel2;
static JPanel panel3;
static JPanel panel4;
static JPanel panelimg;
JButton submitBtn;
JButton exitBtn;
JButton nextBtn;
int dialogtype = JOptionPane.PLAIN_MESSAGE;
String dialogmessage;
String dialogs;
JLabel nameLbl;
JLabel tnameLbl;
JLabel fnameLbl;
JLabel lnameLbl;
JLabel wardLbl;
JLabel daysLbl;
JLabel rcptLbl;
JLabel otherLbl;
JLabel dnoLbl;
JLabel aspLb1;
JLabel nameLbimg;
static JTextField fnameTxt;
static JTextField lnameTxt;
static JTextField wardTxt;
static JTextField daysTxt;
static JTextField rcptTxt;
static JTextField otherTxt;
static JTextField dnoTxt;
static JTextField aspTxt;
public Employee()
{


panel1 = new JPanel();
panel1.setLayout(new FlowLayout());
nameLbl = new JLabel("Employee Form");

panel2 = new JPanel();

panel2.setLayout(new FlowLayout());
tnameLbl = new JLabel("");
panel3=new JPanel();
panel3.setLayout(new GridLayout(8,2));

fnameLbl=new JLabel("Employee id  :");
fnameTxt=new JTextField(10);
lnameLbl = new JLabel("First name :");
lnameTxt = new JTextField(10);
wardLbl = new JLabel("Last name :");
wardTxt = new JTextField(10);
daysLbl=new JLabel("Address :");
daysTxt=new JTextField(10);
otherLbl=new JLabel("Job type :");
otherTxt=new JTextField(10);
rcptLbl=new JLabel("Salary :");
rcptTxt=new JTextField(10);
dnoLbl=new JLabel("Department No. :");
dnoTxt=new JTextField(10);
aspLb1=new JLabel("Assigned to Inpatient no. :");
aspTxt=new JTextField(10);
panel4=new JPanel();
panel4.setLayout(new FlowLayout());

panelimg=new JPanel();
	panelimg.setLayout(new FlowLayout());
	nameLbimg=new JLabel("",new ImageIcon("employee.jpg"),JLabel.CENTER);


submitBtn = new JButton("Submit");

submitBtn.addActionListener(this);
exitBtn = new JButton("Exit");

exitBtn.addActionListener(this);
nextBtn = new JButton("Next");

nextBtn.addActionListener(this);
panel1.add(nameLbl);
panel1.setOpaque(true);
panel2.add(tnameLbl);
panel2.setOpaque(true);
panelimg.add(nameLbimg);
panel3.add(fnameLbl);
panel3.add(fnameTxt);
panel3.add(lnameLbl);
panel3.add(lnameTxt);
panel3.add(wardLbl);
panel3.add(wardTxt);
panel3.add(daysLbl);
panel3.add(daysTxt);
panel3.add(otherLbl);
panel3.add(otherTxt);
panel3.add(rcptLbl);
panel3.add(rcptTxt);
panel3.add(dnoLbl);
panel3.add(dnoTxt);
panel3.add(aspLb1);
panel3.add(aspTxt);

panel3.setOpaque(true);
panel4.add(submitBtn);
panel4.add(exitBtn);
panel4.add(nextBtn);
panel4.setOpaque(true);

frame = new JFrame(" Employee Form");
frame.setSize(900,750);
Container pane = frame.getContentPane();
pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

pane.add(panel1);
pane.add(panelimg);
pane.add(panel2);
pane.add(panel3);
pane.add(panel4);
frame.setVisible(true);

}



public static Connection getConnection()
{

try {
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	//Class.forName("myDriver.ClassName"); ?

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


public void actionPerformed(ActionEvent event)
{
Object source = event.getSource();
if(source.equals(submitBtn))
{
submit();

}
else if(source.equals(exitBtn))
{
System.exit(0);
}
if(source.equals(nextBtn))
{
frame.setVisible(false);
JOptionPane.showMessageDialog(null,"Now Start the treatment of the Admitted Patient");

Treatment m1=new Treatment();

}

}




public void submit()
{
Connection con = getConnection();


String insertString1;

insertString1 = "insert into Employee values('"+fnameTxt.getText().trim()+"','"+ lnameTxt.getText().trim()+ "','" + wardTxt.getText().trim()+"','"+daysTxt.getText().trim()+"','"
+otherTxt.getText().trim()+"','"+rcptTxt.getText().trim()+"','"+dnoTxt.getText().trim()+"','"+aspTxt.getText().trim()+"')";


try {
stmt = con.createStatement();
stmt.executeUpdate(insertString1);
JOptionPane.showMessageDialog(null,"Employee Assigned to Department Successfully");
stmt.close();
con.close();

} catch(SQLException ex) {
System.err.println("SQLException: " + ex.getMessage());
JOptionPane.showMessageDialog(null,"INVALID INPUT");
}



}

public static void main(String[] args)
{


Employee frame1 = new Employee();



}



}

