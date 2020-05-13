package edu.wctc.dao;

import edu.wctc.entity.Emoji;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmojiDAOImpl implements EmojiDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Emoji> getEmojis(){
        Session session = sessionFactory.getCurrentSession();

        List<Emoji> emojiList = session.createQuery("from Emoji", Emoji.class).getResultList();

        return emojiList;
    }

    @Override
    public void saveEmoji(Emoji theEmoji) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theEmoji);
    }

    @Override
    public Emoji getEmoji(int theID) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Emoji.class, theID);
    }

    @Override
    public void deleteEmoji(int theID) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theID);
    }

    @Override
    public List<Emoji> getEmojisByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        // Add wildcards and make search term lowercase (for case insensitivity)
        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        Query<Emoji> query = session.createQuery("from Emoji where lower(characterDetail.name) like :nameToSearch");
        query.setParameter("nameToSearch", theSearchTerm);

        return query.getResultList();
    }
}
