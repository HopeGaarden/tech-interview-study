package teacherObserver;

// Subject
public interface Teacher {
    void subscribe(Student student);
    void unsubscribe(Student student);
    void notifyStudents(String message);
}
