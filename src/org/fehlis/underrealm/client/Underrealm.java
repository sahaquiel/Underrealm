package org.fehlis.underrealm.client;

import java.util.Vector;

import org.fehlis.underrealm.client.ui.DungeonListBox;
import org.fehlis.underrealm.shared.Dungeon;
import org.fehlis.underrealm.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Underrealm implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final UnderrealmServiceAsync greetingService = GWT.create(UnderrealmService.class);

	private final InstanceServiceAsync instanceService = GWT.create(InstanceService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		doMainMenu();
//		new InstanceManager().showMainMenu();
	}
	
	HTML elap;
	
	private void doMainMenu() {
		
		final Button bt_instMan = new Button("Instance Manager");
		final Button bt_testPage = new Button("Update Test");

		// We can add style names to widgets
		bt_instMan.addStyleName("sendButton");
		bt_testPage.addStyleName("sendButton");

		RootPanel.get("pageHeader").add(new Label( "Underrealms Main Menu") );
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("buttonContainer").add(bt_instMan);
		RootPanel.get("buttonContainer").add(bt_testPage);

		elap = new HTML( "(c) noone" );
		RootPanel.get().add( elap );
		
		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				if ( event.getSource() == bt_instMan )
				{
					new InstanceManager().showMainMenu();
				}
				else if ( event.getSource() == bt_testPage )
				{
					//doTest();
					doTest2();
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
	
	private void doTest2()
	{
		elap.setText( "request sent.");
		greetingService.greetServer("notifyme",
				new AsyncCallback<String>() {
					public void onFailure(Throwable caught) {
						elap.setText( "error received:" + caught );
					}
					
					public void onSuccess(String result) {
						elap.setText( "response received: " + result );
					}
				});
	}
	
	private void doTest()
	{		
		  Timer elapsedTimer = new Timer () {
	        public void run() {
	      showElapsed();
	        }
	      };
	      
//	      long startTime = System.currentTimeMillis();

	      // Schedule the timer for every 1/2 second (500 milliseconds)
	      elapsedTimer.scheduleRepeating(2000);
	      
	}
	
	private void showElapsed()
	{
		instanceService.getInstances(
				new AsyncCallback<Vector<Dungeon>>() {
					public void onFailure(Throwable caught) {
					}

					public void onSuccess(Vector<Dungeon> result) {
						elap.setText( "update: " + result );
//						dungeonList.setSelectedIndex( result.size()-1 );
					}
				});
		
	}
	
	private void oldLogin() {
		
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}
}
