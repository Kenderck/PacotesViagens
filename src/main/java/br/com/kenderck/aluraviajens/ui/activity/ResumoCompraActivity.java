package br.com.kenderck.aluraviajens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.kenderck.aluraviajens.R;
import br.com.kenderck.aluraviajens.model.Pacote;
import br.com.kenderck.aluraviajens.util.DataUtil;
import br.com.kenderck.aluraviajens.util.MoedaUtil;
import br.com.kenderck.aluraviajens.util.ResourcesUtil;

import static br.com.kenderck.aluraviajens.PacoteActivitiesConstantes.PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String APPBAR_TITULO = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(APPBAR_TITULO);

        carregaPacoteRecebido();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ResumoCompraActivity.this, ListaPacotesActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//meio que tira todas as activities da pilha
        startActivity(intent);

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(PACOTE)) {

            Pacote pacote = (Pacote) intent.getSerializableExtra(PACOTE);
            inicializaCampos(pacote);

        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraData(pacote);
        mostraPrecoPacote(pacote);
    }

    private void mostraPrecoPacote(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_valor_pacote);
        String moedaBr = MoedaUtil.formataMoeda(pacote.getPreco());
        preco.setText(moedaBr);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataFormatada = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatada);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem);
        Drawable drawable = ResourcesUtil.devolveUmDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }
}
