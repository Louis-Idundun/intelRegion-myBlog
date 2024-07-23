package com.intelRegionProject.myBlog.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Entity(name = "posts")
@Table(name = "posts")
@Getter
@Setter
public class Post extends BaseEntity {
    @Column(name = "post_title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;
}
