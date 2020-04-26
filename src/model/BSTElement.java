package model;

public class BSTElement {
	
	//Relations
	private BSTElement left;
	private BSTElement right;
	private BSTElement head;
	
	//Attributes
	private Long number;
	
	//Constructor
	public BSTElement(Long number) {
		super();
		this.number = number;
	}
	
	//Getters and Setters
	public BSTElement getLeft() {
		return left;
	}

	public BSTElement getRight() {
		return right;
	}

	public BSTElement getHead() {
		return head;
	}

	public Long getNumber() {
		return number;
	}

	public void setLeft(BSTElement left) {
		this.left = left;
	}

	public void setRight(BSTElement right) {
		this.right = right;
	}

	public void setHead(BSTElement head) {
		this.head = head;
	}
}
