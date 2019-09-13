package com.pm.ui.manager;

import com.pm.dao.datasource.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ManagerMain {

    private JFrame mainFrame;
    private JButton mUserButton;
    private JButton mOrderButton;
    private JButton mGoodsButton;
    public Manager manager;



    public ManagerMain(){

        /*//接受用户信息
        this.manager = manager;*/

        mUserButton = new JButton("用户管理");
        mOrderButton = new JButton("订单管理");
        mGoodsButton = new JButton("商品管理");

        mainFrame = new JFrame("管理员");
        mainFrame.setSize(300,200);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        //添加组件

        mainFrame.add(mUserButton);
        mainFrame.add(mGoodsButton);
        mainFrame.add(mOrderButton);
        mainFrame.setVisible(true);
    }

    public void go(){
        mUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MUser mUser = new MUser();
                mUser.go();
            }
        });

        mGoodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MGoods mGoods = new MGoods();
                mGoods.go();
            }
        });

        mOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Morder morder = new Morder();
                morder.go();
            }
        });

    }

}
