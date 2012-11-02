/*
 * Copyright 2012 Denys Sobchyshak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.inceptix.util.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that provides implementation of basic sorting algorithms.
 *
 * @author		Denys Sobchyshak (denys.sobchyshak@gmail.com)
 * @version 	1.1 (02.11.2012)
 */
public class Sorter {
	// --- Fields ---

	// --- Constructors ---

	// --- Methods ---
	/**
	 * Swaps two values in provided array.
	 * @param array
	 * 			array in which values are being swapped
	 * @param i
	 * 			index of first value
	 * @param j
	 * 			index of second value
	 */
	private static void swap(Integer[] array, int i, int j){
		Integer tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	/**
	 * Disposes of duplicate values.
	 * @param list
	 * 			list of values which might contain duplicate values
	 */
	public static void disposeOfDuplicates(List<Integer> list){
		for (int i = 0; i < list.size(); i++){
			Integer j = list.get(i);
			while (list.indexOf(j) != list.lastIndexOf(j)){
				list.remove(j);
			}
		}
	}

    /**
     * Implementation of bubble sort algorithm (using nested loop method).<br>
     * <b>NOTE: bubble sort is not a practical sorting algorithm when
     * n is large, as it is worst-case and average complexity both О(n^2).
     * @param list
     * 			list of integer values to be sorted
     * @param includeDuplicates
     * 			flag that defines if duplicate values should be
     * 			included (true) or disposed of (false)
     * @return
     * 			sorted list of integers
     */
    public static List<Integer> bubbleSort(List<Integer> list, boolean includeDuplicates){
        //TODO misc:Add support for non-int data types
        //TODO misc:Think of a most practical type acceptance
        if (!includeDuplicates){
            disposeOfDuplicates(list);
        }

        Integer[] result = list.toArray(new Integer[0]);

        for (int i = 0; i < result.length; i++){
            for (int j = result.length - 1; j > i; j--){
                if (result[j-1] > result[j]) swap(result, j-1, j);
            }
        }

        return Arrays.asList(result);
    }

	/**
	 * Implementation of quick sort algorithm.
	 * @param list
	 * 			list of integers being sorted
	 * @param includeDuplicates
	 * 			flag that defines if duplicate values should be included (true) or disposed of (false)
	 * @return
	 * 			sorted list of integers
	 */
	public static List<Integer> quickSort(List<Integer> list, boolean includeDuplicates){
		if (!includeDuplicates) {
			disposeOfDuplicates(list);
		}
		return quickSortImpl(list);
	}

	/**
	 * Auxiliary method which itself is an actual implementation of quick sort algorithm.
	 * @param list
	 * 			list being sorted
	 * @return
	 * 			sorted list of values
	 */
	private static List<Integer> quickSortImpl(List<Integer> list){
		// Out condition
		if (list.size() <= 1){
			return list;
		}

		// Split the list in two parts
		// NOTE: Gets into infinite recursive loop if pivot == maximum number && pivot !removed from list
		Integer pivot = list.get(list.size()/2);
		list.remove(list.size()/2);
		List<Integer> leftPart = new ArrayList<Integer>();
		List<Integer> rightPart = new ArrayList<Integer>();
		for (Integer i : list){
			if (pivot >= i){
				// add i to the left hand array part
				leftPart.add(i);
			} else {
				// add i to the right hand array part
				rightPart.add(i);
			}
		}

        // Compose resulting array through recursive calls
		List<Integer> result = quickSortImpl(leftPart);
		result.add(pivot);
		result.addAll(quickSortImpl(rightPart));

		return result;
	}
	
	/**
	 * Implementation of quicksort algorithm.
	 * @param list
	 * 			list of integers being sorted
	 * @param includeDuplicates
	 * 			flag that defines if duplicate values should be 
	 * 			included (true) or disposed of (false)
	 * @return
	 * 			sorted list of integers
	 */
	public static List<Integer> heapSort(List<Integer> list, boolean includeDuplicates){
		if (!includeDuplicates){
			disposeOfDuplicates(list);
		}
		// TODO high:implement heap sort
		return null;
	}
}
