package models;

public class ObjectLabirinty {	
	private Container containt = null;
	private boolean border = false;
	private boolean borderLeft = false;
	private boolean borderRight = false;
	private boolean borderTop = false;
	private boolean borderBottom = false;
	private boolean start;
	private boolean finish;
	private int n;
	
	public int n(){
		return this.n;
	}
	public ObjectLabirinty(){};	
	
	public int number() {
		return this.n;
	}
	public Object getContaint() {		
			return containt;		
	}

	public void setContaint(Container containt) {
		this.containt = containt;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public boolean isBorderLeft() {
		return borderLeft;
	}
	public void setBorderLeft(boolean borderLeft) {
		this.borderLeft = borderLeft;
	}
	public boolean isBorderRight() {
		return borderRight;
	}
	public void setBorderRight(boolean borderRight) {
		this.borderRight = borderRight;
	}
	public boolean isBorderTop() {
		return borderTop;
	}
	public void setBorderTop(boolean borderTop) {
		this.borderTop = borderTop;
	}
	public boolean isBorderBottom() {
		return borderBottom;
	}
	public void setBorderBottom(boolean borderBottom) {
		this.borderBottom = borderBottom;
	}
	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
}
