package devcomcury.tk.ultimatentativa;

/**
 * Created by t3ddy on 22/12/2017.
 */

public class Clima {

    private String estacao;
    private String bairro;
    private String latitude;
    private String longetude;
    private String data;
    private String pressao;
    private String direcaoVento;
    private String velocidadeVento;
    private String sensacaoTermica;

    public Clima() {
    }

    public Clima(String estacao, String bairro, String latitude, String longetude, String data, String pressao, String direcaoVento, String velocidadeVento, String sensacaoTermica) {
        this.estacao = estacao;
        this.bairro = bairro;
        this.latitude = latitude;
        this.longetude = longetude;
        this.data = data;
        this.pressao = pressao;
        this.direcaoVento = direcaoVento;
        this.velocidadeVento = velocidadeVento;
        this.sensacaoTermica = sensacaoTermica;
    }

    public String getEstacao() {
        return estacao;
    }

    public void setEstacao(String estacao) {
        this.estacao = estacao;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongetude() {
        return longetude;
    }

    public void setLongetude(String longetude) {
        this.longetude = longetude;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public String getDirecaoVento() {
        return direcaoVento;
    }

    public void setDirecaoVento(String direcaoVento) {
        this.direcaoVento = direcaoVento;
    }

    public String getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(String velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public String getSensacaoTermica() {
        return sensacaoTermica;
    }

    public void setSensacaoTermica(String sensacaoTermica) {
        this.sensacaoTermica = sensacaoTermica;
    }

    @Override
    public String toString() {
        return "Clima{" +
                "estacao='" + estacao + '\'' +
                ", bairro='" + bairro + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longetude='" + longetude + '\'' +
                ", data='" + data + '\'' +
                ", pressao='" + pressao + '\'' +
                ", direcaoVento='" + direcaoVento + '\'' +
                ", velocidadeVento='" + velocidadeVento + '\'' +
                ", sensacaoTermica='" + sensacaoTermica + '\'' +
                '}';
    }
}
