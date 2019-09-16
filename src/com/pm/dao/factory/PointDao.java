package com.pm.dao.factory;

import com.pm.dao.datasource.Point;
import com.pm.dao.datasource.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PointDao {
    private Session session;

    public PointDao(Session session) {
        this.session = session;
    }

    public Point getPointByID(int id) {
        Query query = session.createQuery("from Point where id = ?1");
        query.setParameter(1, id);
        return (Point) query.uniqueResult();
    }

    //增加积分
    public void maddpoints(int updatetotal, int id) {
        Query query = session.createQuery("update Point set pointValue =?1 where id=?2");
        query.setParameter(1, updatetotal);
        query.setParameter(2, id);
        query.executeUpdate();
    }

    public List<Point> getAllPoint() {
        Query<Point> query = session.createQuery("from Point", Point.class);
        return query.getResultList();
    }

    public void insertUsertopoint(Point b) {
        session.save(b);
    }
}
