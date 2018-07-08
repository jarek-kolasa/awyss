package awyss.data.euro;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class EuroService {

//    public String value = euroLastApplicableValue();

    public EuroService() throws IOException {
    }


    public String dateTime(){
        LocalDate today = LocalDate.now();

        if(today.getDayOfWeek() == DayOfWeek.SATURDAY){
            today = LocalDate.now().minusDays(1);
        }

        if(today.getDayOfWeek() == DayOfWeek.SUNDAY){
            today = LocalDate.now().minusDays(2);
        }

        return today.toString();
    }


    public String euroLastApplicableValue() throws IOException {

        LocalDate today = LocalDate.now();

        if(today.getDayOfWeek() == DayOfWeek.SATURDAY){
            today = LocalDate.now().minusDays(1);
        }

        if(today.getDayOfWeek() == DayOfWeek.SUNDAY){
            today = LocalDate.now().minusDays(2);
        }

        System.out.println(today);

        StringBuffer sentenceBuilder = new StringBuffer();
        String currentDate = today.toString();
        StringBuffer dateBuffer = new StringBuffer("http://api.nbp.pl/api/exchangerates/rates/c/eur/").append(currentDate).append("/?format=json");
        String date = dateBuffer.toString();

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(date);
        HttpResponse execute = httpClient.execute(httpGet);

        String nbpEuroInfo = new BasicResponseHandler().handleResponse(execute);

        JsonParser jsonParser = new JsonParser();
        JsonElement baseJsonElement = jsonParser.parse(nbpEuroInfo);
        JsonObject baseJsonObject = baseJsonElement.getAsJsonObject();
        JsonArray ratesJsonArray = baseJsonObject.get("rates").getAsJsonArray();
        JsonObject ratesJsonObject = ratesJsonArray.get(0).getAsJsonObject();
        String rates = ratesJsonObject.get("ask").getAsString();
        sentenceBuilder.append(rates);

        return sentenceBuilder.toString();
    }
}
