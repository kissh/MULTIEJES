package model;
import processing.core.*;

public class Rectangle extends Figure{

private	int x1;
private	int y1;
private	int x2;
private	int y2;
	
	public void update(int a, int b, int c,int d){
		x1=a;
		y1=b;
		x2=c;
		y2=d;
		
	}
	
	@Override
	public void doPaint(PGraphics g) {
		g.noFill();
		g.rect(x1, y1, x2, y2);
	}



	
	

}
