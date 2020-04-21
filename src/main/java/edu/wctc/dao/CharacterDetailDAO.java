package edu.wctc.dao;

import edu.wctc.entity.CharacterDetail;

public interface CharacterDetailDAO {
    void saveCharacterDetail(CharacterDetail theDetail);

    void deleteCharacterDetail(String theName);
}
