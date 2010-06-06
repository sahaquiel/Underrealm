package org.fehlis.underrealm.client;

import org.fehlis.underrealm.shared.Player;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface UnderrealmServiceAsync {
	void greetServer(String input, AsyncCallback<Player> callback)
			throws IllegalArgumentException;
}
