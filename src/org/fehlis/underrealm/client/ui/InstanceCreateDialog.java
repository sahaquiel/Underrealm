package org.fehlis.underrealm.client.ui;

import org.fehlis.underrealm.shared.Dungeon;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InstanceCreateDialog extends DialogBox {

	private InstanceCreateDialogListener m_listener;
	
	public InstanceCreateDialog()
	{
		initCreateDialog();
	}
	
	
	public void setListener( InstanceCreateDialogListener l )
	{
		m_listener = l;
	}
	
	
	private void initCreateDialog()
	{
		setText("Create new Instance");
		setAnimationEnabled(true);
		final Button createButton = new Button("Create");
		final Button closeButton = new Button("Cancel");
		// We can set the id of a widget by accessing its Element
		createButton.getElement().setId("acceptButton");
		closeButton.getElement().setId("closeButton");
		final TextBox tb_dungeonName = new TextBox();
		final TextArea tb_dungeonDesc = new TextArea();
		final HTML status = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Name of Dungeon:</b>"));
		dialogVPanel.add(tb_dungeonName);
		dialogVPanel.add(new HTML("<br><b>Dungeon Description:</b>"));
		dialogVPanel.add(tb_dungeonDesc);
		dialogVPanel.add(status);
		
		HorizontalPanel dialogHPanel = new HorizontalPanel();
		
//		dialogHPanel.setHorizontalAlignment(VerticalPanel.ALIGN_LEFT);
		
//		dialogHPanel.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
		dialogHPanel.add(createButton);
		dialogHPanel.add(closeButton);
		
		dialogVPanel.add( dialogHPanel );
		
		setWidget(dialogVPanel);
		setModal(true);
	
		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				m_listener.cancelPressed();
			}
		});		
			
		// Add a handler to close the DialogBox
		createButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if ( tb_dungeonName.getText().length() > 0 )
				{	
					Dungeon d = new Dungeon( tb_dungeonName.getText() );
					m_listener.okPressed( d );
				}
				else
				{
					status.setHTML( "<font color='#ff0000'>error! Dungeon name cannot be empty</font>" );
				}
			}
		});			
	}

}
