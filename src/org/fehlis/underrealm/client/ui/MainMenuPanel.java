package org.fehlis.underrealm.client.ui;

import org.fehlis.underrealm.client.InstanceManager;
import org.fehlis.underrealm.client.MainController;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainMenuPanel extends FlowPanel 
{
	MainController m_ctrl;
	
	public MainMenuPanel( MainController ctrl )
	{
		super();
		
		m_ctrl = ctrl;
		
		final Button bt_instMan = new Button("Instance Manager");
		final Button bt_testPage = new Button("Update Test");

		// We can add style names to widgets
//		bt_instMan.addStyleName("sendButton");
//		bt_testPage.addStyleName("sendButton");		
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		add(bt_instMan);
		add(bt_testPage);
		
		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				if ( event.getSource() == bt_instMan )
				{
					new InstanceManager( m_ctrl ).showMainMenu();
				}
				else if ( event.getSource() == bt_testPage )
				{
					//doTest();
					m_ctrl.doTest2();
				}
					 
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
//				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
//					sendNameToServer();
//				}
			}
		};

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		bt_instMan.addClickHandler(handler);
		bt_instMan.addKeyUpHandler(handler);
		bt_testPage.addClickHandler(handler);
		bt_testPage.addKeyUpHandler(handler);		
	}	


}
