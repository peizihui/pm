package com.pm.process;

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
    public List<VOrderinfId> getAllOrderInf(){
        try {
            return orderInfDAO.getAllOrderInf();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
    public VOrderinfId getOrderInfByOId(int OId){
        return orderInfDAO.getOrderByOId(OId);
    }

    public List<VOrderinfId> getUserInf(){
        try {
            return orderInfDAO.getAllOrderInfGroupByUserName();
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
