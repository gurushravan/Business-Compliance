package LawCom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class LoginForm {
    private JPanel loginPanel;
    private JTextField tf1;
    private JTextField tf2;
    private JPasswordField tf3;
    private JTextField tf4;
    private JButton submitButton;
    private JTextField tf5;

    JFrame loginF = new JFrame();
public LoginForm() {
    loginF.setContentPane(loginPanel);
    loginF.setVisible(true);
    loginF.pack();

    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String str = tf1.getText();
            String str1 = tf2.getText();
            char[] str2 = tf3.getPassword();
            String str3 = tf4.getText();
            String str4 = tf5.getText();
            int contact=Integer.parseInt(str4);
            String pass= String.valueOf(str2);

            if(tf1.getText().equals("")|| tf2.getText().equals("")|| tf3.getPassword().equals("")||tf4.getText().equals("")|| tf5.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please fill all the records to continue");
            }
            else {
                String sql = "insert into company (name,email,password,address,contact)" + "values (?,?,?,?,?)";

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "1947");
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, str);
                    statement.setString(2, str1);
                    statement.setString(3, pass);
                    statement.setString(4, str3);
                    statement.setInt(5, contact);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Customer details added successfully");
                    new RestAct();
                } catch (Exception ex) {
                    // JOptionPane.showMessageDialog(null,"add item exception");
                    ex.printStackTrace();
                }
            }
        }
    });
}
}
