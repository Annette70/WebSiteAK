package edu.wctc.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characterdetail")
public class CharacterDetail {

    @Id
    @NotNull
    @Size(min = 1, message = "cannot be blank")
    @Column(name = "CharacterName")
    private String name;

    @Column(name = "CharacterDetail")
    private String detail;
    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            mappedBy = "characterDetail")
    private List<Emoji> emojiList;

    public CharacterDetail(String name, String detail){
        this.name = name;
        this.detail = detail;
    }
    public CharacterDetail(){}

    public void add(Emoji tempEmoji) {
        if (emojiList == null) {
            emojiList = new ArrayList<>();
        }
        emojiList.add(tempEmoji);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getDetail() { return detail; }

    public void setDetail(String detail) { this.detail = detail; }

    public List<Emoji> getEmojiList() { return emojiList; }

    public void setEmojiList(List<Emoji> emojiList) { this.emojiList = emojiList; }
}
