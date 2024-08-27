import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class updateemployee extends JFrame implements ActionListener {


    JButton add ,back;
    JTextField tfeducation ,tfname,tsalary,tAddress,tphone,temail,tdesignation,taadhar;


    JLabel lblempId;
    String empid;


    updateemployee(String empid){
        this.empid=empid;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,750);
        add(image);



        JLabel labelname =new JLabel("Name:");
        labelname.setBounds(70,180,200,40);
        labelname.setFont(new Font("serif",Font.PLAIN,30));
        labelname.setForeground(Color.white);
        image.add(labelname);

        JLabel lblname=new JLabel();
        lblname.setBounds(200,180,250,40);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        lblname.setForeground(Color.white);
        image.add(lblname);

        JLabel labelfname = new JLabel("Father's Name:");
        labelfname.setBounds(500,180,200,40);
        labelfname.setFont(new Font("serif",Font.PLAIN,30));
        labelfname.setForeground(Color.white);
        image.add(labelfname);

        tfname=new JTextField();
        tfname.setBounds(700,180,250,40);
        tfname.setFont(new Font("serif",Font.BOLD,20));
        image.add(tfname);

        JLabel labeldob = new JLabel("Date of Birth:");
        labeldob.setBounds(70,250,200,40);
        labeldob.setFont(new Font("serif",Font.PLAIN,30));
        labeldob.setForeground(Color.white);
        image.add(labeldob);

        JLabel lbldob=new JLabel();
        lbldob.setBounds(245,250,200,40);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        lbldob.setForeground(Color.white);
        image.add(lbldob);

        JLabel labelsalary =new JLabel("Salary:");
        labelsalary.setBounds(500,250,200,40);
        labelsalary.setFont(new Font("serif",Font.PLAIN,30));
        labelsalary.setForeground(Color.white);
        image.add(labelsalary);

        tsalary=new JTextField();
        tsalary.setBounds(700,250,250,40);
        tsalary.setFont(new Font("serif",Font.BOLD,20));
        image.add(tsalary);

        JLabel labeladdress =new JLabel("Address:");
        labeladdress.setBounds(70,310,200,40);
        labeladdress.setFont(new Font("serif",Font.PLAIN,30));
        labeladdress.setForeground(Color.white);
        image.add(labeladdress);

        tAddress=new JTextField();
        tAddress.setBounds(200,310,250,40);
        tAddress.setFont(new Font("serif",Font.BOLD,20));
        image.add(tAddress);

        JLabel labelphone =new JLabel("Phone:");
        labelphone.setBounds(500,310,200,40);
        labelphone.setFont(new Font("serif",Font.PLAIN,30));
        labelphone.setForeground(Color.white);
        image.add(labelphone);

        tphone=new JTextField();
        tphone.setBounds(700,310,250,40);
        tphone.setFont(new Font("serif",Font.BOLD,20));
        image.add(tphone);

        JLabel labelemain =new JLabel("Email:");
        labelemain.setBounds(70,390,200,40);
        labelemain.setFont(new Font("serif",Font.PLAIN,30));
        labelemain.setForeground(Color.white);
        image.add(labelemain);

        temail=new JTextField();
        temail.setBounds(200,390,250,40);
        temail.setFont(new Font("serif",Font.BOLD,20));
        image.add(temail);

        JLabel labeleducation =new JLabel("Qualification:");
        labeleducation.setBounds(500,390,200,40);
        labeleducation.setFont(new Font("serif",Font.PLAIN,30));
        labeleducation.setForeground(Color.white);
        image.add(labeleducation);


        tfeducation=new JTextField();
        tfeducation.setBounds(700,390,250,40);
        tfeducation.setFont(new Font("serif",Font.BOLD,20));
        image.add(tfeducation);

        JLabel labeldesigignation =new JLabel("Desig:");
        labeldesigignation.setBounds(70,460,200,40);
        labeldesigignation.setFont(new Font("serif",Font.PLAIN,30));
        labeldesigignation.setForeground(Color.white);
        image.add(labeldesigignation);

        tdesignation=new JTextField();
        tdesignation.setBounds(200,460,250,40);
        tdesignation.setFont(new Font("serif",Font.BOLD,20));
        image.add(tdesignation);

        JLabel labelAdhar = new JLabel("Aadhar No:");
        labelAdhar.setBounds(500,460,200,40);
        labelAdhar.setFont(new Font("serif",Font.PLAIN,30));
        labelAdhar.setForeground(Color.white);
        image.add(labelAdhar);

        JLabel lblaadhar =new JLabel();
        lblaadhar.setBounds(700,460,250,40);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        lblaadhar.setForeground(Color.white);
        image.add(lblaadhar);

        JLabel labelempId = new JLabel("Employee ID:");
        labelempId.setBounds(70,530,200,40);
        labelempId.setFont(new Font("serif",Font.PLAIN,30));
        labelempId.setForeground(Color.white);
        image.add(labelempId);

        lblempId = new JLabel();
        lblempId.setBounds(250,530,200,40);
        lblempId.setFont(new Font("serif",Font.PLAIN,30));
        lblempId.setForeground(Color.red);
        lblempId.setBackground(Color.white);
        image.add(lblempId);

        try{
            conn c = new conn();
            String query ="select * from employee where empid ='"+empid+"'";
            ResultSet rs=c.s.executeQuery(query);
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tAddress.setText(rs.getString("address"));
                tsalary.setText(rs.getString("salary"));
                tphone.setText(rs.getString("phone"));
                tfeducation.setText(rs.getString("education"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empid"));
                tdesignation.setText(rs.getString("designation"));
                temail.setText(rs.getString("emain"));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        add=new JButton("Update Details");
        add.setBounds(400,600,150,40);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.addActionListener(this);
        image.add(add);

        back=new JButton("Back");
        back.setBounds(600,600,150,40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        image.add(back);




        setSize(1120,750);
        setLocation(400,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){


            String fname=tfname.getText();
            String salary= tsalary.getText();
            String address= tAddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = tfeducation.getText();
            String Designation =tdesignation.getText();

            try {
                conn con =new conn();
                String query="update  employee set fname = '"+fname+"',salary='"+salary+"',address='"+address+"',phone='"+phone+"',emain='"+email+"',designation='"+Designation+"',education='"+education+"'where empid='"+empid+"'";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Detail updated successfully");
                setVisible(false);
                new home();

            }catch ( Exception e){
                e.printStackTrace();

            }


        }
        else {
            setVisible(false);
            new home();
        }
    }
    public static void main(String[] args) {
        new updateemployee("");
    }
}

