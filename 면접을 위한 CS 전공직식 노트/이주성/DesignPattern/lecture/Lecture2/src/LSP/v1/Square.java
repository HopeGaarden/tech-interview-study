package LSP.v1;

import LSP.v1.Rectangle;

public class Square extends Rectangle {
	@Override
	public void setWidth(int width) {
		super.setWidth(width);
		super.setHeight(width);
	}

	@Override
	public void setHeight(int height) {
		super.setWidth(height);
		super.setHeight(height);
	}
}
