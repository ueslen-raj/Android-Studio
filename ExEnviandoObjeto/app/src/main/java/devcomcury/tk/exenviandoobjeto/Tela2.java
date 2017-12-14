package devcomcury.tk.exenviandoobjeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {
    private EditText etCVV;
    private Button btnOk;
    private Button btnCancela;
    private TextView tvLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        tvLog = findViewById(R.id.t2_et_log);
        btnCancela = findViewById(R.id.t2_btn_cancela);
        btnOk = findViewById(R.id.t2_btn_ok);
        etCVV = findViewById(R.id.t2_et_cvv);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.putExtra("cvv",etCVV.getText().toString());
                setResult(RESULT_OK,it);
                finish();
            }
        });
        btnCancela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        Usuario u = null;
        u = (Usuario) getIntent().getSerializableExtra("u");
        if(u == null){
            Toast.makeText(getBaseContext(),"Deu merda",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getBaseContext(),u.toString(),Toast.LENGTH_LONG).show();
            tvLog.setText(u.toString());
        }
    }
}
