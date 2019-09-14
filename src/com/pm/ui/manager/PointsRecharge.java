package com.pm.ui.manager;

import com.pm.process.PointProcess;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PointsRecharge extends JFrame {

    private static final long serialVersionUID = 12312321321L;
    JLabel tpoints;//标签
    JTextField apoints;//文本
    JButton btnadd;//按钮
    JPanel jp1, jp2;//面板

    JPanel jpmain = new JPanel();
    JFrame frame = new JFrame();

    //获取输入框内的值
    int addValue;

    //界面方法
    public void Main(int addValue, int id) {
        //初始化面板
        jp1 = new JPanel();
        jp2 = new JPanel();

        //将每一行的内容添加
        apoints = new JTextField(10);
        tpoints = new JLabel("输入积分值:");

        jp1.add(tpoints);
        jp1.add(apoints);

        btnadd = new JButton("submit");
        jp2.add(btnadd);

        //六行一列
        jpmain.setLayout(new GridLayout(2, 1));//网格式布局

        //将所有的面板加入主面板中
        //作用,在刷新界面时只需删除主面板即可
        jpmain.add(jp1);
        jpmain.add(jp2);

        //将主面板设置在界面上
        frame.add(jpmain);

        //设置窗体
        frame.setTitle("积分充值");//窗体标签
        frame.setSize(400, 150);//窗体大小
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
                if (addValue == 0) {
                    JOptionPane.showMessageDialog(null, "不能为空！", "提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    //创建service对象,
                    PointProcess pointProcess = new PointProcess();
                    Boolean modify = pointProcess.maddpoints(addValue, id);
                    //执行添加用户方法,并将返回值存储在news里
                    //判断执行是否成功
                    if (modify) {
                        JOptionPane.showMessageDialog(frame, "充值成功", "提示", JOptionPane.WARNING_MESSAGE);
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
        addValue = Integer.parseInt(apoints.getText());
    }

}