package edu.wctc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RatingID")
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

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getRating() { return rating; }

    public void setRating(String rating) { this.rating = rating; }

    public List<Emoji> getEmojiList() { return emojiList; }

    public void setEmojiList(List<Emoji> emojiList) { this.emojiList = emojiList; }
}
