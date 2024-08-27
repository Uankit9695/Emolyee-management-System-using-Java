import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class viewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice cemoployeeid;

    JButton search , print, update, back;

    viewEmployee(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons"));
        Image i2=i1.getImage().getScaledInstance(1200,650,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1200,650);
        add(image);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel searchlbl = new JLabel("Search by Employee id");
        searchlbl.setBounds(20,20,150,20);
        image.add(searchlbl);

        cemoployeeid =new Choice();
        cemoployeeid.setBounds(180,20,150,20);
        image.add(cemoployeeid);
        try{
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()){
                cemoployeeid.add(rs.getString("empid"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        table =new JTable();
        try{
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            while(rs.next()){
                cemoployeeid.add(rs.getString("empid"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp= new JScrollPane(table);
        jsp.setBounds(0, 100, 1200,650);
        image.add(jsp);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        image.add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        image.add(print);

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        image.add(update);

        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        image.add(back);






        setSize(1200,650);
        setLocation(300,50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query ="select * from employee where empid ='"+cemoployeeid.getSelectedItem()+"' ";
            try{
                conn c= new conn();
                ResultSet rs= c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }catch (Exception e){
                e.printStackTrace();
            }
            
        } else if (ae.getSource()==print) {
            try{
                table.print();

            }catch( Exception e){
                e.printStackTrace();
            }
            
        } else if (ae.getSource()==update) {
            setVisible(false);
            new updateemployee(cemoployeeid.getSelectedItem());

        }
        else {
            setVisible(false);
            new home();
        }
    }

    public static void main(String[] args) {
        new viewEmployee();

    }
}
