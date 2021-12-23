package lesson2;

public class HomeWork {
    public static void main(String[] args) {
        String[][] array = new String[][]{
                {"22", "654", "6543", "1324"},
                {"6654", "3645", "645", "365"},
                {"500155", "134", "1512", "91283"},
                {"61215", "2151", "2551", "30000"}
        };

        try {
            System.out.println(arraySum(array));
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива должен быть 4х4");
        } catch (MyArrayDataException e) {
            System.out.println("Неверный формат ввода чисел.");
        }

    }

    public static int arraySum(String[][] stringArray) {
        checkArraySize(stringArray);
        return checkNumberArrayAndSumOutput(stringArray);
    }

    private static int checkNumberArrayAndSumOutput(String[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка в ячейке [" + i + "][" + j + "]");
                    throw new MyArrayDataException();
                }
            }
        }// foreach не стал использовать, так как не придумал, как указать на номер ячейки в которой допущена ошибка.
        return sum;
    }

    private static void checkArraySize(String[][] array) {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
    }
}


