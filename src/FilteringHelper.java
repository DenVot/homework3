import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FilteringHelper {
  public static List<String> filter(List<String> toFilter, HashSet<String> toExclude) {
    var result = new ArrayList<String>();

    for (String s : toFilter) {
      if (!toExclude.contains(s)) {
        result.add(s);
      }
    }

    return result;
  }
}
