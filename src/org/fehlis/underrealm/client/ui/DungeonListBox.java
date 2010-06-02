package org.fehlis.underrealm.client.ui;

import java.util.Vector;

import org.fehlis.underrealm.shared.Dungeon;

import com.google.gwt.user.client.ui.ListBox;

public class DungeonListBox extends ListBox
{
	
	public DungeonListBox()
	{
		super();
	}
	
	public DungeonListBox( Vector<Dungeon> d )
	{
		super();
		
		setDungeons(d);
	}
	
	public void setDungeons( Vector<Dungeon> d )
	{
		for ( int i = 0; i < d.size(); i++ )
		this.addItem( d.elementAt( i ).toString() );
	}
	
	public void clear()
	{
		for ( int i = getItemCount(); i > 0 ; i-- )
			removeItem( i );
	}
}
