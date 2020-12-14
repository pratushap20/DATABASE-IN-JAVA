import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Emp_Register {
    JFrame f;
    JLabel lbl_name, lbl_emp_id, lbl_email, lbl_pass1, lbl_pass2,lbl_title;
    JTextField tf_name, tf_emp_id, tf_email;
    JPasswordField pf_pass1, pf_pass2;
    JButton btn_insert,btn_clear,btn_Login;

    public Emp_Register() {
        f = new JFrame();
        f.setTitle("Employee Registration");

        btn_insert = new JButton("INSERT");
        btn_clear = new JButton("CLEAR");
        btn_Login = new JButton("LOGIN PAGE");


        lbl_name = new JLabel();
        lbl_emp_id = new JLabel();
        lbl_email = new JLabel();
        lbl_pass1 = new JLabel();
        lbl_pass2 = new JLabel();
        lbl_title = new JLabel();

        lbl_name.setText("ENTER NAME:");
        lbl_emp_id.setText("ENTER ID:");
        lbl_email.setText("ENTER EMAIL:");
        lbl_pass1.setText("ENTER PASSWORD:");
        lbl_pass2.setText("CONFIRM PASSWORD:");
        lbl_title.setText("EMPLOYEE REGISTRATION:");

        tf_name = new JTextField();
        tf_emp_id = new JTextField();
        tf_email = new JTextField();


        pf_pass1 = new JPasswordField();
        pf_pass2 = new JPasswordField();


        lbl_title.setBounds(125,50,200,50);
        lbl_name.setBounds(50,100,150,30);
        lbl_emp_id.setBounds(50,150,150,30);
        lbl_email.setBounds(50,200,150,30);
        lbl_pass1.setBounds(50,250,150,30);
        lbl_pass2.setBounds(50,300,150,30);

        tf_name.setBounds(180,100,150,30);
        tf_emp_id.setBounds(180,150,150,30);
        tf_email.setBounds(180,200,150,30);
        pf_pass1.setBounds(180,250,150,30);
        pf_pass2.setBounds(180,300,150,30);

        btn_insert.setBounds(100,350,100,40);
        btn_clear.setBounds(210,350,100,40);
        btn_Login.setBounds(100,400,200,40);

        f.add(lbl_title);
        f.add(lbl_name);
        f.add(lbl_emp_id);
        f.add(lbl_email);

        f.add(lbl_pass1);
        f.add(lbl_pass2);
        f.add(tf_name);
        f.add(tf_emp_id);

        f.add(tf_email);
        f.add(pf_pass1);
        f.add(pf_pass2);

        f.add(btn_insert);
        f.add(btn_clear);
        f.add(btn_Login);

        btn_insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insert_record();
            }
        });
        btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear_tf_pf();
            }
        });
        btn_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Emp_login();
            }
        });


        f.setSize(525,550);
        f.setLayout(null);
        f.setVisible(true);


    }


    public void insert_record()
    {
        Db d = new Db();
        String pw="";
        char [] c=pf_pass1.getPassword();
        for (int i =0;i<c.length;i++)
        {
            pw+=c[i];
        }
        String cnfpw="";
        char [] c2=pf_pass1.getPassword();
        for (int i =0;i<c2.length;i++)
        {
            cnfpw+=c[i];
        }
        if(pw.equals(cnfpw))
        {
            String sql = "INSERT into emp_details VALUES('"+tf_emp_id.getText() +"','"+tf_name.getText()+"','"+tf_email.getText()+"')";
            String sql2 = "INSERT into emp_login VALUES('"+tf_emp_id.getText() +"','"+pw+"')";
            try
            {
                d.s.executeUpdate(sql);
                d.s.executeUpdate(sql2);
                JOptionPane.showMessageDialog(null,"Record inserted");
                clear_tf_pf();
                d.c.close();
                f.setVisible(false);
                new Emp_login();

            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Could not Insert.");
            }
        }


    }
    public void clear_tf_pf()
    {
        tf_email.setText("");
        tf_emp_id.setText("");
        tf_name.setText("");
        pf_pass1.setText("");
        pf_pass2.setText("");
    }



}
