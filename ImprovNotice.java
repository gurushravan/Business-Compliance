package LawCom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImprovNotice {
    private JPanel improvPanel;
    public JComboBox cb1;
    private JButton OKButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel sectionLabel;
    private JButton OKButton1;

    public String a1,a2,b1,b2,c1,c2;
    public int i1,i2,i3,x,x1,x2;

    public int i;

    JFrame improvF=new JFrame();

    public ImprovNotice() {
        improvF.setContentPane(improvPanel);
        improvF.setVisible(true);
        improvF.pack();
        textField1.setVisible(false);
        textField2.setVisible(false);
        textField3.setVisible(false);
        sectionLabel.setVisible(false);
        OKButton1.setVisible(false);


    OKButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selected = cb1.getSelectedItem().toString();
            i=Integer.parseInt(selected);
            if(i==1){
                sectionLabel.setVisible(true);
                textField1.setVisible(true);
                OKButton1.setVisible(true);
                textField2.setVisible(false);
                textField3.setVisible(false);

            }
            else if(i==2){
                sectionLabel.setVisible(true);
                textField2.setVisible(true);
                textField1.setVisible(true);
                OKButton1.setVisible(true);

                textField3.setVisible(false);
            }
            else if(i==3){
                sectionLabel.setVisible(true);
                textField2.setVisible(true);
                textField1.setVisible(true);
                textField3.setVisible(true);
                OKButton1.setVisible(true);
            }
        }
    });
        OKButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String str= textField1.getText();
                String str1 =textField2.getText();
                String str2=textField3.getText();
               if(str1==""){
                i1=Integer.parseInt(str);}
               else if(str2==""){
                   i1=Integer.parseInt(str);
                   i2=Integer.parseInt(str1);}
              else{

                    i1=Integer.parseInt(str);
                    i2=Integer.parseInt(str1);
                    i3=Integer.parseInt(str2);}

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "1947");
                    PreparedStatement st = con.prepareStatement("select * from fssai where Section="+i1);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                        x=rs.getInt(1);
                        String s = rs.getString(2);
                        String s2 = rs.getString(6);
                        a1 = s + s2;

                    }
                    PreparedStatement st12 = con.prepareStatement("select * from fssai_penalties where id="+x);
                    ResultSet rs12 = st12.executeQuery();
                    if (rs12.next()) {
                        String s4 = rs12.getString(2);
                        String s5 = rs12.getString(5);
                        a2 = s4 + s5;

                        //String str=
                    }

                    PreparedStatement st1 = con.prepareStatement("select * from fssai where Section ="+i2);
                    ResultSet rs1 = st1.executeQuery();
                    if (rs1.next()) {
                        x1=rs.getInt(1);
                        String s = rs1.getString(2);
                        String s2 = rs1.getString(6);
                        b1 = s + s2;

                    }
                    PreparedStatement st11 = con.prepareStatement("select * from fssai_penalties where id ="+x1);
                    ResultSet rs11 = st11.executeQuery();
                    if (rs11.next()) {
                        String s4 = rs11.getString(2);
                        String s5 = rs11.getString(5);
                        b2 = s4 + s5;

                        //String str=
                    }

                    PreparedStatement st2 = con.prepareStatement("select * from fssai where Section ="+i3);
                    ResultSet rs2 = st2.executeQuery();
                    if (rs2.next()) {
                        x2=rs.getInt(1);
                        String s = rs2.getString(2);
                        String s2 = rs2.getString(6);
                        c1 = s + s2;

                    }
                    PreparedStatement st13 = con.prepareStatement("select * from fssai_penalties where id="+x2);
                    ResultSet rs13 = st13.executeQuery();
                    if (rs13.next()) {
                        String s4 = rs13.getString(2);
                        String s5 = rs13.getString(5);
                        c2 = s4 + s5;

                        //String str=
                    }


                    if (i == 1) {

                        JOptionPane.showMessageDialog(null, a1 + "\nPenalty applicable\n" + a2);
                    } else if (i == 2) {
                        JOptionPane.showMessageDialog(null, a1 + "\nPenalty applicable\n" + a2 + "\n" + b1 + "\nPenalty applicable\n" + b2);
                    } else if (i == 3) {
                        JOptionPane.showMessageDialog(null, a1 + "\nPenalty applicable\n" + a2 + "\n" + b1 + "\nPenalty applicable\n" + b2 + "\n" + c1 + "\nPenalty applicable\n" + c2);
                    }
                }
                            catch(Exception ex){
                    ex.printStackTrace();
                            }

                        }
        });
    }
}
