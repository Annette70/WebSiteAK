package edu.wctc.service;

import edu.wctc.entity.CharacterDetail;

public interface CharacterDetailService {
    void saveCharacterDetail(CharacterDetail theDetail);

    void deleteCharacterDetail(String theName);
}
