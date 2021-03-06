package com.example.casobq;

import android.os.Bundle;
import android.widget.TextView;

public class MostrarNota extends MainActivity{

	private TextView mostrarTitulo;
	private TextView mostrarContenido;
	private String titulo;
	private String contenido;
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.mostrar_nota);
	    
	    //Aqui se recuperan los datos del titulo y el contenido de la nota que se quiere mostrar
	    Bundle extras = getIntent().getExtras(); 
	    if(extras !=null) {
	        titulo = extras.getString("Titulo");
	        contenido = extras.getString("Contenido");
	    }
	    
	    mostrarTitulo = (TextView)findViewById(R.id.text_mostrar_titulo);
	    mostrarContenido = (TextView)findViewById(R.id.text_mostrar_contenido);
	    mostrarTitulo.setText(titulo);
	    mostrarContenido.setText(contenido);
	}
}
