package edu.wctc.service;

import edu.wctc.dao.EmojiDAO;
import edu.wctc.entity.Emoji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmojiServiceImpl implements EmojiService{
    @Autowired
    private EmojiDAO emojiDAO;

    @Override
    @Transactional
    public List<Emoji> getEmojis(){
        return emojiDAO.getEmojis();
    }

    @Override
    @Transactional
    public void saveEmoji(Emoji theEmoji, int imageId) {

        if (imageId != -1) {
            theEmoji.setImageId(imageId);
        }

        emojiDAO.saveEmoji(theEmoji);
    }

    @Override
    @Transactional
    public Emoji getEmoji(int theID) {
        return emojiDAO.getEmoji(theID);
    }

    @Override
    @Transactional
    public void deleteEmoji(int theID) {
        emojiDAO.deleteEmoji(theID);
    }

    @Override
    @Transactional
    public List<Emoji> getEmojisByName(String theSearchTerm) {
        return emojiDAO.getEmojisByName(theSearchTerm);
    }

}
