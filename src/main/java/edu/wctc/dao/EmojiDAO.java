package edu.wctc.dao;

import edu.wctc.entity.Emoji;

import java.util.List;

public interface EmojiDAO {
    List<Emoji> getEmojis();

    void saveEmoji(Emoji theEmoji);

    Emoji getEmoji(int theID);

    void deleteEmoji(int theID);

    List<Emoji> getEmojisByName(String theSearchTerm);
}
