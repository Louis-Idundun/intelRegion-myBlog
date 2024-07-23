package com.intelRegionProject.myBlog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Table(name = "comments")
@Entity(name = "comments")
public class Comment extends BaseEntity {
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "comment_user_fkey")
    )
    private User author;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "comment_post_fkey")
    )
    private Post post;
}
