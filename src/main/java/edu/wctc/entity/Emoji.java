package edu.wctc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

    public Emoji(Integer id, String emote, String characterName, Integer ratingID){
        this.id = id;
        this.emote = emote;
        this.characterName = characterName;
        this.ratingID = ratingID;
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
}

