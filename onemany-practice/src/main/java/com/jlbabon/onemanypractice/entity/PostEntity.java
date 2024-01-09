package com.jlbabon.onemanypractice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @OneToMany(cascade = CascadeType.ALL) // Kapag may bagong post that masesave siya sa comment
    @JoinColumn(name = "post_id", referencedColumnName = "id") // reference column id nitong post entity
    private List<CommentEntity> comments;
}
