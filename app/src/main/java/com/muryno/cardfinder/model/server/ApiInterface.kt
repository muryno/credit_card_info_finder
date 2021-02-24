import com.muryno.cardfinder.model.entity.CardDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {


    @GET("{bin}")
    fun getCard(@Path("bin") id: String?): Call<CardDetails>
}