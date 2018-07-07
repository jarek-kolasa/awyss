package awyss.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class DataTests {

    @Test
    public void testGetNbpConnection() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://api.nbp.pl/api/exchangerates/rates/c/eur/2018-07-06/?format=json");
        HttpResponse response = client.execute(httpGet);
        StatusLine statusLine = response.getStatusLine();

        int statusCode = statusLine.getStatusCode();
        String reasonPhrase = statusLine.getReasonPhrase();

        System.out.println("Status: " + statusCode);
        System.out.println("Description: " + reasonPhrase);

        Header[] allHeaders = response.getAllHeaders();
        for (Header header : allHeaders) {

            System.out.println("Header name: " + header.getName() + ", header value: " + header.getValue());

        }
        BasicResponseHandler basicResponseHandler = new BasicResponseHandler();

        String responseText = basicResponseHandler.handleResponse(response);
        System.out.println(responseText);
    }

    @Test
    public void testGetPolandInfo() throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://api.nbp.pl/api/exchangerates/rates/c/eur/2018-07-06/?format=json");
        HttpResponse execute = httpClient.execute(httpGet);
        String polandInfoInJson = new BasicResponseHandler().handleResponse(execute);

        System.out.println(polandInfoInJson);
    }

    @Test
    public void testGsonParse() {
        String json = "{\"firstname\":\"K\",\"lastname\":\"A\"}";

        JsonParser jsonParser = new JsonParser();

        JsonElement jsonElement = jsonParser.parse(json);

        JsonObject jsonObject = jsonElement.getAsJsonObject();// bo to co wrzucliliśmy do Stringa jest obiektem {}

        String firstname = jsonObject.get("firstname").getAsString();

        String lastname = jsonObject.get("lastname").getAsString();

        System.out.println(firstname);
        System.out.println(lastname);
    }


    @Test
    public void testBuildEuroVelue() throws IOException {
        StringBuffer sentenceBuilder = new StringBuffer("Aktualny kurs Euro: ");
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("http://api.nbp.pl/api/exchangerates/rates/c/eur/2018-07-06/?format=json");
        HttpResponse execute = httpClient.execute(httpGet);

        String nbpEuroInfo = new BasicResponseHandler().handleResponse(execute);

        JsonParser jsonParser = new JsonParser();
        JsonElement baseJsonElement = jsonParser.parse(nbpEuroInfo);
        JsonObject baseJsonObject = baseJsonElement.getAsJsonObject();
        JsonArray ratesJsonArray = baseJsonObject.get("rates").getAsJsonArray();
        JsonObject ratesJsonObject = ratesJsonArray.get(0).getAsJsonObject();
        String rates = ratesJsonObject.get("ask").getAsString();
        sentenceBuilder.append(rates);

        System.out.println(sentenceBuilder);

    }

    @Test
    public void testBuildEuroLastApplicableVelue() throws IOException {

        LocalDate today = LocalDate.now();

        if(today.getDayOfWeek() == DayOfWeek.SATURDAY){
            today = LocalDate.now().minusDays(1);
        }

        if(today.getDayOfWeek() == DayOfWeek.SUNDAY){
            today = LocalDate.now().minusDays(2);
        }

        System.out.println(today);

        StringBuffer sentenceBuilder = new StringBuffer("Aktualny kurs Euro: ");
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

        System.out.println(sentenceBuilder);
    }

}
