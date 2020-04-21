package edu.wctc.dao;

import edu.wctc.entity.Image;

public interface ImageDAO {
    void delete(int id);

    void deleteUnusedImages();

    Image getImage(int imageId);

    int saveImage(Image imageData);
}
