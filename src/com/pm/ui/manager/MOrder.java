package com.pm.ui.manager;

import com.pm.dao.datasource.VOrderinfId;
import com.pm.process.OrderInfProcess;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Vector;

public class MOrder {

    private JFrame jFrame;
    private JPanel jPanelTable,jPanelButton;
    private JTable jTable;
    private JScrollPane scrollPane;
    private JButton topPage,lastPage,nextPage,endPage,operationButton;
    private Object[][] data;

    public MOrder() {
        //按钮
        operationButton = new JButton("操作");
        topPage = new JButton("首页");
        lastPage = new JButton("上一页");
        nextPage = new JButton("下一页");
        endPage = new JButton("尾页");

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
        jPanelButton.add(operationButton);

//表格块
        jPanelTable.add(scrollPane);
//分页

        jFrame = new JFrame("订单信息");
        jFrame.setSize(500,500);
        jFrame.setLayout(new GridLayout(2,1));
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(jPanelTable);
        jFrame.add(jPanelButton);
        jFrame.setVisible(true);


    }

    public void go() {

        showData();

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
        operationButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }
    public void showData(){

        DefaultTableModel defaultTableModel =(DefaultTableModel)jTable.getModel();
        defaultTableModel.setRowCount(0);

        OrderInfProcess orderInfProcess = new OrderInfProcess();
        List<VOrderinfId> vOrderinfIdList = orderInfProcess.getAllOrderInf1();

        for (VOrderinfId vOrderinfId : vOrderinfIdList){
            Vector v = new Vector();
            v.add(vOrderinfId.getoId());
            v.add(vOrderinfId.getCreateDate());
            v.add(vOrderinfId.getCompDate());
            v.add(vOrderinfId.getOsType());
            v.add(vOrderinfId.getGoodsName());
            v.add(vOrderinfId.getUserName());
            defaultTableModel.addRow(v);
        }

    }
    public void  showTable(int currentPage){

    }
}
