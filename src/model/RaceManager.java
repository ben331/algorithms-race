package model;

public class RaceManager {
	
	//Relations
	private DataStructure arrayList;
	private DataStructure linkedList;
	private DataStructure bst;
	
	public RaceManager() {
		arrayList = new AList();
		linkedList = new LinkedList();
		bst = new BST();
	}

	public DataStructure getArrayList() {
		return arrayList;
	}

	public DataStructure getLinkedList() {
		return linkedList;
	}

	public DataStructure getBst() {
		return bst;
	}
	
	public void clearData() {
		arrayList.clear();
		linkedList.clear();
		bst.clear();
	}
}
