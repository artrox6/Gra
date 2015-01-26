//Tworzenie tabeli 3x3 tutaj beda zapisywane wartosci pól 
class TabelaWynikow
{
	
   
   public int[][] tablica = new int[3][3];
      public int[][] tworzenieTabeliWynikow()
	     {
		    for(int i=0 ; i<tablica.length;i++)
		       {
			      for( int j=0;j<tablica.length;j++)
			         {
				        tablica[i][j]=3;
				        System.out.print("a[" + i + "]" + "[" + j + "] =" + tablica[i][j] + " ");
			         }
			      System.out.println();
		       }
		    return tablica;
		    
	    
  }
}
