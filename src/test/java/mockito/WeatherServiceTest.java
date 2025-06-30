package mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @InjectMocks
    private WeatherService weatherService;

    @Mock
    private WeatherClient mockClient;

    @Test
    void getWeather() throws Exception {
        // given
        when(mockClient.getCurrentTemperature(6.57,50.21))
                .thenReturn(Optional.of(10.0));

        // when
        String jacketRecommendation =
                weatherService.giveJacketRecommendation(6.57,50.21);

        // then
        assertEquals("You need a jacket.", jacketRecommendation);
    }

}