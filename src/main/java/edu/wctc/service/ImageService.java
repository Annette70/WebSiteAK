package edu.wctc.service;

import edu.wctc.entity.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void delete(int id);

    void deleteUnusedImages();

    Image getImage(Integer imageId);

    int saveImage(MultipartFile file);
}
