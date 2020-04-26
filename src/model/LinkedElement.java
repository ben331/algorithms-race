package model;

public class LinkedElement {
	
	//Relations
	
	private LinkedElement pre;
	private LinkedElement next;
	
	//Attributes
	private long number;
	
	//Constructor
	public LinkedElement(long number) {
		super();
		this.number = number;
	}
	
	//Getters and Setters
	public LinkedElement getPre() {
		return pre;
	}

	public LinkedElement getNext() {
		return next;
	}

	public long getNumber() {
		return number;
	}

	public void setPre(LinkedElement pre) {
		this.pre = pre;
	}

	public void setNext(LinkedElement next) {
		this.next = next;
	}
}
