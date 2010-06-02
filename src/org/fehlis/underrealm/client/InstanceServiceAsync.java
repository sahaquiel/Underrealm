package org.fehlis.underrealm.client;

import java.util.Vector;

import org.fehlis.underrealm.shared.Dungeon;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface InstanceServiceAsync {
	void createInstance(String input, AsyncCallback<Integer> callback)	throws IllegalArgumentException;

	void createInstance(Dungeon d, AsyncCallback<Integer> callback)	throws IllegalArgumentException;

	void getInstances(AsyncCallback< Vector<Dungeon>> callback)	throws IllegalArgumentException;
}
