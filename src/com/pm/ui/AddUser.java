package com.pm.ui;


import com.pm.dao.datasource.User;
import com.pm.process.UserProcess;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import com.pm.dao.datasource.Student;
//import com.pm.process.StudentProcess;

public class AddUser extends JFrame {

    /**
     * 添加学生卡
     */

    private static final long serialVersionUID = 12312321321L;
    JLabel tid, tname, tpwd;//标签
    JTextField id, name, pwd;//文本
    JButton btnadd;//按钮
    JPanel jp1, jp2, jp3, jp4;//面板


    JPanel jpmain = new JPanel();
    JFrame frame = new JFrame();


    //获取输入框内的值
    String strid , strpwd;
    String strname;

    //界面方法
    public void Main() {
        //初始化面板
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();


        //将每一行的内容添加
        tid = new JLabel("输入id:");
        id = new JTextField(10);
        jp1.add(tid);
        jp1.add(id);

        tname = new JLabel("输入账户:");
        name = new JTextField(10);
        jp2.add(tname);
        jp2.add(name);

        tpwd = new JLabel("输入密码:");
        pwd = new JTextField(10);
        jp3.add(tpwd);
        jp3.add(pwd);

        btnadd = new JButton("Add");
        jp4.add(btnadd);

        //六行一列
        jpmain.setLayout(new GridLayout(4, 1));//网格式布局


        //将所有的面板加入主面板中
        //作用,在刷新界面时只需删除主面板即可
        jpmain.add(jp1);
        jpmain.add(jp2);
        jpmain.add(jp3);
        jpmain.add(jp4);


        //将主面板设置在界面上
        frame.add(jpmain);


        //设置窗体
        frame.setTitle("新增用户");//窗体标签
        frame.setSize(400, 250);//窗体大小
        frame.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出关闭JFrame
        frame.setVisible(true);//显示窗体


        //锁定窗体
        frame.setResizable(false);



      //设置按钮事件
        btnadd.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //获取输入框内容
                findjtext();

                //判断输入框是否为空
                if (strid.equals("") || strname.equals("") || strpwd.equals("")) {
                    JOptionPane.showMessageDialog(null, "请输入所有信息信息!", "提示", JOptionPane.WARNING_MESSAGE);
                }else{
                    //将输入框的值转入bean
                    User user = new User();
                    //创建service对象,
                    UserProcess userProcess = new UserProcess();
                    user.setId(strid);
                    user.setUserName(strname);
                    user.setUserPwd(strpwd);

                    //执行添加用户方法,并将返回值存储在news里
                    boolean news = userProcess.insertUser(user);

                    //判断执行是否成功
                    if (news) {
                        JOptionPane.showMessageDialog(frame, "添加成功", "提示", JOptionPane.WARNING_MESSAGE);
                        frame.dispose();
                        ManagerUI jframeMain = new ManagerUI();
                        jframeMain.Menu();
                    }else {
                        //将信息展示
                        JOptionPane.showMessageDialog(null, "failed");
                    }
                }
            }
        });

    }

    //获取输入框输入
    public void findjtext(){
        strid = id.getText().toString();
        strname = name.getText().toString();
        strpwd =  pwd.getText().toString();

    }
}