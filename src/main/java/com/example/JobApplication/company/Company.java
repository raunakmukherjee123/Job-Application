package com.example.JobApplication.company;

import com.example.JobApplication.job.Job;
import com.example.JobApplication.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "company")
    @JsonIgnore
//    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private List<Job> jobs;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "company")

//    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private List<Review> reviews;
}
