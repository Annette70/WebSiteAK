package edu.wctc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "characterdetail")
public class CharacterDetail {

    @Id
    @NotNull
    @Size(min = 1, message = "cannot be blank")
    @Column(name = "CharacterName")
    private String name;

    @JoinColumn(name = "CharacterDetail")
    private String detail;

    public CharacterDetail(String name, String detail){
        this.name = name;
        this.detail = detail;
    }
    public CharacterDetail(){}

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name = "Emoji",
            joinColumns = @JoinColumn(name = "CharacterName"),
            inverseJoinColumns = @JoinColumn(name = "CharacterName"))
    private List<Emoji> emojiList;

    public void add(Emoji tempEmoji) {
        if (emojiList == null) {
            emojiList = new ArrayList<>();
        }
        emojiList.add(tempEmoji);
    }
}
