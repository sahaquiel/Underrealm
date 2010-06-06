package org.fehlis.underrealm.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Player implements IsSerializable
{
	private boolean m_isAdmin;
	private String m_nickname; 
	
	public Player()
	{
		m_nickname = "nobody";
		m_isAdmin = false;
	}
	
	public Player( String nick )
	{
		m_nickname = nick;
	}
	
	
	public String getNickname()
	{
		return m_nickname;
	}
	
	
	public String toString()
	{
		return m_nickname;
	}
}
