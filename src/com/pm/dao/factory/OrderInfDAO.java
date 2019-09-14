package com.pm.dao.factory;

import com.pm.dao.datasource.VOrderinf;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OrderInfDAO {
    private Session session;

    public OrderInfDAO(Session session){this.session = session;}

    public List<VOrderinf> getAllOrderInf(){
        Query<VOrderinf> query = session.createQuery("from  VOrderinf ",VOrderinf.class);
        return query.getResultList();
    }
    public VOrderinf getOrderByOId(int OId){
        Query query = session.createQuery("from VOrderinf where oId = ?1");
        query.setParameter(1,OId);
        return (VOrderinf)query.uniqueResult();
    }
}
