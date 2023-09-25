package ptithcm.WebMovie.Model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int commentId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "value")
    private int value;

    @Column(name = "date")
    private Time date;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Comment() {
    }

    public Comment(int commentId, String comment, int value, Time date) {
        this.commentId = commentId;
        this.comment = comment;
        this.value = value;
        this.date = date;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Time getDate() {
        return date;
    }

    public void setDate(Time date) {
        this.date = date;
    }
}
