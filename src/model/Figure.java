package model;

import processing.core.PApplet;
import processing.core.PGraphics;

public abstract class Figure extends PApplet{
	
	public abstract void doPaint( PGraphics g );

	
	public void paint(PGraphics g){
		doPaint( g );
	}
	
}
