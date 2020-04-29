package edu.mssql.kzc.q1.Frame_V4;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static edu.mssql.kzc.q1.Frame_V4.PubObj.objLoginFrm;

public class MainFrame extends AFrame {

    public LoginFrame loginFrame = null;

    MainFrame() {
        initUI();
        bindEvent();
    }

    @Override
    protected void customLoad() {

    }

    private void bindEvent() {

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                window_closing(e);
            }
        });

    }


    protected void window_closing(WindowEvent e) {
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

    @Override
    protected void parentInitUI() {

    }

    @Override
    protected void customerLoad() {

    }

    private void initUI() {
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(500, 200, 500, 500);

    }


}
