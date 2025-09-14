package custom_serializable;

public class Lecture {
    private int lectureId;
    private String lectureName;
    public Lecture(int lectureId,  String lectureName) {
        System.out.println("Lecture Constructor...");
        this.lectureId = lectureId;
        this.lectureName = lectureName;
    }
    public int getLectureId() {
        return lectureId;
    }
    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }
    public String getLectureName() {
        return lectureName;
    }
    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }
    @Override
    public String toString() {
        return "Lecture [lectureId=" + lectureId + ", lectureName=" + lectureName + "]";
    }
 
}
