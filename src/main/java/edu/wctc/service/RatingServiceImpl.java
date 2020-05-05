package edu.wctc.service;

import edu.wctc.dao.RatingDAO;
import edu.wctc.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingDAO ratingDAO;

    @Override
    @Transactional
    public void saveRating(Rating theRating) {
        ratingDAO.saveRating(theRating);
    }

    @Override
    @Transactional
    public void deleteRating(int theID) {
        ratingDAO.deleteRating(theID);
    }
}
