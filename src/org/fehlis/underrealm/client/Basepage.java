package org.fehlis.underrealm.client;

import com.google.gwt.user.client.ui.RootPanel;

public class Basepage
{
	public static void clearPage()
	{		
		RootPanel.get("pageHeader").clear();

		RootPanel.get("listContainer").clear();
		RootPanel.get("buttonContainer").clear();
		RootPanel.get("errorLabelContainer").clear();
	}
}
