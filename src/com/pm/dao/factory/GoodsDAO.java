package com.pm.dao.factory;

import com.pm.dao.datasource.Goods;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class GoodsDAO {
    private Session session;

    public GoodsDAO(Session session){
        this.session = session;
    }

    public List<Goods> getAllGoods(){
        Query<Goods> query = session.createQuery("from Goods",Goods.class);
        return query.getResultList();
    }

    public Goods getGoodsByID(int id){
        Query query = session.createQuery("from Goods where id = ?1");
        query.setParameter(1,id);
        return (Goods) query.uniqueResult();
    }

    public void deleGoods(Goods goods){
        session.delete(goods);
    }

    public void deleGoodsByID(int id){
        Query query = session.createQuery("update Goods set isDele = 1 where id = ?1");
        query.setParameter(1,id);
        query.executeUpdate();
    }

    public Goods getGoodsByGoodsId(String goodsId){
        Query query = session.createQuery("from Goods where goodsId = ?1");
        query.setParameter(1,goodsId);
        return (Goods) query.uniqueResult();
    }

    public void insertGoods(Goods goods){
        session.save(goods);
    }

    public void updateGoods(Goods goods) {
        Query query = session.createQuery(
                "update Goods set goodsId = ?1, " +
                        "goodsName = ?2, " +
                        "goodsPrice = ?3 where id = ?4");
        query.setParameter(1, goods.getGoodsId());
        query.setParameter(2, goods.getGoodsName());
        query.setParameter(3, goods.getGoodsPrice());
        query.setParameter(4, goods.getId());
        query.executeUpdate();
    }
}
