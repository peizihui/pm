package com.pm.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class ManagerUI extends JFrame {
    private static final long serialVersionUID = 9527L;

    public ManagerUI() {


    }

    public void MUI() {
        JPanel pane = new JPanel();
        BoxLayout layout = new BoxLayout(pane, BoxLayout.X_AXIS);// 水平的盒布局
        pane.setLayout(layout);

        JButton messageButton = new JButton("用户管理");
        JButton closeButton = new JButton("商品管理");
        JButton closeButton1 = new JButton("订单管理");
        pane.add(Box.createGlue()); // 挤占用户管理按钮和窗口左侧空间
        pane.add(messageButton);
        pane.add(Box.createHorizontalStrut(20));// 按钮之间的水平距离
        pane.add(closeButton);
        pane.add(Box.createHorizontalStrut(20));
        pane.add(closeButton1);
        pane.add(Box.createGlue());
        messageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagerUI.this.dispose();
                MUUI muui = new MUUI();
                muui.muUI();
            }
        });
        add(pane);
        setTitle("管理员界面");// 标题
        setSize(500, 200);// 窗口大小
        setLocationRelativeTo(null);// 窗口居中
        setDefaultCloseOperation(EXIT_ON_CLOSE);// 窗口点击关闭时,退出程序
        this.setVisible(true);
    }
}
