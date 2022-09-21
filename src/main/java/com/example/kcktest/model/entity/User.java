package com.example.kcktest.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "author")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user")
    private Set<News> newsList;
}