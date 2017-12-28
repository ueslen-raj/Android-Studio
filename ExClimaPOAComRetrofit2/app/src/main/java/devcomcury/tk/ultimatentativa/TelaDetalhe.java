package devcomcury.tk.ultimatentativa;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaDetalhe extends AppCompatActivity {
    private TextView tvEstacao;
    private TextView tvDirecaoVento;
    private TextView tvBairro;
    private TextView tvPressao;
    private TextView tvVelocidadeVento;
    private TextView tvSensacaoTermica;
    private TextView tvLongitude;
    private TextView tvLatitude;
    private TextView tvTemperaturaMinima;
    private TextView tvTemperaturaMaxima;
    private TextView tvIconePrevisao;
    private ImageView imIconPrevisao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhes);
        tvTemperaturaMinima = findViewById(R.id.td_tv_temperaturaMin);
        tvTemperaturaMaxima = findViewById(R.id.td_tv_temperaturaMax);
        tvDirecaoVento = findViewById(R.id.td_tv_direcaoVento);
        tvEstacao = findViewById(R.id.td_tv_estacao);
        tvBairro = findViewById(R.id.td_tv_bairro);
        tvLatitude = findViewById(R.id.td_tv_latitude);
        tvLongitude = findViewById(R.id.td_tv_longitude);
        tvPressao = findViewById(R.id.td_tv_pressao);
        tvVelocidadeVento = findViewById(R.id.td_tv_velocidadeVento);
        tvSensacaoTermica = findViewById(R.id.td_tv_sensacaoTermica);
        tvIconePrevisao = findViewById(R.id.td_tv_clima);
        imIconPrevisao = findViewById(R.id.td_im_clima);
        Clima c= null;

        c = (Clima) getIntent().getSerializableExtra("c");

        if(c != null){
            if(c.getBairro() != null){
                tvBairro.setText(c.getBairro());
            }else{
                tvBairro.setText("Data Not Found.");
            }
            if(c.getEstacao() != null){
                tvEstacao.setText(c.getEstacao());
            }else{
                tvEstacao.setText("Data Not Found.");
            }
            if(c.getLatitude() != null){
                tvLatitude.setText(c.getLatitude());
            }else{
                tvLatitude.setText("Data Not Found.");
            }
            if(c.getLongitude() != null){
                tvLongitude.setText(c.getLongitude());
            }else{
                tvLongitude.setText("Data Not Found.");
            }
            if(c.getSensacaoTermica() != null){
                tvSensacaoTermica.setText(c.getSensacaoTermica());
            }else{
                tvSensacaoTermica.setText("Data Not Found.");
            }
            if(c.getTemperaturaMaximaPrevisao() != null){
                tvTemperaturaMaxima.setText(c.getTemperaturaMaximaPrevisao());
            }else{
                tvTemperaturaMaxima.setText("Data Not Found.");
            }
            if(c.getTemperaturaMinimaPrevisao() != null){
                tvTemperaturaMinima.setText(c.getTemperaturaMinimaPrevisao());
            }else{
                tvTemperaturaMinima.setText("Data Not Found.");
            }
            if(c.getPressao() != null){
                tvPressao.setText(c.getPressao());
            }else{
                tvPressao.setText("Data Not Found.");
            }
            if(c.getDirecaoVento() != null){
                tvDirecaoVento.setText(c.getDirecaoVento());
            }else{
                tvDirecaoVento.setText("Data Not Found.");
            }
            if(c.getVelocidadeVento() != null){
                tvVelocidadeVento.setText(c.getVelocidadeVento());
            }else{
                tvVelocidadeVento.setText("Data Not Found.");
            }
            if(c.getIconePrevisao() != null){
                tvIconePrevisao.setText(c.getIconePrevisao());
            }else{
                tvIconePrevisao.setText("Data Not Found.");
            }
            if(c.getIconePrevisao().equals("claro")){
                imIconPrevisao.setImageResource(R.drawable.naocarrega);
            }else if(c.getIconePrevisao().equals("chuva")){
                imIconPrevisao.setImageResource(R.drawable.chuva);
            }else if(c.getIconePrevisao().equals("parcial")){
                imIconPrevisao.setImageResource(R.drawable.naocarrega);
            }else if(c.getIconePrevisao().equals("solechuva")){
                imIconPrevisao.setImageResource(R.drawable.nublado);
            }else{
                imIconPrevisao.setImageResource(R.drawable.naocarrega);
            }
        }
    }
}
   /*     if (c.getIconePrevisao().equals("claro")) {
        tvIconePrevisao.setText("bright");
        } else if (c.getIconePrevisao().equals("chuva")) {
        tvIconePrevisao.setText("rain");
        } else if (c.getIconePrevisao().equals("parcial")) {
        tvIconePrevisao.setText("partial");
        } else if (c.getIconePrevisao().equals("solechuva")) {
        tvIconePrevisao.setText("Sun and rain");
        }*/