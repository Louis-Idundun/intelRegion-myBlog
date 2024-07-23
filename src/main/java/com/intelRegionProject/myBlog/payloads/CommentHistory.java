package com.intelRegionProject.myBlog.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentHistory {
    private UUID commentId;
    private String content;
    private Long likeCount;
    private String commenterFirstName;
    private String commenterLastName;
    private String timeCreated;
    private UUID postId;
}
