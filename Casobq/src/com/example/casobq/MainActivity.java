package com.example.casobq;



//import com.evernote.android.sample.ImagePicker;
import java.util.ArrayList;



//import com.evernote.android.sample.R;
import com.evernote.client.android.EvernoteSession;
import com.evernote.client.android.OnClientCallback;
import com.evernote.edam.notestore.NoteFilter;
import com.evernote.edam.notestore.NoteMetadata;
import com.evernote.edam.notestore.NotesMetadataList;
import com.evernote.edam.notestore.NotesMetadataResultSpec;
import com.evernote.edam.type.NoteSortOrder;
import com.evernote.thrift.transport.TTransportException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	protected EvernoteSession mEvernoteSession;
	private static final EvernoteSession.EvernoteService EVERNOTE_SERVICE = EvernoteSession.EvernoteService.SANDBOX;
	Context ctx;
	
	private Spinner spinnerOrden;
	private ArrayList<String> notesNames;
    private ArrayAdapter<String> mAdapter;
    private ListView listaNotas;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        mEvernoteSession = EvernoteSession.getInstance(this, "jcabfer06", "f36faea248456605", EVERNOTE_SERVICE, true);
        mEvernoteSession.authenticate(this);
        
        
	    Spinner spinner = (Spinner) findViewById(R.id.spinner1);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.Opciones, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
     
		Button botonCrear = (Button)findViewById(R.id.buttonCrear);
		botonCrear.setOnClickListener(crearListener);
		
		spinnerOrden = (Spinner)findViewById(R.id.spinner1);
		spinnerOrden.setOnItemSelectedListener(cambiarOrden);
		
		notesNames = new ArrayList();
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notesNames);
        listaNotas = (ListView)findViewById(R.id.listView_notas);
        listaNotas.setAdapter(mAdapter);
        
        encontrarNotas(0);
    }
    
    private OnItemSelectedListener cambiarOrden = new AdapterView.OnItemSelectedListener() {
    	public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            //Object item = parent.getItemAtPosition(pos);
    		int posicion = spinnerOrden.getSelectedItemPosition();
    		Toast.makeText(getApplicationContext(), "Posicion " + Integer.toString(posicion), Toast.LENGTH_LONG).show();
    		encontrarNotas(posicion);
        }
    	public void onNothingSelected(AdapterView<?> parent) {
        }
    };
    
    private OnClickListener crearListener = new OnClickListener() {
    	public void onClick(View v) {
    		startActivity(new Intent(getApplicationContext(), CrearNota.class));
    	}
    };
    
    public void encontrarNotas(int orden){
    	final int offset = 0;
        final int pageSize = 10;
        
        //Resetear la vista de las notas
        mAdapter.clear();
        
        final NoteFilter filter = new NoteFilter();
        if(orden == 0) {
        	filter.setOrder(NoteSortOrder.TITLE.getValue());
        } else {
        	filter.setOrder(NoteSortOrder.UPDATED.getValue());
        }
        
        final NotesMetadataResultSpec spec = new NotesMetadataResultSpec();
        spec.setIncludeTitle(true);
        
        try {
        final OnClientCallback<NotesMetadataList> callback = new OnClientCallback<NotesMetadataList>() {
	            @Override
	            public void onSuccess(NotesMetadataList data) {
	              Toast.makeText(getApplicationContext(), "Notas encontradas", Toast.LENGTH_LONG).show();

	
	              for (NoteMetadata note : data.getNotes()) {
	                String title = note.getTitle();
	                notesNames.add(title);
	              }
	              mAdapter.notifyDataSetChanged();
	            }
	
	            @Override
	            public void onException(Exception exception) {
	            	 Toast.makeText(getApplicationContext(), "No se encontraron notas", Toast.LENGTH_LONG).show();
	            }
          };
        
    	mEvernoteSession.getClientFactory().createNoteStoreClient()
        	.findNotesMetadata(filter, offset, pageSize, spec, callback);
        } catch (TTransportException exception){
        	 Toast.makeText(getApplicationContext(), "No se pudo crear el note store", Toast.LENGTH_LONG).show();
        }
    }
}
