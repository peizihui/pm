package com.pm.dao.factory;

import com.pm.dao.datasource.VOrderinfId;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrderInfDAO {
    private Session session;

    public OrderInfDAO(Session session){this.session = session;}

    public List<VOrderinfId> getAllOrderInf(){
        Query<VOrderinfId> query = session.createQuery("from  VOrderinfId",VOrderinfId.class);
        return query.getResultList();
    }
    public VOrderinfId getOrderByOId(int OId){
        Query query = session.createQuery("from VOrderinfId where oId = ?1");
        query.setParameter(1,OId);
        return (VOrderinfId)query.uniqueResult();
    }

    public List<VOrderinfId> getAllOrderInfGroupByUserName(){
        Query<VOrderinfId> query = session.createQuery("from  VOrderinfId group by userName",VOrderinfId.class);
        return query.getResultList();
    }
}
