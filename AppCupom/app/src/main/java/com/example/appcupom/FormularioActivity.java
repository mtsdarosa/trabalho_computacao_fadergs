package com.example.appcupom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Date;

public class FormularioActivity extends AppCompatActivity {
    private EditText etCodigoCupom;
    private EditText dtDataValidade;
    private EditText nbValorDesconto;
    private Button btnSalvar;
    private String acao;
    private Cupom cupom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etCodigoCupom = findViewById(R.id.etCodigoCupom);
        dtDataValidade = findViewById(R.id.dtDataValidade);
        nbValorDesconto = findViewById(R.id.nbValorDesconto);
        btnSalvar = findViewById(R.id.btnSalvar);

        acao = getIntent().getStringExtra("acao");
        if (acao.equals("editar")){
            try {
                carregaFormulario();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
               salvar();
           }
        });
    }

    private void carregaFormulario() throws ParseException {
        int idCupom = getIntent().getIntExtra("idCupom", 0);
        if (idCupom != 0){
            cupom = CupomDAO.getCupomById(this, idCupom);

            etCodigoCupom.setText(cupom.getCodigoCupom());
            dtDataValidade.setText(cupom.getDataValidade());
            nbValorDesconto.setText(String.valueOf(cupom.getValorDesconto()));
        }
    }

    private void salvar(){
        if (etCodigoCupom.getText().toString().isEmpty() || dtDataValidade.getText().toString().isEmpty() ||
            nbValorDesconto.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Todos os campos devem ser preenchidos.", Toast.LENGTH_SHORT).show();
        }else{
            if (acao.equals("novo")){
                cupom = new Cupom();
            }

            cupom.setCodigoCupom(etCodigoCupom.getText().toString());
            cupom.setDataValidade(dtDataValidade.getText().toString());
            cupom.setValorDesconto(Float.parseFloat(nbValorDesconto.getText().toString()));

            if (acao.equals("editar")){
                CupomDAO.editar(cupom, this);
                finish();
            }else{
                CupomDAO.inserir(cupom, this);
                etCodigoCupom.setText("");
                dtDataValidade.setText("");
                nbValorDesconto.setText("");
            }
        }
    }

}