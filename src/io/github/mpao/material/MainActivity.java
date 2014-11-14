/*******************************************************************************
 * This software is distributed under the following BSD license:
 *
 * Copyright (c) 2014, Marco Paoletti <mpao@me.com>, http://mpao.github.io
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: 
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *******************************************************************************/
package io.github.mpao.material;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	
	private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
        	setSupportActionBar(toolbar);
        }      
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	/* il caro vecchio pulsante hardware conosciuto come three dot menu. 
    	 * Il giorno che ci abbandonerà, non sarà mai troppo presto! Questo è 
    	 * un workaroud per intercettare che è stato premuto ed utilizzare i
    	 * metodi di Toolbar per visualizzare il menu overflow */
    	if(keyCode == KeyEvent.KEYCODE_MENU){
    		// se è l'odiato bottone, mostra l'overflow menù della toolbar
    		toolbar.showOverflowMenu();
    		/* e ritorna true. in tal modo non mostro il menù che il pulsante
    		 * avrebbe voluto mostrare, cioè l'overflow in basso */
    		return true;  
    	}
    	// per qualunque altro pulsante, fa il return corretto
    	return super.onKeyDown(keyCode, event);
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        switch (item.getItemId()) {
        	case R.id.action_settings:
        		doSomething("Settings");
        		return true;
        	case R.id.action_item:
        		doSomething("Another Item");
        		return true;
        	case R.id.action_info:
        		doSomething("Info");
        		return true;        		
        	default:
            return super.onOptionsItemSelected(item);
        }        
    }
    // metodo pro dimostrazione
    public void doSomething(String string){
        Toast.makeText(this, string, Toast.LENGTH_LONG).show();
    }
}

