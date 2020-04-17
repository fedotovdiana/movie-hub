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
@Table(name = "checklist_film")
public class ChecklistFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checklist;
    @Column(name = "checklist_id")
    private Long id;
    @Column(name = "film_id")
    private Long filmId;
}
