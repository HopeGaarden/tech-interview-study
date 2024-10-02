package teacherObserver;

import java.util.ArrayList;
import java.util.List;

public class TennisTeacher implements Teacher {

    private List<Student> students = new ArrayList<>();

    @Override
    public void subscribe(Student student) {
        students.add(student);
    }

    @Override
    public void unsubscribe(Student student) {
        students.remove(student);
    }

    @Override
    public void notifyStudents(String message) {
        for (Student s : students) {
            s.update(message);
        }

        // students.forEach(student -> student.update(message));
    }

    public void play() {
        System.out.println("[TennisTeacher] - regular tennis course");
        notifyStudents("regular tennis course");
    }

    public void match() {
        System.out.println("[TennisTeacher] - tennis match");
        notifyStudents("tennis match");
    }

}
