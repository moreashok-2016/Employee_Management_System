package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame
{
    JTextField teducation,taddress,tphone,temail,tsalary,tdesignation;
    UpdateEmployee(String number)
    {
        setLayout(null);
        Container c=getContentPane();
        c.setBackground(new Color(20,227,179));

        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(300,50,500,40);
        heading.setFont(new Font("serif",Font.BOLD,30));
        c.add(heading);

        JLabel name=new JLabel("Name:");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("arial",Font.BOLD,20));
        c.add(name);

        JLabel tname=new JLabel();
        tname.setBounds(230,150,150,30);
        tname.setFont(new Font("arial",Font.BOLD,20));
        tname.setBackground(new Color(177,252,197));
        tname.setForeground(Color.red);
        c.add(tname);

        JLabel fname=new JLabel("Father Name:");
        fname.setBounds(450,150,150,30);
        fname.setFont(new Font("arial",Font.BOLD,20));
        c.add(fname);

        JLabel tfname=new JLabel();
        tfname.setBounds(650,150,150,30);
        tfname.setFont(new Font("arial",Font.BOLD,20));
        tfname.setBackground(new Color(177,252,197));
        tfname.setForeground(Color.red);
        c.add(tfname);


        JLabel dob=new JLabel("Date Of Birth");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("arial",Font.BOLD,20));
        c.add(dob);

        JLabel tdob=new JLabel();
        tdob.setBounds(230,200,150,30);
        tdob.setFont(new Font("arial",Font.BOLD,20));
        tdob.setForeground(Color.red);
        c.add(tdob);

        JLabel aadhar=new JLabel("Aadhar No:");
        aadhar.setBounds(450,200,150,30);
        aadhar.setFont(new Font("arial",Font.BOLD,20));
        c.add(aadhar);

        JLabel taadhar=new JLabel();
        taadhar.setBounds(650,200,150,30);
        taadhar.setFont(new Font("arial",Font.BOLD,20));
        taadhar.setBackground(new Color(177,252,197));
        taadhar.setForeground(Color.red);
        c.add(taadhar);

        JLabel empid=new JLabel("Employee ID:");
        empid.setBounds(50,250,150,30);
        empid.setFont(new Font("arial",Font.BOLD,20));
        c.add(empid);

        JLabel tempid=new JLabel();
        tempid.setBounds(230,250,150,30);
        tempid.setFont(new Font("SAN_SARIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        c.add(tempid);

        JLabel address=new JLabel("Address:");
        address.setBounds(450,250,150,30);
        address.setFont(new Font("arial",Font.BOLD,20));
        c.add(address);

        taddress=new JTextField();
        taddress.setBounds(650,250,150,30);
        taddress.setFont(new Font("arial",Font.ITALIC,18));
        taddress.setBackground(new Color(177,252,197));
        c.add(taddress);

        JLabel email=new JLabel("Emai Id:");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("arial",Font.BOLD,20));
        c.add(email);

        temail=new JTextField();
        temail.setBounds(230,300,150,30);
        temail.setFont(new Font("arial",Font.ITALIC,18));
        temail.setBackground(new Color(177,252,197));
        c.add(temail);

        JLabel salary=new JLabel("Salary:");
        salary.setBounds(450,300,150,30);
        salary.setFont(new Font("arial",Font.BOLD,20));
        c.add(salary);

        tsalary=new JTextField();
        tsalary.setBounds(650,300,150,30);
        tsalary.setFont(new Font("arial",Font.ITALIC,18));
        tsalary.setBackground(new Color(177,252,197));
        c.add(tsalary);

        JLabel designation=new JLabel("Designation:");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("arial",Font.BOLD,20));
        c.add(designation);

        tdesignation=new JTextField();
        tdesignation.setBounds(230,350,150,30);
        tdesignation.setFont(new Font("arial",Font.ITALIC,18));
        tdesignation.setBackground(new Color(177,252,197));
        c.add(tdesignation);

        JLabel education=new JLabel("Highest Eduction:");
        education.setBounds(450,350,150,30);
        education.setFont(new Font("arial",Font.BOLD,20));
        c.add(education);

        teducation=new JTextField();
        teducation.setBounds(650,350,150,30);
        teducation.setFont(new Font("arial",Font.ITALIC,18));
        teducation.setBackground(new Color(177,252,197));
        c.add(teducation);

        JLabel phone=new JLabel("Phone No:");
        phone.setBounds(50,400,150,30);
        phone.setFont(new Font("arial",Font.BOLD,20));
        c.add(phone);

        tphone=new JTextField();
        tphone.setBounds(230,400,150,30);
        tphone.setFont(new Font("arial",Font.ITALIC,18));
        tphone.setBackground(new Color(177,252,197));
        c.add(tphone);

        try
        {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee", "postgres", "ashoka");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from employee where empid='"+number+"'");

            while(rs.next())
            {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                teducation.setText(rs.getString("eduction"));
                taadhar.setText(rs.getString("aadhar"));
                tempid.setText(rs.getString("empid"));
                tdesignation.setText(rs.getString("designation"));
                tsalary.setText(rs.getString("salary"));
            }
        }catch(Exception e3)
        {
            e3.printStackTrace();
        }

        JButton save=new JButton("SAVE");
        save.setBounds(250,500,150,30);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        c.add(save);
        save.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                String email=temail.getText();
                String designation=tdesignation.getText();
                String phone=tphone.getText();
                String address=taddress.getText();
                String salary=tsalary.getText();
                String ducation=teducation.getText();

                if(email.contains("@") && email.contains("gmail")&& email.contains(".com") && email!=null) {
                    try {
                        Class.forName("org.postgresql.Driver");
                        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee", "postgres", "ashoka");
                        Statement st = con.createStatement();
                        String query = "update employee set email='" + email + "',designation='" + designation + "',phone='" + phone + "',address='" + address + "',salary='" + salary + "',eduction='" + ducation + "' where empid='" + number + "'";
                        st.executeUpdate(query);

                        JOptionPane.showMessageDialog(null, "Saved Details");
                        setVisible(false);
                        new ViewEmployee();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }else
                    JOptionPane.showMessageDialog(null, "Please Enter- Valid Email");
            }
        });

        JButton back=new JButton("BACK");
        back.setBounds(450,500,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        c.add(back);
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                 setVisible(false);
                 new ViewEmployee();
            }
        });

        setSize(900,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new UpdateEmployee("");
    }
}
