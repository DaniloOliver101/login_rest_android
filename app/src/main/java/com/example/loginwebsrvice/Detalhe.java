package com.example.loginwebsrvice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Detalhe extends AppCompatActivity {
    TextView nome, email, telefone;
    Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe);

        // Configura a barra superior para apresentar um botão de voltar (<-)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Detalhes do Contato");

        Intent it = getIntent();
        Bundle params = it.getExtras();
        ArrayList<Contato> contatos = (ArrayList<Contato>) params.getSerializable("objContatos");

        String itemProcurado = params.getString("nome");

        for (Contato contato : contatos) {
            if (contato.getNome().equals(itemProcurado)) {
                nome = findViewById(R.id.nome);
                email = findViewById(R.id.email);
                telefone = findViewById(R.id.telefone);

                nome.setText(contato.getNome());
                email.setText(contato.getEmail());
                telefone.setText(contato.getTelefone());
            }
        }

    }

    // Botão na ActionBar (Barra Superior)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}