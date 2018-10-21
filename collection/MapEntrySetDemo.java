package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Here in this example we will sort all the laptop according to the
availability and also according to the prices*/
public class MapEntrySetDemo {

	public static class SortLaptop implements Comparator<Map.Entry<Laptop, String>> {
		@Override
		public int compare(Map.Entry<Laptop, String> o1, Map.Entry<Laptop, String> o2) {
			int result = o1.getValue().compareTo(o2.getValue());
			if(result == 0) {
				if(o1.getKey().price > o2.getKey().price) return 1;
				if(o1.getKey().price < o2.getKey().price) return -1;
				return 0;
			} else 
				return result;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Laptop, String> map = new HashMap<>();
		map.put(new Laptop("Dell", 16, 46000), "available");
		map.put(new Laptop("Mac", 8, 72000), "available");
		map.put(new Laptop("Vivo", 12, 38000), "not available");
		map.put(new Laptop("HP", 4, 25000), "not available");
		map.put(new Laptop("Lenevo", 8, 36000), "available");
		
		Set<Map.Entry<Laptop, String>> set = map.entrySet();
		//convert the set to list
		List<Map.Entry<Laptop, String>> list = new ArrayList<>(set);
		//sort the list
		Collections.sort(list, new SortLaptop());
		System.out.println(list);
		
		//Output -
		/*[
		Lenevo RAM= 8 price= 36000.0 
		=available, 
		Dell RAM= 16 price= 46000.0 
		=available, 
		Mac RAM= 8 price= 72000.0 
		=available, 
		HP RAM= 4 price= 25000.0 
		=not available, 
		Vivo RAM= 12 price= 38000.0 
		=not available]*/
	}

}

class Laptop {
	protected String name;
	protected int RAM;
	protected double price;
	
	public Laptop(String name, int RAM, double price) {
		this.name = name;
		this.RAM = RAM;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "\n"+this.name+" RAM= "+this.RAM+" price= "+this.price+" \n";
	}
}
