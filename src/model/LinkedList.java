package model;

public class LinkedList extends DataStructure{
	
	private LinkedElement firstLinkedElement;

	@Override
	public void addIterative(int n) {
		LinkedElement element;
		
		//Case for empty list.
		if(firstLinkedElement==null) {
			element = new LinkedElement((long)Math.random());
			firstLinkedElement=element;
			n-=1;
		}
		
		//Search the last linked element.
		LinkedElement last = firstLinkedElement;
		while(last.getNext()!=null) {
			last=last.getNext();
		}
		
		//Add each element at the end.
		for(int i=0; i<n; i++) {
			element = new LinkedElement((long)Math.random());
			last.setNext(element);
			element.setPre(last);
			last=element;
		}
	}

	@Override
	public void searchIterative(int n) {
		long element;
		LinkedElement current = firstLinkedElement;
		for(int i=0; i<n;i++) {
			element = (long)Math.random();
			while(current!=null  && current.getNumber()!=element) {
				current=current.getNext();
			}
		}
	}

	@Override
	public void removeIterative(int n) {
		long element;
		LinkedElement current;
		
		for(int i=0; i<n;i++) {
			element = (long)Math.random();
			current = firstLinkedElement;
			
			//Search element
			while(current!=null  && current.getNumber()!=element) {
				current=current.getNext();
			}
			
			//Case: Element found
			if(current!=null) {
				
				if(current.getPre()==null && current.getNext()==null) {//-----------Case: It's the only element
					firstLinkedElement=null;
				}else if(firstLinkedElement==current) {//---------------------------Case: It's the first element
					current.getNext().setPre(null);
					firstLinkedElement=firstLinkedElement.getNext();
				}else if(current.getNext()==null) {//-------------------------------Case: It's the last element
					current.getPre().setNext(null);
				}else {
					current.getPre().setNext(current.getNext());
					current.getNext().setPre(current.getPre());
				}
			}
		}
	}

	@Override
	public void addRecursive(int i, int n) {
		LinkedElement element;	
		
		//Case for empty list.
		if(firstLinkedElement==null) {
			element = new LinkedElement((long)Math.random());
			firstLinkedElement=element;
			n-=1;
		}
		
		//Search last element.
		LinkedElement last=firstLinkedElement;
		while(last.getNext()!=null) {
			last=last.getNext();
		}
		
		//Add each element at the end.
		addRecursive(last, i, n);
		
	}
	
	private void addRecursive(LinkedElement last, int i, int n) {
		if (i<n){
			LinkedElement element = new LinkedElement((long)Math.random());
			
			last.setNext(element);
			element.setPre(last);
			last=element;
			addRecursive(last,i++,n);
		}
	}

	@Override
	public void searchRecursive(int i, int n) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			searchRecursive(element, firstLinkedElement);
			searchRecursive(i+1,n);
		}
	}
	
	private void searchRecursive(long element, LinkedElement current) {
		if(current!=null && current.getNumber()!=element) {
			searchRecursive(element, current.getNext());
		}
	}

	@Override
	public void removeRecursive(int i, int n) {
		long element;
		if(i<n) {
			element = (long)Math.random();
			removeRecursive(element, firstLinkedElement);
			removeRecursive(i+1,n);
		}
	}
	
	private void removeRecursive(long element, LinkedElement current) {
		if(current!=null && current.getNumber()!=element) {
			removeRecursive(element, current.getNext());
		}
		//Case: Element found
		if(current!=null) {
			
			if(current.getPre()==null && current.getNext()==null) {//-----------Case: It's the only element
				firstLinkedElement=null;
			}else if(firstLinkedElement==current) {//---------------------------Case: It's the first element
				current.getNext().setPre(null);
				firstLinkedElement=firstLinkedElement.getNext();
			}else if(current.getNext()==null) {//-------------------------------Case: It's the last element
				current.getPre().setNext(null);
			}else {
				current.getPre().setNext(current.getNext());
				current.getNext().setPre(current.getPre());
			}
		}
	}
}
