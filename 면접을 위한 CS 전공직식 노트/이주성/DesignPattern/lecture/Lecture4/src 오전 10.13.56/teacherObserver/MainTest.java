package teacherObserver;

public class MainTest {
    public MainTest() {
        // 강사들 - Subjects
        SwimmingTeacher jason = new SwimmingTeacher();
        TennisTeacher andy = new TennisTeacher();
        // Teacher 타입으로 선언하면 각 swim, play 등 못 씀

        // 수강생들 - Observers
        Student tom = new Tom();
        Student jerry = new Jerry();
        Student mitty = new Mitty();

        // 수영 강의 등록
        jason.subscribe(tom);
        jason.subscribe(jerry);
        jason.swim();
        System.out.println();

        // 테니스 강의 등록
        andy.subscribe(jerry);
        andy.subscribe(mitty);
        andy.match();
        System.out.println();

        // 강의 취소
        jason.unsubscribe(jerry);
        jason.lesson();
        System.out.println();

    }
}
