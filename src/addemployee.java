import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;
public class addemployee extends JFrame implements ActionListener {

    Random ran= new Random();
    int number =ran.nextInt(999999);

    JButton add ,back;
    JTextField tname ,tfname,tsalary,tAddress,tphone,temail,tdesignation,taadhar;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempId;


    addemployee(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/detail.jpg"));
        Image i2=i1.getImage().getScaledInstance(1120,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1120,750);
        add(image);

//        JLabel heading =new JLabel("Add Employee Detail");
//        heading.setBounds(320,30,520,60);
//        heading.setFont(new Font("SAN_SERIF",Font.BOLD,50));
//        image.add(heading);

        JLabel labelname =new JLabel("Name:");
        labelname.setBounds(70,170,200,40);
        labelname.setFont(new Font("serif",Font.PLAIN,30));
        labelname.setForeground(Color.white);
        image.add(labelname);

        tname=new JTextField();
        tname.setBounds(200,170,250,40);
        image.add(tname);

        JLabel labelfname = new JLabel("Father's Name:");
        labelfname.setBounds(500,170,200,40);
        labelfname.setFont(new Font("serif",Font.PLAIN,30));
        labelfname.setForeground(Color.white);
        image.add(labelfname);

        tfname=new JTextField();
        tfname.setBounds(700,170,250,40);
        image.add(tfname);

        JLabel labeldob = new JLabel("Date of Birth:");
        labeldob.setBounds(70,240,200,40);
        labeldob.setFont(new Font("serif",Font.PLAIN,30));
        labeldob.setForeground(Color.white);
        image.add(labeldob);

        dcdob=new JDateChooser();
        dcdob.setBounds(245,240,200,40);
        image.add(dcdob);

        JLabel labelsalary =new JLabel("Salary:");
        labelsalary.setBounds(500,240,200,40);
        labelsalary.setFont(new Font("serif",Font.PLAIN,30));
        labelsalary.setForeground(Color.white);
        image.add(labelsalary);

        tsalary=new JTextField();
        tsalary.setBounds(700,240,250,40);
        image.add(tsalary);

        JLabel labeladdress =new JLabel("Address:");
        labeladdress.setBounds(70,310,200,40);
        labeladdress.setFont(new Font("serif",Font.PLAIN,30));
        labeladdress.setForeground(Color.white);
        image.add(labeladdress);

        tAddress=new JTextField();
        tAddress.setBounds(200,310,250,40);
        image.add(tAddress);

        JLabel labelphone =new JLabel("Phone:");
        labelphone.setBounds(500,310,200,40);
        labelphone.setFont(new Font("serif",Font.PLAIN,30));
        labelphone.setForeground(Color.white);
        image.add(labelphone);

        tphone=new JTextField();
        tphone.setBounds(700,310,250,40);
        image.add(tphone);

        JLabel labelemain =new JLabel("Email:");
        labelemain.setBounds(70,380,200,40);
        labelemain.setFont(new Font("serif",Font.PLAIN,30));
        labelemain.setForeground(Color.white);
        image.add(labelemain);

        temail=new JTextField();
        temail.setBounds(200,380,250,40);
        image.add(temail);

        JLabel labeleducation =new JLabel("Qualification:");
        labeleducation.setBounds(500,380,200,40);
        labeleducation.setFont(new Font("serif",Font.PLAIN,30));
        labeleducation.setForeground(Color.white);
        image.add(labeleducation);

        String courses[]={"BBA","BCA","BA","B.COM","BTech","MBA","MCA","MTech","MSC","Bsc","PHD"};

        cbeducation=new JComboBox(courses);
        cbeducation.setBackground(Color.white);
        cbeducation.setBounds(700,380,250,40);
        image.add(cbeducation);

        JLabel labeldesigignation =new JLabel("Desig:");
        labeldesigignation.setBounds(70,450,200,40);
        labeldesigignation.setFont(new Font("serif",Font.PLAIN,30));
        labeldesigignation.setForeground(Color.white);
        image.add(labeldesigignation);

        tdesignation=new JTextField();
        tdesignation.setBounds(200,450,250,40);
        image.add(tdesignation);

        JLabel labelAdhar = new JLabel("Aadhar No:");
        labelAdhar.setBounds(500,450,200,40);
        labelAdhar.setFont(new Font("serif",Font.PLAIN,30));
        labelAdhar.setForeground(Color.white);
        image.add(labelAdhar);

        taadhar=new JTextField();
        taadhar.setBounds(700,450,250,40);
        image.add(taadhar);

        JLabel labelempId = new JLabel("Employee ID:");
        labelempId.setBounds(70,520,200,40);
        labelempId.setFont(new Font("serif",Font.PLAIN,30));
        labelempId.setForeground(Color.white);
        image.add(labelempId);

        lblempId = new JLabel(""+number);
        lblempId.setBounds(250,520,200,40);
        lblempId.setFont(new Font("serif",Font.PLAIN,30));
        lblempId.setForeground(Color.white);
        image.add(lblempId);

        add=new JButton("Add Details");
        add.setBounds(400,590,150,40);
        add.setBackground(Color.black);
        add.addActionListener(this);
        add.setForeground(Color.white);
        image.add(add);

        back=new JButton("Back");
        back.setBounds(600,590,150,40);
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

            String name= tname.getText();
            String fname=tfname.getText();
            String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary= tsalary.getText();
            String address= tAddress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String educatuion= (String) cbeducation.getSelectedItem();
            String Designation =tdesignation.getText();
            String aadhar= taadhar.getText();
            String empid=lblempId.getText();
            try {
                conn con =new conn();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+educatuion+"','"+Designation+"','"+aadhar+"','"+empid+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Detail added successfully");
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
        new addemployee();
    }
}
