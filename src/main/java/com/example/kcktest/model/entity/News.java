package com.example.kcktest.model.entity;

import com.example.kcktest.model.enums.NewsStatus;
import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class News {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne (fetch = FetchType.LAZY)
    private Image image;

    @Column
    private String header;

    @Column
    private String content;

    @ManyToOne(fetch = FetchType.EAGER,
            cascade = { CascadeType.PERSIST,
                        CascadeType.MERGE,
                        CascadeType.REFRESH,
                        CascadeType.DETACH})
    private User user;

    @Enumerated
    private NewsStatus newsStatus;

    private Timestamp timestamp;
}