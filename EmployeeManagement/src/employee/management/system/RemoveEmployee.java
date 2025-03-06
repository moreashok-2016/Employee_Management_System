package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

public class RemoveEmployee extends JFrame
{
    RemoveEmployee()
    {
        setLayout(null);

        JLabel id=new JLabel("Employee Id:");
        id.setBounds(50,50,100,30);
        id.setFont(new Font("Tahoma",Font.BOLD,15));
        add(id);

        Choice ch=new Choice();
        ch.setBounds(200,50,150,30);
        add(ch);

        try
        {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee", "postgres", "ashoka");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from employee");
            while(rs.next())
            {
                ch.add(rs.getString("empid"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel name=new JLabel("Name:");
        name.setBounds(50,100,100,30);
        name.setFont(new Font("Tahoma",Font.BOLD,15));
        add(name);

        JLabel tname=new JLabel();
        tname.setBounds(200,100,100,30);
        tname.setFont(new Font("Tahome",Font.ITALIC,15));
        add(tname);

        JLabel lphone=new JLabel("Phone");
        lphone.setBounds(50,150,100,30);
        lphone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lphone);

        JLabel tphone=new JLabel();
        tphone.setBounds(200,150,150,30);
        tphone.setFont(new Font("Tahoma",Font.ITALIC,15));
        add(tphone);

        JLabel lemail=new JLabel("Email");
        lemail.setBounds(50,200,100,30);
        lemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lemail);

        JLabel temail=new JLabel();
        temail.setBounds(200,200,150,30);
        temail.setFont(new Font("Tahoma",Font.ITALIC,15));
        add(temail);

        try
        {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee", "postgres", "ashoka");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from employee where empid='"+ch.getSelectedItem()+"'");

            while(rs.next())
            {
               tname.setText(rs.getString("name"));
                temail.setText(rs.getString("email"));
                tphone.setText(rs.getString("phone"));
            }
        }catch(Exception e2)
        {
            e2.printStackTrace();
        }

        ch.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e4) {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee", "postgres", "ashoka");
                    Statement st=con.createStatement();
                    ResultSet rs=st.executeQuery("select * from employee where empid='"+ch.getSelectedItem()+"'");

                    while(rs.next())
                    {
                        tname.setText(rs.getString("name"));
                        temail.setText(rs.getString("email"));
                        tphone.setText(rs.getString("phone"));
                    }
                }catch(Exception e5)
                {
                    e5.printStackTrace();
                }

            }
        });

        JButton delete=new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Class.forName("org.postgresql.Driver");
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/employee", "postgres", "ashoka");
                    Statement st=con.createStatement();
                    st.executeUpdate("delete from employee where empid='"+ch.getSelectedItem()+"'");
                            JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully !");
                             setVisible(false);
                             new Main_Class();
                }catch(Exception e6)
                {
                    e6.printStackTrace();
                }

            }
        });


        JButton back=new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main_Class();
            }
        });


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22=i11.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image=new JLabel(i33);
        image.setBounds(700,80,200,200);
        add(image);


        setVisible(true);
        setSize(1000,400);
        setLocationRelativeTo(null);
    }
    public static void main(String args[])

    {
        new RemoveEmployee();
    }
}
