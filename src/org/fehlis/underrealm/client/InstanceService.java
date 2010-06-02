package org.fehlis.underrealm.client;

import java.util.Vector;

import org.fehlis.underrealm.shared.Dungeon;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("instance")
public interface InstanceService extends RemoteService {
	Integer createInstance(String name) throws IllegalArgumentException;
	Integer createInstance(Dungeon d) throws IllegalArgumentException;
	Vector<Dungeon> getInstances() throws IllegalArgumentException;
}
