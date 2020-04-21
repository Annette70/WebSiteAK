package edu.wctc.dao;

import edu.wctc.entity.Rating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class RatingDAOImpl implements RatingDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveRating(Rating theRating) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theRating);
    }

    @Override
    public void deleteRating(int theID) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from CharacterDetail where id = :doomedRating");

        query.setParameter("doomedRating", theID);

        query.executeUpdate();
    }
}
