package devcomcury.tk.ultimatentativa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        ViewHolder hold = (ViewHolder) holder;
        Clima c = climas.get(position);
        hold.tvEstacao.setText(c.getEstacao());
        hold.tvSensacaoTermica.setText(c.getSensacaoTermica());
        hold.tvVelocidadeVento.setText(c.getVelocidadeVento());
        hold.tvPressao.setText(c.getPressao());
        hold.tvLongitude.setText(c.getLongitude());
        hold.tvLatitude.setText(c.getLatitude());
        hold.tvBairro.setText(c.getBairro());
        hold.tvDirecaoVento.setText(c.getDirecaoVento());
    }

    @Override
    public int getItemCount() {
        return climas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private final TextView tvEstacao;
        private final TextView tvDirecaoVento;
        private final TextView tvBairro;
        private final TextView tvPressao;
        private final TextView tvVelocidadeVento;
        private final TextView tvSensacaoTermica;
        private final TextView tvLongitude;
        private final TextView tvLatitude;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            tvDirecaoVento = itemView.findViewById(R.id.lc_tv_direcaoVento);
            tvEstacao = itemView.findViewById(R.id.lc_tv_estacao);
            tvBairro = itemView.findViewById(R.id.lc_tv_bairro);
            tvLatitude = itemView.findViewById(R.id.lc_tv_latitude);
            tvLongitude = itemView.findViewById(R.id.lc_tv_longetude);
            tvPressao = itemView.findViewById(R.id.lc_tv_pressao);
            tvVelocidadeVento = itemView.findViewById(R.id.lc_tv_velocidadeVento);
            tvSensacaoTermica = itemView.findViewById(R.id.lc_tv_sensacaoTermica);
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