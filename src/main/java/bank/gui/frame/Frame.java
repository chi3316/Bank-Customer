package bank.gui.frame;

import bank.gui.panel.MainPanel;

import javax.swing.*;

public class Frame extends JFrame {
    public static Frame instance = new Frame();
    public Frame() {
        this.setTitle("Bank");
        this.setSize(513,450);
        this.setContentPane(MainPanel.instance);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
