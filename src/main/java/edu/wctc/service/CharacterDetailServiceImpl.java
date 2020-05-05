package edu.wctc.service;

import edu.wctc.dao.CharacterDetailDAO;
import edu.wctc.entity.CharacterDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CharacterDetailServiceImpl implements CharacterDetailService{
    @Autowired
    private CharacterDetailDAO characterDetailDAO;

    @Override
    @Transactional
    public void saveCharacterDetail(CharacterDetail theDetail) {
        characterDetailDAO.saveCharacterDetail(theDetail);
    }

    @Override
    @Transactional
    public void deleteCharacterDetail(String theName) {
        characterDetailDAO.deleteCharacterDetail(theName);
    }
}
