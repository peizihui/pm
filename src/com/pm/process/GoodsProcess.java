package com.pm.process;

import com.pm.dao.datasource.Goods;
import com.pm.dao.factory.GoodsDAO;
import com.pm.dao.factory.ManagerDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GoodsProcess {

    private Session session;
    private GoodsDAO goodsDAO;

    public GoodsProcess() {
        //获取session
        session = HibernateUtils.getSession();
        //初始化
        goodsDAO = new GoodsDAO(session);
    }

    /***
     * 获取所有的商品信息，返回商品列表
     * @return
     */
    public List<Goods> getGoods(){
        try {
            return goodsDAO.getAllGoods();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 通过商品ID查询，返回商品信息
     * @param id
     * @return
     */
    public Goods getGoods(int id) {
        return goodsDAO.getGoodsByID(id);
    }

    /***
     * 通过商品ID删除商品
     * @param id
     * @return
     */
    public boolean deleGoods(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            goodsDAO.deleGoodsByID(id);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean saveGoods(Goods goods) {
        Transaction transaction = session.beginTransaction();
        try {
            goodsDAO.insertGoods(goods);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }




    public boolean updateGoods(Goods goods) {
        Transaction transaction = session.beginTransaction();
        try {
            goodsDAO.updateGoods(goods);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
