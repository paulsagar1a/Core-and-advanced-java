package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static class SortByRank implements Comparator<Country> {
		@Override
		public int compare(Country obj1, Country obj2) {
			if(obj1.rank > obj2.rank) return 1;
			if(obj1.rank < obj2.rank) return -1;
			return 0;
		}
	}
	
	public static class SortByName implements Comparator<Country> {
		@Override
		public int compare(Country obj1, Country obj2) {
			return obj1.name.compareTo(obj2.name);
		}
	}
	
	//Sorted in descending order
	public static class SortByHDI implements Comparator<Country> {
		@Override
		public int compare(Country obj1, Country obj2) {
			if(obj1.HDI > obj2.HDI) return -1;
			if(obj1.HDI < obj2.HDI) return 1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Country> list = new ArrayList<>();
		list.add(new Country(5, "United Kingdom", 0.922));
		list.add(new Country(4, "Germany", 0.936));
		list.add(new Country(3, "Japan", 0.909));
		list.add(new Country(2, "China", .0752));
		list.add(new Country(1, "United States", 0.924));
		
		//Sort by economic value (rank)
		Collections.sort(list, new SortByRank());
		System.out.println("Top 5 economy in 2018"
				+ " in ascending order:\n"+list);
		
		//Sort by name
		Collections.sort(list, new SortByName());
		System.out.println("Ascending order contry name:\n"+list);
		
		//Sort by HDI
		Collections.sort(list, new SortByHDI());
		System.out.println("Human development index(HDI) of "
				+ "countries in 2018 in descending order:\n"+list);
		
	}

}

class Country {
	protected int rank;
	protected String name;
	protected double HDI; //Human Development Index
	
	public Country(int rank, String name, double HDI) {
		this.rank = rank;
		this.name = name;
		this.HDI = HDI;
	}
	
	@Override
	public String toString() {
		return "\n"+this.rank+" "+this.name+" "+this.HDI;
	}
}