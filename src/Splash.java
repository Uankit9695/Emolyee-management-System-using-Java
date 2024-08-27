import com.sun.deploy.panel.NodeBorder;
import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Splash extends JFrame implements ActionListener {
    Splash(){
        getContentPane().setBackground(Color.GREEN);
        setLayout(null);


        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Front3.jpg"));
        Image i2=i1.getImage().getScaledInstance(1600,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1600,900);
        add(image);

        JButton click=new JButton("CONTINUE");
        click.setBounds(360,685,200,70);
        click.setFont(new Font("Canva sans",Font.PLAIN,30));
        click.setBackground(Color.black);
        click.setForeground(Color.white);
        click.addActionListener(this);
        image.add(click);


        setSize(1600,900);
        setLocation(150,50);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new login();

    }


    public static void main(String[] args) {
        new Splash();
    }
}
