package bank.startup;

import bank.gui.frame.Frame;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Startup {
    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(() -> {
            Frame.instance.setVisible(true);
        });
    }
}
