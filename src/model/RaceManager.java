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
	
	//Main methods
	public void startRaceAddIterative(String n) {
		int num = toInt(n);
		addToArrayListIterative(num);
		addToLinkedListIterative(num);
		addToBSTIterative(num);
	}
	public void startRaceSearchIterative(String n) {
		int num = toInt(n);
		searchInArrayListIterative(num);
		searchInLinkedListIterative(num);
		searchInBSTIterative(num);
	}
	public void startRaceDeleteIterative(String n) {
		int num = toInt(n);
		removeFromArrayListIterative(num);
		removeFromLinkedListIterative(num);
		removeFromBSTIterative(num);
	}
	public void startRaceAddRecursive(String n) {
		int num = toInt(n);
		addToArrayListRecursive(num,0);
		addToLinkedListRecursive(num,0);
		addToBSTRecursive(num,0);
	}
	public void startRaceSearchRecursive(String n) {
		int num = toInt(n);
		searchInArrayListRecursive(num,0);
		searchInLinkedListRecursive(num,0);
		searchInBSTRecursive(num,0);
	}
	public void startRaceDeleteRecursive(String n) {
		int num = toInt(n);
		removeFromArrayListRecursive(num,0);
		removeFromLinkedListRecursive(num,0);
		removeFromBSTRecursive(num,0);
	}
	//Auxiliary methods
	private int toInt(String n) {
		int num = Integer.parseInt(n);
		if(num<=0) {
			throw new NumberFormatException();
		}
		return num;
	}
	
	
	//Methods--for--add---------------------------------------------------------------------------------------------------------------
	private void addToArrayListIterative(int n) {
		Long element;
		
		for(int i=0; i<n; i++) {
			element = (long)Math.random();
			arrayListElements.add(element);
		}
	}
	
	private void addToArrayListRecursive(int n, int i) {
		Long element;
		
		if(i<n) {
			element = (long)Math.random();
			arrayListElements.add(element);
			addToArrayListRecursive(n,i+1);
		}
	}
	
	private void addToLinkedListIterative(int n) {
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
	
	private void addToLinkedListRecursive(int n, int i) {
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
	
	private void addToBSTIterative(int n) {
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
	
	private void addToBSTRecursive(int n, int i) {
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
	
	private void searchInArrayListIterative(int n) {
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
	
	private void searchInArrayListRecursive(int n, int i) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			searchInArrayListRecursive(element,0);
			searchInArrayListRecursive(n, i+1);
		}
	}
	
	private boolean searchInArrayListRecursive(long element, int i) {
		if(i<arrayListElements.size() && arrayListElements.get(i).longValue()!=element) {
			return searchInArrayListRecursive(element, i+1);
		}else {
			return true;
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
	
	private void searchInLinkedListIterative(int n) {
		long element;
		LinkedElement current = firstLinkedElement;
		for(int i=0; i<n;i++) {
			element = (long)Math.random();
			while(current!=null  && current.getNumber()!=element) {
				current=current.getNext();
			}
		}
	}
	
	private void searchInLinkedListRecursive(int n, int i) {
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
	
	private void searchInBSTIterative(int n) {
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
	
	private void searchInBSTRecursive(int n, int i) {
		long element;
		if(i<n) {
			element= (long)Math.random();
			searchInBSTRecursive(rootBSTElements, element);
		}
	}
	private BSTElement searchInBSTRecursive(BSTElement nodo, long element) {
		if(nodo!=null) {
			if(nodo.getNumber()<element) {
				return searchInBSTRecursive(nodo.getLeft(),element);
			}else if(nodo.getNumber()>element) {
				return searchInBSTRecursive(nodo.getRight(),element);
			}else {
				return nodo;
			}
		}else {
			return null;
		}
	}
	
	// Methods for remove -----------------------------------------------------------------------------------------------------------
	
	private void removeFromArrayListIterative(int n) {
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
	
	private void removeFromArrayListRecursive(int n, int i) {
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
	
	private void removeFromLinkedListIterative(int n) {
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
	
	private void removeFromLinkedListRecursive(int n, int i) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			removeFromLinkedListRecursive(element, firstLinkedElement);
			removeFromLinkedListRecursive(n,i+1);
		}
	}	
	private void removeFromLinkedListRecursive(long element, LinkedElement current) {
		if(current!=null && current.getNumber()!=element) {
			removeFromLinkedListRecursive(element, current.getNext());
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
	private void removeFromBSTIterative(int n) {
		long num;
		BSTElement element;
		for(int i=0;i<n ;i++) {
			num = (long)Math.random();
			element = searchInBSTRecursive(rootBSTElements , num);
			
			if(element.getLeft()==null | element.getRight()==null) {      //Delete element with one child
				if(element==rootBSTElements) {
					if(element.getLeft()!=null) {
						element.getLeft().setHead(null);
						rootBSTElements=element.getLeft();
					}else {
						element.getRight().setHead(null);
						rootBSTElements=element.getRight();
					}
				}else {
					if(element.getLeft()!=null) {
						element.getLeft().setHead(element.getHead());
						if(element.getHead().getLeft()==element) {
							element.getHead().setLeft(element.getLeft());
						}else {
							element.getHead().setRight(element.getLeft());
						}					
					}else {
						element.getRight().setHead(element.getHead());
						if(element.getHead().getLeft()==element) {
							element.getHead().setLeft(element.getRight());
						}else {
							element.getHead().setRight(element.getRight());
						}
					}				
				}
				
				
			}else if(element.getLeft()==null && element.getRight()==null) {     //Delete sheet
				if(element==rootBSTElements) {
					rootBSTElements=null;
				}else {
					if(element.getHead().getLeft()==element) {
						element.getHead().setLeft(null);
					}else {
						element.getHead().setRight(null);
					}
				}
				
				
			}else {				                                             //Delete element with both children
				BSTElement min = searchMinBSTRecursive(element.getRight());
				removeFromBSTRecursive(min);
				min.setHead(element.getHead());
				min.setRight(element.getRight());
				min.setLeft(element.getLeft());
				element.getLeft().setHead(min);
				if(element.getRight()!=null) {
					element.getRight().setHead(min);
				}
				if(element==rootBSTElements) {
					rootBSTElements=min;
				}else {
					if(element.getHead().getLeft()==element) {
						element.getHead().setLeft(min);
					}else {
						element.getHead().setRight(min);
					}
				}
			}
		}
	}
	private void removeFromBSTRecursive(int n, int i) {
		long num;
		if(i<n) {
			num = (long)Math.random();
			BSTElement element = searchInBSTRecursive(rootBSTElements, num);
			removeFromBSTRecursive(element);
			removeFromBSTRecursive(n,i+1);
		}
	}
	
	
	private boolean removeFromBSTRecursive(BSTElement element) {
		if(element==null) {
			return false;
		}else if(element.getLeft()==null | element.getRight()==null) {      //Delete element with one child
			if(element==rootBSTElements) {
				if(element.getLeft()!=null) {
					element.getLeft().setHead(null);
					rootBSTElements=element.getLeft();
				}else {
					element.getRight().setHead(null);
					rootBSTElements=element.getRight();
				}
			}else {
				if(element.getLeft()!=null) {
					element.getLeft().setHead(element.getHead());
					if(element.getHead().getLeft()==element) {
						element.getHead().setLeft(element.getLeft());
					}else {
						element.getHead().setRight(element.getLeft());
					}					
				}else {
					element.getRight().setHead(element.getHead());
					if(element.getHead().getLeft()==element) {
						element.getHead().setLeft(element.getRight());
					}else {
						element.getHead().setRight(element.getRight());
					}
				}				
			}
			return true;
			
			
		}else if(element.getLeft()==null && element.getRight()==null) {     //Delete sheet
			if(element==rootBSTElements) {
				rootBSTElements=null;
			}else {
				if(element.getHead().getLeft()==element) {
					element.getHead().setLeft(null);
				}else {
					element.getHead().setRight(null);
				}
			}
			return true;
			
			
		}else {				                                             //Delete element with both children
			BSTElement min = searchMinBSTRecursive(element.getRight());
			removeFromBSTRecursive(min);
			min.setHead(element.getHead());
			min.setRight(element.getRight());
			min.setLeft(element.getLeft());
			element.getLeft().setHead(min);
			if(element.getRight()!=null) {
				element.getRight().setHead(min);
			}
			if(element==rootBSTElements) {
				rootBSTElements=min;
			}else {
				if(element.getHead().getLeft()==element) {
					element.getHead().setLeft(min);
				}else {
					element.getHead().setRight(min);
				}
			}
			return true;
		}
	}
	
	public BSTElement searchMinBSTRecursive(BSTElement root) {
		if(root.getLeft()!=null) {
			return searchMinBSTRecursive(root.getLeft());
		}else {
			return root;
		}
	}
}
