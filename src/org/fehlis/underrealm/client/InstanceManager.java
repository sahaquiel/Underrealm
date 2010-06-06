package org.fehlis.underrealm.client;

import java.util.Vector;

import org.fehlis.underrealm.client.ui.DungeonListBox;
import org.fehlis.underrealm.client.ui.InstanceCreateDialog;
import org.fehlis.underrealm.client.ui.InstanceCreateDialogListener;
import org.fehlis.underrealm.shared.Dungeon;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class InstanceManager implements InstanceCreateDialogListener
{
	private static final int STATE_MAIN = 0;
	private static final int STATE_CREATE_DIALOG = 1;	

	private int m_state = STATE_MAIN;
	
	private final InstanceServiceAsync instanceService = GWT.create(InstanceService.class);

	Button createButton;
	Button selectButton;
	InstanceCreateDialog createDialogBox;
	DungeonListBox dungeonList;
	
	public void onModuleLoad()
	{
		showMainMenu();
	}
	
	
	void showMainMenu()
	{
		// clear HTML first
		Basepage.clearPage();
		
		createButton = new Button("Create new");
		selectButton = new Button("Select");
		dungeonList = new DungeonListBox();

		final Label errorLabel = new Label();
		
		// We can add style names to widgets
		createButton.addStyleName("createButton");
		selectButton.addStyleName("selectButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("pageHeader").clear();
		RootPanel.get("pageHeader").add(new Label( "Instance Manager") );

		RootPanel.get("listContainer").add(dungeonList);
		RootPanel.get("buttonContainer").add(selectButton);
		RootPanel.get("buttonContainer").add(createButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);
		
		updateDungeonList();
		
		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		createButton.addClickHandler(handler);
		createButton.addKeyUpHandler(handler);
		selectButton.addClickHandler(handler);
		selectButton.addKeyUpHandler(handler);
		
		createDialogBox = new InstanceCreateDialog();
		createDialogBox.setListener( this );		
	}

	private void setState( int state )
	{
		m_state = state;
		
		switch( m_state )
		{
		case STATE_MAIN:
			createButton.setEnabled(true);
			selectButton.setEnabled(true);
			break;
		case STATE_CREATE_DIALOG:
			createButton.setEnabled(false);
			selectButton.setEnabled(false);
			break;
		}
	}

	
	private void updateDungeonList()
	{
		// first empty list data
		dungeonList.clear();
		
		// new get updated list data from server
		instanceService.getInstances(
				new AsyncCallback<Vector<Dungeon>>() {
					public void onFailure(Throwable caught) {
					}

					public void onSuccess(Vector<Dungeon> result) {
						dungeonList.setDungeons( result );
						dungeonList.setSelectedIndex( result.size()-1 );
					}
				});
	}
	
	
	// Create a handler for the sendButton and nameField
	class MyHandler implements ClickHandler, KeyUpHandler {
		/**
		 * Fired when the user clicks on the sendButton.
		 */
		public void onClick(ClickEvent event) {
			if ( event.getSource() == createButton )
			{
				openCreateInstanceDialog();
			}
			else if ( event.getSource() == selectButton )
			{
				openSelectedInstance();
			}
		}

		public void onKeyUp(KeyUpEvent event) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	private void openSelectedInstance()
	{
		
	}
	
	
	private void openCreateInstanceDialog()
	{
		setState( STATE_CREATE_DIALOG );
			
		createDialogBox.center();		
	}
	

	@Override
	public void cancelPressed() {
		setState( STATE_MAIN );
		createDialogBox.hide();
	}


	@Override
	public void okPressed(Dungeon newDungeon) {
		instanceService.createInstance( newDungeon, 
				new AsyncCallback<Integer>() {
					public void onFailure(Throwable caught) {
					}

					public void onSuccess(Integer result) {
					}
				});
		
		setState( STATE_MAIN );
		createDialogBox.hide();
		updateDungeonList();
	}
	

}
