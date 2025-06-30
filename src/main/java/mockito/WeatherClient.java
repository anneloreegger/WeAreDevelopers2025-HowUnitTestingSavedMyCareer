package mockito;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;

public class WeatherClient {

    private static final String API_URL =
            "https://weather.openweathermap.org/data/2.5/weather";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Optional<Double> getCurrentTemperature(Double longitude, Double latitude)
            throws Exception {
        String url = API_URL + "?lat=" + latitude + "&lon=" + longitude;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Map<String, Object> responseMap =
                    objectMapper.readValue(response.body(), Map.class);
            Map<String, Double> mainData =
                    (Map<String, Double>) responseMap.get("main");
            return Optional.ofNullable(mainData.get("temp"));
        }

        return Optional.empty();
    }


}
