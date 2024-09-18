package br.ufjf.services;

import java.util.Map;
import java.util.HashMap;

import br.ufjf.models.Review;

public class ReviewService {
    
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
