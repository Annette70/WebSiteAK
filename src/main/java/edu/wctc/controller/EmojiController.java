package edu.wctc.controller;

import edu.wctc.service.ImageServiceImpl;
import edu.wctc.entity.Emoji;
import edu.wctc.service.CharacterDetailService;
import edu.wctc.service.EmojiService;
import edu.wctc.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/emoji")
public class EmojiController {
    @Autowired
    private CharacterDetailService characterDetailService;

    @Autowired
    private EmojiService emojiService;

    @Autowired
    private RatingService ratingService;

    @GetMapping("/list4")
    public String listDonuts(Model theModel) {
        List<Emoji> emojiList = emojiService.getEmojis();

        theModel.addAttribute("emojis", emojiList);

        return "list-emojis";
    }

    @RequestMapping("/user/showAddEmojiForm")
    public String showAddEmojiForm(Model theModel) {
        Emoji theEmoji = new Emoji();

        theModel.addAttribute("aEmoji", theEmoji);

        theModel.addAttribute("emojis", emojiService.getEmojis())

        return "emoji-form";
    }

    @RequestMapping("/showUpdateEmojiForm")
    public String showUpdateEmojiForm(@RequestParam ("emojiID") int theID, Model theModel){
        Emoji theEmoji = emojiService.getEmoji(theID);

        theModel.addAttribute("aEmoji", theEmoji);

        return "emoji-form";
    }

    @PostMapping("/save")
    public String saveEmoji(@RequestParam("imageFile") MultipartFile file,
                            @Valid @ModelAttribute("emoji") Emoji theEmoji,
                            BindingResult bindingResult,
                            Model theModel){
        if (bindingResult.hasErrors()){
            System.err.println(bindingResult);

            theModel.addAttribute("aEmoji", theEmoji);

            return "emoji-form";
        }
        int imageId = imageService.saveImage(file);

        emojiService.saveEmoji(theEmoji);

        imageService.deleteUnusedImages();

        return "redirect:/emoji/list4";
    }

    @GetMapping

}
