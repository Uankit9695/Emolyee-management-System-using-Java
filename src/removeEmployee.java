import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class removeEmployee extends JFrame implements ActionListener {

    Choice cEmpid;
    JButton delete, back;
    removeEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelempid=new JLabel("Employee id");
        labelempid.setBounds(50,100,100,30);
        add(labelempid);

        cEmpid = new Choice();
        cEmpid.setBounds(200,100,150,30);
        add(cEmpid);

        try {

            conn c= new conn();
            String query ="select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                cEmpid.add(rs.getString("empid"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,100,30);
        add(labelname);

        JLabel lblname=new JLabel();
        lblname.setBounds(200,150,100,30);
        add(lblname);

        JLabel labelphone=new JLabel("Phone");
        labelphone.setBounds(50,200,100,30);
        add(labelphone);

        JLabel lblphone=new JLabel();
        lblphone.setBounds(200,200,100,30);
        add(lblphone);

        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,250,100,30);
        add(labelemail);

        JLabel lblemail=new JLabel();
        lblemail.setBounds(200,250,100,30);
        add(lblemail);

        try {

            conn c= new conn();
            String query ="select * from employee where empid ='"+cEmpid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("emain"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        cEmpid.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                try {

                    conn c= new conn();
                    String query ="select * from employee where empid ='"+cEmpid.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()){
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("emain"));
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,0,700,500);
        add(image);




        setSize(1100,600);
        setLocation(300,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                conn c= new conn();
                String query = "delete from employee where empid = '"+cEmpid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information deleted Successfully!");
                setVisible(false);
                new home();

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else {
            setVisible(false);
            new home();
        }

    }
    public static void main(String[] args) {
        new removeEmployee();
    }
}
