package com.pm.ui.manager;

import com.pm.dao.datasource.User;
import com.pm.dao.factory.UserDAO;
import com.pm.process.UserProcess;
import org.hibernate.Session;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MUser extends JFrame {
    private static final long serialVersionUID = 9527L;
    private JPanel pane;
    private JPanel pane2;
    private JTable table;
    private JButton addpoint;
    private JButton adduser;
    private JButton freezeuser;
    private JButton stopfrzee;
    private JButton updatepwd;
    private JFrame mainFrame;
    private Object[][] data;
    private Session session;
    private UserDAO userDAO;

    public MUser() {
        pane = new JPanel();
        pane2 = new JPanel();

        addpoint = new JButton("积分充值");
        adduser = new JButton("添加用户");
        freezeuser = new JButton("冻结用户");
        stopfrzee = new JButton("解冻用户");
        updatepwd = new JButton("修改密码");

        //设置表格
        String[] columnNames = {"ID", "用户名", "密码", "账户状态"};

        table = new JTable(data, columnNames);
        table.setModel(new DefaultTableModel(data, columnNames));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(300, 600);
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        pane.add(Box.createGlue()); // 挤占用户管理按钮和窗口左侧空间
        pane.add(addpoint);
        pane.add(Box.createHorizontalStrut(20));// 按钮之间的水平距离
        pane.add(adduser);
        pane.add(Box.createHorizontalStrut(20));
        pane.add(freezeuser);
        pane.add(Box.createHorizontalStrut(20));
        pane.add(stopfrzee);
        pane.add(Box.createHorizontalStrut(20));
        pane.add(updatepwd);
        pane.add(Box.createGlue());
        pane2.add(scrollPane);

        add(pane);
        add(pane2);
        setTitle("用户管理界面");// 标题
        setSize(600, 600);// 窗口大小
        setLayout(new GridLayout(3, 1));
        setResizable(false);
        setLocationRelativeTo(null);// 窗口居中
        this.setVisible(true);

    }

    public void go() {
        showData();
        adduser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MUser.this.dispose();
                AddUser addUser = new AddUser();
                addUser.Main();
            }
        });

        freezeuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                int ID = Integer.valueOf(id);

                UserProcess userProcess = new UserProcess();
                userProcess.frzzeeUserByID(ID);
            }
        });
        stopfrzee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                int ID = Integer.valueOf(id);

                UserProcess userProcess = new UserProcess();
                userProcess.stopfrzzeeUserByID(ID);
            }
        });
        updatepwd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                int ID = Integer.valueOf(id);
                String pwd = "12";
                EditPwd editPwd = new EditPwd();
                editPwd.Main(ID,pwd);

            }
        });
        addpoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                int ID = Integer.valueOf(id);

                int addValue=0;

                PointsRecharge pointsRecharge = new PointsRecharge();
                pointsRecharge.Main(addValue,ID);
            }
        });
    }

    /***
     *显示所有用户信息
     */
    public void showData() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);

        UserProcess userProcess = new UserProcess();
        List<User> usersList = userProcess.getAllUsers();

        for (User user : usersList) {
            Vector v = new Vector();
            v.add(user.getId());
            v.add(user.getUserName());
            v.add(user.getUserPwd());
            v.add(user.getIsFreeze());
            defaultTableModel.addRow(v);
        }
    }
}
