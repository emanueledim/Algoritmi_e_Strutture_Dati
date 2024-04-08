package Homework;

import java.util.Objects;

public class DriverTreap {
	public static void main(String[] args) {
		
		Treap treap1 = new Treap();
		treap1.TreapInsert(new TreeNode('H', 5));
		treap1.TreapInsert(new TreeNode('G', 4));
		treap1.TreapInsert(new TreeNode('B', 7));
		treap1.TreapInsert(new TreeNode('E', 23));
		treap1.TreapInsert(new TreeNode('F', 2));
		treap1.TreapInsert(new TreeNode('I', 73));
		treap1.TreapInsert(new TreeNode('K', 65));
		treap1.TreapInsert(new TreeNode('A', 10));
		treap1.TreapInsert(new TreeNode('C', 25));
		treap1.TreapInsert(new TreeNode('D', 9));
		
		Treap treap2 = new Treap();
		treap2.TreapInsert(new TreeNode('J', 50));
		treap2.TreapInsert(new TreeNode('D', 41));
		treap2.TreapInsert(new TreeNode('Q', 65));
		treap2.TreapInsert(new TreeNode('T', 12));
		treap2.TreapInsert(new TreeNode('U', 2));
		treap2.TreapInsert(new TreeNode('S', 99));
		treap2.TreapInsert(new TreeNode('L', 82));
		treap2.TreapInsert(new TreeNode('Z', 74));
		treap2.TreapInsert(new TreeNode('V', 75));
		treap2.TreapInsert(new TreeNode('M', 3));
		treap2.TreapInsert(new TreeNode('H', 15));
		treap2.TreapInsert(new TreeNode('A', 64));
		treap2.TreapInsert(new TreeNode('F', 11));
		treap2.TreapInsert(new TreeNode('K', 32));
		treap2.TreapInsert(new TreeNode('P', 4));
		treap2.TreapInsert(new TreeNode('Y', 10));
		treap2.TreapInsert(new TreeNode('B', 1));
		
		Treap treap3 = new Treap();
		treap3.TreapInsert(new TreeNode('C', 3));
		treap3.TreapInsert(new TreeNode('X', 50));
		treap3.TreapInsert(new TreeNode('H', 1));
		treap3.TreapInsert(new TreeNode('I', 25));
		treap3.TreapInsert(new TreeNode('K', 505));
		treap3.TreapInsert(new TreeNode('E', 20));
		treap3.TreapInsert(new TreeNode('L', 76));
		treap3.TreapInsert(new TreeNode('R', 14));
		treap3.TreapInsert(new TreeNode('F', 91));
		treap3.TreapInsert(new TreeNode('J', 23));
		treap3.TreapInsert(new TreeNode('Q', 53));
		treap3.TreapInsert(new TreeNode('S', 7));
		treap3.TreapInsert(new TreeNode('M', 99));
		treap3.TreapInsert(new TreeNode('Z', 84));
		treap3.TreapInsert(new TreeNode('A', 35));
		treap3.TreapInsert(new TreeNode('N', 21));
		treap3.TreapInsert(new TreeNode('O', 28));
		treap3.TreapInsert(new TreeNode('B', 43));
		treap3.TreapInsert(new TreeNode('P', 71));
		treap3.TreapInsert(new TreeNode('T', 65));
		treap3.TreapInsert(new TreeNode('D', 32));
		treap3.TreapInsert(new TreeNode('V', 46));
		treap3.TreapInsert(new TreeNode('W', 103));
		treap3.TreapInsert(new TreeNode('Y', 106));
		treap3.TreapInsert(new TreeNode('U', 2));
		treap3.TreapInsert(new TreeNode('G', 61));
		
		Stampa(treap1.root);
		Stampa(treap2.root);
		Stampa(treap3.root);
	}
	
	public static void Stampa(TreeNode x) {
		if(x == null)
			return;
		System.out.print(x.key + ", " + x.priority+" | ");
		if(x.left != null) {
			System.out.print("[LEFT: " + x.left.key + ", "+ x.left.priority+"]");
		}else {
			System.out.print("[LEFT: NIL]");
		}
		if(x.right != null) {
			System.out.print("  [RIGHT: " + x.right.key + ", "+ x.right.priority+"]");
		}else {
			System.out.print("  [RIGHT: NIL]");
		}
		System.out.println();
		Stampa(x.left);
		Stampa(x.right);
	}
}

class Treap {

	public TreeNode root;
	public final TreeNode NIL = null;
	
	public Treap() {
		root = null;
	}

	public void TreapInsert(TreeNode z) {
		TreeNode y = NIL;
		TreeNode x = root;
		while(x != null) { //Fino alle foglie dell'albero
			y = x;
			if(z.key < x.key) {
				x = x.left; // Scorro a sinistra se la chiave di z è più piccola di x
			}else {
				x = x.right;  // Scorro a destra se la chiave di z è più grande di x
			}
		}
		
		z.parent = y;
		if(y == NIL) { //Se l'albero è vuoto, imposta z come radice
			root = z;
		}else if(z.key < y.key) {
			y.left = z;
		}else if(z.key > y.key) { //Non può verificarsi il caso con 2 chiavi uguali (vincolo del problema)
			y.right = z;
		}
		//Fine tree-insert
		//Inizio rotazioni
		boolean exit = false;
		while(!Objects.equals(z.parent, NIL) && !exit) {
			if(z.priority < z.parent.priority) {
				y = z.parent;
				if(z.equals(y.left)){ //Se z è figlio sinistro di y, ruota a destra
					RightRotate(z, y);
				}else if(z.equals(y.right)){ // Invece se z è figlio destro di y, ruota a sinistra
					LeftRotate(z, y);
				}
			}else {
				exit = true;
			}
		}
	}
	

	public void LeftRotate(TreeNode z, TreeNode y) {
		y.right = z.left;
		if(z.left != NIL) {
			z.left.parent = y;
		}
		z.parent = y.parent;
		if(Objects.equals(y.parent, NIL)) {
			root = z;
		}
		else if(y.equals(y.parent.left)) {
			y.parent.left = z;
		}
		else if(y.equals(y.parent.right)) {
			y.parent.right = z;
		}
		z.left = y;
		y.parent = z;
		
	}

	public void RightRotate(TreeNode z, TreeNode y) {
		y.left = z.right;
		if(z.right != NIL) {
			z.right.parent = y;
		}
		z.parent = y.parent;
		if(Objects.equals(y.parent, NIL)) {
			root = z;
		}
		else if(y.equals(y.parent.left)) {
			y.parent.left = z;
		}
		else if(y.equals(y.parent.right)) {
				y.parent.right = z;
		}
		z.right = y;
		y.parent = z;
	}
	
	public void Stampa(TreeNode x) {
		if(x == NIL)
			return;
		System.out.print(x.key + " " + x.priority + " LEFT: " + x.left.key + " "+ x.left.priority + " RIGHT: " + x.right.key +" "+ x.right.priority+"\n");
		Stampa(x.left);
		Stampa(x.right);
	}
}

class TreeNode {

	public char key;
	public int priority;
	public TreeNode parent;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode() {
		key = 0;
		priority = 0;
		parent = null;
		left = null;
		right = null;
	}

	public TreeNode(char k, int p) {
		key = k;
		priority = p;
		parent = null;
		left = null;
		right = null;
	}
}

