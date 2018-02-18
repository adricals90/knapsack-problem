package knapsack;
//Project
//By: Orlando Calle 

public class knapsack {

	public static void main(String[] args) {
		
		int b=10;// max size 
		int n=7;// number of elements.

		int [] val= {0,4,7,8,1,6,4,9};
		int [] size={0,3,4,5,2,3,6,5};
		int[][] v=new int[n+1][b+1];
		
		System.out.println("          The Knaksack Problem");

		
		for(int w=0;w<=b;w++){
			 v[0][w]=0;
		}
		for(int i=1;i<=n;i++){
			 v[i][0]=0;
		}
		
		for(int i=1;i<=n;i++){
			
			for(int w=0;w<=b;w++){
				
				if(size[i]<=w){
					
					if((val[i]+v[i-1][w-size[i]])>v[i-1][w]){
						
						v[i][w]=val[i]+v[i-1][w-size[i]];
					}else
					{
						v[i][w]=v[i-1][w];

					}
				}
				else{
					v[i][w]=v[i-1][w];
				}
			}
		}
		
		for(int w=0;w<=n;w++){// display the matrix
			for(int i=0;i<=b;i++){
			System.out.print(v[w][i]+" | ");
			}
		System.out.println();
		}
		
    	System.out.println("The optimum value is: |"+v[n][b]+"|");// optimum value
    	
    	System.out.print("The items chosen are: ");

    	while(n>0&&b>0){// finding the items chosen
    		if(v[n][b]!=v[n-1][b]){
    			System.out.print(n+" ");
    			b=b-size[n];
    			n--;
    		}
    		else{
    			n--;
    		}
    	}
	
	}

}
