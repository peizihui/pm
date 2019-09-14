package com.pm.ui.manager;

import com.pm.process.UserProcess;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class EditPwd extends JFrame {

    private static final long serialVersionUID = 12312321321L;
    JLabel tpwd0;
    JLabel tpwd1;//标签
    JPasswordField pwd0, pwd1;//文本
    JButton btnedit;//按钮
    JPanel jp1, jp2, jp3;//面板

    JPanel jpmain = new JPanel();
    JFrame frame = new JFrame();

    //获取输入框内的值
    String strpwd0;
    String strpwd1;

    //界面方法
    public void Main(int id, String pwd) {
        //初始化面板
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        //将每一行的内容添加
        tpwd0 = new JLabel("输入新密码:");
        pwd0 = new JPasswordField(10);

        tpwd1 = new JLabel("确认密码:");
        pwd1 = new JPasswordField(10);

        jp1.add(tpwd0);
        jp1.add(pwd0);
        jp2.add(tpwd1);
        jp2.add(pwd1);

        btnedit = new JButton("submit");
        jp3.add(btnedit);

        //六行一列
        jpmain.setLayout(new GridLayout(2, 1));//网格式布局

        //将所有的面板加入主面板中
        //作用,在刷新界面时只需删除主面板即可
        jpmain.add(jp1);
        jpmain.add(jp2);
        jpmain.add(jp3);

        //将主面板设置在界面上
        frame.add(jpmain);

        //设置窗体
        frame.setTitle("修改用户密码");//窗体标签
        frame.setSize(400, 150);//窗体大小
        frame.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出关闭JFrame
        frame.setVisible(true);//显示窗体

        //锁定窗体
        frame.setResizable(false);

        //设置按钮事件
        btnedit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取输入框内容
                findjtext();
                //判断输入框是否为空
                if (strpwd0.equals("") || strpwd1.equals("")) {
                    JOptionPane.showMessageDialog(null, "不能为空！", "提示", JOptionPane.WARNING_MESSAGE); }
                //判断两次输入是否相等
                else if (!strpwd0.equals(strpwd1)){
                    JOptionPane.showMessageDialog(null, "两次输入不一致！", "提示", JOptionPane.WARNING_MESSAGE); }
                else{
                    //创建service对象,
                    UserProcess up = new UserProcess();
                    Boolean modify = up.editpwdUser(id, strpwd1);
                    //执行添加用户方法,并将返回值存储在modify里
                    //判断执行是否成功
                    if (modify) {
                        JOptionPane.showMessageDialog(frame, "密码修改成功", "提示", JOptionPane.WARNING_MESSAGE);
                        frame.dispose();
                        ManagerMain jframeMain = new ManagerMain();
                        jframeMain.go();
                    } else {
                        //将信息展示
                        JOptionPane.showMessageDialog(null, "failed");
                    }
                }
            }
        });

    }

    //获取输入框输入
    public void findjtext() {
        strpwd0 = pwd0.getText().toString();
        strpwd1 = pwd1.getText().toString();
    }

}