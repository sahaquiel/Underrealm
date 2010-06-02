package org.fehlis.underrealm.shared;

import java.io.Serializable;
import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Dungeon implements IsSerializable {
	
	private String m_name;
	private String m_desc;
//	private Vector m_rooms;
	
	public Dungeon()
	{
		
	}
	
	public Dungeon( String name )
	{
		m_name = name;
		m_desc = "";
//		m_rooms = new Vector();
	}
	
	public Dungeon( String name, String desc )
	{
		m_name = name;
		m_desc = desc;
//		m_rooms = new Vector();
	}
	
	public String toString()
	{
		return m_name;
	}
}
