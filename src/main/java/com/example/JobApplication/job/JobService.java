package com.example.JobApplication.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void create(Job job);

    Job findJobById(Integer id);

    boolean deteteJobById(Integer id);

    boolean updateJob(Integer id, Job updatedjob);
}
