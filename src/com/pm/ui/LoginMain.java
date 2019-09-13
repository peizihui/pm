package com.pm.ui;

import com.pm.process.ManagerProcess;
import com.pm.process.UserProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginMain {
    private String account = "";
    private String password = "";

    private JFrame mainFrame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;


    private JTextField accountField;
    private JPasswordField passwordField;

    private JLabel accountLabel;
    private JLabel passwordLabel;

    private JButton loginButton;

    private JRadioButton mgRadioButton;
    private JRadioButton userRadioButton;

    //private static final int ROLE_USER = 1;
    //private static final int ROLE_MG = 2;


    public LoginMain() {
        //初始化窗口
        accountField = new JTextField(10);
        accountLabel = new JLabel("用户名");

        passwordField = new JPasswordField(10);
        passwordLabel = new JLabel("密码");

        userRadioButton = new JRadioButton("用户",true);
        mgRadioButton = new JRadioButton("管理员");
        loginButton = new JButton("登录");


        //将单选按钮绑定为一组
        ButtonGroup bg = new ButtonGroup();
        bg.add(userRadioButton);
        bg.add(mgRadioButton);

        //组合组件
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        panel1.add(accountLabel);
        panel1.add(accountField);
        panel2.add(passwordLabel);
        panel2.add(passwordField);
        panel3.add(userRadioButton);
        panel3.add(mgRadioButton);
        panel4.add(loginButton);

        mainFrame = new JFrame("积分管理系统登录入口");

        mainFrame.setSize(300,200);
        mainFrame.setBounds(600,200,300,220);
        mainFrame.setLayout(new GridLayout(4,1));
        mainFrame.setResizable(false);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //添加组件
        mainFrame.add(panel1);
        mainFrame.add(panel2);
        mainFrame.add(panel3);
        mainFrame.add(panel4);
        mainFrame.setVisible(true);

    }

    public void Login(){

        //监听登录按钮
        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //检查用户名与密码是否为空
                if (check()) {

                    //选择登录用户
                    if (userRadioButton.isSelected()) {
                        UserProcess up = new UserProcess();
                        if (up.userLogin(account, password) != null) {
                            mainFrame.dispose();
                            //TODO 添加用户窗口
                            System.out.println("UY");
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "用户名或密码错误！",
                                    "注意",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        ManagerProcess mp = new ManagerProcess();
                        if (mp.ManagerLogin(account, password) != null) {
                            mainFrame.dispose();
                            //TODO 添加管理员窗口
                            ManagerUI jframeMain = new ManagerUI();
                            jframeMain.MUI();
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "用户名或密码错误！",
                                    "注意",
                                    JOptionPane.WARNING_MESSAGE);
                        }

                    }
                }
            }
        });
    }

    public boolean check(){
        account = accountField.getText();
        password = String.valueOf(passwordField.getPassword());

        if (account.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "请输入用户名！",
                    "注意",
                    JOptionPane.ERROR_MESSAGE);
        } else if (password.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "请输入密码！",
                    "注意",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            return true;
        }
        return false;
    }
}
