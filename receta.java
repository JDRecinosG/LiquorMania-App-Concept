package com.example.liquormania;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jrecinos on 11/25/15.
 */
public class receta extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_de_licor);

        final Intent intent_rec = getIntent();

        String licor_rec = intent_rec.getStringExtra("especificacion");
        Log.d("licor: ", licor_rec + "" );

        ArrayList<String> receta_licor = new ArrayList();

        if (licor_rec.equalsIgnoreCase("Van Gogh: Original"))
        {
            receta_licor.add("VODKA TONIC\n" +
                    "2 oz de vodka Van Gogh: Original\n" +
                    "4 oz de agua tonica\n" +
                    "1-2 cachetes de limon\n" +
                    "exprimir los cachetes de limon y\n" +
                    "dejar caerlo en el vaso!");
            // Look it up in the Database instead of hardcoding
        } else if (licor_rec.equalsIgnoreCase("Van Gogh: Mango") ) {
            receta_licor.add( "MANGO-TINI\n" +
                    "1.5 oz de vodka Van Gogh: Mango\n" +
                    "1/2 oz de licor de mango\n" +
                    "2 oz de jugo de mango natural\n" +
                    "agitar bien durante 10-15 segundos!");
        }

        MyAdapter adaptador = new MyAdapter( this, R.layout.receta, receta_licor );
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

        public MyAdapter( Context context, int textViewResourceID, ArrayList<String> list ) {
            super( context, textViewResourceID, list );

            cont = context;
            MyView = textViewResourceID;
            l = list;
        }

        public View getView( int position, View convertView, ViewGroup parent ) {
            View v;
            if( convertView == null ) {
                LayoutInflater inflator = (LayoutInflater)cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = inflator.inflate(MyView, null, true);
            } else {
                v = convertView;
            }
            TextView txt = (TextView)v.findViewById(R.id.receta_txt);
            txt.setText( l.get(position) );

            String s1 = l.get(position);

            if( s1.equalsIgnoreCase("Van Gogh: Original") ) {
                ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
                iv.setImageResource(R.drawable.receta_vangoghoriginal);
            } else if (l.get(position).equals("Van Gogh: Mango") ) {
                ImageView iv = (ImageView)v.findViewById(R.id.imagenLicor);
                iv.setImageResource(R.drawable.receta_vangoghmango);

            }
            fadeIn(convertView);


            return v;
        }
    }

    public void fadeIn(View view) {

        try {
            TextView text_receta = (TextView) findViewById(R.id.receta_txt);
            //text_receta.setVisibility(View.VISIBLE);

            Animation animationAlpha = AnimationUtils.loadAnimation(this, R.anim.alpha);
            text_receta.startAnimation(animationAlpha);





        } catch (Exception e) {
            //Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate(R.menu.tipos_de_licor, menu);
        return true;
    }


}
