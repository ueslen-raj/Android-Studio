package devcomcury.tk.exenviandoobjeto;

import java.io.Serializable;

/**
 * Created by t3ddy on 13/12/2017.
 */

public class Usuario implements Serializable {
    private String login;
    private String senha;
    private String sexo;

    public Usuario() {
    }

    public Usuario(String login, String senha, String sexo) {
        this.login = login;
        this.senha = senha;
        this.sexo = sexo;
    }

    public String getSexo() { return sexo; }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Login: "+login+"\nSenha: "+senha+"\nSexo: "+sexo;
    }
}
