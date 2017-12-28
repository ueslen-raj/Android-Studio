package devcomcury.tk.ultimatentativa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by t3ddy on 23/12/2017.
 */

public class ClimaAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Clima> climas;
    private static ClickListener clickListener;

    public ClimaAdapter(Context context, ArrayList<Clima> climas) {
        this.context = context;
        this.climas = climas;
    }

    public void setClimas(ArrayList<Clima> climas) {
        this.climas = climas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.linha_clima,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String TAG = "AdapaterClima";
        ViewHolder hold = (ViewHolder) holder;
        Clima c = climas.get(position);
        if(c.getBairro() != null) {
            hold.tvBairro.setText(c.getBairro());
        }else{
            hold.tvBairro.setText("Bairro Não Encontrado");
        }if(c.getTemperaturaMaximaPrevisao() != null){
            hold.tvTemperaturaMaxima.setText(c.getTemperaturaMaximaPrevisao());
        }else{
            hold.tvTemperaturaMaxima.setText("Temperatura Não Encontrada");
        }if(c.getTemperaturaMinimaPrevisao() != null){
            hold.tvTemperaturaMinima.setText(c.getTemperaturaMinimaPrevisao());
        }else {
            hold.tvTemperaturaMinima.setText("Temperatura Não Encontrada");
        }
        if(c.getIconePrevisao().equals("claro")){
            hold.imClima.setImageResource(R.drawable.naocarrega);
        }else if(c.getIconePrevisao().equals("chuva")){
            hold.imClima.setImageResource(R.drawable.chuva);
        }else if(c.getIconePrevisao().equals("parcial")){
            hold.imClima.setImageResource(R.drawable.naocarrega);
        }else if(c.getIconePrevisao().equals("solechuva")){
            hold.imClima.setImageResource(R.drawable.nublado);
        }else{
            hold.imClima.setImageResource(R.drawable.naocarrega);
        }

    }

    @Override
    public int getItemCount() {
        return climas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        private final ImageView imClima;
        private final TextView tvBairro;
        private final TextView tvTemperaturaMinima;
        private final TextView tvTemperaturaMaxima;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            imClima = itemView.findViewById(R.id.lc_iv_clima);
            tvTemperaturaMinima = itemView.findViewById(R.id.td_tv_temperaturaMin);
            tvTemperaturaMaxima = itemView.findViewById(R.id.lc_tv_temperaturaMax);
            tvBairro = itemView.findViewById(R.id.lc_tv_bairro);
        }
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(),v);
            return true;
        }
    }
    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener){
        ClimaAdapter.clickListener = clickListener;
    }
}