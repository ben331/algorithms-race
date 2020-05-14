package model;

import java.util.ArrayList;
import java.util.Random;

public class AList extends DataStructure{
	
	private ArrayList<Long> arrayListElements;
	
	public AList(){
		arrayListElements = new ArrayList<Long>();
	}
	
	public void clear(){
		arrayListElements = new ArrayList<Long>();
	}

	@Override
	public void addIterative(int n, Random r) {
		Long element;
		
		for(int i=0; i<n; i++) {
			element = r.nextLong();
			arrayListElements.add(element);
		}
	}

	@Override
	public void searchIterative(int n, Random r) {
		long element;
		boolean founded = false;
		for(int i=0; i<n;i++) {
			element = r.nextLong();
			for(int j=0; j<arrayListElements.size() && !founded;j++) {

				founded=arrayListElements.get(j).longValue()==element;
			}
			founded=false;
		}
	}

	@Override
	public void removeIterative(int n, Random r) {
		long element;
		boolean removed= false;
		for(int i=0; i<n;i++) {
			element = r.nextLong();
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
	public void addRecursive(int i, int n, Random r) {
		Long element;
		
		if(i<n) {
			element = r.nextLong();
			arrayListElements.add(element);
			addRecursive(i+1, n, r);
		}
	}

	@Override
	public void searchRecursive(int i, int n, Random r) {
		long element;
		if(i<n) {
			element = r.nextLong();
			searchRecursive(element,0);
			searchRecursive(i+1, n, r);
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
	public void removeRecursive(int i, int n, Random r) {
		long element;
		if(i<n) {
			element = r.nextLong();
			removeRecursive(element,0);
			removeRecursive(i, n, r);
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
