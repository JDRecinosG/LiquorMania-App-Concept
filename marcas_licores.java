package com.example.liquormania;

import java.util.ArrayList;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class marcas_licores extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipos_de_licor);
		
		final Intent intent = getIntent( );
		final Intent intent_esp = new Intent(this, sub_de_marca.class);
		
		String licor = intent.getStringExtra( "elemento" );
        Log.d("licor: ", licor + "" );
        
		
	ArrayList<String> licor_especifico = new ArrayList<String>();
	
	if( licor.equalsIgnoreCase( "Vodka" ) ) {
		
		licor_especifico.add( "Van Gogh" );
		licor_especifico.add( "Skyy" );
		licor_especifico.add( "Stolichnaya" );
		licor_especifico.add( "Ultimat" );
		licor_especifico.add( "Pavlov" );
	}
	else if( licor.equalsIgnoreCase( "Tequila" ) ){
		
		licor_especifico.add( "Patron" );
		licor_especifico.add( "Quita Penas");
		licor_especifico.add( "El Charro" );
		licor_especifico.add( "Corralejo" );
		
	}
	else if( licor.equalsIgnoreCase( "Whisky" ) ) {
		
		licor_especifico.add( "Whyte & MacKay" );
		licor_especifico.add( "Johnnie Walker" );
		licor_especifico.add( "Old Parr" );
		licor_especifico.add( "Jack Daniels" );
		
	}
	else if( licor.equalsIgnoreCase( "Ron" ) ) {
		
		licor_especifico.add( "Botran 12 años" );
		licor_especifico.add( "Ron Zacapa" );
		licor_especifico.add( "XL" );
		
	}
	else if( licor.equalsIgnoreCase( "Absinthe" ) ) {
		
		licor_especifico.add( "Lucid" );
		licor_especifico.add( "Akveld" );
		
	}
	else if( licor.equalsIgnoreCase( "Vino" ) ) {
		
		licor_especifico.add( "Casillero del Diablo" );
		licor_especifico.add( "Cabernet" );
		licor_especifico.add( "Rioja" );
		licor_especifico.add( "Bicicleta" );
		licor_especifico.add( "Zinfandel" );
		
	}
	else if( licor.equalsIgnoreCase( "Cerveza" ) ) {
		
		licor_especifico.add( "Gallo" );
		licor_especifico.add( "Stella Artois" );
		licor_especifico.add( "Amstell" );
		licor_especifico.add( "Corona" );
		licor_especifico.add( "Brahva" );
		licor_especifico.add( "Monte Carlo" );
		licor_especifico.add( "Heineken" );
		licor_especifico.add( "Dorada" );
		
	}
	else {
		
		licor_especifico.add( "Jagermeister" );
	
	}
	
	MyAdapter adaptador = new MyAdapter( this, R.layout.activity_tipos_de_licor, licor_especifico );
	ListView listado = (ListView)findViewById(R.id.lista_de_licores);
	listado.setAdapter(adaptador);
	
	listado.setOnItemClickListener(new OnItemClickListener()
	{
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			
			
			ListView list = (ListView)arg0;
			
			String str1 = list.getAdapter().getItem(arg2).toString();
			
			Toast.makeText(getApplicationContext(), str1, Toast.LENGTH_LONG ).show();
			
			intent_esp.putExtra("specific", str1);
			startActivity(intent_esp);
			
						
		}
	});
	
	
	
}
	class MyAdapter extends ArrayAdapter {
		
		Context cont;
		int MyView;
		ArrayList<String> l;
		
		
		public MyAdapter( Context context, int textViewResourceID, ArrayList<String> list) {
			super(context, textViewResourceID, list);
			
			cont = context;
			MyView = textViewResourceID;
			l = list;

		}
		
		
		
	public View getView( int position, View convertView, ViewGroup parent ) {
			
			View v;
			if( convertView == null ){
				
				LayoutInflater inflator = (LayoutInflater)cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
				v = inflator.inflate(MyView, null, true);
			}
			else{
				v = convertView;
			}
			TextView txt = (TextView)v.findViewById(R.id.textView);
			txt.setText( l.get(position) );
			
			return v;
		}
	
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tipos_de_licor, menu);
		return true;
	}
}
