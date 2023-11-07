package FeastFast.RestaurantManagement;

public class CustomerOrder {

    private String status;
    private String pickupLocation;
    private String deliveryLocation;
    private String issueReported;
    private double tip;

    public CustomerOrder() {
        // Initialize default values
        this.status = "Pending";
        this.pickupLocation = "";
        this.deliveryLocation = "";
        this.issueReported = "";
        this.tip = 0.0;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getIssueReported() {
        return issueReported;
    }

    public void setIssueReported(String issueReported) {
        this.issueReported = issueReported;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    // Additional methods and logic as required by your application
}
