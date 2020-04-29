package ui.frame;

import javax.swing.*;

public class CustomerFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CustomerFrame");
        frame.setContentPane(new CustomerFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
