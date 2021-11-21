import java.util.*;

public class CoolNumbers {

    private static final char[] letters = "АВЕКМНОРСТУХ".toCharArray();
    private static final Random lettersRandom = new Random();
    public static List<String> autoNumbers = new ArrayList<>();

    public static HashSet<String> autoNumbersHashSet = new HashSet<>(autoNumbers);
    public static TreeSet<String> autoNumbersTreeSet = new TreeSet<>(autoNumbers);
    public static String autoNumber;


    public static char getRandomLetters() {
        return letters[lettersRandom.nextInt(letters.length)];
    }

    public static String getRandomNumbers() {
        int Numbers = (int) (Math.random() * 9) + 1;
        return Integer.toString(Numbers);
    }

    public static String getRandomRegionNumber() {
        int RegionNumber = (int) (Math.random() * 199) + 1;
        return Integer.toString(RegionNumber);
    }

    public static List<String> generateCoolNumbers() {
        for (int i = 0; i < 2000000; i++) {
            autoNumber = getRandomLetters() + getRandomNumbers() + getRandomNumbers() + getRandomNumbers() + getRandomLetters() + getRandomLetters() + getRandomRegionNumber();
            if (!autoNumbers.contains(autoNumber)) {
                autoNumbers.add(autoNumber);
            }
        }
        return autoNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {

        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int indexNumber = Collections.binarySearch(sortedList, number);
        return indexNumber != -1;
    }


    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

}
