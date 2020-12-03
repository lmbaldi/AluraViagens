package com.example.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.dao.PacoteDao;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

import static com.example.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configurarLista();
       }

    private void configurarLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener((adapterView, view, posicao, id) -> {
            Pacote pacoteClicado = pacotes.get(posicao);
            irParaResumoPacote(pacoteClicado);
        });
    }

    private void irParaResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}