package com.example.casobq;



import com.evernote.client.android.EvernoteSession;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	protected EvernoteSession mEvernoteSession;
	private static final EvernoteSession.EvernoteService EVERNOTE_SERVICE = EvernoteSession.EvernoteService.SANDBOX;
	Context ctx;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        mEvernoteSession = EvernoteSession.getInstance(this, "jcabfer06", "f36faea248456605", EVERNOTE_SERVICE, true);
        mEvernoteSession.authenticate(this);
        
        Button botonLogin = (Button)findViewById(R.id.buttonLogin);
        botonLogin.setOnClickListener(loginListener);
    }
    
    
    private OnClickListener loginListener = new OnClickListener() {
        public void onClick(View v) {
        	TextView usuario = (TextView)findViewById(R.id.editTextUsuario);   
        	String token;
        	
        	Toast.makeText(MainActivity.this, usuario.getText().toString(), Toast.LENGTH_LONG).show();
        }
    };
}
