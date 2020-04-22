package edu.wctc.service;

import edu.wctc.entity.Emoji;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmojiServiceImpl implements EmojiService{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Emoji> getEmojis(){
        Session session = sessionFactory.getCurrentSession();

        List<Emoji> emojiList = session.createQuery("from Emoji", Emoji.class).getResultList();

        return emojiList;
    }

    @Override
    @Transactional
    public void saveEmoji(Emoji theEmoji) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theEmoji);
    }

    @Override
    @Transactional
    public Emoji getEmoji(int theID) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Emoji.class, theID);
    }

    @Override
    @Transactional
    public void deleteEmoji(int theID) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theID);
    }

    @Override
    @Transactional
    public List<Emoji> getEmojisByName(String theSearchTerm) {
        Session session = sessionFactory.getCurrentSession();

        // Add wildcards and make search term lowercase (for case insensitivity)
        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        Query<Emoji> query = session.createQuery("from Emoji where lower(characterName) like :nameToSearch");
        query.setParameter("nameToSearch", theSearchTerm);

        return query.getResultList();
    }
}
