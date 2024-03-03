package com.project.caryatch.domain.category;

import com.project.caryatch.domain.advertisement.Advertisement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_type")
    private String category_type;

    @Column(name = "popularity")
    private String popularity;

    @ManyToMany(mappedBy = "categories")
    private Set<Advertisement> advertisements;
}
