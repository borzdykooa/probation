package collection;

public class MyCollectionDemo {

    public static void main(String[] args) {
        checkAddAll();
        checkAddElement();
        checkGetValueByIndex();
        checkRemoveByIndex();
        checkRemoveAllByValue();
        checkRemoveFirstByValue();
        checkClear();
        checkFindMax();
        checkFindMin();
        checkFindAverage();
    }

    private static void checkFindAverage() {
        MyCollection<Double> myCollection = getMyCollection();
        Double average = myCollection.findAverage();
        if (average != 2.000000000000001) {
            System.out.println("findAverage method doesn't work properly!");
        }
    }

    private static void checkFindMax() {
        MyCollection<Double> myCollection = getMyCollection();
        Double max = myCollection.findMax();
        if (max != 6.9) {
            System.out.println("findMax method doesn't work properly!");
        }
    }

    private static void checkFindMin() {
        MyCollection<Double> myCollection = getMyCollection();
        Double min = myCollection.findMin();
        if (min != 1.0) {
            System.out.println("findMin method doesn't work properly!");
        }
    }

    private static void checkClear() {
        MyCollection<Double> myCollection = getMyCollection();
        myCollection.clear();
        if (myCollection.size() != 0) {
            System.out.println("checkClear method doesn't work properly!");
        }
    }

    private static void checkRemoveFirstByValue() {
        MyCollection<Double> myCollection = getMyCollection();
        myCollection.removeFirstByValue(1.0);
        if (myCollection.size() != 17) {
            System.out.println("removeFirstByValue method doesn't work properly!");
        }
    }

    private static void checkRemoveAllByValue() {
        MyCollection<Double> myCollection = getMyCollection();
        myCollection.removeAllByValue(1.1);
        if (myCollection.size() != 7) {
            System.out.println("removeAllByValue method doesn't work properly!");
        }
    }

    private static void checkRemoveByIndex() {
        MyCollection<Double> myCollection = getMyCollection();
        myCollection.removeByIndex(1);
        if (myCollection.getValueByIndex(1) != 3.1 || myCollection.size() != 17) {
            System.out.println("removeByIndex method doesn't work properly!");
        }
    }

    private static void checkGetValueByIndex() {
        MyCollection<Double> myCollection = getMyCollection();
        Double valueByIndex = myCollection.getValueByIndex(2);
        if (valueByIndex != 3.1) {
            System.out.println("getValueByIndex method doesn't work properly!");
        }
    }

    private static void checkAddElement() {
        MyCollection<Double> myCollection = getMyCollection();
        myCollection.addElement(111.1);
        myCollection.addElement(3.3);
        if (myCollection.size() != 20) {
            System.out.println("addElement method doesn't work properly!");
        }
    }

    private static void checkAddAll() {
        MyCollection<Double> myCollection = getMyCollection();
        if (myCollection.size() != 18) {
            System.out.println("addAll method doesn't work properly!");
        }
    }

    private static MyCollection<Double> getMyCollection() {
        MyCollection<Double> myCollection = new MyCollection<>();
        Double[] doubles = {1.0, 2.6, 3.1, 4.0, 6.9, 1.1, 4.3, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 2.0};
        myCollection.addAll(doubles);
        return myCollection;
    }
}
