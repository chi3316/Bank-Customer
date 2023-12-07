package bank.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GuiUtil {
    private static final String imgFolder = "src/main/resources/imgs";

    public static void setImageIcon(JButton b, String fileName, String tip) {
        ImageIcon i = new ImageIcon((new File(imgFolder, fileName)).getAbsolutePath());
        b.setIcon(i);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    public static void showPanel(JPanel p,double stretch) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500,500);
        jFrame.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(stretch);
        jFrame.setContentPane(cp);
        jFrame.add(p);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        cp.show(p);
    }
}
