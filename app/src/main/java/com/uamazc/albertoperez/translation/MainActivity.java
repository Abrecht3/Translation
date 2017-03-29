package com.uamazc.albertoperez.translation;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static int TIEMPO_ESPERA = 500;

    ImageButton btnleft,btnright,btnup;
    ImageView moveIm;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnleft=(ImageButton) findViewById(R.id.btnleft);
        btnright=(ImageButton) findViewById(R.id.btnrigth);
        btnup=(ImageButton) findViewById(R.id.buttonup);
        moveIm=(ImageView) findViewById(R.id.perrito);

        btnleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveIm.setX(moveIm.getX() - 20);
                moveIm.setImageResource(R.drawable.perro_izquierda);
            }
        });

        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveIm.setY(moveIm.getY() - 20);
                moveIm.setX(moveIm.getX() + 20);
                caer(TIEMPO_ESPERA);
            }
        });

        btnright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveIm.setX(moveIm.getX() + 20);
                moveIm.setImageResource(R.drawable.perro_derecha);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void caer(int milisegundos) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // acciones que se ejecutan tras los milisegundos
                moveIm.setY(moveIm.getY() + 20);
                moveIm.setX(moveIm.getX() + 20);
            }
        }, milisegundos);
    }
}
