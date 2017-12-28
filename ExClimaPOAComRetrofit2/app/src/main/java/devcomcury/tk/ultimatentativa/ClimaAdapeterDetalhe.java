package devcomcury.tk.ultimatentativa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by t3ddy on 25/12/2017.
 */

public class ClimaAdapeterDetalhe extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Clima> clima2;
    private static ClickListener clickListener;

    public ClimaAdapeterDetalhe(Context context, ArrayList<Clima> climas) {
        this.context = context;
        this.clima2 = climas;
    }
    public void setClima2(ArrayList<Clima> climas) {
        this.clima2 = climas;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.tela_detalhes,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holde = (ViewHolder) holder;
        Clima c = clima2.get(position);
        if(c.getIconePrevisao() != null){
            holde.tvClima.setText(c.getIconePrevisao());
        }else{
            holde.tvClima.setText("Clima Nao informado");
        }
        if(c.getEstacao() != null) {
            holde.tvEstacao.setText(c.getEstacao());
        }else {
            holde.tvEstacao.setText("Dados não encontrado");
        }if(c.getDirecaoVento() != null) {
            holde.tvDirecaoVento.setText(c.getDirecaoVento());
        }else{
            holde.tvDirecaoVento.setText("Dados não encontrado");
        }
        if(c.getBairro() != null) {
             holde.tvBairro.setText(c.getBairro());
        }else{
            holde.tvBairro.setText("Dados não encontrado");
        }
        if(c.getPressao() != null){
                holde.tvPressao.setText(c.getPressao());
        }else{
            holde.tvPressao.setText("Dados não encontrado");
        }
        if(c.getVelocidadeVento() != null) {
            holde.tvVelocidadeVento.setText(c.getVelocidadeVento());
        }else{
            holde.tvVelocidadeVento.setText("Dados não encontrado");
        }
        if(c.getSensacaoTermica() != null) {
            holde.tvSensacaoTermica.setText(c.getSensacaoTermica());
        }else{
            holde.tvSensacaoTermica.setText("Dados não encontrado");
        }
        if(c.getLongitude() != null) {
            holde.tvLongitude.setText(c.getLongitude());
        }else{
            holde.tvLongitude.setText("Dados não encontrado");
        }
        if(c.getLatitude() != null){
            holde.tvLatitude.setText(c.getLatitude());
        }else{
            holde.tvLatitude.setText("Dados não encontrado");
        }
        if(c.getTemperaturaMaximaPrevisao() != null) {
            holde.tvTemperaturaMaxima.setText(c.getTemperaturaMaximaPrevisao());
        }else{
            holde.tvTemperaturaMaxima.setText("Dados não encontrado");
        }
        if(c.getTemperaturaMinimaPrevisao() != null) {
            holde.tvTemperaturaMinima.setText(c.getTemperaturaMinimaPrevisao());
        }else{
            holde.tvTemperaturaMinima.setText("Dados não encontrado");
        }

    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        private final TextView tvEstacao;
        private final TextView tvDirecaoVento;
        private final TextView tvBairro;
        private final TextView tvPressao;
        private final TextView tvVelocidadeVento;
        private final TextView tvSensacaoTermica;
        private final TextView tvLongitude;
        private final TextView tvLatitude;
        private final TextView tvTemperaturaMinima;
        private final TextView tvTemperaturaMaxima;
        private final TextView tvClima;
        private final ImageView imClima;
        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            tvClima = itemView.findViewById(R.id.td_tv_clima);
            imClima = itemView.findViewById(R.id.td_im_clima);
            tvTemperaturaMinima = itemView.findViewById(R.id.td_tv_temperaturaMin);
            tvTemperaturaMaxima = itemView.findViewById(R.id.td_tv_temperaturaMax);
            tvDirecaoVento = itemView.findViewById(R.id.td_tv_direcaoVento);
            tvEstacao = itemView.findViewById(R.id.td_tv_estacao);
            tvBairro = itemView.findViewById(R.id.td_tv_bairro);
            tvLatitude = itemView.findViewById(R.id.td_tv_latitude);
            tvLongitude = itemView.findViewById(R.id.td_tv_longitude);
            tvPressao = itemView.findViewById(R.id.td_tv_pressao);
            tvVelocidadeVento = itemView.findViewById(R.id.td_tv_velocidadeVento);
            tvSensacaoTermica = itemView.findViewById(R.id.td_tv_sensacaoTermica);
        }

        @Override
        public void onClick(View view) {

        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
    @Override
    public int getItemCount() {
        return clima2.size();
    }
    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }

    public void setOnItemClickListener(ClimaAdapeterDetalhe.ClickListener clickListener){
        ClimaAdapeterDetalhe.clickListener = clickListener;
    }
}
