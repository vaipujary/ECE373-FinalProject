package FeastFast.OrderingAndTransactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FeastFast.UserManagement.Restaurant;

public class Review {
	
	private Map<String, List<ReviewEntry>> restaurantReviews;
	
    public Review() {
        this.restaurantReviews = new HashMap<>();
    }
    
    // Method to submit a review for a restaurant
    public void submitReview(String restaurantName, String customerName, int rating, String reviewText) {
        ReviewEntry reviewEntry = new ReviewEntry(customerName, rating, reviewText);

        // Check if the restaurant has existing reviews
        if (restaurantReviews.containsKey(restaurantName)) {
            restaurantReviews.get(restaurantName).add(reviewEntry);
        } else {
            List<ReviewEntry> reviews = new ArrayList<>();
            reviews.add(reviewEntry);
            restaurantReviews.put(restaurantName, reviews);
        }
    }
    
    // Method to retrieve reviews for a specific restaurant
    public List<ReviewEntry> getRestaurantReviews(String restaurantName) {
        return restaurantReviews.get(restaurantName);
    }

	public static class ReviewEntry {
		private String customerName;
		private int rating;
		private String reviewText;
		
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
