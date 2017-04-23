package model;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {
	
	public void wyswietlMenu() {
		
		Sklep sklep = new Sklep ("www.sklep.com");
		Scanner skaner = new Scanner(System.in);
		
		System.out.println("1 - dodaj komputer");
		System.out.println("2 - usun produkt");
		System.out.println("3 - edytuj produkt");
		System.out.println("4 - wyswietl produkt");
		System.out.println("5 - dodaj szkolenie");
		System.out.println("6 - wyswietl szkolenie");
		System.out.println("7 - wyswietl rabaty");
		System.out.println("q- wyjscie");
		
		
		
		String wybor;
		
		do {
			System.out.println("Podaj wybor: ");
			wybor = skaner.nextLine();
		
		switch (wybor) {
		case "1": {
			System.out.println("Podaj cene: ");
			BigDecimal cena = skaner.nextBigDecimal();
			//15.6\n
			skaner.nextLine();
			System.out.println("Podaj nazwe: ");
			String nazwa = skaner.nextLine();
			System.out.println("Podaj cpu: ");
			String cpu = skaner.nextLine();
			System.out.println("Podaj ram: ");
			String ram = skaner.nextLine();
			
			
			Komputer komputer = new Komputer(cena, nazwa, cpu, ram);
			sklep.dodajProdukt(komputer);
		}			
			break;
		case "2": {
			if ( sklep.czyPusty()){
				System.out.println("Sklep pusty");
			}else{
				
			sklep.wyswietlListe();
			System.out.println("Podaj indeks do usuniecia: ");
			int index = skaner.nextInt();
			skaner.nextLine();
			
			if (sklep.sprawdzIndex(index)){
				sklep.usunProdukt(index);
				System.out.println("Podales niepoprany indeks");
			}
			
			sklep.usunProdukt(index);
			System.out.println("Komputer zostal usuniety ");
		}
		}
			break;
		case "3" : {
			sklep.wyswietlListe();
			System.out.println("Ktory element edytujemy: ");
			int index = skaner.nextInt();
			skaner.nextLine();
			
			Produkt produkt = sklep.znajdzProdukt(index);
			
			if ( produkt instanceof Komputer) {
				Komputer komputer = (Komputer)sklep.znajdzProdukt(index);
				
				System.out.println("Podaj nowa cene( aktualna: " + komputer.getCena() + "): ");
			BigDecimal cena = skaner.nextBigDecimal();
			skaner.nextLine();
			
			System.out.println("Podaj nowa nazwa( aktualna: " + komputer.getNazwa() + "): ");
			String nazwa = skaner.nextLine();
			
			
			System.out.println("Podaj nowa cpu( aktualna: " + komputer.getCpu() + "): ");
			String cpu = skaner.nextLine();
			
			System.out.println("Podaj nowa ram( aktualna: " + komputer.getRam() + "): ");
			String ram = skaner.nextLine();
			//	komputer.setCena(cena);
		//	komputer.setNazwa(nazwa);
		//	komputer.setCpu(cpu);
		//	komputer.setRam(ram);
			
			komputer.zaktualizuj(cena,nazwa,ram,cpu);
				
			}
			
			
			//order.markSuccess();
			//order.markFail();
			
			//sklep.zmodyfikujProdukt(index, komputer);
			
			
		}
			break;
		case "4" :
			sklep.wyswietlListe();
			
			break;
		case "5" : {
			System.out.println("Podaj cene: ");
			BigDecimal cena = skaner.nextBigDecimal();
			//15.6\n
			skaner.nextLine();
			System.out.println("Podaj nazwe: ");
			String nazwa = skaner.nextLine();
			System.out.println("Podaj technologia: ");
			String technologia = skaner.nextLine();
						
			
			Szkolenie szkolenie = new Szkolenie(cena, nazwa, technologia);
			sklep.dodajProdukt(szkolenie);
			
		}
			break ;	
			
		case "6" :	
			sklep.wyswietlRabaty();
			
			
			
			
			
			
			break ;
		case "q" :
			System.out.println("koniec programu");
			
			
			default: 
				// System.out.println("bledny wybor");
				break;
			}
			
		} while(!wybor.equalsIgnoreCase("q"));
		System.out.println(wybor);
		}
	}


