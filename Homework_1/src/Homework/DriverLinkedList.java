package Homework;

public class DriverLinkedList {

	public static void main(String[] args) {
		DoubleLinkedList dll1 = new DoubleLinkedList(); //12 elementi
		dll1.Append("Emanuele");
		dll1.Append("Carmine");
		dll1.Append("Giovanni");
		dll1.Append("Francesco");
		dll1.Append("Ciro");
		dll1.Append("Gennaro");
		dll1.Append("Luca");
		dll1.Append("Marco");
		dll1.Append("Fabio");
		dll1.Append("Umberto");
		dll1.Append("Gianluca");
		dll1.Append("Maria");
		ReverseLinkedList(dll1);
		StampaLista(dll1);
		//Risultato atteso:
		//Emanuele,Carmine,Giovanni,Francesco,Ciro,Gennaro,Maria,Gianluca,Umberto,Fabio,Marco,Luca
		
		DoubleLinkedList dll2 = new DoubleLinkedList(); //6 elementi
		dll2.Append("Fabiana");
		dll2.Append("Ciro");
		dll2.Append("Francesco");
		dll2.Append("Giuseppe");
		dll2.Append("Maria");
		dll2.Append("Giovanna");
		ReverseLinkedList(dll2);
		StampaLista(dll2);
		//Risultato atteso:
		//Fabiana,Ciro,Francesco,Giovanna,Maria,Giuseppe
		

		DoubleLinkedList dll3 = new DoubleLinkedList(); //8 elementi
		dll3.Append("Francesco");
		dll3.Append("Giovanni");
		dll3.Append("Luca");
		dll3.Append("Marco");
		dll3.Append("Ciro");
		dll3.Append("Gennaro");
		dll3.Append("Emanuele");
		dll3.Append("Carmine");
		ReverseLinkedList(dll3);
		StampaLista(dll3);
		//Risultato atteso:
		//Francesco,Giovanni,Luca,Marco,Carmine,Emanuele,Gennaro,Ciro
		
		DoubleLinkedList dll4 = new DoubleLinkedList(); //0 elementi
		ReverseLinkedList(dll4); //Restituisce false
		StampaLista(dll4);
		//Risultato atteso:
		//Nessun elemento stampato
	}
	
	public static boolean ReverseLinkedList(DoubleLinkedList dll) { 
		Node last = dll.head;
		Node mid = dll.head;
		if(dll.head == null) {
			return false;
		}
		int count = 1;
		while(last.next != null) {
			last = last.next;
			count++;
		}
		if(count < 4) {
			return false;
		}
		count = count/2;
		for(int i=0; i < count; i++) {
			mid = mid.next;
		}			
		while(mid != last && mid != last.next ) {
			Swap(mid, last);
			mid = mid.next;
			last = last.prev;
		}
		return true;
	}
	
	public static void Swap(Node a, Node b) {
		Node temp = new Node();
		temp.name = a.name;
		a.name = b.name;
		b.name = temp.name;
	}
	
	public static void StampaLista(DoubleLinkedList dll) {
		Node t = dll.head;
		while(t!= null) {
			System.out.print(t.name + "  ");
			t = t.next;
		}
		System.out.println();
	}
}

class DoubleLinkedList {

	Node head;

	public DoubleLinkedList(){
		head = null;
	}
	
	public boolean Push(String e){
		Node r = new Node();
		r.name = e;
		r.next = head;
		r.prev = null;
		head = r;
		return true;
	}
	
	public boolean Pop(String e){
		if(!Empty()){
			Node q = head;
		    e = q.name;
		    head = head.next;
		    return true;
		}else return false;
	}

		    
	private boolean Empty() {
		return head == null;
	}

	public boolean Append(String e){

		if(Empty()){
			Push(e);
		    return false;
		}
		Node q = head; 
		Node temp = new Node();
		temp.name = e;
		temp.next = null;
		temp.prev = null;
		while(q.next != null)
			q = q.next; 
		q.next = temp;
		temp.prev = q;
		return true;
	}
}

class Node {
	public String name;
	public Node prev;
	public Node next;
	
	Node(){
		name = "";
	}
	
	Node(String d) {
		name = d;
	}
}
