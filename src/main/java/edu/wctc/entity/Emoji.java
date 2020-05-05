package edu.wctc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "emoji")
public class Emoji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmojiID")
    private Integer id;

    @Column(name = "Emote")
    private String emote;


    @Column(name = "imageid")
    private Integer imageId;

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "RatingID")
    private Rating rating;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "CharacterName")
    private CharacterDetail characterDetail;

    public Emoji(Integer id, String emote){
        this.id = id;
        this.emote = emote;
    }

    public Emoji(){}

    public CharacterDetail getCharacterDetail() {
        return characterDetail;
    }

    public void setCharacterDetail(CharacterDetail characterDetail) {
        this.characterDetail = characterDetail;
    }

    public String getEmote() {
        return emote;
    }

    public void setEmote(String emote) {
        this.emote = emote;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}

