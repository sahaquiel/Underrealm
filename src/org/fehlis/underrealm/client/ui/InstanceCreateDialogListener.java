package org.fehlis.underrealm.client.ui;

import org.fehlis.underrealm.shared.Dungeon;

public interface InstanceCreateDialogListener
{
	public void cancelPressed();
	public void okPressed( Dungeon newDungeon );
}
