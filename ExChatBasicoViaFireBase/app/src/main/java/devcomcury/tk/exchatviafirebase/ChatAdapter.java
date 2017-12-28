package devcomcury.tk.exchatviafirebase;

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

public class ChatAdapter extends RecyclerView.Adapter{
    private Context context;
    private ArrayList<Chat> conversa;

    public ChatAdapter(Context context,
                          ArrayList<Chat> converca) {
        this.context = context;
        this.conversa = converca;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.chat_conversa,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder hold = (ViewHolder) holder;
        Chat c = conversa.get(position);
        hold.tvEnviado.setText(c.getTextoEnviado());
        //hold.tvRecebido.setText(c.getTextoRecebido());
    }

    @Override
    public int getItemCount() {
        return conversa.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvEnviado;
        //private final TextView tvRecebido;

        public ViewHolder(View itemView) {
            super(itemView);
            tvEnviado = itemView.findViewById(R.id.cc_tv_enviado);
            //tvRecebido = itemView.findViewById(R.id.cc_tv_recebido);
        }//fecha construtor
    }
}
