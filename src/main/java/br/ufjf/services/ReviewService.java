package br.ufjf.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.ufjf.exceptions.ReviewsException;
import br.ufjf.interfaces.AplicationWindow;
import br.ufjf.interfaces.screens.libraries.Adm;
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

    public void addUserReview(Review review) throws ReviewsException {
        if(getUserReviewByISBN(review.getISBN(), review.getUsername()) != null)
            throw new ReviewsException("Esse Usuário já cadastrou sua avalição!");
        else create(review);
    }

    public void removeUserReview(Review receivedReview) throws ReviewsException {
        List<Review> reviews = findAll();
        boolean isFound = false;
        for(Review review : reviews) {
            if(review.getId().equalsIgnoreCase(receivedReview.getId())) {
                reviews.remove(review);
                isFound = true;
                break;
            }
        }

        if(isFound) {
            FileManager.write(path, reviews);
            AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
        } else throw new ReviewsException("Avaliação não encontrada!");
    }

    public List<Review> getAllReviewsByISBN(String ISBN) {
        
        List<Review> reviews = new ArrayList<>();
        
        for(Review review : findAll())
            if(review.getISBN().equalsIgnoreCase(ISBN))
                reviews.add(review);
        return reviews;
    }

    public Review getUserReviewByISBN(String ISBN, String username) {
        for(Review review : getAllReviewsByISBN(ISBN))
            if(review.getUsername().equalsIgnoreCase(username))
                return review;
        return null;
    }

    public void update(Review receivedReview) throws ReviewsException {
        List<Review> reviews = findAll();
        for(Review review : reviews) {
            if(review.getId().equalsIgnoreCase(receivedReview.getId())) {
                reviews.remove(review);
                reviews.add(receivedReview);
                break;
            }
        }
        FileManager.write(path, reviews);

        if(AplicationWindow.getUser().equals("admin")) {
            AplicationWindow.reloadScreen(new Adm(), "adm");
        }
        
        //AplicationWindow.reloadScreen(new PersonalLibrary(), "personalLibrary");
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
