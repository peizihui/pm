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
