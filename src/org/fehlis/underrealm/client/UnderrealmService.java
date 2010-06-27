package org.fehlis.underrealm.client;

import org.fehlis.underrealm.shared.Dice;
import org.fehlis.underrealm.shared.Player;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface UnderrealmService extends RemoteService
{
	Player greetServer(String name) throws IllegalArgumentException;
	
	public int[] rollRice( Dice[] dices );
}
