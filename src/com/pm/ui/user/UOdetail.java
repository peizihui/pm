package com.pm.ui.user;

import com.pm.dao.datasource.Order;
import com.pm.dao.datasource.VOrderinf;
import com.pm.dao.datasource.VOrderinfId;

import javax.swing.*;
import java.awt.*;

public class UOdetail extends JFrame {
    private VOrderinfId vo;

    public UOdetail(VOrderinfId vo){
        this.vo = vo;
        this.setLayout(new GridLayout(7,2));   /*设置布局，三行三列*/
        this.setPreferredSize(new Dimension(270, 350));//设置大小
        this.setTitle("订单详情");

        this.pack();
        this.setLocationRelativeTo(null);
        JButton but=new JButton("订单号");
        JLabel jLabel= new JLabel(vo.getOrderId());
        JButton but1=new JButton("用户名");
        JLabel jLabel1=new JLabel(vo.getUserName());
        JButton but2=new JButton("商品名");
        JLabel jLabel2=new JLabel(vo.getGoodsName());
        JButton but3=new JButton("兑换价格");
        JLabel jLabel3 = new JLabel(vo.getGoodsPrice()+"");

        JButton but4=new JButton("创建时间");
        JLabel jLabel4=new JLabel(vo.getCreateDate()+"");
        JButton but5=new JButton("完成时间");
        JLabel jLabel5=new JLabel(vo.getCompDate()+"");
        JButton but6=new JButton("订单状态");
        JLabel jLabel6=new JLabel(vo.getOsType());
        add(but);
        add(jLabel);
        add(but1);
        add(jLabel1);
        add(but2);
        add(jLabel2);
        add(but3);
        add(jLabel3);
        add(but4);
        add(jLabel4);
        add(but5);
        add(jLabel5);

        add(but6);
        add(jLabel6);
    }
    public void go(){
        this.setVisible(true);//设置dialog显示
    };
}

