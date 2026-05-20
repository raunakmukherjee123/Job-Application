package com.example.JobApplication.review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Integer companyId);

    String addReview(Integer companyId, Review review);

    Review getReviewBydId(Integer companyId, Integer reviewId);

    String updateReview(Integer companyId, Integer reviewId, Review review);
}
