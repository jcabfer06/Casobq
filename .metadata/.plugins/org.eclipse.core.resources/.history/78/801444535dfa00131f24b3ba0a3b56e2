package com.example.casobq;

//import com.evernote.android.sample.R;
import com.evernote.client.android.EvernoteUtil;
import com.evernote.client.android.OnClientCallback;
import com.evernote.edam.type.Note;
import com.evernote.thrift.transport.TTransportException;

import android.os.Bundle;
/*import android.widget.Button;
import android.widget.EditText;*/

//import com.evernote.android.sample.R;
//import com.evernote.client.android.EvernoteSession;

import android.text.TextUtils;
//import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.app.Activity;

public class CrearNota extends MainActivity {

	private EditText textoTitulo;
	private EditText textoContenido;
	private Button botonGuardar;
	
	// Callback used as a result of creating a note in a normal notebook or a linked notebook
	  private OnClientCallback<Note> mNoteCreateCallback = new OnClientCallback<Note>() {
	    @Override
	    public void onSuccess(Note note) {
	      Toast.makeText(getApplicationContext(), "Nota guardada", Toast.LENGTH_LONG).show();
	    }
	
	    @Override
	    public void onException(Exception exception) {
	      //Log.e(LOGTAG, "Error saving note", exception);
	      Toast.makeText(getApplicationContext(), "Error al guardar nota", Toast.LENGTH_LONG).show();
	    }
	  };
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.crear_nota);
	    
	    textoTitulo = (EditText)findViewById(R.id.text_titulo);
	    textoContenido = (EditText)findViewById(R.id.text_contenido);
	    botonGuardar = (Button)findViewById(R.id.button_guardar);
	    
	    botonGuardar.setOnClickListener(guardarListener);
	}
	
	private OnClickListener guardarListener = new OnClickListener () {
		public void onClick(View v) {
			saveNote(v);
		}
	};
	
	//Función para guardar la nota
	public void saveNote(View view) {
	    String titulo = textoTitulo.getText().toString();
	    String contenido = textoContenido.getText().toString();
	    if (TextUtils.isEmpty(titulo) || TextUtils.isEmpty(contenido)) {
	      Toast.makeText(getApplicationContext(), "Faltan campos por rellenar", Toast.LENGTH_LONG).show();
	      return;
	    }

	    Note nota = new Note();
	    nota.setTitle(titulo);

	    //TODO: line breaks need to be converted to render in ENML
	    nota.setContent(EvernoteUtil.NOTE_PREFIX + contenido + EvernoteUtil.NOTE_SUFFIX);

	      try {
	        mEvernoteSession.getClientFactory().createNoteStoreClient().createNote(nota, mNoteCreateCallback);
	      } catch (TTransportException exception) {
	        //Log.e(LOGTAG, "Error creating notestore", exception);
	        Toast.makeText(getApplicationContext(), "Error al crear note store", Toast.LENGTH_LONG).show();
	      }
	  }
	
}
