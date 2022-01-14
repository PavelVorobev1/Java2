package ru.geekbrains.lesson3;

import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {

    Map<String, String> telephone = new HashMap<>();

    public void add(String phoneNumber, String surname) {
        telephone.put(phoneNumber, surname);
    }

    public void get(String surname) {
        Map<String, String> info = new HashMap<>();
        for (Map.Entry<String, String> entry : telephone.entrySet()) {
            if (entry.getValue().equals(surname)) {
                info.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println(info.entrySet());
    }

    public void getInfo() {
        System.out.println(telephone.entrySet());
    }
}
