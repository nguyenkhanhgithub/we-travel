package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "tag")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long tagId;

    @Column(name = "tag_name")
    private String tagName;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "tagId" , cascade = CascadeType.ALL)
    private List<TagOfTour> tagOfTourList;
}
