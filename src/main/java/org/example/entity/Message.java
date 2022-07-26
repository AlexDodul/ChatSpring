package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Table(name = "user_messages")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_message_user_id"))
    private User user;

    @Column(name = "message", columnDefinition = "text")
    private String message;

    @Column(name = "date")
    private Timestamp date = new Timestamp(new Date().getTime());
}
