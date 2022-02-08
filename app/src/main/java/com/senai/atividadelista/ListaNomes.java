package com.senai.atividadelista;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListaNomes extends ListActivity {

    private ArrayList<String> nomes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent it = getIntent();
        if(it != null) {
            Bundle paramas = it.getExtras();
            if (paramas != null) {
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        paramas.getStringArrayList("lista")
                );
                setListAdapter(arrayAdapter);
            }
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String nome = (String) this.getListAdapter().getItem(position);
        Toast.makeText(this, "Você selecionou: " + nome, Toast.LENGTH_SHORT).show();
    }
}