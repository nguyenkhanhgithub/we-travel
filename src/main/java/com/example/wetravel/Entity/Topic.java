package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Topic")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long topicId;

    @Column(name = "topic_name")
    private String topicName;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "topicId" , cascade = CascadeType.ALL)
    private List<Post> postList;
}
