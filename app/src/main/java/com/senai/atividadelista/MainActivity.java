package com.senai.atividadelista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLista = (Button) findViewById(R.id.btnLista);
        btnLista.setOnClickListener(this);

        Button btnCadastro = (Button) findViewById(R.id.btnCadastrar);
        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Cadastrar.class);
                startActivity(it);
            }
        });


    }

    @Override
    public void onClick(View v) {
        Intent its = getIntent();
        if(its != null) {
            Bundle paramas = its.getExtras();
            if (paramas != null) {
                ArrayList<String> nomes = new ArrayList<>();
                nomes = paramas.getStringArrayList("nomesSalvos");
                Intent it = new Intent(this, ListaNomes.class);

                Bundle params = new Bundle();
                params.putStringArrayList("lista", nomes);

                it.putExtras(params);
                startActivity(it);
            }
        }
    }
}