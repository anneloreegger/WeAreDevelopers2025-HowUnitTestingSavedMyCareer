package mockito;

public class WeatherService {

    private WeatherClient weatherClient;

    public WeatherService() {
        this.weatherClient = new WeatherClient();
    }

    public String giveJacketRecommendation(Double latitude, Double longitude)
            throws Exception {
        return weatherClient.getCurrentTemperature(latitude, longitude)
                .map(temp -> {
                    if (temp < 0.0) {
                        return "You need a very warm jacket.";
                    } else if (temp < 15.0) {
                        return "You need a jacket.";
                    } else if (temp < 25) {
                        return "You don't need a jacket.";
                    } else {
                        return "You definitely do not need a jacket, stay in the shade!";
                    }
                }).orElse("Please try again later.");
    }
}
