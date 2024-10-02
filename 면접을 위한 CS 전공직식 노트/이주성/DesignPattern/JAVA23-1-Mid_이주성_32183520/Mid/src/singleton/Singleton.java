package singleton;

public class Singleton {
    // 동기화된 싱글톤으로 관리되어야 하므로 private volatile static으로 선언
    private volatile static Singleton instance = null;

    // 다른곳에서 생성할 수 없도록 생성자를 private로 선언
    private Singleton() {
        System.out.println("Singleton constructor");
    }

    // 싱글톤 객체를 얻을 유일한 메서드
    public static Singleton getInstance() {
        // 아직 생성되지 않았을 경우
        if (instance == null) {
            // synchronized 동기화
            synchronized (Singleton.class) {
                if (instance == null) {
                    // 싱글톤 객체 생성
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}