package com.intelRegionProject.myBlog.models;

import jakarta.persistence.*;

@Entity(name = "likes")
@Table(name = "likes")
public class Like {
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "like_user_fkey")
    )
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "like_post_fkey")
    )
    private Post post;

    @ManyToOne
    @JoinColumn(
            name = "comment_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "like_comment_fkey")
    )
    private Comment comment;
}
