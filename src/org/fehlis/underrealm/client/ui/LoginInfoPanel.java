package org.fehlis.underrealm.client.ui;

import org.fehlis.underrealm.client.MainController;
import org.fehlis.underrealm.shared.Player;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class LoginInfoPanel extends FlowPanel
{
	MainController m_ctrl;
	
	public LoginInfoPanel( MainController ctrl )
	{
		super();
		
		m_ctrl = ctrl;
		
		if ( m_ctrl.getPlayer() == null )
		{
			this.add(new HTML( "<i>not logged in</i>" ) );
		}
		else
		{
			HTML label_username = new HTML( "welcome, " + m_ctrl.getPlayer().getNickname() );
			Button bt_logout = new Button( "logout" ); 
			
			bt_logout.addClickHandler(new ClickHandler() {
				public void onClick(ClickEvent event) {
					m_ctrl.doLogout();
				}
			});
			
			this.add( label_username );
			this.add( bt_logout );	
		}		
	}
}
