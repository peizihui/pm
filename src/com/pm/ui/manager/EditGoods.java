package com.pm.ui.manager;

import com.pm.dao.datasource.Goods;
import com.pm.process.GoodsProcess;
import com.pm.util.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditGoods {
    private int ID;
    private String goodsId = "";
    private String goodsName = "";
    private int goodsPrice;

    private JFrame mainFrame;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;

    private JTextField idText;
    private JTextField goodsIdText;
    private JTextField goodsNameText;
    private JTextField goodsPriceText;

    private JLabel idLabel;
    private JLabel goodsIdLabel;
    private JLabel goodsNameLabel;
    private JLabel goodsPriceLabel;

    private JButton confirmButton;
    private JButton cancelButton;


    public EditGoods() {
        //初始化窗口
        idLabel = new JLabel("ID");
        idText = new JTextField();
        idText.setEditable(false);
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
        panel5 = new JPanel();


        panel1.add(idLabel);
        panel1.add(idText);
        panel2.add(goodsIdLabel);
        panel2.add(goodsIdText);
        panel3.add(goodsNameLabel);
        panel3.add(goodsNameText);
        panel4.add(goodsPriceLabel);
        panel4.add(goodsPriceText);
        panel5.add(confirmButton);
        panel5.add(cancelButton);

        mainFrame = new JFrame("修改商品信息");

        mainFrame.setSize(300,200);
        mainFrame.setBounds(600,200,300,220);
        mainFrame.setLayout(new GridLayout(5,1));
        mainFrame.setResizable(false);

        //添加组件
        mainFrame.add(panel1);
        mainFrame.add(panel2);
        mainFrame.add(panel3);
        mainFrame.add(panel4);
        mainFrame.add(panel5);
        mainFrame.setVisible(true);
    }

    public void go(int id){
        this.ID = id;
        GoodsProcess goodsProcess = new GoodsProcess();
        Goods goods = goodsProcess.getGoodsById(ID);
        idText.setText(String.valueOf(goods.getId()));
        goodsIdText.setText(goods.getGoodsId());
        goodsNameText.setText(goods.getGoodsName());
        goodsPriceText.setText(String.valueOf(goods.getGoodsPrice()));

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (check()){
                    goods.setGoodsId(goodsId);
                    goods.setGoodsName(goodsName);
                    goods.setGoodsPrice(goodsPrice);

                    GoodsProcess goodsProcess = new GoodsProcess();
                    boolean c = goodsProcess.updateGoods(goods);

                    if (c){
                        JOptionPane.showMessageDialog(null,
                                "修改成功！",
                                "注意",
                                JOptionPane.WARNING_MESSAGE);
                        mainFrame.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "修改失败！",
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
}
