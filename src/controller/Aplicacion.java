package controller;//paquete principal del programa principal. Se debe ejecutar siempre Aplicacion
import processing.core.*;//importacion de librerias de processing
import java.io.PrintWriter;

import controlP5.*;
//importacion de modelos de figuras. Si se crea una figura nueva es neceario importarla del paquete model.
import model.Arc;
import model.Drawing;
import model.Ellipse;
import model.Line;
import model.Rectangle;
//PrintWriter output se necesita esa funcion de processing pero no supe importarla
public class Aplicacion extends PApplet{
	
	//iniciacion coordenadas
	int x1=0;
	int y1=0;
	int x2=x1;
	int y2=y1;
	int x_2=x1;
	int y_2=y1;

	//iniciacion valores de texto
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
	
	Drawing drawing;

	
	  public void settings(){
		  size(700, 700);
	  }
	public void setup() {
	  PFont font = createFont("arial",8);
	  cp5 = new ControlP5(this);
	  drawing = new Drawing();
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
	    
	    
	    
	    
	    
	    
	  
	    PrintWriter output = createWriter ("archivo de figuras.txt");
	    output.println("meter el arreglo con los datos aca");
	    output.flush();//escribe en el archivo
	    output.close();//cierra la escritura del archivo
	    //exit();// sirve pa cerrar el programa cuando uno le ponga un condicion
	  
	  
	     
	    		
	   
	    		
	    		
	    		
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
	  
	  
	  background(255); 
	  for (int i = 0; i <= width; i +=18) { 
		  fill(0, 0, 0); text(i/(height/40), i+2, height-1);
		  stroke(200); line(i, height, i, 0); 
		  } 
	  for (int j = 0; j < height; j += 18) { 
		  fill(0, 0, 0); 
		  text(40-j/(width/40), 2, j+15);
		  stroke(200); 
		  line(0, j, width, j); 
		  } 
	  stroke(0);

	if (tool==0){
	recttool(x1,y1,x2,y2);
	recttool2(x1,y1,x_2,y_2);
	
	}

	if (tool==1){
	  ellitool(x1, y1,x2, y2);
	  ellitool2(x1, y1,x_2, y_2);
	}
	if (tool==2){
	  linetool(x1, y1,x2, y2);
	  linetool2(x1, y1,x_2, y_2);
	}
	if (tool==3){
	  arctool(x1, y1,x2, y2);
	  arctool2(x1, y1,x_2, y_2);
	}
	drawing.doPaint(g);
	println(drawing);
	}

	void recttool(int a, int b, int c, int d){
	 Rectangle rectangle=new Rectangle();
		rectangle.update(a,b,c,d);
		rectangle.doPaint(g);
		drawing.addFigure(rectangle);
	}
	void recttool2(int a, int b, int c, int d){
		 Rectangle rectangle=new Rectangle();
			rectangle.update(a,b,c,d);
			rectangle.doPaint(g);
		}
	void ellitool(int a, int b, int c, int d){
		 Ellipse ellipse=new Ellipse();
		 ellipse.update(a,b,c,d);
		 ellipse.doPaint(g);
		 drawing.addFigure(ellipse);
	}
	void ellitool2(int a, int b, int c, int d){
		 Ellipse ellipse=new Ellipse();
		 ellipse.update(a,b,c,d);
		 ellipse.doPaint(g);
	}

	void linetool(int a, int b, int c, int d){
		 Line line=new Line();
		 line.update(a,b,c,d);
		 line.doPaint(g);
		 drawing.addFigure(line);
	}
	void linetool2(int a, int b, int c, int d){
		 Line line=new Line();
		 line.update(a,b,c,d);
		 line.doPaint(g);
	}

	void arctool(int a, int b, int c, int d){
		 Arc arc=new Arc();
		 arc.update(a,b,c,d);
		 arc.doPaint(g);
		 drawing.addFigure(arc);
	}
	void arctool2(int a, int b, int c, int d){
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
	    x_2=0;
	    y_2=0;
	    		
	  }
	    if (tool==1){
	    x1=mouseX;
	    y1=mouseY;
	    x2=0;
	    y2=0;
	    x_2=0;
	    y_2=0;
	  }
	  
	    if (tool==2){
	    x1=mouseX;
	    y1=mouseY;
	    x2=x1;
	    y2=y1;
	    x_2=x1;
	    y_2=y1;
	  }
	  
	    if (tool==3){
	    x1=mouseX;
	    y1=mouseY;
	    x2=0;
	    y2=0;
	    x_2=0;
	    y_2=0;
	  }
	  
	  
	}

	public void mouseDragged() 
	{
	    if (tool==0){
	    x_2=mouseX-x1;
	    y_2=mouseY-y1;
	  }
	    if (tool==1){
	    x_2=2*(mouseX-x1);
	    y_2=2*(mouseY-y1);
	  }
	  
	    if (tool==2){
	    x_2=mouseX;
	    y_2=mouseY;
	  }
	  
	  
	    if (tool==3){
	    x_2=2*(mouseX-x1);
	    y_2=2*(mouseY-y1);
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
	  
	    if (tool==3){
	    x2=2*(mouseX-x1);
	    y2=2*(mouseY-y1);
	  }

	}	 	
	
	
	
	
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "controller.Aplicacion" });
	  }
}
