package model;

import java.util.Random;

public class BST extends DataStructure{
	
	private BSTElement rootElement;
	
	public void clear() {
		rootElement = null;
	}

	@Override
	public void addIterative(int n, Random r) {
		BSTElement element = new BSTElement(r.nextLong());
		boolean wasAdded=false;
		
		if(rootElement==null) {
			rootElement = element;
			n-=1;
		}
		
		BSTElement root = rootElement;
			
		for(int i=0; i<n;i++) {
			System.out.println("A"+i);
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

	@Override
	public void searchIterative(int n, Random r) {
		long element;
		BSTElement nodo = rootElement;
		boolean wasFounded=false;
		for(int i=0; i<n; i++) {
			element= r.nextLong();
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

	@Override
	public void removeIterative(int n, Random r) {
		long num;
		BSTElement element;
		for(int i=0;i<n ;i++) {
			num = r.nextLong();
			element = searchRecursive(rootElement , num);
			
			
			
			if(element!=null) {
				if(element.getLeft()==null | element.getRight()==null) {      //Delete element with one child
					if(element==rootElement) {
						if(element.getLeft()!=null) {
							element.getLeft().setHead(null);
							rootElement=element.getLeft();
						}else {
							element.getRight().setHead(null);
							rootElement=element.getRight();
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
					if(element==rootElement) {
						rootElement=null;
					}else {
						if(element.getHead().getLeft()==element) {
							element.getHead().setLeft(null);
						}else {
							element.getHead().setRight(null);
						}
					}
					
					
				}else {				                                             //Delete element with both children
					BSTElement min = element.getRight().getMin();
					removeRecursive(min);
					min.setHead(element.getHead());
					min.setRight(element.getRight());
					min.setLeft(element.getLeft());
					element.getLeft().setHead(min);
					if(element.getRight()!=null) {
						element.getRight().setHead(min);
					}
					if(element==rootElement) {
						rootElement=min;
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
	}

	@Override
	public void addRecursive(int i, int n, Random r) {
		BSTElement element;
		if(i<n) {
			element = new BSTElement((r.nextLong()));
			addRecursive(element, rootElement);
			addRecursive(i+1, n, r);
		}
	}
	
	private void addRecursive(BSTElement element, BSTElement root) {
		if(rootElement==null) {
			rootElement=element;
		}
		else if(element.getNumber()<root.getNumber()) {
			if(root.getLeft()==null) {
				root.setLeft(element);
				element.setHead(root);
			}else {
				addRecursive(element, root.getLeft());
			}				
		}else {
			if(root.getRight()==null) {
				root.setRight(element);
				element.setHead(root);
			}else {
				addRecursive(element, root.getRight());
			}
		}
	}

	@Override
	public void searchRecursive(int i, int n, Random r) {
		long element;
		if(i<n) {
			element= r.nextLong();
			searchRecursive(rootElement, element);
			searchRecursive(i+1,n,r);
		}
	}
	
	private BSTElement searchRecursive(BSTElement nodo, long element) {
		if(nodo!=null) {
			if(nodo.getNumber()<element) {
				return searchRecursive(nodo.getLeft(),element);
			}else if(nodo.getNumber()>element) {
				return searchRecursive(nodo.getRight(),element);
			}else {
				return nodo;
			}
		}else {
			return null;
		}
	}

	@Override
	public void removeRecursive(int i, int n, Random r) {
		long num;
		if(i<n) {
			num = r.nextLong();
			BSTElement element = searchRecursive(rootElement, num);
			removeRecursive(element);
			removeRecursive(i+1,n,r);
		}
	}
	
	private boolean removeRecursive(BSTElement element) {
		if(element==null) {
			return false;
		}else if(element.getLeft()==null | element.getRight()==null) {      //Delete element with one child
			if(element==rootElement) {
				if(element.getLeft()!=null) {
					element.getLeft().setHead(null);
					rootElement=element.getLeft();
				}else {
					element.getRight().setHead(null);
					rootElement=element.getRight();
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
			if(element==rootElement) {
				rootElement=null;
			}else {
				if(element.getHead().getLeft()==element) {
					element.getHead().setLeft(null);
				}else {
					element.getHead().setRight(null);
				}
			}
			return true;
			
			
		}else {				                                             //Delete element with both children
			BSTElement min = element.getRight().getMin();
			removeRecursive(min);
			min.setHead(element.getHead());
			min.setRight(element.getRight());
			min.setLeft(element.getLeft());
			element.getLeft().setHead(min);
			if(element.getRight()!=null) {
				element.getRight().setHead(min);
			}
			if(element==rootElement) {
				rootElement=min;
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

}
