package model;

import java.util.Random;

public abstract class DataStructure {
	
	public DataStructure() {}
	
	public abstract void addIterative(int n, Random r);
	public abstract void searchIterative(int n, Random r);
	public abstract void removeIterative(int n, Random r);
	public abstract void addRecursive(int i, int n, Random r);
	public abstract void searchRecursive(int i, int n, Random r);
	public abstract void removeRecursive(int i, int n, Random r);
	public abstract void clear();

}
