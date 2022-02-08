package com.senai.atividadelista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Cadastrar extends AppCompatActivity implements View.OnClickListener{

    protected ArrayList<String> nomes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        Button btnCadastrar = (Button) findViewById(R.id.btnAdicionar);
        btnCadastrar.setOnClickListener(this);

        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Cadastrar.this, MainActivity.class);

                Bundle params = new Bundle();
                params.putStringArrayList("nomesSalvos", nomes);
                it.putExtras(params);

                startActivity(it);
            }
        });
    }

    @Override
    public void onClick(View v) {
        EditText nome = (EditText) findViewById(R.id.inputNome);
        nomes.add(nome.getText().toString());
        System.out.println(nomes);

        Toast.makeText(this,"Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
    }
}