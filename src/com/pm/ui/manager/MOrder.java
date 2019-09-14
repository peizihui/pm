package com.pm.ui.manager;

import com.pm.dao.datasource.Goods;
import com.pm.dao.datasource.Order;
import com.pm.dao.factory.GoodsDAO;
import com.pm.process.GoodsProcess;
import com.pm.process.OrderProcess;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;

public class MOrder {

    private JFrame jFrame;
    private JPanel jPanelSearch,jPanelTable,jPanelButton;
    private JTextField searchText;
    private JTable jTable;
    private JScrollPane scrollPane;
    private JButton topPage,lastPage,nextPage,endPage,searchButton;
    private Object[][] data;

    public MOrder() {
        //按钮
        searchButton = new JButton("查询");
        topPage = new JButton("首页");
        lastPage = new JButton("上一页");
        nextPage = new JButton("下一页");
        endPage = new JButton("尾页");

        searchText = new JTextField(10);

        jPanelSearch = new JPanel();
        jPanelTable = new JPanel();
        jPanelButton = new JPanel();


//订单表格
        String[] columnNames={"订单ID","下单时间","完成时间","订单状态","购买商品","下单用户"};

        jTable = new JTable(data,columnNames);
        jTable.setModel(new DefaultTableModel(data,columnNames));
        jTable.setFillsViewportHeight(true);
        jTable.setAutoCreateRowSorter(true);

        scrollPane = new JScrollPane(jTable);
        scrollPane.setSize(300,300);
//分页块
        jPanelButton.add(topPage);
        jPanelButton.add(lastPage);
        jPanelButton.add(nextPage);
        jPanelButton.add(endPage);

//查询块
        jPanelSearch.add(searchText);
        jPanelSearch.add(searchButton);
//表格块
        jPanelTable.add(scrollPane);
//分页



        jFrame = new JFrame("订单信息");
        jFrame.setSize(500,500);
        jFrame.setLayout(new GridLayout(3,1));
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(jPanelSearch);
        jFrame.add(jPanelTable);
        jFrame.add(jPanelButton);
        jFrame.setVisible(true);


    }

    public void go() {
        showData();

        searchButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        topPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        lastPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        nextPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        endPage.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }
    public void showData(){

        DefaultTableModel defaultTableModel =(DefaultTableModel)jTable.getModel();
        defaultTableModel.setRowCount(0);

        OrderProcess orderProcess = new OrderProcess();
        List<Order> orderList = orderProcess.getAllOrder();

        for (Order order : orderList){
            Vector v = new Vector();
            v.add(order.getId());
            v.add(order.getCreateDate());
            v.add(order.getCompDate());
            v.add(order.getOsId());
            v.add(order.getgId());
            v.add(order.getUserId());
            defaultTableModel.addRow(v);
        }

    }
    public void  showTable(int currentPage){

    }
}
