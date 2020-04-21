package edu.wctc.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingID")
    private Integer id;
    @Column(name = "rating")
    private String rating;

    @OneToMany(mappedBy = "ratingID",
            cascade = CascadeType.ALL)
    private List<Emoji> emojiList;

    public void add(Emoji tempEmoji) {
        if (emojiList == null) {
            emojiList = new ArrayList<>();
        }
        emojiList.add(tempEmoji);
    }

    public Rating(String rating) {
        this.rating = rating;
    }

    public  Rating(){}

}
