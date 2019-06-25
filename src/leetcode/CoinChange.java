package leetcode;

import java.util.*;

public class CoinChange {
    public static void main(String[] args) {
        Row row = new Row();
        row.setName("row1");
        row.setNo(101);
        System.out.println(row.getName());
        List<Complex> complexes = new ArrayList<>();
        complexes.add(getComplex(row));
        changeComplexes(complexes);
        System.out.println(row.getName());
    }

    public static Complex getComplex(Row row) {
        Complex complex = new Complex();
        complex.setRow(row);
        complex.setId("123");
        return complex;
    }

    public static void changeComplexes(List<Complex> complexes) {
        for (Complex complex : complexes) {
            complex.getRow().setName("afterChanged");
        }
    }

    static class Row {
        private int No;
        private String name;

        public int getNo() {
            return No;
        }

        public void setNo(int no) {
            No = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Complex {
        private String id;
        private Row row;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Row getRow() {
            return row;
        }

        public void setRow(Row row) {
            this.row = row;
        }
    }


}
