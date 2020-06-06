import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

  private static final String URL = "https://yandex.ru/pogoda/saint-petersburg";

  public static void main(String[] args) throws IOException {

    Document doc = Jsoup.connect(URL).get();
    Elements termValueElement = doc.select("div.term__value");
    Elements linkConditionElement = doc.select("div.link__condition.day-anchor.i-bem");
    String textConditionJSOUP = linkConditionElement.text().trim();

    System.out.println("          Погода в Санкт-Петербурге");
    for (int i = 0; i < termValueElement.size(); i++) {
      String[] textFromJSOUP = termValueElement.text().split(" ");
      // System.out.println(textFromJSOUP[i]);
      String test = textFromJSOUP[2];
      int titleIndex =  test.indexOf(",");
      String textWind = test.substring(0, titleIndex);
      System.out.println("Текущая температура: "
          + textFromJSOUP[0] + " " + textConditionJSOUP
          + " | Ощущается как: " + textFromJSOUP[1]
          + "\n" + "Ветер: " + textWind + " " + textFromJSOUP[3]
          + " Направление: " + textFromJSOUP[4]
          + " | Влажность: " + textFromJSOUP[5]
          + "\n" + "Давление: " + textFromJSOUP[6] + " Миллиметров ртутного столба");
      break;
    }
  }
}
