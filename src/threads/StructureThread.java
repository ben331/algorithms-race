package threads;
import model.DataStructure;
public class StructureThread extends Thread{
	
	public static final char ADD = 'A';
	public static final char REMOVE = 'R';
	public static final char SEARCH = 'S';
	
	private DataStructure dataStructure;
	
	private char method;
	private boolean inModeInterative;
	private int n;
	
	public StructureThread(DataStructure dataStructure) {
		this.dataStructure = dataStructure;
	}
	
	
	public void setMethod(char method) {
		this.method = method;
	}
	
	public void setInModeInterative(boolean inModeInterative) {
		this.inModeInterative = inModeInterative;
	}

	public void setN(int n) {
		this.n = n;
	}




	@Override
	public void run() {
		if(inModeInterative) {
			switch(method) {
			case ADD:
				dataStructure.addIterative(n);
				break;
			case SEARCH:
				dataStructure.searchIterative(n);
				break;
			case REMOVE:
				dataStructure.removeIterative(n);
				break;
			}
		}else {
			switch(method) {
			case ADD:
				dataStructure.addRecursive(0, n);
				break;
			case SEARCH:
				dataStructure.searchRecursive(0, n);
				break;
			case REMOVE:
				dataStructure.removeRecursive(0, n);
				break;
			}
		}
	}
}
