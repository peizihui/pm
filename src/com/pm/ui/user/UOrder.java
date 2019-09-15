package com.pm.ui.user;

import com.pm.dao.datasource.*;
import com.pm.dao.factory.UserDAO;
import com.pm.process.GoodsProcess;
import com.pm.process.OrderInfProcess;
import com.pm.process.OrderProcess;
import com.pm.process.UserProcess;
import com.pm.ui.manager.PointsRecharge;
import org.hibernate.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.transaction.SystemException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class UOrder extends JFrame{
    private static final long serialVersionUID = 9527L;
    private JPanel pane;
    private JPanel pane2;
    private JTable table;
    private JButton detail;
    private JButton cancel;
    private JButton delete;
    private Object[][] data;
    private User user;
    public UOrder(User user) {
        this.user = user;


        pane = new JPanel();
        pane2 = new JPanel();

        detail = new JButton("详细信息");
        cancel = new JButton("取消订单");
        delete = new JButton("删除订单");

        //设置表格
        String[] columnNames = {"ID", "订单号", "商品名", "状态"};

        table = new JTable(data, columnNames);
        table.setModel(new DefaultTableModel(data, columnNames));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(300, 600);
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);

        pane.add(Box.createGlue()); // 挤占用户管理按钮和窗口左侧空间
        pane.add(detail);
        pane.add(Box.createHorizontalStrut(20));// 按钮之间的水平距离
        pane.add(cancel);
        pane.add(Box.createHorizontalStrut(20));
        pane.add(delete);
        pane.add(Box.createGlue());
        pane2.add(scrollPane);

        add(pane);
        add(pane2);
        setTitle("我的订单");// 标题
        setSize(600, 600);// 窗口大小
        setLayout(new GridLayout(3, 1));
        setResizable(false);
        setLocationRelativeTo(null);// 窗口居中
        this.setVisible(true);

    }

    public void go() {
        showData();
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UOrder.this.dispose();
                String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                int ID = Integer.valueOf(id);
                OrderProcess op = new OrderProcess();
                op.cancelOrder(ID);

                showData();


            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UOrder.this.dispose();
                String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                int ID = Integer.valueOf(id);
                OrderProcess op = new OrderProcess();
                op.deleteOrder(ID);
                showData();

            }
        });

        detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UOrder.this.dispose();
                String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                int ID = Integer.valueOf(id);
                OrderInfProcess op = new OrderInfProcess();
                ;
                UOdetail UO = new UOdetail(op.getOrderInfByOId1(ID));
                UO.go();
            }

        });
    }

    /***
     *显示所有用户信息
     */
    public void showData() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);

        OrderInfProcess op = new OrderInfProcess();
        List<VOrderinfId> OrderList = op.getOrderInfByUId(user.getId());
        for (VOrderinfId order : OrderList) {
            Vector v = new Vector();
            v.add(order.getoId());
            v.add(order.getOrderId());
            v.add(order.getGoodsName());
            v.add(order.getOsType());
            defaultTableModel.addRow(v);
        }
    }
}
