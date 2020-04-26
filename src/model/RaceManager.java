package model;

import java.util.ArrayList;

public class RaceManager {
	
	//Relations
	private BSTElement rootBSTElements;
	private LinkedElement firstLinkedElement;
	private LinkedElement lastLinkedElement;
	private ArrayList<Long> arrayListElements;
	
	//Constructor
	public RaceManager() {
		arrayListElements = new ArrayList<Long>();
	}

	//Getters
	public BSTElement getRootBSTElements() {
		return rootBSTElements;
	}

	public LinkedElement getFirstLinkedElement() {
		return firstLinkedElement;
	}

	public ArrayList<Long> getArrayListElements() {
		return arrayListElements;
	}
	
	//Methods--for--add---------------------------------------------------------------------------------------------------------------
	public void addToArrayListIterative(int n) {
		Long element;
		
		for(int i=0; i<n; i++) {
			element = (long)Math.random();
			arrayListElements.add(element);
		}
	}
	
	public void addToArrayListRecursive(int n, int i) {
		Long element;
		
		if(i<n) {
			element = (long)Math.random();
			arrayListElements.add(element);
			addToArrayListRecursive(n,i+1);
		}
	}
	
	public void addToLinkedListIterative(int n) {
		LinkedElement element;
		
		if(firstLinkedElement==null) {
			element = new LinkedElement((long)Math.random());
			firstLinkedElement=element;
			lastLinkedElement=element;
			n-=1;
		}
		for(int i=0; i<n; i++) {
			element = new LinkedElement((long)Math.random());
			
			lastLinkedElement.setNext(element);
			element.setPre(lastLinkedElement);
			lastLinkedElement=element;
		}
	}
	
	public void addToLinkedListRecursive(int n, int i) {
		LinkedElement element;
		
		if(firstLinkedElement==null) {
			element = new LinkedElement((long)Math.random());
			firstLinkedElement=element;
			lastLinkedElement=element;
			n-=1;
		}
		if (i<n){
			element = new LinkedElement((long)Math.random());
			
			lastLinkedElement.setNext(element);
			element.setPre(lastLinkedElement);
			lastLinkedElement=element;
			addToLinkedListRecursive(n,++i);
		}
	}
	
	public void addToBSTIterative(int n) {
		BSTElement element = new BSTElement((long)Math.random());
		BSTElement root = rootBSTElements;
		boolean wasAdded=false;
		
		if(rootBSTElements==null) {
			rootBSTElements = element;
			n-=1;
		}
			
		for(int i=0; i<n;i++) {
			element = new BSTElement((long)Math.random());
			while(!wasAdded) {
				if(element.getNumber()<root.getNumber()) {
					if(root.getLeft()==null) {
						root.setLeft(element);
						element.setHead(root);
						wasAdded=true;
					}else {
						root=root.getLeft();
					}				
				}else {
					if(root.getRight()==null) {
						root.setRight(element);
						element.setHead(root);
						wasAdded=true;
					}else {
						root=root.getRight();
					}
				}
			}
			wasAdded=false;
		}
	}
	
	public void addToBSTRecursive(int n, int i) {
		BSTElement element;
		if(i<n) {
			element = new BSTElement((long)Math.random());
			addToBST(element, rootBSTElements);
			addToBSTRecursive(n,i+1);
		}
	}
	private void addToBST(BSTElement element, BSTElement root) {
		if(rootBSTElements==null) {
			rootBSTElements=element;
		}
		else if(element.getNumber()<root.getNumber()) {
			if(root.getLeft()==null) {
				root.setLeft(element);
				element.setHead(root);
			}else {
				addToBST(element, root.getLeft());
			}				
		}else {
			if(root.getRight()==null) {
				root.setRight(element);
				element.setHead(root);
			}else {
				addToBST(element, root.getRight());
			}
		}
	}
	
	//Searching Methods---------------------------------------------------------------------------------------------------------------
	
