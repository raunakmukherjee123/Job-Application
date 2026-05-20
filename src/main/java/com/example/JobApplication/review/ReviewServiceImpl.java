package com.example.JobApplication.review;

import com.example.JobApplication.company.Company;
import com.example.JobApplication.company.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Override
    public List<Review> getAllReviews(Integer companyId) {
        List<Review> reviewList=reviewRepository.findByCompanyId(companyId);

        return reviewList;
    }

    @Override
    public String addReview(Integer companyId, Review review) {
        Company company=companyService.getById(companyId);
        if(company!=null)
        {
            review.setCompany(company);
            reviewRepository.save(review);

            return "Review added";
        }
        return "No company found";
    }

    @Override
    public Review getReviewBydId(Integer companyId, Integer reviewId) {
        List<Review> reviewList=getAllReviews(companyId);

        return reviewList.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String updateReview(Integer companyId, Integer reviewId, Review review) {

        return "Review updated";
    }
}
