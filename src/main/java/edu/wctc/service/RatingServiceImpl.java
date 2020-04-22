package edu.wctc.service;

import edu.wctc.entity.Rating;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveRating(Rating theRating) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theRating);
    }

    @Override
    @Transactional
    public void deleteRating(int theID) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from CharacterDetail where id = :doomedRating");

        query.setParameter("doomedRating", theID);

        query.executeUpdate();
    }
}
