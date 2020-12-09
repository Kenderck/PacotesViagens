package br.com.kenderck.aluraviajens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.kenderck.aluraviajens.R;
import br.com.kenderck.aluraviajens.model.Pacote;
import br.com.kenderck.aluraviajens.util.MoedaUtil;

import static br.com.kenderck.aluraviajens.PacoteActivitiesConstantes.PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String APPBAR_TITULO = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(APPBAR_TITULO);


        carregaPacoteRecebido();


    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACOTE)) {
            final Pacote pacote = (Pacote) intent.getSerializableExtra(PACOTE);

            mostraPreco(pacote);

            configuraBotao(pacote);
        }
    }

    private void configuraBotao(final Pacote pacote) {
        Button botaoFinalizaCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinalizaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompra(pacote);
            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_valor_pacote);
        String moedaBr = MoedaUtil.formataMoeda(pacote.getPreco());
        preco.setText(moedaBr);
    }
}
