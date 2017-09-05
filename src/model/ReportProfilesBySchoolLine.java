package model;

public class ReportProfilesBySchoolLine {
    private String count;
    private String profile;
    private int countSections;
    private double countHours;
    private int countStudents;


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getCountSections() {
        return countSections;
    }

    public void setCountSections(int countSections) {
        this.countSections = countSections;
    }

    public double getCountHours() {
        return countHours;
    }

    public void setCountHours(double countHours) {
        this.countHours = countHours;
    }

    public int getCountStudents() {
        return countStudents;
    }

    public void setCountStudents(int countStudents) {
        this.countStudents = countStudents;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public ReportProfilesBySchoolLine(String count, String profile, int countSections, double countHours, int countStudents) {
        this.count = count;
        this.profile = profile;
        this.countSections = countSections;
        this.countHours = countHours;
        this.countStudents = countStudents;
    }

    public ReportProfilesBySchoolLine() {
    }


}
