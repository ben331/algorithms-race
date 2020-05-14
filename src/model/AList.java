package model;

import java.util.ArrayList;

public class AList extends DataStructure{
	
	private ArrayList<Long> arrayListElements;
	
	public AList(){
		arrayListElements = new ArrayList<Long>();
	}

	@Override
	public void addIterative(int n) {
		Long element;
		
		for(int i=0; i<n; i++) {
			element = (long)Math.random();
			arrayListElements.add(element);
			System.out.println("L"+i);
		}
	}

	@Override
	public void searchIterative(int n) {
		long element;
		boolean founded = false;
		for(int i=0; i<n;i++) {
			element = (long)Math.random();
			for(int j=0; j<arrayListElements.size() && !founded;j++) {

				founded=arrayListElements.get(j).longValue()==element;
			}
			founded=false;
		}
	}

	@Override
	public void removeIterative(int n) {
		long element;
		boolean removed= false;
		for(int i=0; i<n;i++) {
			element = (long)Math.random();
			for(int j=0; j<arrayListElements.size() && !removed;j++) {

				if(arrayListElements.get(j).longValue()==element) {
					arrayListElements.remove(j);
					removed=true;
				}
			}
			removed=false;
		}
	}

	@Override
	public void addRecursive(int i, int n) {
		Long element;
		
		if(i<n) {
			element = (long)Math.random();
			arrayListElements.add(element);
			addRecursive(i+1, n);
		}
	}

	@Override
	public void searchRecursive(int i, int n) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			searchRecursive(element,0);
			searchRecursive(i+1, n);
		}
	}
	
	private boolean searchRecursive(long element, int i) {
		if(i<arrayListElements.size() && arrayListElements.get(i).longValue()!=element) {
			return searchRecursive(element, i+1);
		}else {
			return true;
		}
	}
	
	
	
	
	@Override
	public void removeRecursive(int i, int n) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			removeRecursive(element,0);
		}
	}
	
	private boolean removeRecursive(long element, int i) {
		if(i<arrayListElements.size()) {
			if(arrayListElements.get(i).longValue()==element) {
				return true;
			}else {
				return removeRecursive(element, i+1);
			}
		}else {
			return false;
		}
	}
	
	
	
	
	
	
	
	/*    Binary Search for sorted ArrayList
	private boolean searchInArrayListRecursive(long element, int min, int max) {
		boolean founded=false;
		if(min!=max) {
			if(element<arrayListElements.get((int)(min+max)/2)) {
				founded=searchInArrayListRecursive(element, min, (int)((min+max)/2) -1);
			}
			else if(element>arrayListElements.get((int)(min+max)/2)) {
				founded=searchInArrayListRecursive(element,(int)((min+max)/2)+1, max);
			}else {
				founded=true;
			}
		}else {
			founded = element==arrayListElements.get(min);
		}
		return founded;
	}*/

}
