package com.pm.ui.manager;

import com.pm.dao.datasource.Goods;
import com.pm.process.GoodsProcess;
//import com.pm.util.Event;
import com.pm.util.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGoods{

    private String goodsId = "";
    private String goodsName = "";
    private int goodsPrice;

    private JFrame mainFrame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;


    private JTextField goodsIdText;
    private JTextField goodsNameText;
    private JTextField goodsPriceText;

    private JLabel goodsIdLabel;
    private JLabel goodsNameLabel;
    private JLabel goodsPriceLabel;

    private JButton confirmButton;
    private JButton cancelButton;

    public AddGoods() {
        //初始化窗口
        goodsIdLabel = new JLabel("商品编号(条形码编号)");
        goodsIdText = new JTextField(13);
        goodsNameLabel = new JLabel("商品名");
        goodsNameText = new JTextField(10);
        goodsPriceLabel = new JLabel("兑换价格");
        goodsPriceText = new JTextField(10);

        confirmButton = new JButton("确定");
        cancelButton = new JButton("取消");

        //组合组件
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        panel1.add(goodsIdLabel);
        panel1.add(goodsIdText);
        panel2.add(goodsNameLabel);
        panel2.add(goodsNameText);
        panel3.add(goodsPriceLabel);
        panel3.add(goodsPriceText);
        panel4.add(confirmButton);
        panel4.add(cancelButton);

        mainFrame = new JFrame("上架商品");

        mainFrame.setSize(300,200);
        mainFrame.setBounds(600,200,300,220);
        mainFrame.setLayout(new GridLayout(4,1));
        mainFrame.setResizable(false);

        //添加组件
        mainFrame.add(panel1);
        mainFrame.add(panel2);
        mainFrame.add(panel3);
        mainFrame.add(panel4);
        mainFrame.setVisible(true);
    }

    public void go() {

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()){
                    Goods goods = new Goods();
                    goods.setGoodsId(goodsId);
                    goods.setGoodsName(goodsName);
                    goods.setGoodsPrice(goodsPrice);

                    GoodsProcess goodsProcess = new GoodsProcess();
                    boolean c = goodsProcess.saveGoods(goods);

                    if (c){
                        JOptionPane.showMessageDialog(null,
                                "添加成功！",
                                "注意",
                                JOptionPane.WARNING_MESSAGE);
                        mainFrame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "添加失败！",
                                "注意",
                                JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });

        cancelButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });

    }

    public boolean check(){
        goodsId = goodsIdText.getText();
        goodsName = goodsNameText.getText();
        goodsPrice = Integer.parseInt(goodsPriceText.getText());

        boolean c = new Tools().isALLIntger(goodsId);

        if (goodsId.length() != 13 || !c) {
            JOptionPane.showMessageDialog(null,
                    "请输入正确的13位条形码！",
                    "注意",
                    JOptionPane.WARNING_MESSAGE);
        } else if (goodsName.equals("")) {
            JOptionPane.showMessageDialog(null,
                    "请输入商品名！",
                    "注意",
                    JOptionPane.WARNING_MESSAGE);
        } else if(goodsPrice < 0){
            JOptionPane.showMessageDialog(null,
                    "兑换价格错误！",
                    "注意",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            return true;
        }
        return false;
    }

    //获取主窗口属性
    public Object getFrame(){
        return this.mainFrame;
    }
}
