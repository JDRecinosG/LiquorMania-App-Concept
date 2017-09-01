package com.example.liquormania;

import java.util.ArrayList;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TiposDeLicor extends Activity {

    MediaPlayer bgMusic, bgMusic2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipos_de_licor);
        bgMusic = MediaPlayer.create(TiposDeLicor.this, R.raw.allnightparov);
        bgMusic2 = MediaPlayer.create(TiposDeLicor.this, R.raw.bootyswingparov);
        //bgMusic.start();


		Thread mMusic = new Thread() {
          public void run() {
              try {
                      bgMusic.start();
                      bgMusic.setLooping(true);

                  // implement a switch in order to pick music
                  // make it work like an "mp3 playlist"

                   // if (!bgMusic.isPlaying())
                   //     bgMusic2.start();

              } catch( Exception e ) {
                  bgMusic.stop();
                  bgMusic2.stop();
              } finally {

              }
          }
        };
        mMusic.start();
        //bgMusic.start();

		final Intent intent = new Intent(this, marcas_licores.class);

		// final Intent intent2 = new Intent(this, licor_especifico.class);

		/*List<Map<String, String>> tiposDeLicor = new ArrayList<Map<String, String>>();

		Map<String, String> item;
	    item = new HashMap<String, String>();
	    item.put("1", "A");
	    item.put("2", "B");
	    tiposDeLicor.add(item);
	    item = new HashMap<String, String>();
	    item.put("1", "C");
	    item.put("2", "D");
	    tiposDeLicor.add(item);*/

		ArrayList<String> tiposDeLicor = new ArrayList<String>();


		tiposDeLicor.add( "Jagermeister" );
		tiposDeLicor.add( "Vodka" );
		tiposDeLicor.add( "Whisky" );
		tiposDeLicor.add( "Tequila" );
		tiposDeLicor.add( "Ron" );
		tiposDeLicor.add( "Absinthe" );
		tiposDeLicor.add( "Vino" );
		tiposDeLicor.add( "Cerveza" );


		MyAdapter adaptador = new MyAdapter( this, R.layout.marca, tiposDeLicor );
		ListView listado = (ListView)findViewById(R.id.lista_de_licores);
		listado.setAdapter(adaptador);


		listado.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {


				ListView list = (ListView)arg0;

				String str = list.getAdapter().getItem(arg2).toString();

				Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG ).show();

				intent.putExtra("elemento", str);
				startActivity(intent);

				
				/* Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
				intent.putExtra(SearchManager.QUERY, str + " restaurante guatemala");
				startActivity(intent); */

			}
		});
		/*SimpleAdapter adapter = new SimpleAdapter(this, tiposDeLicor,android.R.layout.simple_list_item_1, new String[] { "AAA" },
			     new int[] { android.R.id.text1 });*/



			   // listado.setAdapter(adaptador);
			   // setContentView(R.layout.activity_tipos_de_licor);



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
			TextView txt = (TextView)v.findViewById(R.id.marcas);
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
