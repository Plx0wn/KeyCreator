package fr.plx0wn.Events;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEvents implements KeyListener {

//	public boolean isInteger(String str){
//		int[] intKey = {1,2,3,4,5,6,7,8,9};
//		for(int i = 0; i < intKey.length; i++){
//			if()
//		}
//		return false;
//	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
        String Valid="1234567890";
        if (!Valid.contains(String.valueOf(e.getKeyChar()))) {
        	// CANCEL EVENT (soon)
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
