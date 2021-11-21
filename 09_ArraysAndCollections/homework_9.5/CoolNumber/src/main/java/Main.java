import net.sf.saxon.functions.ConstantFunction;

import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */

    public static void main(String[] args) {

        long start1 = System.nanoTime();
        boolean x1 = CoolNumbers.bruteForceSearchInList(CoolNumbers.autoNumbers, "У777HC66");
        long finish1 = System.nanoTime();
        long elapsed1 = finish1 - start1;
        if (x1) {
            System.out.println("Поиск перебором: номер найден, поиск занял " + elapsed1 + " нс");
        } else {
            System.out.println("Поиск перебором: номер не найден, поиск занял " + elapsed1 + " нс");
        }

        long start2 = System.nanoTime();
        Collections.sort(CoolNumbers.autoNumbers);
        boolean x2 = CoolNumbers.binarySearchInList(CoolNumbers.autoNumbers, "У777HC66");
        long finish2 = System.nanoTime();
        long elapsed2 = finish2 - start2;
        if (x2) {
            System.out.println("Бинарный поиск: номер найден, поиск занял " + elapsed2 + " нс");
        } else {
            System.out.println("Бинарный поиск: номер не найден, поиск занял " + elapsed2 + " нс");
        }

        long start3 = System.nanoTime();
        boolean x3 = CoolNumbers.searchInHashSet(CoolNumbers.autoNumbersHashSet, "У777HC66");
        long finish3 = System.nanoTime();
        long elapsed3 = finish3 - start3;
        if (x3) {
            System.out.println("Поиск в HashSet: номер найден, поиск занял " + elapsed3 + " нс");
        } else {
            System.out.println("Поиск в HashSet: номер не найден, поиск занял " + elapsed3 + " нс");
        }

        long start4 = System.nanoTime();
        boolean x4 = CoolNumbers.searchInTreeSet(CoolNumbers.autoNumbersTreeSet, "У777HC66");
        long finish4 = System.nanoTime();
        long elapsed4 = finish4 - start4;
        if (x4) {
            System.out.println("Поиск в TreeSet: номер найден, поиск занял " + elapsed4 + " нс");
        } else {
            System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + elapsed4 + " нс");
        }
    }

}
