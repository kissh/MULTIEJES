package model;
import processing.core.*;

public class Arc extends Figure{

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
		g.arc(x1, y1, x2, y2,PI,TWO_PI);
	}



	
	

}
