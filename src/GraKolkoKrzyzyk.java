import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GraKolkoKrzyzyk extends JFrame implements ActionListener
{	
	
//Miejsce tworzenia  obiektow 
   private JCheckBox[][] checkBoxy= new JCheckBox[3][3];
   private JButton bNowaGra = new JButton("Nowa Gra");
   private Gracz gracz = new Gracz();
   private TabelaWynikow tabelaW = new TabelaWynikow();
		 
//Tworzenie ramki gry
   public GraKolkoKrzyzyk()
     {
        setSize(400,400);
        setTitle("Kolko i Krzyzyk");
	    setLayout(null);
			
	    bNowaGra.setBounds(150, 300, 100, 30);
	    bNowaGra.addActionListener(this);
	    add(bNowaGra);
//Wstawienie opisu pÃ³l planszy gry 
	    JLabel PolaPoziom = new JLabel("A        B        C");
	    PolaPoziom.setBounds(170, 100, 120, 30);
	    add(PolaPoziom);
		
	    JLabel PolaPion1 = new JLabel("1");
	    PolaPion1.setBounds(145, 130, 30, 30);
	    add(PolaPion1);
		
	    JLabel PolaPion2 = new JLabel("2");
	    PolaPion2.setBounds(145, 160, 30, 30);
	    add(PolaPion2);
		
	    JLabel PolaPion3 = new JLabel("3");
	    PolaPion3.setBounds(145, 190, 30, 30);
	    add(PolaPion3);
     }
//Metoda tworzaca tabele obiektÃ³w JCheckBox 3x3 , po kliknieciu w chceck box odpowiednia wartosc (gracz kolko =1 ; gracz krzyzyk = 0)wpisywana jest do tabeli wynikÃ³w
   private JCheckBox[][] stworzCheckBoxy()
      {
	     for(int i = 0; i < 3;i++)
		    {
		       for (int j = 0; j<3;j++)
			      {
				     checkBoxy[i][j] = new JCheckBox();
					 checkBoxy[i][j].addActionListener(this);
				  }					
			 }
		 return checkBoxy;
	  }
//Metoda przypisujaca pozycje JCheckBox w oknie gry oraz dodajaca ich wyswietlanie	
   private JCheckBox[][]wyswietlCheckBoxy()
	  {
	     int i=0;
		 int j=0;
		 int x=163;
		 int y=128;
		 for ( j = 0; j < 3;j++)
		    {
		       for ( i = 0; i<3;i++)
			      {
			         checkBoxy[i][j].setBounds(x, y, 30, 30);
			         add(checkBoxy[i][j]);
				     y=y+30;
				     if(y>188)
					    {
					       y=128;
					    }
			
			      }		
			   x=x+32;
			   if(x>227)
			      {
				     x=163;
			      }
		     }
		  return checkBoxy;
	 }


//Metoda sprawdzajaca wyniki w  tabeli jesli warunki zostana spelnione wyswietla komunikat o zwyciestwie gracza
	private void sprawdzanieZwyciezcy()
	   {	int i;	
	      int j;
		  int licznikKolko=0;
		  int licznikKrzyzyk=0;
		     for( i = 0; i < 3;i++)
			    {
				   licznikKolko=0;
				   licznikKrzyzyk=0;
				   
				   for( j =0 ;j < 3;j ++)
				      {
					     if(tabelaW.tablica[i][j]==1)
						    {
							   licznikKolko++;
							}
						 else if (tabelaW.tablica[i][j]==0)
						    {
							   licznikKrzyzyk++;
							}
						 if(licznikKolko==3)
							{
							   System.out.println("Wygral Gracz Kolko");
							}
						 else if(licznikKrzyzyk==3)
							{
							   System.out.println("Wygral Gracz krzyzyk");
							}
					  }
					
			    }
		     for( j = 0; j < 3;j++)
			    {
				   licznikKolko=0;
				   licznikKrzyzyk=0;
				   
				   for( i =0 ;i < 3;i ++)
				      {
					     if(tabelaW.tablica[i][j]==1)
						    {
							   licznikKolko++;
							}
						 else if (tabelaW.tablica[i][j]==0)
						    {
							   licznikKrzyzyk++;
							}
						 if(licznikKolko==3)
							{
							   System.out.println("Wygral Gracz Kolko");
							}
						 else if(licznikKrzyzyk==3)
							{
							   System.out.println("Wygral Gracz krzyzyk");
							}
					  }
					
			    }
	   		
//Wyjatki
	  if   ((tabelaW.tablica[0][0] == 1 && tabelaW.tablica[1][1] == 1 && tabelaW.tablica[2][2] == 1) ||
		   (tabelaW.tablica[2][0] == 1 && tabelaW.tablica[1][1] == 1 && tabelaW.tablica[0][2] == 1))	
		      {
			     System.out.println("Wygral Gracz Kolko");
			  }
	  else if	((tabelaW.tablica[2][0] == 0 && tabelaW.tablica[1][1] == 0 && tabelaW.tablica[0][2] == 0) ||
				(tabelaW.tablica[0][0] == 0 && tabelaW.tablica[1][1] == 0 && tabelaW.tablica[2][2] == 0))	
			  {
			     System.out.println("Wygral Gracz krzyzyk");
			  }
	
		
	   }    


//Metoda zawierajaca w sobie wszystkie kluczowe metody dla programu, bedzie wywolywana po rozpoczeciu programu.
	public void rozpocznijGre()
	   {
		  tabelaW.tworzenieTabeliWynikow();
		  stworzCheckBoxy();
		  wyswietlCheckBoxy();
		  wyswietl();
	   }
//Metoda wyswietlajaca okno gry
	private void wyswietl()
	   {
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setVisible(true);		
	   }
	public static void main(String[] args) 
	   {
          GraKolkoKrzyzyk oknoGry = new GraKolkoKrzyzyk();
		  oknoGry.rozpocznijGre();
	   }
	public void actionPerformed(ActionEvent e) 
	   {
	      Object zrodlo = e.getSource();
//Akcje wykonywane po kliknieciu w przycisk â€žNowa Graâ€�	
		  if(zrodlo == bNowaGra)
		     {	
		        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        dispose();
		        GraKolkoKrzyzyk oknoGry = new GraKolkoKrzyzyk();
		        oknoGry.rozpocznijGre();
		     }
		
		  else
//Wpisywanie wartosci w tabele wynikÃ³w zaleznie od warunkÃ³w
		  for(int i = 0; i < 3;i++)
		     {
			    for (int j = 0; j<3;j++)
			       {
				      if(zrodlo == checkBoxy[i][j])
					     {
						    if((checkBoxy[i][j].isSelected()==true)&&(gracz.graczAktualny == gracz.graczKolko))
							   {
								  tabelaW.tablica[i][j]=1;
								  System.out.println("tabelaW.tablica["+i+"]["+j+"] " + tabelaW.tablica[i][j]);
								  gracz.przydzielGracza();
							   }
					        else if((checkBoxy[i][j].isSelected()==true)&&(gracz.graczAktualny == gracz.graczKrzyzyk))
					           {
								  tabelaW.tablica[i][j]=0;
								  System.out.println("tabelaW.tablica["+i+"]["+j+"] " + tabelaW.tablica[i][j]);
								  gracz.przydzielGracza();	
							   }
						    sprawdzanieZwyciezcy();
					     }		
				      
			      }
		   }
	 }
}