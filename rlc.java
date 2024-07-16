package LawCom;


import javax.swing.ButtonGroup;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class rlc {
    private JPanel rlcPanel;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JRadioButton yesRadioButton1;
    private JRadioButton noRadioButton1;
    private JLabel qLabel;
    public String s3;
    public String s6;
    JFrame rlcF = new JFrame();
public rlc() {
    rlcF.setContentPane(rlcPanel);
    rlcF.setVisible(true);
    rlcF.pack();
    qLabel.setVisible(false);
    yesRadioButton1.setVisible(false);
    noRadioButton1.setVisible(false);
    yesRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            qLabel.setVisible(true);
            yesRadioButton1.setVisible(true);
            noRadioButton1.setVisible(true);

        }
    });
    noRadioButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "1947");
                PreparedStatement st = con.prepareStatement("select * from fssai where id=1");
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String s = rs.getString(2);
                    String s2 = rs.getString(6);
                    s3 = s + s2;
                    JOptionPane.showMessageDialog(null, "You do not possess a food security license! You require a Food Security License for your business to operate as mandated by the Food Security and Standards Act, 2006 where acc. to");
                    //JOptionPane.showMessageDialog(null, s3);
                }
                PreparedStatement st1 = con.prepareStatement("select * from fssai_penalties where id=1");
                ResultSet rs1 = st1.executeQuery();
                if (rs1.next()) {
                    String s4 = rs1.getString(2);
                    String s5 = rs1.getString(5);
                    s6 = s4 + s5;

                    //String str=
                }

                JOptionPane.showMessageDialog(null, s3+"\nPenalty applicable\n"+ s6);

                new RestAct();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }
});
    yesRadioButton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ImprovNotice();
        }
    });
    noRadioButton1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new RestAct();
        }
    });
}}
