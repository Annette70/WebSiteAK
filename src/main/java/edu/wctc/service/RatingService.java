package edu.wctc.service;

import edu.wctc.entity.Rating;

public interface RatingService {
    void saveRating(Rating theRating);

    void deleteRating(int theID);
}
