package com.vladuken.tasks.Task5.unit;

import java.util.LinkedList;

public class Task5 {

    public static int findNumOfElementsToDelete(Integer[] array) {
		
		if(array.length == 0)
			return 0;
		
		LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();    // list of lists
		LinkedList<Integer> perList = new LinkedList<Integer>();   //perspective list
		
		perList.add(array[0]);
		list.add(perList);
		
		for(int i = 1; i < array.length; i++) {
			
			perList = findPerList(list, array[i]);
			
			if (perList == null) {
				perList = new LinkedList<Integer>();
			}
			
			perList.add(array[i]);
			list.add(perList);
			
			list = deleteUselessLists(list);
		}

		int maxSize = 0;
		
		for(int i = 0; i < list.size(); i++) 
			if(list.get(i).size() > maxSize)
				maxSize = list.get(i).size();
		
       
        return array.length - maxSize;
    }
	
	private static LinkedList<Integer> findPerList(LinkedList<LinkedList<Integer>> list, Integer x){
		
		LinkedList<Integer> curList = null;
		LinkedList<Integer> tempList;
		Integer lastElem = Integer.MIN_VALUE;
		
		for (int i=0; i < list.size(); i++) {
			if(list.get(i).getLast() < x  && list.get(i).getLast() > lastElem) {
				curList = new LinkedList<Integer>();
				tempList = list.get(i);
				
				for(int j = 0; j < tempList.size(); j++)
					curList.add(tempList.get(j));
				
				lastElem = curList.getLast();
			}
		}
		
		return curList;
	}
	
	private static LinkedList<LinkedList<Integer>> deleteUselessLists(LinkedList<LinkedList<Integer>> list){
		
		LinkedList<LinkedList<Integer>> newList = new LinkedList<LinkedList<Integer>>();
		
		for (int i=0; i < list.size() - 1; i++) 
			if(list.get(i).size() != list.getLast().size())
				newList.add(list.get(i));
		
		newList.add(list.getLast());
		
		return newList;
	}

}
