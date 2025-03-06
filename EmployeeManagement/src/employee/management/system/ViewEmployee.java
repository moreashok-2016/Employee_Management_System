package employee.management.system;
import net.proteanit.sql.DbUtils;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.*;

public class ViewEmployee extends JFrame
{
    JTable table;
    JButton search1,print,update,back,exit;
    ViewEmployee()
    {
        setLayout(null);
        getContentPane().setBackground(new Color(255,131,122));
        JLabel search=new JLabel("Search by employee id");
        search.setBounds(20,20,150,20);
        add(search);

        Choice ch=new Choice();
        ch.setBounds(180,20,150,20);
        ch.setBackground(Color.white);
        add(ch);
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee","postgres","ashoka");
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery("select * from employee");
            while(rs.next())
            {
                ch.add(rs.getString("empid"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        table=new JTable();
        try
        {
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee","postgres","ashoka");
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            JScrollPane sp=new JScrollPane(table);
            sp.setBounds(0,100,900,600);
            add(sp);

        }catch (Exception e1)
        {
            e1.printStackTrace();
        }

        search1=new JButton("Search");
        search1.setBounds(20,70,80,20);
        add(search1);
        search1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("org.postgresql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee", "postgres", "ashoka");
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select * from employee where empid='"+ch.getSelectedItem()+"'");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e2)
                {
                    e2.printStackTrace();
                }
            }
        });

        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        add(print);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {

                    table.print();
                }catch (Exception e2)
                {
                    e2.printStackTrace();
                }
            }
        });

        update=new JButton("Update");
        update.setBounds(220,70,80,20);
        add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               setVisible(false);
               new UpdateEmployee(ch.getSelectedItem());
            }
        });

        back=new JButton("Back");
        back.setBounds(320,70,80,20);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                new Main_Class();
            }
        });

        exit=new JButton("Exit");
        exit.setBounds(420,70,80,20);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                setVisible(false);
            }
        });



        setSize(900,700);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);

    }
   public static void main(String args[])
   {
       new ViewEmployee();
   }
}
