package devcomcury.tk.exchatviafirebase;

/**
 * Created by t3ddy on 23/12/2017.
 */

public class Chat {
    private String textoEnviado;
    private String textoRecebido;
    private String key;

    public Chat() {
    }

    public Chat(String textoEnviado, String textoRecebido, String key) {
        this.textoEnviado = textoEnviado;
        this.textoRecebido = textoRecebido;
        this.key = key;
    }

    public String getTextoEnviado() {
        return textoEnviado;
    }

    public void setTextoEnviado(String textoEnviado) {
        this.textoEnviado = textoEnviado;
    }

    public String getTextoRecebido() {
        return textoRecebido;
    }

    public void setTextoRecebido(String textoRecebido) {
        this.textoRecebido = textoRecebido;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    @Override
    public String toString() {
        return "\ntexto recebido: "+textoRecebido+"\nTexto Enviado: "+textoEnviado+"\nChave: "+key;
    }
}
