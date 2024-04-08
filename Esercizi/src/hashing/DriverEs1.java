package hashing;

public class DriverEs1 {

	private static final int m = 11;
	
	public DriverEs1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Table T = new Table(m);	//Tabella con m slot
		HashInsert(T, 33, m);
		HashInsert(T, 10, m);
		HashInsert(T, 24, m);
		HashInsert(T, 14, m);
		HashInsert(T, 16, m);
		HashInsert(T, 13, m);
		HashInsert(T, 23, m);
		HashInsert(T, 31, m);
		HashInsert(T, 18, m);
		HashInsert(T, 11, m);
		HashInsert(T, 7, m);
		int elem = 24;
		int pos = LinearScan(T,elem, m);
		System.out.println(pos);
		return;
	}
	
	public static class DataTable{
		public int data;
		public boolean isValid;
		
		public DataTable() {
			data = -1;
			isValid = false;
		}
	}
	
	public static class Table{
		public DataTable[] slots;
		public int m;
		
		public Table(int m) {
			slots = new DataTable[m];
			for(int i=0; i<m; i++) {
				slots[i] = new DataTable();
			}
		}
	}
	
	public static int HashInsert(Table T, int k, int m) {
		int i=0;
		int j=0;
		while(i < m) {
			j = hash(k, i, m);
			if(!T.slots[j].isValid) {
				T.slots[j].data = k;
				T.slots[j].isValid = true;
				return j;
			}else {
				i++;
			}
		}
		return k;
		
	}

	public static int LinearScan(Table T, int k, int m) {
		int i = 0;
		int c = -1;
		int j = hash(k, i, m);
		while(T.slots[j].data != k || T.slots[j].isValid == false && i<m) {	//Finche il dato non corrisponde e non è valido
			if(c == -1) {
				c = j;
			}
			i++;
			j = (hash(k, i, m)+i*hash(k,i,m))%m;
		}
		
		if(c != -1) {
			j = c;
		}
		return j;
	}
	
	private static int hash(int k, int i, int m) {
		return (((k%m)+3*i+i*i)%m);
	}
}
