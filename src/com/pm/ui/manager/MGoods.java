package com.pm.ui.manager;

import com.pm.dao.datasource.Goods;
import com.pm.process.GoodsProcess;
import com.pm.util.Page;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Vector;

public class MGoods {
    private JPanel jp1;
    private JPanel jp2;
    private JPanel jp3;
    private JTable table;
    private JButton addGoodsButton;
    private JButton editGoodsButton;
    private JButton deleGoodsButton;
    private JButton refreshButton;
    private JButton fristPageButton;
    private JButton nextPageButton;
    private JButton previousPageButton;
    private JButton lastPageButton;
    private JFrame mainFrame;
    private int currentPage;
    private int fristPage;
    private int lastPage;
    private int tableRows;
    private List<Goods> goodsList;

    public MGoods() {
        addGoodsButton = new JButton("上架商品");
        editGoodsButton = new JButton("修改商品信息");
        deleGoodsButton = new JButton("删除商品");
        refreshButton = new JButton("刷新");
        fristPageButton = new JButton("首页");
        previousPageButton = new JButton("上一页");
        nextPageButton = new JButton("下一页");
        lastPageButton = new JButton("末页");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();


        //设置表格
        String[] columnNames = {"ID", "商品编号", "商品名", "兑换价格"};

        table = new JTable(null, columnNames){
            //设置禁止编辑单元格
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(new DefaultTableModel(null, columnNames));

        JScrollPane scrollPane = new JScrollPane(table);
        //table.setFillsViewportHeight(true);
        //列排序功能
        //table.setAutoCreateRowSorter(true);
        //设置表格列不可移动
        table.getTableHeader().setReorderingAllowed(false);
        //行单选
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);




        jp1.add(addGoodsButton);
        jp1.add(editGoodsButton);
        jp1.add(deleGoodsButton);
        jp1.add(refreshButton);
        jp2.add(scrollPane);
        jp3.add(fristPageButton);
        jp3.add(previousPageButton);
        jp3.add(nextPageButton);
        jp3.add(lastPageButton);

        mainFrame = new JFrame("商品管理");
        mainFrame.setSize(500,500);
        mainFrame.setLayout(new GridLayout(3,1));
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        //添加组件

        mainFrame.add(jp1);
        mainFrame.add(jp2);
        mainFrame.add(jp3);
        mainFrame.setVisible(true);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getFristPage() {
        return fristPage;
    }

    public void setFristPage(int fristPage) {
        this.fristPage = fristPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public void go() {
        setGoodsList();

        initPageNumber();

        showData();

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showData();
            }
        });

        addGoodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddGoods addGoods = new AddGoods();
                addGoods.go();

                //获取子窗口，添加窗口监听当子窗口关闭后刷新table数据
                JFrame frame = (JFrame) addGoods.getFrame();
                frame.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {

                    }

                    @Override
                    public void windowClosing(WindowEvent e) {

                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        setCurrentPage(getLastPage());
                        showData();
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });
            }
        });

        editGoodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = table.getValueAt(table.getSelectedRow(),0).toString();
                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "请选择商品！",
                            "注意",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    int ID = Integer.parseInt(id);
                    EditGoods editGoods = new EditGoods();
                    editGoods.go(ID);
                    //获取子窗口，添加窗口监听当子窗口关闭后刷新table数据
                    JFrame frame = (JFrame) editGoods.getFrame();
                    frame.addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {

                        }

                        @Override
                        public void windowClosing(WindowEvent e) {

                        }

                        @Override
                        public void windowClosed(WindowEvent e) {
                            showData();
                        }

                        @Override
                        public void windowIconified(WindowEvent e) {

                        }

                        @Override
                        public void windowDeiconified(WindowEvent e) {

                        }

                        @Override
                        public void windowActivated(WindowEvent e) {

                        }

                        @Override
                        public void windowDeactivated(WindowEvent e) {

                        }
                    });
                }
            }
        });

        deleGoodsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                GoodsProcess goodsProcess = new GoodsProcess();

                int result=JOptionPane.showConfirmDialog(null, "是否删除该商品？");
                if(result==0){

                    //获取选中行的id
                    String id = table.getValueAt(table.getSelectedRow(),0).toString();

                    int ID = Integer.parseInt(id);
                    boolean c = goodsProcess.deleGoods(ID);
                    if (c) {
                        //刷新表格
                        showData();
                        JOptionPane.showMessageDialog(null,
                                "删除成功！",
                                "注意",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "删除失败！",
                                "注意",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        fristPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentPage(fristPage);
                showData();
            }
        });

        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getCurrentPage() > getFristPage()){
                    setCurrentPage(currentPage - 1);
                    showData();
                }else{
                    setCurrentPage(getFristPage());
                    showData();
                }
            }
        });

        nextPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getCurrentPage() < getLastPage()){
                    setCurrentPage(currentPage + 1);
                    showData();
                }else{
                    setCurrentPage(lastPage);
                    showData();
                }
            }
        });

        lastPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentPage(lastPage);
                showData();
            }
        });
    }

    public void initPageNumber(){

        this.fristPage = 1;
        this.tableRows = 8;
        this.currentPage = fristPage;

        if(this.goodsList.size() % this.tableRows ==0){
            this.lastPage = this.goodsList.size() / this.tableRows;
        }else{
            this.lastPage = this.goodsList.size() / this.tableRows + 1;
        }
    }

    public void setGoodsList(){
        GoodsProcess goodsProcess = new GoodsProcess();
        this.goodsList = goodsProcess.getGoods();
    }

    /***
     *显示所有商品信息
     */
    public void showData(){
        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);

        //列表分页
        Page page = new Page(tableRows);
        List<Goods> list =  page.cutList(currentPage, goodsList);

        for(Goods goods : list){
            Vector v = new Vector();
            if (goods.getIsDele() == 0){
                v.add(goods.getId());
                v.add(goods.getGoodsId());
                v.add(goods.getGoodsName());
                v.add(goods.getGoodsPrice());
                defaultTableModel.addRow(v);
            }
        }
    }
}
