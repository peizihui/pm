package com.pm.ui.user;

import com.pm.dao.datasource.Manager;
import com.pm.dao.datasource.User;
import com.pm.ui.manager.MGoods;
import com.pm.ui.manager.MOrder;
import com.pm.ui.manager.MUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserMain extends JFrame{

    private JFrame mainFrame;
    private JButton mUserButton;
    private JButton mOrderButton;
    private JButton mGoodsButton;
    public Manager manager;
    public User user = null;


    public UserMain(User user){
        this.user = user;
        mUserButton = new JButton("个人信息");
        mOrderButton = new JButton("个人订单");
        mGoodsButton = new JButton("商品管理");

        mainFrame = new JFrame(user.getUserName()+"");
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
                UOrder uOrder = new UOrder(user);
                uOrder.go();
            }
        });

    }

}
