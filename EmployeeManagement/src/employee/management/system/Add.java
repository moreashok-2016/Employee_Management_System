package employee.management.system;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Add extends JFrame implements ActionListener
{
    JDateChooser tdob;
    JComboBox beducation;

    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;
    JLabel tempid;
    Random r=new Random();
    int num=r.nextInt(100);
    JButton add,back;
    Add()
    {
        setLayout(null);
        Container c=getContentPane();
        c.setBackground(new Color(20,227,179));

        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(300,50,500,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        c.add(heading);

        JLabel name=new JLabel("Name:");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("arial",Font.BOLD,20));
        c.add(name);

        tname=new JTextField();
        tname.setBounds(230,150,150,30);
        tname.setFont(new Font("arial",Font.BOLD,20));
        tname.setBackground(new Color(177,252,197));
        c.add(tname);

        JLabel fname=new JLabel("Father Name:");
        fname.setBounds(450,150,150,30);
        fname.setFont(new Font("arial",Font.BOLD,20));
        c.add(fname);

        tfname=new JTextField();
        tfname.setBounds(650,150,150,30);
        tfname.setFont(new Font("arial",Font.BOLD,20));
        tfname.setBackground(new Color(177,252,197));
        c.add(tfname);

        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("arial",Font.BOLD,20));
        c.add(dob);

        tdob=new JDateChooser();
        tdob.setBounds(230,200,150,30);
        tdob.setFont(new Font("arial",Font.BOLD,20));
        tdob.setBackground(new Color(177,252,197));
        c.add(tdob);

        JLabel address=new JLabel("Address:");
        address.setBounds(450,200,150,30);
        address.setFont(new Font("arial",Font.BOLD,20));
        c.add(address);

        taddress=new JTextField();
        taddress.setBounds(650,200,150,30);
        taddress.setFont(new Font("arial",Font.BOLD,20));
        taddress.setBackground(new Color(177,252,197));
        c.add(taddress);


        JLabel phone=new JLabel("Phone No:");
        phone.setBounds(50,250,150,30);
        phone.setFont(new Font("arial",Font.BOLD,20));
        c.add(phone);

        tphone=new JTextField();
        tphone.setBounds(230,250,150,30);
        tphone.setFont(new Font("arial",Font.BOLD,20));
        tphone.setBackground(new Color(177,252,197));
        c.add(tphone);

        JLabel aadhar=new JLabel("Aadhar No:");
        aadhar.setBounds(450,250,150,30);
        aadhar.setFont(new Font("arial",Font.BOLD,20));
        c.add(aadhar);

        taadhar=new JTextField();
        taadhar.setBounds(650,250,150,30);
        taadhar.setFont(new Font("arial",Font.BOLD,20));
        taadhar.setBackground(new Color(177,252,197));
        c.add(taadhar);


        JLabel email=new JLabel("Emai Id:");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("arial",Font.BOLD,20));
        c.add(email);

        temail=new JTextField();
        temail.setBounds(230,300,150,30);
        temail.setFont(new Font("arial",Font.BOLD,20));
        temail.setBackground(new Color(177,252,197));
        c.add(temail);

        JLabel salary=new JLabel("Salary:");
        salary.setBounds(450,300,150,30);
        salary.setFont(new Font("arial",Font.BOLD,20));
        c.add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(650,300,150,30);
        tsalary.setFont(new Font("arial",Font.BOLD,20));
        tsalary.setBackground(new Color(177,252,197));
        c.add(tsalary);

        JLabel designation=new JLabel("Designation:");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("arial",Font.BOLD,20));
        c.add(designation);

        tdesignation=new JTextField();
        tdesignation.setBounds(230,350,150,30);
        tdesignation.setFont(new Font("arial",Font.BOLD,20));
        tdesignation.setBackground(new Color(177,252,197));
        c.add(tdesignation);

        JLabel education=new JLabel("Highest Eduction:");
        education.setBounds(450,350,150,30);
        education.setFont(new Font("arial",Font.BOLD,20));
        c.add(education);

        String items[]={"BCS","BCA","MCS","IT","Computer","MCA","BBA","BA","BSC","MA","MTech","MSC","PHD"};
        beducation =new JComboBox(items);
        beducation.setBounds(650,350,150,30);
        beducation.setFont(new Font("arial",Font.BOLD,15));
        beducation.setBackground(new Color(177,252,197));
        c.add(beducation);

        JLabel empid=new JLabel("Employee ID:");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("arial",Font.BOLD,20));
        c.add(empid);

        tempid=new JLabel(""+num);
        tempid.setBounds(230,400,150,30);
        tempid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        c.add(tempid);

        add=new JButton("ADD");
        add.setBounds(250,500,150,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        c.add(add);

        back=new JButton("BACK");
        back.setBounds(450,500,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        c.add(back);

        add.addActionListener(this);
        back.addActionListener(this);

        setSize(900,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource()==add)
        {
            String name=tname.getText();
            String fname=tfname.getText();
            String dob=((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String salary=tsalary.getText();
            String address=taddress.getText();
            String aadhar=taadhar.getText();
            String phone=tphone.getText();
            String email=temail.getText();
            String education=(String)beducation.getSelectedItem();
            String designation=tdesignation.getText();
            String empid=tempid.getText();

            if(email.contains("@") && email.contains("gmail")&& email.contains(".com") && email!=null)
            {
                int ct1=0, ct2=0;
                if(phone.length() == 10){
                    for(int i=0; i<phone.length(); i++){
                        char ch = phone.charAt(i);
                        if(ch=='0' || ch=='1' || ch=='2' || ch=='3' || ch=='4' || ch=='5' || ch=='6' || ch=='7' || ch=='8' || ch=='9'){
                            ct1++;
                        }else{
                            break;
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Phone No");
                }
                if(aadhar.length() == 12){
                    for(int i=0; i<aadhar.length(); i++){
                        char ch = aadhar.charAt(i);
                        if(ch=='0' || ch=='1' || ch=='2' || ch=='3' || ch=='4' || ch=='5' || ch=='6' || ch=='7' || ch=='8' || ch=='9'){
                            ct2++;
                        }else{
                            break;
                        }
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Aadhar No");
                }
                if(phone.length() == ct1 && aadhar.length()== ct2){
                    try {
                        Class.forName("org.postgresql.Driver");
                        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee", "postgres", "ashoka");
                        Statement st = con.createStatement();
                        st.executeUpdate("insert into employee values('" + name + "','" + fname + "','" + dob + "','" + salary + "','" + address + "','" + phone + "','" + email + "','" + education + "','" + designation + "','" + aadhar + "','" + empid + "')");

                        JOptionPane.showMessageDialog(null, "Details Saved Successfully");
                        new Main_Class();
                        setVisible(false);

                    } catch (Exception e) {
                        System.out.println("Exception:" + e);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Data");
                }
            }else
            {
                JOptionPane.showMessageDialog(null, "Please Enter Valid Email");
            }

        }else
        {
            new Main_Class();
        }
    }

    public static void main(String args[])
    {
        new Add();
    }
}