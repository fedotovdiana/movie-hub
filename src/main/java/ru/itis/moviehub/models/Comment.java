package ru.itis.moviehub.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "checklist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String user;
    private String text;
    private String date;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
}
