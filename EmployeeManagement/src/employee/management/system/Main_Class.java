package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Class extends JFrame
{
    Main_Class()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);

        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(340,155,400,40);
        heading.setFont(new Font("Relaway",Font.BOLD,25));
        img.add(heading);

        JButton add=new JButton("Add Employee");
        add.setBounds(335,270,150,40);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        img.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Add();
                setVisible(false);
            }
        });

        JButton view=new JButton("View Employee");
        view.setBounds(565,270,150,40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        img.add(view);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               new ViewEmployee();
               setVisible(false);
            }
        });

        JButton remove=new JButton("Remove Employee");
        remove.setBounds(440,370,150,40);
        remove.setForeground(Color.white);
        remove.setBackground(Color.black);
        img.add(remove);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RemoveEmployee();
                setVisible(false);
            }
        });

        setSize(1120,630);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String args[])
    {
        new Main_Class();
    }
}
