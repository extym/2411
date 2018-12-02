import java.lang.reflect.Array;
import java.util.Random;

public class TesTest {

    public static void main(String[] args) {

        // объявляем массив целых чисел
        int[] anArray = new int[20];
        Random rand = new Random();
        for (int i = 0; i < anArray.length; i++) {

            anArray[i] = rand.nextInt(100) - 50;

            System.out.print(anArray[i] + " ");
        }
            // Нахождение среди элементов массива наименьшего
            int min = anArray[0];

            for (int i = 1; i < anArray.length; i++) {
                if ( anArray[i] < min & anArray[i] > 0 ) min = anArray[i];
            }

                System.out.println("Наименьший элемент: " + min);

            //Количество положительных чисел

            // Найти количество меньше 0
            int s = 0;//для количества цифр более0
            int r = 0;

            for (int i = 0; i < anArray.length; i++) {
                if (anArray[i] > 0) {
                    s = s + 1;
                }else r = r + 1;
            }

            //System.out.println(anArray[i]);
            System.out.println("Количество поожительных цифр = " + s);
            System.out.println("Количество отрицательных чисел = " + r);

        }
    }



