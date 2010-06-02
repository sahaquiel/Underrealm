package org.fehlis.underrealm.server;

import org.fehlis.underrealm.client.UnderrealmService;
import org.fehlis.underrealm.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class UnderrealmServiceImpl extends RemoteServiceServlet implements
		UnderrealmService {

	public String greetServer(String input) throws IllegalArgumentException {
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
		
		return "" + System.currentTimeMillis();
	}
}
