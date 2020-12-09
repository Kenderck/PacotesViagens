package br.com.kenderck.aluraviajens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.kenderck.aluraviajens.R;
import br.com.kenderck.aluraviajens.adapter.listaPacotesAdapter;
import br.com.kenderck.aluraviajens.dao.PacoteDAO;
import br.com.kenderck.aluraviajens.model.Pacote;

import static br.com.kenderck.aluraviajens.PacoteActivitiesConstantes.PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String APPBAR_PACOTE = "Pacotes";//Ctrl + Alt + c


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(APPBAR_PACOTE);

        configuraLista();
    }

    private void configuraLista() {//Ctrl + Alt + m
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new listaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vaiParaResumoPacotes(position, pacotes);
            }
        });
    }

    private void vaiParaResumoPacotes(int position, List<Pacote> pacotes) {
        Pacote pacoteEscolhido = pacotes.get(position);
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(PACOTE, pacoteEscolhido);
        startActivity(intent);
    }
}
