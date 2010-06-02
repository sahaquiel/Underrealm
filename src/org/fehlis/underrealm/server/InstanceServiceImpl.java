package org.fehlis.underrealm.server;

import java.util.Vector;

import org.fehlis.underrealm.client.InstanceService;
import org.fehlis.underrealm.client.UnderrealmService;
import org.fehlis.underrealm.shared.Dungeon;
import org.fehlis.underrealm.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class InstanceServiceImpl extends RemoteServiceServlet implements
		InstanceService {

	private Vector< Dungeon > m_instances;
	
	public InstanceServiceImpl()
	{
		m_instances = new Vector<Dungeon>();
	}
	
	public Integer createInstance(String input) throws IllegalArgumentException {
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Instance Name must be at least 4 characters long");
		}

		m_instances.add( new Dungeon( input ) );
		
		return new Integer( m_instances.size() );
/*		
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
*/				
	}

	public Integer createInstance(Dungeon input) throws IllegalArgumentException {
		m_instances.add( input );
		
		return new Integer( m_instances.size() );
	}

	public Vector<Dungeon> getInstances() throws IllegalArgumentException {		
		return m_instances;
	}

}
