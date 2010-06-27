package org.fehlis.underrealm.client.ui;

import org.fehlis.underrealm.shared.Dungeon;
import org.fehlis.underrealm.shared.Player;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DiceRollDialog extends DialogBox {

	private DiceRollDialogListener m_listener;
	private int m_numOfDices;
	private Player m_player;
	private Label m_diceLabel[];
	
	public DiceRollDialog( Player p, int numOfDices )
	{
		m_player = p;
		m_numOfDices = numOfDices;
		initDialog();
	}
	
	
	public void setListener( DiceRollDialogListener l )
	{
		m_listener = l;
	}
	
	
	private void initDialog()
	{
		setText("Roll em dice");
		setAnimationEnabled(true);
		
		final Button rollButton = new Button("Roll");

		// We can set the id of a widget by accessing its Element
		rollButton.getElement().setId("rollButton");
		
		VerticalPanel dialogVPanel = new VerticalPanel();
		
		m_diceLabel = new Label[m_numOfDices];
		for ( int i = 0; i < m_numOfDices; i++ )
		{
			m_diceLabel[i] = new Label( "" + i );
			
			dialogVPanel.add( m_diceLabel[i] );
		}
		
		dialogVPanel.add( rollButton );
		add( dialogVPanel );
		
		setModal(true);
	
		// Add a handler to close the DialogBox
		rollButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				m_listener.rollPressed();
			}
		});
	}
	
	public void setDices( int result[] )
	{
		for ( int i = 0; i < m_numOfDices; i++ )
		{
			m_diceLabel[i].setText( "" + result[i] );
		}
	}
}
