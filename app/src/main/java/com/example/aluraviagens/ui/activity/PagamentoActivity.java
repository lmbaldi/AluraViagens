package com.example.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.MoedaUtil;

import java.math.BigDecimal;

import static com.example.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);
        carregarPacoteRecebido();
    }

    private void carregarPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            mostrarPreco(pacote);
            configurarBotao(pacote);
        }
    }

    private void configurarBotao(Pacote pacote) {
        Button botaoFinalizarCompra = findViewById(R.id.pagamento_botao_finalizar_compra);
        botaoFinalizarCompra.setOnClickListener(view -> {
            irParaResumoCompra(pacote);
        });
    }

    private void irParaResumoCompra(Pacote pacote) {
        Intent intentResumoCompra = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intentResumoCompra.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intentResumoCompra);
    }

    private void mostrarPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moeda = MoedaUtil.formatarMoeda(pacote.getPreco());
        preco.setText(moeda);
    }
}