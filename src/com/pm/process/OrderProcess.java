package com.pm.process;

import com.pm.dao.datasource.Goods;
import com.pm.dao.datasource.Order;
import com.pm.dao.factory.GoodsDAO;
import com.pm.dao.factory.ManagerDAO;
import com.pm.dao.factory.OrderDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;

import javax.transaction.*;
import java.util.List;

public class OrderProcess {

    private Session session;
    private ManagerDAO managerDAO;
    private OrderDAO orderDAO;
    private Transaction transaction;
    public OrderProcess(){

        session = HibernateUtils.getSession();
        managerDAO = new ManagerDAO(session);
        orderDAO = new OrderDAO(session);
    }
    public List<Order>getAllOrder(){
        try {
            return orderDAO.getAllOrder();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Order>getOrderById(int id){
        try {
            return (List<Order>) orderDAO.getOrderById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //上面的似乎有点问题
    public Order getOrderByID(int id){
        try {
            return orderDAO.getOrderById(id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //通过UserID获取Order对象
    public List<Order>getOrderByUserId(int userId){
        try {
            return orderDAO.getOrderByUserId(userId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //取消订单
//  id	os_type
//  1	未支付
//  2	已发货
//  3	已完成
//  4	无效
//  5	已删除
//  6	已取消

    public boolean cancelOrder(int orderId){
        org.hibernate.Transaction tx= session.beginTransaction();
        try {
            orderDAO.updateOrderStatus(orderId,6);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
            return false;
        }

    }
    //删除订单
    public boolean deleteOrder(int orderId){
        org.hibernate.Transaction tx= session.beginTransaction();
        try {
            orderDAO.updateOrderStatus(orderId,5);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());return false;
        }

    }
    public boolean frozenOrderById(int id) throws SystemException {
        Transaction transaction = (Transaction) session.beginTransaction();
        try {
            Order order = orderDAO.getOrderById(id);
            orderDAO.frozenOrderById(order);
            transaction.commit();
            return true;
        } catch (SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
            transaction.rollback();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
