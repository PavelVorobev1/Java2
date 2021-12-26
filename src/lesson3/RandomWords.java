package lesson3;

import java.util.*;

public class RandomWords {

    public static void main(String[] args) {

        ArrayList<String> arrayWords = new ArrayList<>();

        arrayWords.add("вагон");
        arrayWords.add("премия");
        arrayWords.add("версия");
        arrayWords.add("директор");
        arrayWords.add("палец");
        arrayWords.add("директор");
        arrayWords.add("форма");
        arrayWords.add("поле");
        arrayWords.add("премия");
        arrayWords.add("версия");
        arrayWords.add("сумка");
        arrayWords.add("обеспечение");
        arrayWords.add("обеспечение");
        arrayWords.add("премия");
        arrayWords.add("премия");
        arrayWords.add("премия");
        arrayWords.add("обеспечение");
        arrayWords.add("форма");
        arrayWords.add("обеспечение");
        arrayWords.add("палец");
        arrayWords.add("обеспечение");
        arrayWords.add("обеспечение");

        Map<String, Integer> uniqueWord = uniqueWordTheirRepeat(arrayWords);

        for (Map.Entry<String, Integer> word : uniqueWord.entrySet()) {
            System.out.println("Слово " + "'" + word.getKey() + "'" + " встретилось " + word.getValue() + " раза.");
        }

    }

    public static Map<String, Integer> uniqueWordTheirRepeat(ArrayList<String> arrayWords) {
        Map<String, Integer> uniqueWord = new HashMap<>();
        int coincidences = 0;
        for (int i = 0; i < arrayWords.size(); i++) {
            for (String arrayWord : arrayWords) {
                if (arrayWords.get(i).equals(arrayWord)) {
                    coincidences++;
                }
            }
            uniqueWord.put(arrayWords.get(i), coincidences);
            coincidences = 0;
        }
        return uniqueWord;
    }

}
