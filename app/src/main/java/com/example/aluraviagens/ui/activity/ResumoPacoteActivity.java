package com.example.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.DataUtil;
import com.example.aluraviagens.util.DiasUtil;
import com.example.aluraviagens.util.MoedaUtil;
import com.example.aluraviagens.util.ResourcesUtil;

import static com.example.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);
        carregarPacoteRecebido();
    }

    private void carregarPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            inicializarCampos(pacote);
            configurarBotao(pacote);
        }
    }

    private void inicializarCampos(Pacote pacote) {
        mostrarLocal(pacote);
        mostrarImagem(pacote);
        mostrarDias(pacote);
        mostrarPreco(pacote);
        mostrarData(pacote);
    }

    private void configurarBotao(Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_botao_realizar_pagamento);
        botaoRealizaPagamento.setOnClickListener(view -> {
            irParaPagamento(pacote);
        });
    }

    private void irParaPagamento(Pacote pacote) {
        Intent intentPgto = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intentPgto.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intentPgto);
    }

    private void mostrarData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = DataUtil.conveterPeriodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

    private void mostrarPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moeda = MoedaUtil.formatarMoeda(pacote.getPreco());
        preco.setText(moeda);
    }

    private void mostrarDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formatarEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostrarImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourcesUtil.getDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostrarLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}