package com.pm.dao.factory;

import com.pm.dao.datasource.VOrderinf;
import com.pm.dao.datasource.VOrderinfId;
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
    public VOrderinfId getOrderByOId1(int OId){
        Query query = session.createQuery("from VOrderinfId where oId = ?1");
        query.setParameter(1,OId);
        return (VOrderinfId)query.uniqueResult();
    }
    public List<VOrderinfId> getOrderByUId(int uId){
        Query query = session.createQuery("from VOrderinfId where  userId = ?1 and osType != '已删除'");
        query.setParameter(1,uId);
        return query.list();
    }
}
