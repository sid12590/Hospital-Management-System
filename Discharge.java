import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.*;

public class Discharge extends Applet implements ActionListener{

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
static JPanel panel1;
static JPanel panel2;
static JPanel panel3;
static JPanel panel4;


JButton submitBtn;
JButton exitBtn;
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
static JTextField fnameTxt;
static JTextField lnameTxt;
static JTextField wardTxt;
static JTextField daysTxt;
static JTextField rcptTxt;
static JTextField otherTxt;

public Discharge()
{


panel1 = new JPanel();
panel1.setLayout(new FlowLayout());
nameLbl = new JLabel("Discharge form");

panel2 = new JPanel();

panel2.setLayout(new FlowLayout());
tnameLbl = new JLabel("Ward Charges = Rs.1000/day");
panel3=new JPanel();
panel3.setLayout(new GridLayout(6,2));
fnameLbl=new JLabel("first name  :");
fnameTxt=new JTextField(10);
lnameLbl = new JLabel("Last name :");
lnameTxt = new JTextField(10);

wardLbl = new JLabel("treatment charges :");

wardTxt = new JTextField(10);


daysLbl=new JLabel("No of days :");
daysTxt=new JTextField(10);

otherLbl=new JLabel("Medical charges :");
otherTxt=new JTextField(10);

rcptLbl=new JLabel("receipt no  :");
rcptTxt=new JTextField(10);


panel4=new JPanel();
panel4.setLayout(new FlowLayout());


submitBtn = new JButton("Submit");

submitBtn.addActionListener(this);
exitBtn = new JButton("Exit");

exitBtn.addActionListener(this);
panel1.add(nameLbl);
panel1.setOpaque(true);
panel2.add(tnameLbl);
panel2.setOpaque(true);
panel3.add(rcptLbl);
panel3.add(rcptTxt);
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

panel3.setOpaque(true);
panel4.add(submitBtn);
panel4.add(exitBtn);
panel4.setOpaque(true);
frame = new JFrame(" DISCHARGE FORM");
frame.setSize(500,500);
Container pane = frame.getContentPane();
pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

pane.add(panel1);
pane.add(panel2);
pane.add(panel3);
pane.add(panel4);
frame.setVisible(true);

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
}




public void submit()
{
Connection con = getConnection();


String insertString1;
int total,a,b,c;                                                                                                  
insertString1 = "insert into discharge values('"+rcptTxt.getText().trim()+"','"+ fnameTxt.getText().trim()+ " ','" + lnameTxt.getText().trim()+"','"+wardTxt.getText().trim()+"','"+daysTxt.getText().trim()+"','"+otherTxt.getText().trim()+"')";


try {
stmt = con.createStatement();

stmt.executeUpdate(insertString1);
stmt.close();
con.close();

} catch(SQLException ex) {
System.err.println("SQLException: " + ex.getMessage());
}


a = Integer.valueOf(wardTxt.getText().trim()).intValue();
b = Integer.valueOf(otherTxt.getText().trim()).intValue();
c = Integer.valueOf(daysTxt.getText().trim()).intValue();
total=a+b+(c*1000);


JOptionPane.showMessageDialog(null,"AMOUNT TO BE PAID :"+total);
JOptionPane.showMessageDialog(null,"THANK YOU FOR USING JSZ HOSPITAL FACILITIES....MAY YOUR HEALTH FROM NOW ON IS CHERISHED BY OUR CARE ONLY");
}

public static void main(String[] args)
{


Discharge frame1 = new Discharge();



}



}

