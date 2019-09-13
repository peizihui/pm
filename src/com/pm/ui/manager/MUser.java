package com.pm.ui.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MUser extends JFrame {
    private static final long serialVersionUID = 9527L;
    private JPanel pane;
    private BoxLayout layout;
    private JButton messageButton;
    private JButton closeButton;
    private JButton closeButton1;
    private JButton stopfrzee;

    public MUser() {
        pane = new JPanel();
        layout = new BoxLayout(pane, BoxLayout.X_AXIS);// 水平的盒布局
        pane.setLayout(layout);

        messageButton = new JButton("积分充值");
        closeButton = new JButton("添加用户");
        closeButton1 = new JButton("冻结用户");
        stopfrzee = new JButton("解冻用户");

        pane.add(Box.createGlue()); // 挤占用户管理按钮和窗口左侧空间
        pane.add(messageButton);
        pane.add(Box.createHorizontalStrut(20));// 按钮之间的水平距离
        pane.add(closeButton);
        pane.add(Box.createHorizontalStrut(20));
        pane.add(closeButton1);
        pane.add(Box.createGlue());
        pane.add(Box.createHorizontalStrut(20));
        pane.add(stopfrzee);
        pane.add(Box.createGlue());


        add(pane);
        setTitle("用户管理界面");// 标题
        setSize(550, 200);// 窗口大小
        setLocationRelativeTo(null);// 窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 窗口点击关闭时,退出程序
        this.setVisible(true);

    }

    public void go() {

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MUser.this.dispose();
                AddUser addUser = new AddUser();
                addUser.Main();
            }
        });
    }
}
