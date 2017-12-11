package devcomcury.tk.teste2;

/**
 * Created by t3ddy on 09/12/2017.
 */

public class Teste {

    private int num;
    //construtor vazio
    public Teste() {
    }
    //Chamando os valores
    public int getNum() {
        return num;
    }
    //Setando os Valores
    public void setNum(int num) {
        this.num = num;
    }


    @Override //Mostrando os Valores
    public String toString() {
        return "Num: "+num;
    }
}
