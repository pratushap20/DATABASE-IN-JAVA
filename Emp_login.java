import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Emp_login {
    //Create Objs
    JFrame f ;
    JLabel lbl_user_id,lbl_pass,lbl_title;
    JTextField tf_emp_id;
    JPasswordField pf_pass;
    JButton btn_login,btn_register;
    public  Emp_login()
    {
        //INITIALIZE
        f = new JFrame();
        btn_login = new JButton("LOGIN");
        btn_register = new JButton("REGISTER");

        lbl_user_id = new JLabel("USER ID:");
        lbl_pass= new JLabel("PASSWORD:");
        lbl_title= new JLabel("LOGIN");

        tf_emp_id=new JTextField();

        pf_pass=new JPasswordField();


        //FRAME-->location
        lbl_title.setBounds(200,50,100,40);
        lbl_user_id.setBounds(50,100,100,40);
        lbl_pass.setBounds(50,150,100,40);

        tf_emp_id.setBounds(170,100,200,40);
        pf_pass.setBounds(170,150,200,40);
        btn_login.setBounds(135,200,150,40);
        btn_register.setBounds(135,250,150,40);

        //Button Function
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validate_login();
            }
        });
        btn_register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Emp_Register();
            }
        });

        //ADD COMPONENTS IN OUR FRAME
        f.add(lbl_pass);
        f.add(lbl_title);
        f.add(lbl_user_id);
        f.add(tf_emp_id);
        f.add(pf_pass);
        f.add(btn_login);
        f.add(btn_register);

        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);



    }
    public  void validate_login()
    {
        Db d = new Db();
        char [] c=pf_pass.getPassword();
        String pw = "";
        for(int i=0;i<c.length;i++)
        {
            pw+=c[i];
        }
        if(tf_emp_id.getText()=="" || pw=="")
        {
            JOptionPane.showMessageDialog(null,"ENTER USER ID AND PASSWORD");
        }
        else
        {
            String sql = "SELECT * FROM emp_login where emp_id='"+tf_emp_id.getText()+"' and emp_pw='"+pw+"'";
            try
            {
                ResultSet rs = d.s.executeQuery(sql);
                if(rs.next())
                {
                    JOptionPane.showMessageDialog(null,"LOGIN SUCCESS");
                    d.c.close();
                    f.setVisible(false);
                    new Emp_Dashboard(tf_emp_id.getText());


                }
                else
                {
                    JOptionPane.showMessageDialog(null,"USER ID or PASSWORD is INCORRECT.");
                }
            }
            catch (Exception e)
            {

            }

        }
    }
    public static void main(String [] args)

    {

        new Emp_login();

    }


}
