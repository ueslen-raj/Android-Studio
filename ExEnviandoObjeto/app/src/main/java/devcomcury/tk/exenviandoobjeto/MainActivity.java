package devcomcury.tk.exenviandoobjeto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    private static final String Tag = "MainActivity";
    private EditText etLogin;
    private EditText etSenha;
    private Button btnEntra;
    private RadioGroup sexo;
    private RadioButton masculino;
    private RadioButton feminino;
    private TextView tvLog;

    public static int Tela2 = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEntra = findViewById(R.id.ma_btn_entrar);
        etLogin = findViewById(R.id.ma_et_login);
        etSenha = findViewById(R.id.ma_et_senha);
        sexo = findViewById(R.id.ma_rg_sexo);
        masculino = findViewById(R.id.ma_rd_masculino);
        feminino = findViewById(R.id.ma_rd_feminino);
        tvLog = findViewById(R.id.ma_tv_log);


        btnEntra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etLogin.getText().toString().isEmpty()) {
                    Toast.makeText(getBaseContext(), "Campo Login Vazio", Toast.LENGTH_SHORT).show();
                }else {
                    if(etSenha.getText().toString().isEmpty()){
                        Toast.makeText(getBaseContext(),"Campo Senha Vazio",Toast.LENGTH_SHORT).show();
                    }else{
                Usuario u = new Usuario();
                u.setLogin(etLogin.getText().toString());
                u.setSenha(etSenha.getText().toString());
                    if (sexo.getCheckedRadioButtonId() == masculino.getId()) {
                        u.setSexo(masculino.getText().toString());
                    } else if (sexo.getCheckedRadioButtonId() == feminino.getId()) {
                        u.setSexo(feminino.getText().toString());
                    }
                    Intent it = new Intent(MainActivity.this, Tela2.class);
                    it.putExtra("u", u);
                    //startActivity(it);
                    startActivityForResult(it, Tela2);
                    onPause();
                }
            }
           }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Tela2){
            if(resultCode == RESULT_CANCELED){
                Toast.makeText(getBaseContext(),"Que Pena Voce Cancelo seu Merda",Toast.LENGTH_LONG).show();
            }else if(resultCode == RESULT_OK) {
                String CVV = data.getStringExtra("cvv");
                Toast.makeText(getBaseContext(), "cvv: " + CVV, Toast.LENGTH_LONG).show();
                tvLog.setText(CVV);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
