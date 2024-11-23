package Complaint;

public class Complaint {
    private String username;
    private String complaintId;
    private String date;
    private String description;
    private String status;
    private String resolution;

    public Complaint(String username, String complaintId, String date, String description) {
        this.username = username;
        this.complaintId = complaintId;
        this.date = date;
        this.description = description;
        this.status = "Pending";
    }

    public String getUsername() {
        return username;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getResolution() {
        return resolution;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return date + " | " + complaintId + " | " + description + " | " + status;
    }
}

