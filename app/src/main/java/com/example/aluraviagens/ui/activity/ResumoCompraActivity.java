package com.example.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aluraviagens.R;
import com.example.aluraviagens.model.Pacote;
import com.example.aluraviagens.util.DataUtil;
import com.example.aluraviagens.util.MoedaUtil;
import com.example.aluraviagens.util.ResourcesUtil;

import static com.example.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);
        carregarPacoteRecebido();
    }

    private void carregarPacoteRecebido() {
        Intent intent = getIntent();

        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializarCampos(pacote);
        }
    }

    private void inicializarCampos(Pacote pacote) {
        mostrarLocal(pacote);
        mostrarImagem(pacote);
        mostrarData(pacote);
        mostrarPreco(pacote);
    }

    private void mostrarPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String moeda = MoedaUtil.formatarMoeda(pacote.getPreco());
        preco.setText(moeda);
    }

    private void mostrarData(Pacote pacote) {
        TextView data = findViewById((R.id.resumo_compra_data_viagem));
        String peridoEmTexto = DataUtil.conveterPeriodoEmTexto(pacote.getDias());
        data.setText(peridoEmTexto);
    }

    private void mostrarImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawableDoPacote = ResourcesUtil.getDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostrarLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }
}