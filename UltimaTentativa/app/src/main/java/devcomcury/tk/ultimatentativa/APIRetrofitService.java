package devcomcury.tk.ultimatentativa;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by t3ddy on 22/12/2017.
 */

public interface APIRetrofitService {
    String BASE_URL = "https://metroclimaestacoes.procempa.com.br/metroclima/seam/resource/rest/externalRest/ultimaLeitura";

    @GET()
    Call<List<Clima>> getClimaCall();
}
