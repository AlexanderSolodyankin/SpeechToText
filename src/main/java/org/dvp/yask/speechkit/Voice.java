package org.dvp.yask.speechkit;

public class Voice extends En
{
    public static String random()
    {
        System.out.println("Клас Voice/ функция random/ строка 7 начало функции");
        System.out.println("Клас Voice/ функция random/ строка 8 генерация числа val");
        int val = generateRandomNumber(0, 1);
        System.out.println("Клас Voice/ функция random/ строка 10 полученно число val " + val);
        System.out.println("Клас Voice/ функция random/ строка 11 полученно возвращаем " + (val == 0 ? En.ALYSS : En.NICK));
        System.out.println("Клас Voice/ функция random/ строка 12 конец функции");
        return val == 0 ? En.ALYSS : En.NICK;
    }

    private static int generateRandomNumber(int min, int max)
    {
        System.out.println("Клас Voice/ функция generateRandomNumber/ строка 18 начало функции");
        System.out.println("Клас Voice/ функция generateRandomNumber/ строка 19 генерация числа val");
        Double val = (Math.random() * ((max - min) + 1)) + min;
        System.out.println("Клас Voice/ функция generateRandomNumber/ строка 21 полученно число val " + val);
        System.out.println("Клас Voice/ функция generateRandomNumber/ строка 22 полученно возвращаем " + val.intValue());
        System.out.println("Клас Voice/ функция generateRandomNumber/ строка 23 конец функции");
        return val.intValue();
    }
}
