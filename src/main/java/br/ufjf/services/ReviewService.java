package br.ufjf.services;

import java.util.Map;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;

import br.ufjf.models.Review;

public class ReviewService {
    
    Map<String[], Review> listReview = new HashMap<>();

    public List<Review> getReviews(String ISBN) {

        List<Review> reviews = new ArrayList<Review>();
        
        for(Review review : listReview.values()) {
            if(review.getISBN().equals(ISBN)) {
                reviews.add(review);
            }
        }

        return reviews;
    }
    
    public Map<String[], Review> addReview(Review review) {
        
        Map<String[], Review> listReview = new HashMap<>(); // MUDAR DEPOIS PARA GET LIST
        String[] reviewKey = {review.getISBN(), review.getUsername()};

        listReview.put(reviewKey, review);

        // SAVE

        return listReview;
    }

    public Map<String[], Review> removeReview(Review review) {
        
        Map<String[], Review> listReview = new HashMap<>(); // MUDAR DEPOIS PARA GET LIST
        String[] reviewKey = {review.getISBN(), review.getUsername()};

        //TO DO TRY CATCH
        if(listReview.containsKey(reviewKey)) {
            listReview.remove(reviewKey);
        }
        else {
            // ERROR
        }

        // SAVE listReview

        return listReview;
    }
}
