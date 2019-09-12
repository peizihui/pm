package com.pm.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ManagerUI extends JFrame{


    /**
     * 主界面,也就是欢迎界面
     */

    private static final long serialVersionUID = 9527L;
    // 菜单栏
    JMenuBar menuBar = new JMenuBar();
    JMenuItem jItem = new JMenuItem();
    //定义菜单选项
    JMenuItem borrow;
    //定义选项卡
    JPanel jp1;

    JFrame frame = new JFrame();


    /*
     * 构造方法在这里的使用:在调用JframeMain类时,会默认调用改构造方法,使该方法里面的菜单
     * 条默认加载,但是不会加载下面的界面方法.
     * 作用:将界面的方法分开,利于界面跳转
     */
    public ManagerUI(){

        //添加菜单选项
        borrow = new JMenuItem("新增用户");


        //添加到菜单条上
        menuBar.add(borrow);

        //设置新的面板
        jp1 = new JPanel();

        //设置菜单条
        setJMenuBar(menuBar);



    }

    //界面方法
    public void Menu(){

        //设置点击菜单栏事件,用过调用新的类实现界面的清除,设置和重构
        borrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManagerUI.this.dispose();
                AddUser addUser = new AddUser();
                addUser.Main();
            }
        });


        //设置界面属性
        this.setTitle("管理员主界面");
        this.setSize(550, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


        //锁定窗体
        this.setResizable(false);


    }
}
