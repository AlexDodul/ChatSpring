package org.example.entity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Table(name = "user_messages")
@Entity
public class Message {

    public Message() {}

    public Message(Long id, User user, String message, Timestamp date) {
        this.id = id;
        this.user = user;
        this.message = message;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_message_user_id"))
    private User user;

    @Column(name = "message", columnDefinition = "text")
    private String message;

    @Column(name = "date")
    private Timestamp date = new Timestamp(new Date().getTime());

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user=" + user +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
