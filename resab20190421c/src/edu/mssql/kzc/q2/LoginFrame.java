package edu.mssql.kzc.q2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JPanel contanier;   //窗口
    //标签
    private JLabel labelLoginName;//账号标签
    private JLabel labelLoginPwd;//密码标签
    private JLabel labelMsg;  //提示标签
    //输入框
    private JTextField inputName;  //输入用户名
    private JTextField inputPwd;  //输入密码
    //按钮
    private JButton btnSubmit;  //提交按钮
    private JButton btnReset;   //重置按钮


    //构造
    public LoginFrame() {
        initUI();
        bindEvent();

    }

    //自定义方法
    private void customerLoad() {
        labelMsg.setText("");

    }

    //界面
    private void initUI() {
        //窗体
        this.setTitle("系统登录");
        int windowsWidth = 500;
        int windowsHeight = 300;
        this.setSize(windowsWidth, windowsHeight);
        this.setResizable(true);
// 计算当前窗体居中时的x、y座标  
//int x = (Toolkit.getDefaultToolkit().getScreenSize().width - width) / 2;
//int y = (Toolkit.getDefaultToolkit().getScreenSize().height - height) / 2;     // 定义当前窗体的位置
//this.setLocation(x, y);
        //窗口居中
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - windowsWidth) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - windowsHeight) / 2;
        this.setLocation(x, y);
        //实例化窗口对象
        contanier = new JPanel();//画板
        contanier.setLayout(null);
        this.add(contanier);//  窗口添加画板


        //组件 声明   赋值
        labelLoginName = new JLabel();
        labelLoginPwd = new JLabel();
        labelMsg = new JLabel();
        btnSubmit = new JButton();
        btnReset = new JButton();
        inputName = new JTextField();
        inputPwd = new JTextField();


        labelLoginName.setText("账号");
        labelLoginPwd.setText("密码");
        labelMsg.setText("hello");
        btnReset.setText("重置");
        btnSubmit.setText("提交");

        labelLoginName.setBounds(80, 50, 80, 50);
        labelLoginPwd.setBounds(80, 100, 80, 50);
        inputName.setBounds(130, 60, 180, 30);
        inputPwd.setBounds(130, 110, 180, 30);
        btnReset.setBounds(230, 160, 80, 40);
        btnSubmit.setBounds(130, 160, 80, 40);

        labelMsg.setBounds(80, 210, 280, 30);
        labelMsg.setText("1234hello");
        labelMsg.setForeground(Color.red);


        contanier.add(labelLoginName);
        contanier.add(labelLoginPwd);
        contanier.add(labelMsg);
        contanier.add(inputName);
        contanier.add(inputPwd);
        contanier.add(btnReset);
        contanier.add(btnSubmit);
    }

    //按键事件
    private void bindEvent() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //点击事件  匿名方案
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSubmit_click(e);   //调用类方法
            }
        });
        //点击方案 lamda 方案
        btnReset.addActionListener(e -> {
            btnReset_click(e);   //调用自身方法
        });

    }

    // 重置按键
    private void btnReset_click(ActionEvent e) {
        labelMsg.setText("");
        inputName.setText("");
        inputPwd.setText("");

        this.setVisible(false);
        MainFrame mainFrame=new MainFrame();
        mainFrame.setVisible(true);


    }

    //提交按键
    private void btnSubmit_click(ActionEvent e) {
        labelMsg.setText("");
        String loginName = inputName.getText();
        String loginPwd = inputPwd.getText();

        if (loginName == null || loginPwd.isEmpty()) {
            labelMsg.setText("提示:请输入账号.");
            return;
        }
        if (loginName == null || loginPwd.isEmpty()) {
            labelMsg.setText("提示:请输入密码");
            return;

        }

        boolean vIsOk = StudentCrud.login(loginName, loginPwd);
        if (vIsOk) {
            labelMsg.setText("提示:登录成功");
            this.setVisible(false);
            MainFrame mainFrame=new MainFrame();

            //mainFrame.loginFrame=this;

            PubObj.objLoginFrm=this;  //更赋值对象
            mainFrame.setVisible(true);

        } else {
            labelMsg.setText("提示:登录失败.");
        }


    }
}
