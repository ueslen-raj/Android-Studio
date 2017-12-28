package devcomcury.tk.exchatviafirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView chatGlobal;
    private EditText chat;
    private Button btnEnviar;

    private ArrayList<Chat> conversa;
    private ChatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviar = findViewById(R.id.ma_btn_enviar);
        chat = findViewById(R.id.ma_et_chat);
        chatGlobal = findViewById(R.id.ma_rv_chatGlobal);

        //Setando Adapter
        conversa = new ArrayList<>();
        adapter = new ChatAdapter(MainActivity.this,conversa);
        chatGlobal.setAdapter(adapter);
        chatGlobal.setHasFixedSize(true);
        chatGlobal.setLayoutManager(new LinearLayoutManager(this));

        FirebaseApp.initializeApp(MainActivity.this);
        final FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference banco = db.getReference("Conversa");
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Chat c = new Chat();
                c.setTextoEnviado(chat.getText().toString());
                banco.push().setValue(c);
                Toast.makeText(getBaseContext(),"Chat: "+c.toString(),Toast.LENGTH_SHORT).show();
                Limpar();

            }
        });
        banco.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    conversa.clear();
                    for(DataSnapshot data: dataSnapshot.getChildren()){
                        Chat c = data.getValue(Chat.class);
                        c.setKey(data.getKey());
                        conversa.add(c);
                    }//fecha for
                    adapter.notifyDataSetChanged();
                }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getBaseContext(),"Algo Esta Errado"+databaseError,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Limpar(){
        chat.setText(null);
    }
}
