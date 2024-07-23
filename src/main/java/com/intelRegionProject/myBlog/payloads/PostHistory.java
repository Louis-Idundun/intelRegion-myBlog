package com.intelRegionProject.myBlog.payloads;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Data
public class PostHistory {
    private UUID postId;
    private String content;
    private Long likeCount;
    private Long commentCount;
    private String posterFirstName;
    private String posterLastName;
    private String timeCreated;
    private List<CommentHistory> comments = new ArrayList<>();

}
