package LawCom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestAct {
    private JButton licenseCheckButton;
    private JButton conductingAnAuditButton;
    private JPanel restActPanel;

    JFrame restActF = new JFrame();
    public RestAct() {
        restActF.setContentPane(restActPanel);
        restActF.setVisible(true);
        restActF.pack();
    licenseCheckButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new rlc();
        }
    });
    conductingAnAuditButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new rca();
        }
    });
}
}
