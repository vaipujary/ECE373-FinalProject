package FeastFast.OrderingAndTransactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FeastFast.UserManagement.Restaurant;

// This class handles user reviews and ratings for specific restaurants
public class Review {
	
	// Attributes
	// Review has restaurant name and review entry
	private Map<String, List<ReviewEntry>> restaurantReviews;
	
	// Constructor
    public Review() {
        this.restaurantReviews = new HashMap<>();
    }
    
    // Method to submit a review for a restaurant
    public void submitReview(String restaurantName, String customerName, int rating, String reviewText) {
        
    	// New review entry object
    	ReviewEntry reviewEntry = new ReviewEntry(customerName, rating, reviewText);

        // Check if the restaurant has existing reviews and add the new entry
        if (restaurantReviews.containsKey(restaurantName)) {
            restaurantReviews.get(restaurantName).add(reviewEntry);
        } 
        
        // Otherwise, create a new elements in restaurant reviews mapping
        else {
            List<ReviewEntry> reviews = new ArrayList<>();
            reviews.add(reviewEntry);
            restaurantReviews.put(restaurantName, reviews);
        }
    }
    
    public Map<String, List<ReviewEntry>> getReviewRestaurantReviews(){
    	return this.restaurantReviews;
    }
    // Method to retrieve reviews for a specific restaurant
    public List<ReviewEntry> getRestaurantReviews(String restaurantName) {
        return restaurantReviews.get(restaurantName);
    }
    
    public String getReviewText(ReviewEntry reviewEntry) {
    	return reviewEntry.getReviewText();
    }

    // Static class to handle customer review entries
	public static class ReviewEntry {
		private String customerName;
		private int rating;
		private String reviewText;
		
		// Constructor for review entry
		public ReviewEntry(String customerName, int rating, String reviewText) {
			this.customerName = customerName;
			this.rating = rating;
			this.reviewText = reviewText;
		}
		
		public String getCustomerName() {
            return customerName;
        }

        public int getRating() {
            return rating;
        }

        public String getReviewText() {
            return reviewText;
        }
	}
}
