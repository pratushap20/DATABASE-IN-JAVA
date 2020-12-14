import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Emp_Dashboard {

    LocalTime t = java.time.LocalTime.now();
    LocalDate d1 = java.time.LocalDate.now();




    public  Emp_Dashboard(String emp_id)

    {
        mark_time_in(emp_id);
        JFrame f1;
        JButton btn_logout;
        JLabel userid = new JLabel("your EMP ID:"+emp_id+" DAy:"+d1+"\t time in:"+t);



        f1 = new JFrame();
        f1.setTitle("DASHBOARD");
        f1.setSize(500,500);

        btn_logout=new JButton("LOGOUT");

        btn_logout.setBounds(100,100,100,100);
        userid.setBounds(200,200,500,200);

        btn_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mark_time_out();
                JOptionPane.showMessageDialog(null,"You have been Logged out");
                f1.setVisible(false);
                new Emp_login();
            }
        });

        f1.add(userid);
        f1.add(btn_logout);

        f1.setLayout(null);
        f1.setVisible(true);

    }

    public void mark_time_in(String emp_id) {
        Db d = new Db();


        String sql = "INSERT into emp_attendance VALUES(NULL, '" + emp_id + "', '" + java.time.LocalDate.now() + "', '" + t + "', NULL)";

        try {

            d.s.executeUpdate(sql);
            d.s.close();

        } catch (Exception e)
        {

        }

    }
    public void mark_time_out()
    {
        Db d = new Db();
        String sql2 = "SELECT * FROM emp_attendance WHERE day='"+d1+"' and time_in='"+t+"' ";
        int sno=0;



        try
        {
            ResultSet rs1 = d.s.executeQuery(sql2);
            while(rs1.next())
                {
                    sno= Integer.parseInt(rs1.getString("serial"));
                }
            String sql1= "UPDATE  emp_attendance set time_out='"+java.time.LocalTime.now()+"' where  serial="+sno+"";
            d.s.executeUpdate(sql1);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }

    }

}

