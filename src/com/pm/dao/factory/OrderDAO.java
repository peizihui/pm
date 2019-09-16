package com.pm.dao.factory;

import com.pm.dao.datasource.Order;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDAO {
    private Session session;

    public OrderDAO(Session session){
        this.session = session;
    }
    public List<Order>getAllOrder(){
        Query<Order>query = session.createQuery("from Order",Order.class);
        return query.getResultList();
    }
    public Order getOrderById(int id){
        Query query = session.createQuery("from Order where id = ?1");
        query.setParameter(1,id);
        return (Order)query.uniqueResult();
    }
    //根据UserId获取订单
    public List<Order> getOrderByUserId(int userId){
        Query query = session.createQuery("from Order where userId = ?1");
        query.setParameter(1,userId);
        List<Order> list = query.list();
        return list;
    }
    public void frozenOrderById(Order id){
        Query query = session.createQuery("update Order set osId = 5 where id = ?1");
        query.setParameter(1,id);
    }

}
