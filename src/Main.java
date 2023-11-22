import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.out.println("Неверные параметры");
      return;
    }

    var inputFilePath = args[0];
    var toExcludeFilePath = args[1];
    var toSaveIntoFilePath = args[2];

    var toFilterWords = new ArrayList<String>();

    try (var fileReader = new BufferedReader(new FileReader(inputFilePath))) {
      String line;

      while ((line = fileReader.readLine()) != null) {
        toFilterWords.add(line);
      }
    } catch (IOException e) {
      System.out.println("Файл не найден");
      return;
    }

    var toExclude = new HashSet<String>();

    try (var fileReader = new BufferedReader(new FileReader(toExcludeFilePath))) {
      String line;

      while ((line = fileReader.readLine()) != null) {
        toExclude.add(line);
      }
    } catch (IOException e) {
      System.out.println("Файл не найден");
      return;
    }

    var result = FilteringHelper.filter(toFilterWords, toExclude);

    try (var fileWriter = new BufferedWriter(new FileWriter(toSaveIntoFilePath))) {
      for (String s : result) {
        fileWriter.write(s + '\n');
      }
    } catch (IOException e) {
      System.out.println("Файл не найден");
    }
  }
}