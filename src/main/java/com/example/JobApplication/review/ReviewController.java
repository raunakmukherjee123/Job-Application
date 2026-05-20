package com.example.JobApplication.review;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company/{companyId}")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<?> gerAllReviews(@PathVariable Integer companyId)
    {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/review/add")
    public ResponseEntity<?> addReview(@PathVariable Integer companyId, @RequestBody Review review)
    {
        return new ResponseEntity<>(reviewService.addReview(companyId,review),HttpStatus.CREATED);
    }

    @GetMapping("/review/{reviewId}")
    public ResponseEntity<?> getReview(@PathVariable Integer companyId,@PathVariable Integer reviewId)
    {
        return new ResponseEntity<>(reviewService.getReviewBydId(companyId,reviewId), HttpStatus.OK);
    }

    @PutMapping("/review/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Integer companyId,@PathVariable Integer reviewId, @RequestBody Review review)
    {
        return new ResponseEntity<>(reviewService.updateReview(companyId,reviewId,review), HttpStatus.OK);
    }

    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<?> deleteReview(@PathVariable Integer companyId,@PathVariable Integer reviewId)
    {
        return new ResponseEntity<>(reviewService.deleteReview(companyId,reviewId), HttpStatus.OK);
    }
}
