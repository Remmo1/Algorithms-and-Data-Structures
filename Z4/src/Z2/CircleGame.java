package Z2;

import Za1.OneWayLinkedList;

public class CircleGame {
    private final int n;
    private final int k;
    OneWayLinkedList<Integer> list;

    public CircleGame(int n, int k) {
        this.n = n;
        this.k = k;
        list = new OneWayLinkedList<>();
    }

    private void FillTheList() {
        for (int i = 1; i <= n; i++) {
            list.addEnd(i);
        }
    }

    public int LastSurvived() {
        FillTheList();
        int i = k;
        int loopCounter = 0;
        int killed;

        if (k == n) {
            return 0;
        }

        while (list.Size() != 1) {
            killed = list.deleteElem(new OneWayLinkedList.Element<>(i));
            System.out.println("Killed in " + ++loopCounter + " loop: " + killed);
            i += k;
            i %= n;
        }

        return list.get(0);
    }


    public static void main(String[] args) {
        CircleGame circleGame = new CircleGame(7, 3);
        int a = circleGame.LastSurvived();
        System.out.println("Last man standing: " + a);
    }

}
