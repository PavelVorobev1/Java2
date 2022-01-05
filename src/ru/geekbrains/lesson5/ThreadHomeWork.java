package ru.geekbrains.lesson5;

import java.util.Arrays;

public class ThreadHomeWork {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {

        example1();
        example2();

    }

    public static void example1() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время работы без многопоточности = " + (System.currentTimeMillis() - start));
    }

    public static void example2() throws InterruptedException {

        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();

        float[] arrLeft = new float[HALF];
        float[] arrRight = new float[HALF];

        System.arraycopy(arr, 0, arrLeft, 0, HALF);
        System.arraycopy(arr, HALF, arrRight, 0, HALF);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrLeft.length; i++) {
                    arrLeft[i] = (float) (arrLeft[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < arrRight.length; i++) {
                    arrRight[i] = (float) (arrRight[i] * Math.sin(0.2f + (i + HALF) / 5) * Math.cos(0.2f + (i+HALF) / 5) * Math.cos(0.4f + (i+HALF) / 2));
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread1.join();

        float[] mergedArray = new float[SIZE];

        System.arraycopy(arrLeft, 0, mergedArray, 0, HALF);
        System.arraycopy(arrRight, 0, mergedArray, HALF, HALF);

        System.out.println("Время работы с двумя потоками = " + (System.currentTimeMillis() - start));

    }

}

