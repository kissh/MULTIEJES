package controller;
import processing.core.*;
import controlP5.*;
import model.Arc;
import model.Ellipse;
import model.Line;
import model.Rectangle;
import outputs.Lista;

public class Aplicacion extends PApplet{
	
	int x1=0;
	int y1=0;
	int x2=x1;
	int y2=y1;

	Textfield X1;
	Textfield Y1;
	Textfield X2;
	Textfield Y2;

	String TF1="X1";
	String TF2="Y1";
	String TF3="X2";
	String TF4="Y2";


	ControlP5 cp5;
	int tool=0;

	
	  public void settings(){
		  size(700, 700);
	  }
	public void setup() {
	  PFont font = createFont("arial",8);
	  cp5 = new ControlP5(this);
	  ButtonBar b = cp5.addButtonBar("bar")
	     .setPosition(0, 0)
	     .setSize(400, 20)
	     .addItems(split("a b c d"," "))
	     ;
	     println(b.getItem("a"));
	  b.changeItem("a","text","rectangulo");
	  b.changeItem("b","text","circulo");
	  b.changeItem("c","text","linea");
	  b.changeItem("d","text","arco");
	    b.onChange(new CallbackListener(){
	    public void controlEvent(CallbackEvent ev) {
	      ButtonBar bar = (ButtonBar)ev.getController();
	      println(bar.hover());
	      tool=bar.hover();
	    }
	  });
	  

	  
	  
	                 
	  X1=cp5.addTextfield(TF1)
	  .setColorCaptionLabel(0)
	     .setPosition(20,650)
	     .setSize(60,20)
	     .setFont(createFont("arial",20))
	     .setAutoClear(false)
	     .setValue(x1);
	     
	  Y1=cp5.addTextfield(TF2)
	  .setColorCaptionLabel(0)
	     .setPosition(120,650)
	     .setSize(60,20)
	     .setFont(createFont("arial",20))
	     .setAutoClear(false)
	     .setValue(y1)
	     ;
	     
	  X2=cp5.addTextfield(TF3)
	  .setColorCaptionLabel(0)
	     .setPosition(220,650)
	     .setSize(60,20)
	     .setFont(createFont("arial",20))
	     .setAutoClear(false)
	     .setValue(x2)
	     ;
	     
	   Y2=cp5.addTextfield(TF4)
	     .setColorCaptionLabel(0)
	     .setPosition(320,650)
	     .setSize(60,20)
	     .setFont(createFont("arial",20))
	     .setAutoClear(false)
	     .setValue(y2)
	     ;
	}


	public void draw() {
	  X1.setValue(x1);
	  Y1.setValue(y1);
	  X2.setValue(x2);
	  Y2.setValue(y2);
	  
	  
	  background(220);

	if (tool==0){
	recttool(x1,y1,x2,y2);
	}

	if (tool==1){
	  ellitool(x1, y1,x2, y2);
	}
	if (tool==2){
	  linetool(x1, y1,x2, y2);
	}
	if (tool==3){
	  arctool(x1, y1,x2, y2);
	}

	}

	void recttool(int a, int b, int c, int d){
	 Rectangle rectangle=new Rectangle();
		rectangle.update(a,b,c,d);
		rectangle.doPaint(g);
		Lista.add(1,a,b,c,d);
	}
	void ellitool(int a, int b, int c, int d){
		 Ellipse ellipse=new Ellipse();
		 ellipse.update(a,b,c,d);
		 ellipse.doPaint(g);
	}

	void linetool(int a, int b, int c, int d){
		 Line line=new Line();
		 line.update(a,b,c,d);
		 line.doPaint(g);
	}

	void arctool(int a, int b, int c, int d){
		 Arc arc=new Arc();
		 arc.update(a,b,c,d);
		 arc.doPaint(g);
	}

	void norm(float x){
	 if (x>=0){

	 } else{
	 }
	}

	public void mousePressed() {
	  if (tool==0){
	    x1=mouseX;
	    y1=mouseY;
	    x2=0;
	    y2=0;
	  }
	    if (tool==1){
	    x1=mouseX;
	    y1=mouseY;
	    x2=0;
	    y2=0;
	  }
	  
	    if (tool==2){
	    x1=mouseX;
	    y1=mouseY;
	    x2=x1;
	    y2=y1;
	  }
	  
	    if (tool==3){
	    x1=mouseX;
	    y1=mouseY;
	    x2=0;
	    y2=0;
	  }
	  
	  
	}

	public void mouseDragged() 
	{
	    if (tool==0){
	    x2=mouseX-x1;
	    y2=mouseY-y1;
	  }
	    if (tool==1){
	    x2=2*(mouseX-x1);
	    y2=2*(mouseY-y1);
	  }
	  
	    if (tool==2){
	    x2=mouseX;
	    y2=mouseY;
	  }
	  
	  
	    if (tool==3){
	    x2=2*(mouseX-x1);
	    y2=2*(mouseY-y1);
	  }
	  
	}
	public void mouseReleased() {
	    if (tool==0){
	    x2=mouseX-x1;
	    y2=mouseY-y1;
	  }
	  
	    if (tool==1){
	    x2=2*(mouseX-x1);
	    y2=2*(mouseY-y1);
	  }
	  
	      if (tool==2){
	    x2=mouseX;
	    y2=mouseY;
	  }
	  
	    if (tool==1){
	    x2=2*(mouseX-x1);
	    y2=2*(mouseY-y1);
	  }

	}	 	
	
	
	
	
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "controller.Aplicacion" });
	  }
}
