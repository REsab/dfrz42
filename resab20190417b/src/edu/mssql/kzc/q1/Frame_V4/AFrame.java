package edu.mssql.kzc.q1.Frame_V4;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public abstract class AFrame extends JFrame {

    private static final long serialVersionUID = 6691861673349231643L;
    protected JPanel container;
    private int height = 300;
    private int width = 400;
    //构造

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    AFrame() {


        parentInitUI();
        parentBindEvent();
        parentCustomLoad();
        customLoad();


    }

    protected abstract void customLoad();

    protected void parentCustomLoad() {
    }

    protected void parentBindEvent() {
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                window_closing(e);
            }
        });

    }

    protected abstract void window_closing(WindowEvent e);

    protected abstract void parentInitUI();

    protected abstract void customerLoad();


}
