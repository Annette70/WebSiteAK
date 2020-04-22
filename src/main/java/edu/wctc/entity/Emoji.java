package edu.wctc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "emoji")
public class Emoji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmojiID")
    private Integer id;

    @Column(name = "Emote")
    private String emote;

    @Column(name = "CharacterName")
    private String characterName;

    @Column(name = "RatingID")
    private Integer ratingID;

    @Column(name = "image_id")
    private Integer imageId;

    public Emoji(Integer id, String emote, String characterName, Integer ratingID){
        this.id = id;
        this.emote = emote;
        this.characterName = characterName;
    }
    public Emoji(){}

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "RatingID")
    private Rating rating;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name = "CharacterDetail",
            joinColumns = @JoinColumn(name = "CharacterName"),
            inverseJoinColumns = @JoinColumn(name = "CharacterName"))
    private List<CharacterDetail> characterDetailList;

    public void add(CharacterDetail tempCharacterDetail) {
        if (characterDetailList == null) {
            characterDetailList = new ArrayList<>();
        }
        characterDetailList.add(tempCharacterDetail);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmote() {
        return emote;
    }

    public void setEmote(String emote) {
        this.emote = emote;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Integer getRatingID() {
        return ratingID;
    }

    public void setRatingID(Integer ratingID) {
        this.ratingID = ratingID;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<CharacterDetail> getCharacterDetailList() {
        return characterDetailList;
    }

    public void setCharacterDetailList(List<CharacterDetail> characterDetailList) {
        this.characterDetailList = characterDetailList;
    }
}

