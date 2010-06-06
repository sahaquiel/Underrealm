package org.fehlis.underrealm.server;

import org.fehlis.underrealm.client.UnderrealmService;
import org.fehlis.underrealm.shared.FieldVerifier;
import org.fehlis.underrealm.shared.Player;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UnderrealmServiceImpl extends RemoteServiceServlet implements
		UnderrealmService {

	public Player greetServer(String input) throws IllegalArgumentException {
/*
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
*/
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		Player p = DataStore.getUserByNickname( input );		
		
		return p;
	}
}
