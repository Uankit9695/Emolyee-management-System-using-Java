import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class home extends JFrame implements ActionListener {
    JButton add,update,remove,view;

    home(){
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/home2.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);


        add=new JButton("Add Employee");
        add.setBounds(670,180,150,40);
        add.addActionListener(this);
        image.add(add);

        view=new JButton("View Employee");
        view.setBounds(840,180,150,40);
        view.addActionListener(this);
        image.add(view);

        update=new JButton("Update Employee");
        update.setBounds(670,250,150,40);
        update.addActionListener(this);
        image.add(update);

        remove=new JButton("Remove Employee");
        remove.setBounds(840,250,150,40);
        remove.addActionListener(this);
        image.add(remove);


        setSize(1120,630);
        setLocation(400,150);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
            new addemployee();

        } else if (ae.getSource()==view) {
            setVisible(false);
            new viewEmployee();

        } else if (ae.getSource()==update) {
            setVisible(false);
            new viewEmployee();


        }else {
            setVisible(false);
            new removeEmployee();

        }

    }
    public static void main(String[] args) {
        new home();

    }
}
