package collection;

import java.util.Arrays;

public class MyCollection<T extends Double> {
    private final int DEFAULT_SIZE = 31;
    private final double MIN_LOAD = 0.89;
    private final double MAX_LOAD = 6;
    private final int MULTIPLIER = 3;
    private Double[] array = new Double[DEFAULT_SIZE];
    private int actualSize = 0;

    public void addElement(T value) {
        if (actualSize > array.length * MIN_LOAD)
            enlarge();
        array[actualSize++] = value;
    }

    public void addAll(T[] doubleArray) {
        if (actualSize > array.length * MIN_LOAD)
            enlarge();
        for (T aDoubleArray : doubleArray) {
            array[actualSize++] = aDoubleArray;
            if (actualSize > array.length * MIN_LOAD)
                enlarge();
        }
    }

    public Double getValueByIndex(int index) {
        if (index > actualSize) {
            System.out.println("Error! This collection has only " + actualSize + " elements!");
            throw new IndexOutOfBoundsException();
        } else if (index < 0) {
            System.out.println("Error! Your index is incorrect (it's negative!");
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void removeByIndex(int index) {
        remove(index);
        if (array.length > DEFAULT_SIZE && actualSize < array.length / MAX_LOAD)
            reduce();
    }

    public void removeFirstByValue(T value) {
        for (int i = 0; i < actualSize; i++) {
            if (value.equals(array[i])) {
                remove(i);
                if (array.length > DEFAULT_SIZE && actualSize < array.length / MAX_LOAD)
                    reduce();
                return;
            }
        }
    }

    public void removeAllByValue(T value) {
        for (int i = 0; i < actualSize; i++) {
            if (value.equals(array[i])) {
                System.arraycopy(array, i + 1, array, i, actualSize - i);
                array[actualSize] = null;
                i--;
                actualSize--;
            }
        }
        if (array.length > DEFAULT_SIZE && actualSize < array.length / MAX_LOAD)
            reduce();
    }

    public int size() {
        return actualSize;
    }

    public void clear() {
        array = new Double[DEFAULT_SIZE];
        actualSize = 0;
    }

    public Double findMax() {
        if (actualSize == 0) {
            return null;
        }
        Double max = array[0];
        for (int i = 0; i < actualSize; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    public Double findMin() {
        if (actualSize == 0) {
            return null;
        }
        double min = Double.POSITIVE_INFINITY;
        for (int i = 0; i < actualSize; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public Double findAverage() {
        if (actualSize == 0) {
            return null;
        }
        double count = 0;
        for (int i = 0; i < actualSize; i++) {
            count = count + array[i];
        }
        return count / actualSize;
    }

    private void remove(int i) {
        System.arraycopy(array, i + 1, array, i, actualSize - i);
        array[actualSize] = null;
        actualSize--;
    }

    private void reduce() {
        Double[] newArray = new Double[array.length / MULTIPLIER];
        System.arraycopy(array, 0, newArray, 0, actualSize);
        array = newArray;
    }

    private void enlarge() {
        Double[] newArray = new Double[array.length * MULTIPLIER];
        System.arraycopy(array, 0, newArray, 0, actualSize);
        array = newArray;
    }

    @Override
    public String toString() {
        Double[] newArray = new Double[actualSize];
        System.arraycopy(array, 0, newArray, 0, actualSize);
        return "MyCollection" + Arrays.toString(newArray);
    }
}
