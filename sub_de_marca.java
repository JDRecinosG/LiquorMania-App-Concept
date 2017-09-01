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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class sub_de_marca extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipos_de_licor);
		
		final Intent intent_esp = getIntent( );
        final Intent intent_rec = new Intent(this, receta.class);

		String licor_esp = intent_esp.getStringExtra( "specific" );
        Log.d("licor: ", licor_esp + "" );
        
        ArrayList<String> sub_licor = new ArrayList<String>();
        
        if( licor_esp.equalsIgnoreCase( "Skyy" ) ){
        	sub_licor.add( "Skyy: Original" );
        	sub_licor.add( "Skyy: Dragonfruit" );
        	sub_licor.add( "Skyy: Raspberry" );
        	sub_licor.add( "Skyy: Grape" );
        	sub_licor.add( "Skyy 90" );
        }
        else if( licor_esp.equalsIgnoreCase( "Van Gogh" ) ){
        	sub_licor.add( "Van Gogh: Original" );
        	sub_licor.add( "Van Gogh: Mango" );
        	sub_licor.add( "Van Gogh: Melon" );
        	sub_licor.add( "Van Gogh: Double Espresso" );
        	sub_licor.add( "Van Gogh: Acai-Blueberry" );
        	sub_licor.add( "Van Gogh: Banana" );
        	sub_licor.add( "Van Gogh: Pomegranate" );
        }
        else if( licor_esp.equalsIgnoreCase( "Stolichnaya" ) ){
        	sub_licor.add( "Stolichnaya: Original" );
        }
        else if( licor_esp.equalsIgnoreCase( "Ultimat" ) ){
        	sub_licor.add( "Ultimat: Original" );
        }
        else if( licor_esp.equalsIgnoreCase( "Pavlov" ) ){
        	sub_licor.add( "Pavlov: Original" );
        }
        else if( licor_esp.equalsIgnoreCase( "Patron" ) ){
        	sub_licor.add( "Patron: A�ejo" );
        	sub_licor.add( "Patrong: Cafe" );
        }
        else if( licor_esp.equalsIgnoreCase( "Quita Penas" ) ){
        	sub_licor.add( "Quita Penas: Crema de tequila" );
        	sub_licor.add( "Quita Penas: Original" );
        }
        else if( licor_esp.equalsIgnoreCase( "El Charro" ) ){
        	sub_licor.add( "El Charro: Gold" );
        	sub_licor.add( "El Charro: Silver" );
        }
        else if( licor_esp.equalsIgnoreCase( "Corralejo" ) ){
        	sub_licor.add( "Corralejo: A�ejo" );
        }
        else if( licor_esp.equalsIgnoreCase( "Whyte & MacKay" ) ){
        	sub_licor.add( "Whyte & MacKay: Special" );
        	sub_licor.add( "Whyte & MacKay: 13 a�os" );
        	sub_licor.add( "Whyte & MacKay: 19 a�os" );
        	sub_licor.add( "Whyte & MacKay: 23 a�os" );
        	sub_licor.add( "Whyte & MacKay: 31 a�os" );
        }
        else if( licor_esp.equalsIgnoreCase( "Johnnie Walker" ) ){
        	sub_licor.add( "Johnnie Walker: Red Label" );
        	sub_licor.add( "Johnnie Walker: Black Label" );
        	sub_licor.add( "Johnnie Walker: Green Label" );
        	sub_licor.add( "Johnnie Walker: Gold Label" );
        }
        else if( licor_esp.equalsIgnoreCase( "Old Parr" ) ){
        	sub_licor.add( "Old Parr: $$$" );
        }
        else if( licor_esp.equalsIgnoreCase( "Jack Daniels" ) ){
        	sub_licor.add( "Jack Daniels: $$$" );
        }
        else if( licor_esp.equalsIgnoreCase("Lucid" ) ){
        	sub_licor.add( "Lucid: $$$" );
        }
        else if( licor_esp.equalsIgnoreCase("J�germeister") ){
        	sub_licor.add( "J�germeister: $$$" );
        }
        
        MyAdapter adaptador = new MyAdapter( this, R.layout.especifico_de_marca, sub_licor );
    	ListView lista = (ListView)findViewById(R.id.lista_de_licores);
    	lista.setAdapter(adaptador);
    	
    	lista.setOnItemClickListener(new OnItemClickListener()
    	{
    		@Override
    		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
    				long arg3) {
    			
    			
    			ListView list = (ListView)arg0;
    			
    			String str = list.getAdapter().getItem(arg2).toString();
    			
    			Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG ).show();
    			
    			intent_rec.putExtra("especificacion", str);
    			startActivity(intent_rec);
    			
    						
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
			TextView txt = (TextView)v.findViewById(R.id.especificacion);
			txt.setText( l.get(position) );
			// Log.d( "licor: ", position + " " + (l.get(position) == null) );
			
			String s1 = l.get(position);
			
			if( s1.equalsIgnoreCase( "Skyy: Dragonfruit" ) ){
			ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
			iv.setImageResource(R.drawable.skyydragonfruit);
			}
			else if(l.get(position).equals("Skyy: Original") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.skyyoriginal);
			}
			else if(l.get(position).equals("Skyy: Grape") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.skyygrape);
			}
			else if(l.get(position).equals("Skyy: Raspberry") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.skyyraspberry);
			}
			else if(l.get(position).equals("Skyy 90") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.skyy90);
			}
			else if(l.get(position).equals("Van Gogh: Original") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.vangoghoriginal);
			}
			else if(l.get(position).equals("Van Gogh: Mango") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.vangoghmango);
			}
			else if(l.get(position).equals("Van Gogh: Melon") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.vangoghmelon);
			}
			else if(l.get(position).equals("Van Gogh: Banana") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.vangoghbanana);
			}
			else if(l.get(position).equals("Van Gogh: Acai-Blueberry") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.vangoghacai);
			}
			else if(l.get(position).equals("Van Gogh: Pomegranate") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.vangoghpomegranate);
			}
			else if(l.get(position).equals("Van Gogh: Double Espresso") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.vangoghespresso);
			}
			else if(l.get(position).equals("Jagermeister") ) {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.jager);
			}
			else {
				ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
				iv.setImageResource(R.drawable.ic_launcher);
			}
			
			
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
