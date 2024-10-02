package teacherObserver;

import java.util.ArrayList;
import java.util.List;

public class SwimmingTeacher implements Teacher {
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

    public void swim() {
        System.out.println("[SwimmingTeacher] - free swim");
        notifyStudents("free swim");
    }

    public void lesson() {
        System.out.println("[SwimmingTeacher] - swimming lesson~");
        notifyStudents("swimming lesson~");
    }
}
