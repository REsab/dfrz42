package edu.school.ui.frm;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends JFrame {

    public LoginFrame loginFrame = null;

    MainFrame() {
        initUI();
        bindEvent();
    }

    private void bindEvent() {

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                window_closing(e);
            }
        });

    }


    private void window_closing(WindowEvent e) {
        int option = JOptionPane.showConfirmDialog(MainFrame.this, "确定退出吗?", "提示", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            if (e.getWindow() == MainFrame.this) {
                // System.exit(0);
                if (objLoginFrm != null) {
                    objLoginFrm.setVisible(true);
                    PubObj.objLoginFrm = null;
                }
                this.dispose();  //关闭当前窗体
            }
        }
    }

    private void initUI() {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(500, 200, 500, 500);

    }


}
