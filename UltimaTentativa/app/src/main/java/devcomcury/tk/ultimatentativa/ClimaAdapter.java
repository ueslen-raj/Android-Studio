package devcomcury.tk.ultimatentativa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by t3ddy on 23/12/2017.
 */

public class ClimaAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Clima> climas;
    private static ClickListener clickListener;

    public ClimaAdapter(Context context,
                        ArrayList<Clima> climas) {
        this.context = context;
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
            Clima c = new Clima();
            hold.tvEstacao.setText(c.getEstacao());
    }

    @Override
    public int getItemCount() {
        return climas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {

        private final TextView tvEstacao;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            tvEstacao = itemView.findViewById(R.id.lc_tv_estacao);
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