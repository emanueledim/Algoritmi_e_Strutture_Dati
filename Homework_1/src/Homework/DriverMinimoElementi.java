package Homework;

public class DriverMinimoElementi {

	public static void main(String[] args) {
		

		int[] vet1 = {5,5,5,5,5,5,5};				//Vettore atteso in uscita->6 6 6 6 6 6 6
		int[] vet2= {0,0,455,5,5,5,5,5,0,0,0,0};	//Vettore atteso in uscita->5 5 11 10 10 10 10 10 5 5 5 5
		int[] vet3= {9,8,3,2,1,4,5,9,9,7};	//Vettore atteso in uscita->9 6 2 1 0 3 4 9 9 5 
		int[] vet4= {9,8,3,2,1,4,5,9,9,7,6,7};	//Vettore atteso in uscita->11 8 2 1 0 3 4 11 11 7 5 7 
		
		MinimiPerElemento(vet1,vet1.length);
		MinimiPerElemento(vet2,vet2.length);
		MinimiPerElemento(vet3,vet3.length);
		MinimiPerElemento(vet4,vet4.length);
	}
	

	public static int BinarySearchModified(int vet[], int low, int high,int valore, int dim){
    	
    	if (high>=low) {
    		int mid = low+(high-low)/2;
    		if ((mid == dim-1 || valore<vet[mid+1]) && vet[mid] == valore){ //in questo modo trovo l'ultima occorrenza di un numero che si ripete
    										//così da tener conto dei <= e non solamente  dei < 
    			return mid;
    		} 
    		else if(valore<vet[mid]) {
    			return BinarySearchModified(vet,low,(mid-1),valore,dim);
    		}
    		else{
    			return BinarySearchModified(vet,(mid+1),high,valore,dim);
    		}
    	}
    	return -1;
    }
	
	public static void MergeSort(int[] vet, int dim){
	    if (dim<2){
	        return;
	    }
	    int mid=dim/2;
	    int[] l=new int[mid];
	    int[] r=new int[dim-mid];

	    for (int i=0;i<mid;i++) {
	        l[i]=vet[i];
	    }
	    for (int i=mid;i<dim;i++) {
	        r[i-mid]=vet[i];
	    }
	    MergeSort(l,mid);
	    MergeSort(r,dim-mid);

	    merge(vet,l,r,mid,dim-mid);
	}
	
	public static void merge(int[] vet, int[] l, int[] r, int left, int right){
			 
	    int i = 0;
	    int j = 0;
	    int k = 0;
	    while (i < left && j < right) {
	        if (l[i] <= r[j]) {
	            vet[k++] = l[i++];
	        }
	        else {
	            vet[k++] = r[j++];
	        }
	    }
	    while (i < left) {
	        vet[k++] = l[i++];
	    }
	    while (j < right) {
	        vet[k++] = r[j++];
	    }
	}
	
	static void Stampa(int[] vettore,int dim){

		for(int i=0; i<dim;i++){
			System.out.print(vettore[i]+" ");
		}
		System.out.println();

	}
	
	static int[] Copy(int[] vet1,int dim) {
		int[] vet2=new int[dim];
		for(int i=0;i<dim;i++) {
			
			vet2[i]=vet1[i];
		}
		
		return vet2;
		
	}
	
	static void MinimiPerElemento(int[] vet,int dim) {
		
		int[] vetcopy=new int[dim];
		int[] vetout=new int[dim];
		vetcopy=Copy(vet,dim);											//O(n)
		MergeSort(vetcopy,dim);										//O(nlog n)
		
		for(int i=0; i<dim; i++) {
			vetout[i]=BinarySearchModified(vetcopy,0,dim,vet[i],dim);  // for->complessità O(n),binary search modificata->O(log n) => O(nlog n)
			
		}
		Stampa(vetout,dim);
	}
	
}
