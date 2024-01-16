package com.jlbabon.manytomanymapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
@Entity
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    private String description;
    private String content;
    private LocalDateTime postedAt;
    private LocalDateTime lastUpdatedAt;
    // FETCH TYPE
    // EAGER = bibigay niya lahat ng kailangan mo kahit hindi mo hinihingi
    // LAZY = kung ano lang yung kailangan mo yung lang bibigay niya

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "fk_post", referencedColumnName = "postId"),
            inverseJoinColumns = @JoinColumn(name = "fk_tags", referencedColumnName = "tagId")
    )
    private Set<TagEntity> tags = new HashSet<>();
}
