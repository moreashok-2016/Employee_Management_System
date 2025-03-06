package employee.management.system;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
    JTextField tusername;
    JPasswordField tpassword;
    JButton login,back;

    Login()
    {
        JLabel username=new JLabel("UserName:");
        username.setBounds(40,20,100,30);
        add(username);

        tusername=new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password=new JLabel("Password:");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword=new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        login=new JButton("Login");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        add(login);

        back=new JButton("Back");
        back.setBounds(150,190,150,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);

        login.addActionListener(this);
        back.addActionListener(this);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i22=i11.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel imgg=new JLabel(i33);
        imgg.setBounds(150,-80,600,400);
        add(imgg);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,600,300);
        add(img);

        setLayout(null);
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==back)
        {
            System.exit(90);

        } else if(e.getSource()==login)
        {
            String username=tusername.getText();
            String password=tpassword.getText();
            try {
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:1234/emp", "postgres", "ashoka");
                Statement st=con.createStatement();
                ResultSet rs=st.executeQuery("select * from login where username='"+username+"' and password='"+password+"'");

                if(rs.next())
                {
                    setVisible(false);
                    new Main_Class();
                }else
                    JOptionPane.showMessageDialog(this,"Invalid UserName or Password");
            }catch(Exception e1)
            {
                e1.printStackTrace();
            }
        }

    }

    public static void main(String[] args)
    {
        new Login();
    }
}
