package org.fehlis.underrealm.shared;

import java.util.Random;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Dice implements IsSerializable
{
	private int m_faces;
	
	public Dice()
	{
		m_faces = 6;
	}
	
	public Dice( int faces )
	{
		m_faces = faces;
	}
	
	public int roll()
	{
		return new Random().nextInt( m_faces ) + 1;
	}
}
