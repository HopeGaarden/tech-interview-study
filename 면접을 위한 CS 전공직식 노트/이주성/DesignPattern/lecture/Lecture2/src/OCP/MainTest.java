package OCP;

import OCP.v1.Door1;
import OCP.v2.*;

public class MainTest {
	// OCP - Open Close Principle
	// 확장에는 열려 있고, 변경에는 닫혀 있다.
	// 기존코드를 변경하지 않으면서(closed), 기능을 추가할 수 있도록(open) 설계되어야한다.
	public MainTest() {
		// OCP violation
		System.out.println("version1 - ifelseif");
//		Door1[] doors = {new OCP.v1.PushDoor(), new OCP.v1.AutomaticDoor(), new OCP.v1.KnobDoor(), new OCP.v1.SlidingDoor() };
//		for (Door1 door : doors) {
//			if (door instanceof OCP.v1.AutomaticDoor) {
//				((OCP.v1.AutomaticDoor)door).pressOpen();
//			} else if (door instanceof OCP.v1.KnobDoor) {
//				((OCP.v1.KnobDoor)door).twistOpen();
//			} else if (door instanceof OCP.v1.SlidingDoor) {
//				((OCP.v1.SlidingDoor)door).slideOpen();
//			} else if (door instanceof OCP.v1.PushDoor) {
//				((OCP.v1.PushDoor)door).pushOpen();
//			}
//		}
		Door1 d1 = new OCP.v1.PushDoor();
		if (d1 instanceof OCP.v1.PushDoor) {
			((OCP.v1.PushDoor) d1).pushOpen();
		}
		
		// OCP
		Door[] doors2 = {new PushDoor(), new AutomaticDoor(), new KnobDoor(), new SlidingDoor() };
		System.out.println("\nversion2 - polymorphism");
		for (Door door : doors2) {
			door.open();
		}
	}

}
