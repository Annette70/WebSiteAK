package edu.wctc.controller;

import edu.wctc.entity.Image;
import edu.wctc.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageService imageService;


    @RequestMapping("/display")
    public void showImage(@RequestParam("id") Integer id, HttpServletResponse response) throws IOException {
        Image imageData = imageService.getImage(id);

        response.setContentType(imageData.getMimeType());

        response.getOutputStream().write(imageData.getFile());
        response.getOutputStream().close();
    }
}
