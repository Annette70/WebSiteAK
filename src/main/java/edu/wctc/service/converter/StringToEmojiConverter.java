package edu.wctc.service.converter;

import edu.wctc.entity.Emoji;
import edu.wctc.service.EmojiService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.convert.converter.Converter;

public class StringToEmojiConverter implements Converter<String, Emoji> {
    @Autowired
    private EmojiService emojiService;

    @Override
    public Emoji convert(String source){
        int emojiID = Integer.parseInt(source);
        Emoji aEmoji = emojiService.getEmoji(emojiID);

        return aEmoji;
    }

}
