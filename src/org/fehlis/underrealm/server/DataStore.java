package org.fehlis.underrealm.server;

import java.util.Vector;

import org.fehlis.underrealm.shared.Player;

public class DataStore
{
	static Vector<Player> m_users;
	
	static
	{
		m_users = new Vector<Player>();
		
		Player p1 = new Player("gambit");
		Player p2 = new Player("bokko");
		
		m_users.add( p1 );
		m_users.add( p2 );
	}
	
	
	public static Vector<Player> getUsers()
	{
		return m_users;
	}
	
	
	public static Player getUserByNickname( String nick )
	{
		Player ret = null;
		
		for ( int i = 0; i < m_users.size(); i++ )
		{
			if ( m_users.elementAt(i).getNickname().equals( nick ) )
			{
				ret = m_users.elementAt(i);
				break;
			}
		}
		
		return ret;
	}
}
