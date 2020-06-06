import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

  private static final String URL = "https://yandex.ru/pogoda/saint-petersburg";

  public static void main(String[] args) throws IOException {

    Document doc = Jsoup.connect(URL).get();
    String title = doc.title();
    Elements termValueElement = doc.select("div.term__value"); //тут почти все данные температуры
    Elements termValueElementTemp = doc.select("div.temp.fact__temp.fact__temp_size_s"); //температура сейчас
    Elements linkConditionElement = doc.select("div.link__condition.day-anchor.i-bem"); //посмурный, ясно, солнечно и т.д
    Elements linkConditionElement2 = doc.select("div.link__feelings.fact__feelings"); //Ощущается как
    String textConditionJSOUP = linkConditionElement.text().trim();
    int textConditionJSOUPTemp = termValueElementTemp.text().lastIndexOf("а");
    int textConditionJSOUPTempSimvol = termValueElementTemp.text().lastIndexOf("°"); //ищем последний "символ"
    int textConditionJSOUP2 = linkConditionElement2.text().lastIndexOf(" "); //ищем последний пробел
    int textConditionJSOUP3 = linkConditionElement2.text().lastIndexOf("°"); //ищем последний "символ"
    String textCondition2 = linkConditionElement2.text().substring(textConditionJSOUP2 + 1, textConditionJSOUP3 + 1); //получаем полезную нагрузку
    String textCondition3 = termValueElementTemp.text().substring(textConditionJSOUPTemp + 1, textConditionJSOUPTempSimvol + 1); //получаем полезную нагрузку
    int textTitle = title.indexOf("—"); //ищем последний символ

    System.out.println("              " + title.substring(0, textTitle - 12));
    for (int i = 0; i < termValueElement.size(); i++) {
      String[] textFromJSOUP = termValueElement.text().split(" ");
    //  System.out.println(textFromJSOUP[i]); //чисто для проверки
      String test = textFromJSOUP[2];
//      int titleIndex =  test.indexOf(",");
//      String textWind = test.substring(0, titleIndex);
      System.out.println("Текущая температура: "
          + textCondition3 + " " + textConditionJSOUP
          + " | Ощущается как: " + textCondition2
          + "\n" + "Ветер: " + textFromJSOUP[2] + " " + textFromJSOUP[3]
          + " Направление: " + textFromJSOUP[4]
          + " | Влажность: " + textFromJSOUP[5]
          + "\n" + "Давление: " + textFromJSOUP[6] + " Миллиметров ртутного столба");
      break;
    }
  }
}
