package devcomcury.tk.ultimatentativa;

import android.util.Log;
import android.widget.Adapter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by t3ddy on 22/12/2017.
 */

public class Clima implements Serializable {

    private String estacao;
    private String bairro;
    private String latitude;
    private String longitude;
    private String data;
    private String pressao;
    private String direcaoVento;
    private String velocidadeVento;
    private String sensacaoTermica;
    private String temperaturaMinimaPrevisao;
    private String temperaturaMaximaPrevisao;
    private String iconePrevisao;


    public Clima(String location, int localizacao, float latitude, float longitude) {
    }

    public Clima(String estacao,String iconePrevisao, String bairro, String latitude, String longitude, String data, String pressao, String direcaoVento, String velocidadeVento, String sensacaoTermica, String temperaturaMinimaPrevisao, String temperaturaMaximaPrevisao) {
        this.estacao = estacao;
        this.bairro = bairro;
        this.latitude = latitude;
        this.longitude = longitude;
        this.data = data;
        this.pressao = pressao;
        this.direcaoVento = direcaoVento;
        this.velocidadeVento = velocidadeVento;
        this.sensacaoTermica = sensacaoTermica;
        this.temperaturaMinimaPrevisao = temperaturaMinimaPrevisao;
        this.temperaturaMaximaPrevisao = temperaturaMaximaPrevisao;
        this.iconePrevisao = iconePrevisao;
    }

    public String getIconePrevisao() {
        return iconePrevisao;
    }

    public void setIconePrevisao(String iconePrevisao) {
        this.iconePrevisao = iconePrevisao;
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

    public final String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public final String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
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

    public String getTemperaturaMinimaPrevisao() {
        return temperaturaMinimaPrevisao;
    }

    public void setTemperaturaMinimaPrevisao(String temperaturaMinimaPrevisao) {
        this.temperaturaMinimaPrevisao = temperaturaMinimaPrevisao;
    }

    public String getTemperaturaMaximaPrevisao() {
        return temperaturaMaximaPrevisao;
    }

    public void setTemperaturaMaximaPrevisao(String temperaturaMaximaPrevisao) {
        this.temperaturaMaximaPrevisao = temperaturaMaximaPrevisao;
    }

    public static ArrayList<Clima> getClima(){
        ArrayList<Clima> cli = new ArrayList<>();
        cli.add(new Clima("Location",R.drawable.localizacao,(float)-30.028033, (float)-51.22353));
        return cli;
    }

    @Override
    public String toString() {
        return "Clima{" +
                "estacao='" + estacao + '\'' +
                ", bairro='" + bairro + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", data='" + data + '\'' +
                ", pressao='" + pressao + '\'' +
                ", direcaoVento='" + direcaoVento + '\'' +
                ", velocidadeVento='" + velocidadeVento + '\'' +
                ", sensacaoTermica='" + sensacaoTermica + '\'' +
                ", temperaturaMinimaPrevisao='" + temperaturaMinimaPrevisao + '\'' +
                ", temperaturaMaximaPrevisao='" + temperaturaMaximaPrevisao + '\'' +
                '}';
    }
}
