package com.daniele.fisiohome.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daniele.fisiohome.FisioHome;
import com.daniele.fisiohome.R;
import com.daniele.fisiohome.model.Agendamento;
import com.daniele.fisiohome.model.Endereco;
import com.daniele.fisiohome.model.Fisioterapeuta;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AgendarActivity extends AppCompatActivity {

    private TextView campoData, campoLocal, campoNomeFisio, campoMotivo, campoPagamento;
    private Button botaoConfirmarAgendamento;
    DatabaseReference databaseAgendamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar);

        campoData = findViewById(R.id.data_agendamento);
        campoLocal = findViewById(R.id.local_agendamento);
        campoMotivo = findViewById(R.id.motivo_agendamento);
        campoNomeFisio = findViewById(R.id.fisioterapeuta_agendamento);
        campoPagamento = findViewById(R.id.pagamento_agendamento);
        botaoConfirmarAgendamento = findViewById(R.id.button_confirmar_agendamento);

        Fisioterapeuta fisioterapeuta = FisioHome.getFisioterapeutaAtual();


        campoNomeFisio.setText(fisioterapeuta.getNome());

       // Endereco endereco = fisioterapeuta.getEnderecoFisioterapeuta();
       // String local = endereco.getLogradouro() + " - " + String.valueOf(endereco.getNumero()) + ", " + endereco.getCidade();
        campoLocal.setText(FisioHome.getFisioterapeutaAtual().getLogradouro() + " - " + String.valueOf(FisioHome.getFisioterapeutaAtual().getNumero()) + ", " + FisioHome.getFisioterapeutaAtual().getCidade() );

        Intent intent = getIntent();

        // agora recuperamos as strings que armazenamos no intent
        String id = intent.getStringExtra("FISIOTERAPEUTA_ID");

        databaseAgendamento = FirebaseDatabase.getInstance().getReference("agendamentos").child(id);


        botaoConfirmarAgendamento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                salvarAgendamento();
            }
        });
    }

    private void salvarAgendamento() {



            String id = databaseAgendamento.push().getKey();

            Agendamento agendamento = new Agendamento(id, "06/05/2019", true );

            databaseAgendamento.child(id).setValue(agendamento);

            Toast.makeText(this, "Agendamento realizado com sucesso!", Toast.LENGTH_LONG).show();


    }

}


