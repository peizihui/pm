package com.pm.process;

import com.pm.dao.datasource.VOrderinf;
import com.pm.dao.datasource.VOrderinfId;
import com.pm.dao.factory.OrderInfDAO;
import com.pm.util.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class OrderInfProcess {
    private Session session;
    private OrderInfDAO orderInfDAO;

    public OrderInfProcess(){
        session = HibernateUtils.getSession();
        orderInfDAO= new OrderInfDAO(session);
    }
    public List<VOrderinf> getAllOrderInf(){
        try {
            return orderInfDAO.getAllOrderInf();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }


    //修改上面的方法
    public List<VOrderinfId> getAllOrderInf1(){
        try {
            return orderInfDAO.getAllOrderInf1();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    public VOrderinf getOrderInfByOId(int OId){
        return orderInfDAO.getOrderByOId(OId);
    }
    public VOrderinfId getOrderInfByOId1(int OId){
        return orderInfDAO.getOrderByOId1(OId);
    }
    public List<VOrderinfId> getOrderInfByUId(int uId){
        return  orderInfDAO.getOrderByUId(uId);


    }
}
