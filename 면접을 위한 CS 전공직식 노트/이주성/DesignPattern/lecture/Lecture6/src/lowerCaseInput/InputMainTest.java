package src.lowerCaseInput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputMainTest {

	public InputMainTest() throws IOException {
		InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
		int c = 0;
		while ((c = in.read()) >= 0 ) {
			System.out.print((char)c);
		}
		in.close();
	}

}
