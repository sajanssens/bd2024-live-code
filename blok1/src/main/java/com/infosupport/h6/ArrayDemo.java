package com.infosupport.h6;

import java.util.ArrayList;

public class ArrayDemo {

    public static void main(String[] args) {
        int getal = 0; // één getal
        int[] getallen = new int[10]; // tien getallen
        getallen[0] = 1;
        getallen[1] = 1;
        getallen[2] = 1;

        ArrayList<Integer> getallenMakkelijker = new ArrayList<>();
        getallenMakkelijker.add(0);
        getallenMakkelijker.add(1);
        getallenMakkelijker.add(2);
    }
}

class Person {

    HistoryRecord[] historyRecords = new HistoryRecord[10];
    int index = 0;

    class HistoryRecord {
    }

    void add(HistoryRecord hr) {
        if (index >= historyRecords.length) {
            HistoryRecord[] historyRecordsNew = new HistoryRecord[historyRecords.length * 2];
            System.arraycopy(historyRecords, 0, historyRecordsNew, 0, index);
        }
        historyRecords[index] = hr;
        index++;
    }
}
