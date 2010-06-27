package org.fehlis.underrealm.client;

import org.fehlis.underrealm.client.ui.DiceRollDialog;
import org.fehlis.underrealm.client.ui.DiceRollDialogListener;
import org.fehlis.underrealm.shared.Dice;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class DiceRollTest implements DiceRollDialogListener
{
	private Underrealm m_mainGame;
	private int m_numOfDice;
	private DiceRollDialog m_rollDiceDlg;
	private AsyncCallback<int[]> m_callback; 
	
	public DiceRollTest( Underrealm mainGame, int numOfDice )
	{
		m_mainGame = mainGame;
		m_numOfDice = numOfDice;
		
		init();
	}
	
	public void init()
	{
		m_rollDiceDlg = new DiceRollDialog( m_mainGame.getPlayer(), m_numOfDice );
		m_rollDiceDlg.setListener( this );

		m_callback = new AsyncCallback<int[]>() {
			public void onFailure(Throwable caught) {
//				elap.setText( "error received:" + caught );
			}
			
			public void onSuccess(int[] result) {
				m_rollDiceDlg.setDices( result );
			}
		};
		
		m_rollDiceDlg.show();	
	}

	@Override
	public void rollPressed()
	{
		Dice[] dices = new Dice[m_numOfDice];
		
		for ( int i = 0; i < dices.length; i++ )
		{
			dices[i] = new Dice(6);
		}
		
		m_mainGame.getGreetingService().rollRice(dices, m_callback);
	}
}
