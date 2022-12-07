package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Table(name = "Post")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "topic_id" , referencedColumnName = "topic_id")
    private Topic topicId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id" , referencedColumnName = "account_id")
    private Account accountId;

    @Column(name = "date_post")
    private LocalDateTime timePost;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "is_public")
    private Boolean isPublic;

    @Column(name = "is_block")
    private Boolean isBlock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id" , referencedColumnName = "service_id")
    private Service serviceId;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "postId" , cascade = CascadeType.ALL)
    private List<ReportPost> reportPostList;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "postId" , cascade = CascadeType.ALL)
    private List<Comment> commentList;
}
