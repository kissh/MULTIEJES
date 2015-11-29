package model;

import java.util.LinkedList;
import java.util.List;
import processing.core.PGraphics;

public class Drawing {
	

	public Drawing()
	{
		super();
		list = new LinkedList<>();
	}

	public void doPaint( PGraphics g )
	{

		for ( Figure f : list )
		{

			f.paint( g );

		}
	}

	public int getSize()
	{
		return list.size();
	}

	public void addFigure( Figure f )
	{
		list.add( f );
		this.row=this.getSize();
	}

	public void removeFigure( Figure f )
	{
		list.remove( f );
	}

	
	
	public void clear()
	{
		list.clear();
	}


	private List<Figure> list;
	private int row;
	private final int column=5;
}
