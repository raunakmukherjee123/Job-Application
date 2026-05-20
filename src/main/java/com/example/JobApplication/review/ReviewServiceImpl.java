package com.example.JobApplication.review;

import com.example.JobApplication.company.Company;
import com.example.JobApplication.company.CompanyService;
import jakarta.transaction.Transactional;
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
    public String updateReview(Integer companyId, Integer reviewId, Review updatedReview) {
        if (companyService.getById(companyId) != null) {
            updatedReview.setCompany(companyService.getById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return "Review updated";
        } else {
            return "Not updated";
        }
    }

    @Transactional
    @Override
    public String deleteReview(Integer companyId, Integer reviewId) {
        if (companyService.getById(companyId) != null && reviewRepository.existsById(reviewId)) {
            Review review = reviewRepository.findById(reviewId).orElse(null);

            Company company = review.getCompany();

            company.getReviews().remove(review);

            companyService.updateCompany(companyId, company);

            reviewRepository.deleteById(reviewId);

            return "Review has been deleted";
        }
        return "Cannot be deleted";
    }
}
