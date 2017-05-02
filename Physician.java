import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;

public class Physician extends Applet implements ActionListener{

static String userid="system", password = "tiger";
static String url = "jdbc:odbc:dsn1";
static Statement stmt;
static Connection con;

static JFrame frame2;
String ward2;
String days2;
String fname2;
String lname2;


String other2;
static JPanel panel1;
static JPanel panel2;
static JPanel panel3;
static JPanel panel4;
static JLabel spec_Lb;
static JPanel panelimg;

JButton submitBtn;
JButton exitBtn;
JButton nextBtn;
int dialogtype = JOptionPane.PLAIN_MESSAGE;
String dialogmessage;
String dialogs;
JLabel name2Lbl;
JLabel tname2Lbl;
JLabel fname2Lbl;
JLabel lname2Lbl;
JLabel ward2Lbl;
JLabel days2Lbl;

JLabel panelspec;
JLabel other2Lbl;
JLabel nameLbimg;

static JTextField fname2Txt;
static JTextField lname2Txt;

static JTextField ward2Txt;
static JTextField days2Txt;
static JTextField other2Txt;
static JTextField user2Txt_spec;
String spec;
static JComboBox speciality;

public Physician()
{


panel1 = new JPanel();
panel1.setLayout(new FlowLayout());
name2Lbl = new JLabel("Physician Form");

panel2 = new JPanel();

panel2.setLayout(new FlowLayout());
tname2Lbl = new JLabel("");
panel3=new JPanel();
panel3.setLayout(new GridLayout(7,2));
fname2Lbl=new JLabel("Physician ID  :");
fname2Txt=new JTextField(10);

lname2Lbl = new JLabel("First name :");
lname2Txt = new JTextField(10);

ward2Lbl = new JLabel("Last Name :");

ward2Txt = new JTextField(10);


days2Lbl=new JLabel("Address :");
days2Txt=new JTextField(10);

other2Lbl=new JLabel("Phone No. :");
other2Txt=new JTextField(10);

/*rcptLbl=new JLabel("Blood Group  :");
rcptTxt=new JTextField(10);*/

panelspec=new JLabel();
		panelspec.setLayout(new FlowLayout(FlowLayout.LEFT));
		spec_Lb=new JLabel("Speciality In *                                                      ");
		speciality=new JComboBox();
		speciality.setBackground(Color.WHITE);
		speciality.addItem(" Select ");
		speciality.addItem("Cardiologist");
		speciality.addItem("Psychiatrist");
		speciality.addItem("Surgeon");
		speciality.addItem("Neurologist");
		panelspec.add(spec_Lb);
		panelspec.add(speciality);
		panelspec.setOpaque(false);


panel4=new JPanel();
panel4.setLayout(new FlowLayout());
panelimg=new JPanel();
	panelimg.setLayout(new FlowLayout());
	nameLbimg=new JLabel("",new ImageIcon("physician.jpg"),JLabel.CENTER);



submitBtn = new JButton("Submit");

submitBtn.addActionListener(this);
exitBtn = new JButton("Exit");

exitBtn.addActionListener(this);
nextBtn = new JButton("Next");

nextBtn.addActionListener(this);

panel1.add(name2Lbl);
panel1.setOpaque(true);
panel2.add(tname2Lbl);
panel2.setOpaque(true);
panelimg.add(nameLbimg);
panel3.add(fname2Lbl);
panel3.add(fname2Txt);


panel3.add(lname2Lbl);
panel3.add(lname2Txt);
panel3.add(ward2Lbl);
panel3.add(ward2Txt);
panel3.add(days2Lbl);
panel3.add(days2Txt);
panel3.add(other2Lbl);
panel3.add(other2Txt);

panel3.add(panelspec);
panel3.setOpaque(true);
panel4.add(submitBtn);
panel4.add(exitBtn);
panel4.add(nextBtn);
panel4.setOpaque(true);


frame2 = new JFrame(" Physician Form");
frame2.setSize(750,750);
Container pane = frame2.getContentPane();
pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

pane.add(panel1);
pane.add(panelimg);
pane.add(panel2);
pane.add(panel3);
pane.add(panel4);
frame2.setVisible(true);

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
frame2.setVisible(false);
Inpatient f3=new Inpatient();
}
}





public void submit()
{
Connection con = getConnection();


String insertString1;

spec=(String)speciality.getSelectedItem();
insertString1 = "insert into physician values('"+fname2Txt.getText().trim()+"','"+ lname2Txt.getText().trim()+ "','" + ward2Txt.getText().trim()+"','"+days2Txt.getText().trim()+"','"+other2Txt.getText().trim()+"','"+spec+"')";


try {
stmt = con.createStatement();
stmt.executeUpdate(insertString1);
JOptionPane.showMessageDialog(null,"Physician Assigned in hospital successfully");
JOptionPane.showMessageDialog(null,"Does Patient Needs to be admitted...If Yes then please click next or cancel it if it's No");
stmt.close();
con.close();

} catch(SQLException ex) {
System.err.println("SQLException: " + ex.getMessage());
JOptionPane.showMessageDialog(null,"INVALID INPUT");
}


}

public static void main(String[] args)
{


Physician frame1 = new Physician();




}



}

