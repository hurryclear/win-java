package com.collection.collection;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Set
 * - no order
 *  - no order: the sequence you add the elements and the sequence it printed out is different
 *  - sorted (TreeSet): the sequence of the elements will be sorted (increase by default)
 * - no duplication
 * - no index
 */
public class SetTest1 {

    public static void main(String[] args) {

        Set<Integer> nums1 = new HashSet<>();
        Set<Integer> nums2 = new LinkedHashSet<>();
        Set<Integer> nums3 = new TreeSet<>();

        // HashSet: no order, no duplication, no index
        System.out.println("==== HashSet ====");
        nums1.add(222);
        nums1.add(111);
        nums1.add(111);
        nums1.add(444);
        nums1.add(333);
        System.out.println(nums1);

        // LinkedHashSet: in order, no duplication, no index
        System.out.println("==== LinkedHashSet ====");
        nums2.add(222);
        nums2.add(111);
        nums2.add(444);
        nums2.add(444);
        nums2.add(333);
        System.out.println(nums2);

        // TreeSet: sorted, no duplication, no index
        System.out.println("==== TreeSet ====");
        nums3.add(222);
        nums3.add(222);
        nums3.add(111);
        nums3.add(444);
        nums3.add(333);
        System.out.println(nums3);


    }
}
