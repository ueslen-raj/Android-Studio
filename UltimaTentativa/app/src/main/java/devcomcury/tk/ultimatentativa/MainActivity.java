package devcomcury.tk.ultimatentativa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progress;
    private RecyclerView rvClima;
    private ArrayList<Clima>climas;
    private ClimaAdapter adapter;
    public String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvClima = findViewById(R.id.ma_rv_clima);
        progress = findViewById(R.id.progress);
        progress.setVisibility(View.INVISIBLE);
        climas = new ArrayList<>();
        adapter = new ClimaAdapter(MainActivity.this,climas);
        rvClima.setAdapter(adapter);
        rvClima.setHasFixedSize(true);
        rvClima.setLayoutManager(
                new LinearLayoutManager(this));

        Gson g = new GsonBuilder().registerTypeAdapter(
                Clima.class,
                new ClimaDeserialize()).create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIRetrofitService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(g))
                .build();
        final APIRetrofitService service = retrofit.create(APIRetrofitService.class);



        adapter.setOnItemClickListener(new ClimaAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

            }

            @Override
            public void onItemLongClick(int position, View v) {

            }
        });
    }
}
