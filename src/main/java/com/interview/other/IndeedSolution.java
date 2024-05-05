package com.interview.other;

import java.util.*;

public class IndeedSolution {

    public static void main(String[] argv) {
        String[][] products = {
                {"Cheese", "Dairy"},
                {"Carrots", "Produce"},
                {"Potatoes", "Produce"},
                {"Canned Tuna", "Pantry"},
                {"Romaine Lettuce", "Produce"},
                {"Chocolate Milk", "Dairy"},
                {"Flour", "Pantry"},
                {"Iceberg Lettuce", "Produce"},
                {"Coffee", "Pantry"},
                {"Pasta", "Pantry"},
                {"Milk", "Dairy"},
                {"Blueberries", "Produce"},
                {"Pasta Sauce", "Pantry"}
        };

        String[] list1 = {"Blueberries", "Milk", "Coffee", "Flour", "Cheese", "Carrots"};
        String[] list2 = {"Blueberries", "Carrots", "Coffee", "Milk", "Flour", "Cheese"};
        String[] list3 = {"Blueberries", "Carrots", "Romaine Lettuce", "Iceberg Lettuce"};
        String[] list4 = {"Milk", "Flour", "Chocolate Milk", "Pasta Sauce"};
        String[] list5 = {"Cheese", "Potatoes", "Blueberries", "Canned Tuna"};

        int saved = shopping(products, list1);
        System.out.println(saved);
/*        saved = shopping(products, list2);
        System.out.println(saved);
        saved = shopping(products, list3);
        System.out.println(saved);
        saved = shopping(products, list4);
        System.out.println(saved);
        saved = shopping(products, list5);
        System.out.println(saved);*/
    }

    private static int shopping(String[][] products, String[] items) {
        int saved = 0;
        Map<String, String> productCategorymap = new HashMap<>();
        Map<String, Set<String>> categoryProductListMap = new HashMap<>();

        if (products != null) {
            for (String[] row : products) {
                String keys = row[0];
                String value = row[1];


                productCategorymap.put(keys, value);
                if (categoryProductListMap.containsKey(value)) {
                    Set<String> mySet = categoryProductListMap.get(value);
                    mySet.add(keys);
                } else {
                    Set<String> mySet = new HashSet<>();
                    mySet.add(keys);
                    categoryProductListMap.put(value, mySet);
                }

            }
        }

        System.out.println(productCategorymap.toString());
        System.out.println("------------");
        System.out.println(categoryProductListMap.toString());

        int StoreVisit1 = 0;
        String previousCategory = null;
        System.out.println("------------");
        System.out.println("iterating through array: " + Arrays.toString(items));
        for (String item : items) {
            if (previousCategory == null) {
                previousCategory = productCategorymap.get(item);
                StoreVisit1 = 1;
            } else if (!previousCategory.equalsIgnoreCase(productCategorymap.get(item))) {
                StoreVisit1++;
            }
        }





        System.out.println("------------");
        System.out.println("StoreVisit1: " + StoreVisit1);

        int StoreVisit2 = 0;
        Set<String> mySet = new HashSet<>(Arrays.asList(items));
        for (int i = 0; i < items.length; i++) {
            if (mySet.size() > 0) {
                System.out.println("Set :" + mySet.toString());
                String category = productCategorymap.get(items[i]);
                Set<String> productUnderCategory = categoryProductListMap.get(category);
                System.out.println("removing :" + productUnderCategory.toString());
                mySet.removeAll(productUnderCategory);
                StoreVisit2++;
            }
        }
        System.out.println("StoreVisit2: " + StoreVisit2);
        saved = StoreVisit1 - StoreVisit2;
        return saved;
    }
}
