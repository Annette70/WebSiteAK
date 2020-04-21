package edu.wctc.dao;

import edu.wctc.entity.Rating;

public interface RatingDAO {
    void saveRating(Rating theRating);

    void deleteRating(int theID);
}
