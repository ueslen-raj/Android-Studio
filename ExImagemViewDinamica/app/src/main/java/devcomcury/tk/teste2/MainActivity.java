package devcomcury.tk.teste2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Chamando Funções do Layout
    private Button btn_ok;
    private EditText et_number;
    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Dando Referencias as Funções de layout
        btn_ok = findViewById(R.id.btn_ok);
        et_number = findViewById(R.id.et_numero);
        imagem = findViewById(R.id.imageButton);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Chamando a Class Teste
                Teste t = new Teste();

                //Validando et_Number Para nao ter valores vazio
                if(et_number.getText().toString().isEmpty()){

                    //Chamando Uma Menssagem Temporario                   //Dizendo a Duração //Setando Ela na Tela com show()
                    Toast.makeText(getBaseContext(),"Campo(s) estão vazio(s)",Toast.LENGTH_LONG).show();
                }else{
                    //chamando Num da Class Teste,Mostrando que et_numero seta Num
                    t.setNum(Integer.parseInt(et_number.getText().toString()));

                    //Se Num foi igual a 1 seta a Imagem ic_Laucher_round
                    if(t.getNum() == 1) {
                        imagem.setImageResource(R.mipmap.ic_launcher_round);
                    }else{
                        //Senão seta a imagem ic_Laucher
                        imagem.setImageResource(R.mipmap.ic_launcher);
                    }//Fecha Else

                    //Limpa Campos Sitados.
                    Limpar();

                }//Fecha Else da Validação
            }//Fecha OnClick
        });//Fecha setOnClickListener
    }//fecha OnCreate

    //Limpar() para tirar algo que foi escrito.
    public void Limpar(){
        et_number.setText(null);
    }
}//Fecha MainActivity
