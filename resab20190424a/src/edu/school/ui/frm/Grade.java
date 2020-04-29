package edu.school.ui.frm;

import java.awt.event.WindowEvent;

public class Grade extends AFrame {


    @Override
    void initUI() {

        int width = 800;
        int height = 600;
        String vTitle = "学生管理系统-年级管理 ";
        if (FrmUtil.Login_User.getStudentNo() != null) {
            vTitle += "[" + FrmUtil.Login_User.getStudentNo() + "]";
        }
        this.setTitle(vTitle);
        this.setResizable(false);

    }

    @Override
    void bindEvent() {

    }

    @Override
    void customer() {

    }

    @Override
    void window_closing(WindowEvent event) {

        this.dispose();
    }
}
