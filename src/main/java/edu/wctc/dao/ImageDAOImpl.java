package edu.wctc.dao;

import edu.wctc.entity.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDAOImpl implements ImageDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();

        session.delete(getImage(id));
    }

    @Override
    public void deleteUnusedImages() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Image where id not in (select imageId from Donut)");

        query.executeUpdate();
    }

    @Override
    public Image getImage(int imageId) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Image.class, imageId);
    }

    @Override
    public int saveImage(Image imageData) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(imageData);

        return imageData.getId();
    }
}
