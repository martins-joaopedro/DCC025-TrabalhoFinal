package br.ufjf.services;

import java.util.ArrayList;
import java.util.List;

import br.ufjf.models.dto.PersonalBookDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.libraries.PersonalLibrary;
import br.ufjf.models.Review;
import br.ufjf.persistence.FileManager;

public class ReviewService implements IService<Review> {

    Gson gson = new Gson();
    String path = "reviews.json";

    @Override
    public Review findById(String id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Review> findAll() {
        String data = FileManager.load(path);
        List<Review> reviews;
        if(!data.isEmpty()) {
            var type = new TypeToken<List<Review>>(){}.getType();
            reviews = new ArrayList<>(gson.fromJson(data, type));
            return reviews;
        } else return new ArrayList<>();
    }

    @Override
    public void create(Review obj) {
        int id = findAll().size();
        obj.setId(String.valueOf(id));
        System.out.println(obj);
        FileManager.append(path, obj);
    }

    @Override
    public void saveAll(List<Review> obj) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Review> getReviewsByISBN(String ISBN) {
        
        List<Review> reviews = new ArrayList<>();
        
        for(Review review : findAll())
            if(review.getISBN().equalsIgnoreCase(ISBN))
                reviews.add(review);

        return reviews;
    }

    public Review getUserReviewByISBN(String ISBN, String username) {
        
        for(Review review : getReviewsByISBN(ISBN))
            if(review.getUsername().equalsIgnoreCase(username))
                return review;
        
        return null;
    }
    
    public void removeUserReview(Review receivedReview) {
        List<Review> reviews = findAll();
        for(Review review : reviews) {
            if(review.getId().equalsIgnoreCase(receivedReview.getId())) {
                reviews.remove(review);
                break;
            }
        }
        FileManager.write(path, reviews);
        AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
    }

    public void update(Review receivedReview) {
        removeUserReview(receivedReview);
        create(receivedReview);
    }

    public int getAverageStarsByISBN(String ISBN) {
        List<Review> reviews = findAll();
        int sum = 0;
        int amount = 0;
        for(Review review : reviews) {
            if(review.getISBN().equalsIgnoreCase(ISBN)) {
                sum += review.getStars();
                amount++;
            }
        }

        if(amount == 0)
            return 0;
        else return sum/amount;
    }

}
