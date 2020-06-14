import java.io.IOException;

public class Main {

  private static final String SPB_WEATHER = "https://yandex.ru/pogoda/saint-petersburg";
  private static final String MSK_WEATHER = "https://yandex.ru/pogoda/213";
  private static final String UFA_WEATHER = "https://yandex.ru/pogoda/172";


  public static void main(String[] args) throws IOException {

    Weather weatherSPB = new Weather(SPB_WEATHER);
    weatherSPB.weatherFromSite();

    Weather weatherMSK = new Weather(MSK_WEATHER);
    weatherMSK.weatherFromSite();

    Weather weatherUFA = new Weather(UFA_WEATHER);
    weatherUFA.weatherFromSite();

  }
}