	public void searchInArrayListIterative(int n) {
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
	
	public void searchInArrayListRecursive(int n, int i) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			searchInArrayListRecursive(element,0,arrayListElements.size());
		}
	}

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
	}
	
	public void searchInLinkedListIterative(int n) {
		long element;
		LinkedElement current = firstLinkedElement;
		for(int i=0; i<n;i++) {
			element = (long)Math.random();
			while(current!=null  && current.getNumber()!=element) {
				current=current.getNext();
			}
		}
	}
	
	public void searchInLinkedListRecursive(int n, int i) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			searchInLinkedListRecursive(element, firstLinkedElement);
			searchInLinkedListRecursive(n,i+1);
		}
	}	
	private void searchInLinkedListRecursive(long element, LinkedElement current) {
		if(current!=null && current.getNumber()!=element) {
			searchInLinkedListRecursive(element, current.getNext());
		}
	}
	
	public void searchInBSTIterative(int n) {
		long element;
		BSTElement nodo = rootBSTElements;
		boolean wasFounded=false;
		for(int i=0; i<n; i++) {
			element= (long)Math.random();
			while(nodo!=null && !wasFounded) {
				if(nodo.getNumber()<element) {
					nodo = nodo.getLeft();
				}else if(nodo.getNumber()>element) {
					nodo = nodo.getRight();
				}else {
					wasFounded=true;
				}
			}
			wasFounded=false;
		}
	}
	
	public void searchInBSTRecursive(int n, int i) {
		long element;
		if(i<n) {
			element= (long)Math.random();
			searchInBSTRecursive(rootBSTElements, element);
		}
	}
	private boolean searchInBSTRecursive(BSTElement nodo, long element) {
		boolean founded=false;
		if(nodo!=null) {
			if(nodo.getNumber()<element) {
				founded = searchInBSTRecursive(nodo.getLeft(),element);
			}else if(nodo.getNumber()>element) {
				founded = searchInBSTRecursive(nodo.getRight(),element);
			}else {
				founded = true;
			}
		}
		return founded;
	}
	
	// Methods for remove -----------------------------------------------------------------------------------------------------------
	
	public void removeFromArrayListIterative(int n) {
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
	
	public void removeFromArrayListRecursive(int n, int i) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			removeFromArrayListRecursive(element,0,arrayListElements.size());
		}
	}

	private boolean removeFromArrayListRecursive(long element, int min, int max) {
		boolean removed=false;
		if(min!=max) {
			if(element<arrayListElements.get((int)(min+max)/2)) {
				removed=removeFromArrayListRecursive(element, min, (int)((min+max)/2) -1);
			}
			else if(element>arrayListElements.get((int)(min+max)/2)) {
				removed=removeFromArrayListRecursive(element,(int)((min+max)/2)+1, max);
			}else {
				arrayListElements.remove((int)(min+max)/2);
				removed=true;
			}
		}else {
			removed = element==arrayListElements.get(min);
		}
		return removed;
	}
	
	public void removeFromLinkedListIterative(int n) {
		long element;
		LinkedElement current;
		for(int i=0; i<n;i++) {
			element = (long)Math.random();
			current = firstLinkedElement;
			while(current!=null  && current.getNumber()!=element) {
				current=current.getNext();
			}
			if(current!=null) {
				if(firstLinkedElement==lastLinkedElement) {
					firstLinkedElement=null;
					lastLinkedElement=null;
				}else if(firstLinkedElement==current) {
					current.getNext().setPre(null);
					firstLinkedElement=firstLinkedElement.getNext();
				}else if(lastLinkedElement==current) {
					current.getPre().setNext(null);
					lastLinkedElement=lastLinkedElement.getPre();
				}else {
					current.getPre().setNext(current.getNext());
					current.getNext().setPre(current.getPre());
				}
			}
		}
	}
	
	public void removedFromLinkedListRecursive(int n, int i) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			removedFromLinkedListRecursive(element, firstLinkedElement);
			removedFromLinkedListRecursive(n,i+1);
		}
	}	
	private void removedFromLinkedListRecursive(long element, LinkedElement current) {
		if(current!=null && current.getNumber()!=element) {
			removedFromLinkedListRecursive(element, current.getNext());
		}if(current!=null) {
			if(firstLinkedElement==lastLinkedElement) {
				firstLinkedElement=null;
				lastLinkedElement=null;
			}else if(firstLinkedElement==current) {
				current.getNext().setPre(null);
				firstLinkedElement=firstLinkedElement.getNext();
			}else if(lastLinkedElement==current) {
				current.getPre().setNext(null);
				lastLinkedElement=lastLinkedElement.getPre();
			}else {
				current.getPre().setNext(current.getNext());
				current.getNext().setPre(current.getPre());
			}
		}
	}
}
