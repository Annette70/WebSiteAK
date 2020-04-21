package edu.wctc.dao;

import edu.wctc.entity.CharacterDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CharacterDetailDAOImpl implements CharacterDetailDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCharacterDetail(CharacterDetail theDetail) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theDetail);
    }

    @Override
    public void deleteCharacterDetail(String theName) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from CharacterDetail where id = :doomedCharacterName");

        query.setParameter("doomedCharacterName", theName);

        query.executeUpdate();
    }
}
