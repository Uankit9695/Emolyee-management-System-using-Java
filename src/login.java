import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements  ActionListener {

    JTextField tfusername,tfpasswerd;
    login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel searchlbl = new JLabel("Admin Login");
        searchlbl.setBounds(180,20,350,50);
        searchlbl.setFont(new Font("serif",Font.BOLD,40));
        add(searchlbl);

        JLabel username=new JLabel("Username");
        username. setBounds(70,90,100,30);
        username.setFont(new Font("serif",Font.PLAIN,20));
        add(username);

        tfusername=new JTextField();
        tfusername.setBounds(180,90,200,30);
        add(tfusername);

        JLabel password=new JLabel("Password");
        password. setBounds(70,150,100,30);
        password.setFont(new Font("serif",Font.PLAIN,20));
        add(password);

        tfpasswerd=new JTextField();
        tfpasswerd.setBounds(180,150,200,30);
        add(tfpasswerd);

        JButton Login=new JButton("LOGIN");
        Login.setBounds(180,230,200,40);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(250,250, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,0,250,250);
        add(image);


        setVisible(true);
        setSize(700,400);
        setLocation(650,200);

    }
    public void actionPerformed(ActionEvent ae){
        try{
            String username=tfusername.getText();
            String passwerd=tfpasswerd.getText();

            conn c= new conn();
            String query="select *from login where username= '"+username+"' and password ='"+passwerd+"'";
            ResultSet rs=c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new home();
            }
            else {
                JOptionPane.showMessageDialog(null,"Invalid username or password");
                setVisible(false);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new login();
    }
}
