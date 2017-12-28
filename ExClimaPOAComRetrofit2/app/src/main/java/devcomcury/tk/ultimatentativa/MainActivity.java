package devcomcury.tk.ultimatentativa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
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

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvClima;
    private ArrayList<Clima>climas;
    private ClimaAdapter adapter;
    public String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvClima = findViewById(R.id.ma_rv_clima);

        adapter = new ClimaAdapter(MainActivity.this,new ArrayList<Clima>(0));
        rvClima.setAdapter(adapter);
        rvClima.setHasFixedSize(true);
        rvClima.setLayoutManager(new LinearLayoutManager(this));

        Gson g = new GsonBuilder().registerTypeAdapter(
                Clima.class,
                new ClimaDeserialize()).create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIRetrofitService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(g))
                .build();

        final APIRetrofitService service = retrofit.create(APIRetrofitService.class);

        final Call<List<Clima>> climaCall = service.getClimaCall();

        climaCall.enqueue(new Callback<List<Clima>>() {
            @Override
            public void onResponse(Call<List<Clima>> call, Response<List<Clima>> response) {
                    List<Clima> climaAux = response.body();

                    climas = new ArrayList<>();

                    for (Clima clima : climaAux) {
                        climas.add(clima);
                    }

                /* Setando a lista de produtos proveniente da internet */
                    adapter.setClimas(climas);
                /* Notificando o adapter sobre o novo array */
                    adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Clima>> call, Throwable t) {

                Toast.makeText(
                        getBaseContext(),
                        "Erro na conexão!"+t.getMessage(),
                        Toast.LENGTH_LONG).show();

            }
        });

        adapter.setOnItemClickListener(new ClimaAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                Clima c = climas.get(position);
                Intent it = new Intent(MainActivity.this,TelaDetalhe.class);
                it.putExtra("c",c);
                startActivity(it);
            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }
}
