//Tworzenie klasy gracz
class Gracz
{
	public int graczKolko;
	public int graczKrzyzyk;
	public int graczAktualny;
//Przypisanie wartrosci poczatkowych graczy
  Gracz()
      {
	     graczKolko= 1;
	     graczKrzyzyk=0;
	     graczAktualny=graczKolko;
	  }
//Funkcja zmieniajaca ture graczy
	public int przydzielGracza()
      {
	     if(graczAktualny== graczKolko)
	        graczAktualny = graczKrzyzyk;
	     else if(graczAktualny==graczKrzyzyk)
		    graczAktualny = graczKolko;
		 return graczAktualny;
	  }
}