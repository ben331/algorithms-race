package model;

public abstract class DataStructure {
	
	public DataStructure() {}
	
	public abstract void addIterative(int n);
	public abstract void searchIterative(int n);
	public abstract void removeIterative(int n);
	public abstract void addRecursive(int i, int n);
	public abstract void searchRecursive(int i, int n);
	public abstract void removeRecursive(int i, int n);

}
