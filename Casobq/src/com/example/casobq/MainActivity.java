package com.example.casobq;

import android.app.Activity;
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
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        Button botonLogin = (Button)findViewById(R.id.buttonLogin);
        botonLogin.setOnClickListener(loginListener);
    }
    
    
    private OnClickListener loginListener = new OnClickListener() {
        public void onClick(View v) {
        	TextView usuario = (TextView)findViewById(R.id.editTextUsuario);            
        	Toast.makeText(MainActivity.this, usuario.getText().toString(), Toast.LENGTH_LONG).show();
        }
    };
}
