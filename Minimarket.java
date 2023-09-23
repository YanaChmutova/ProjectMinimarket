import java.io.*;
import java.util.*;

public class Minimarket {
	private String name;
	private String address;
	private TreeMap<Product, Integer> products = new TreeMap<>();
	
	public Minimarket(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void addProduct(Product p, int quantity) {
	boolean isExists = products.containsKey(p);
	if(isExists == false) {
		products.put(p, quantity);
	}
	else {
		int value = products.get(p);
		value +=quantity;
		products.replace(p, value);
	}
	}
	public void displayProducts () {
		System.out.println("MiniMarket: " + name);
		System.out.println("Address " + address);
		System.out.println("\tProducts: ");
		Set<Product> keys = products.keySet();
		for(Product p: keys) {
			System.out.println(p);
			System.out.println("quantity: " + products.get(p));
		}
		System.out.println("************************************");
	}
	public void saveProducts(String folderPath, String filename) throws IOException {
		File fld = new File(folderPath);
		if(fld.exists()==false) {
			fld.mkdirs();
		String filePath = folderPath + "\\" + filename;
		File fl = new File(filePath);
		if(fl.exists()==false) {
		fl.createNewFile();	
		}
		saveProductsToFile(fl);
		}
	}
	public void saveProductsToFile(File fl) throws IOException {
		FileWriter fr = new FileWriter(fl);
		BufferedWriter bw = new BufferedWriter(fr);
		Set<Product> keys = products.keySet();
		for(Product p: keys) {
			int quantity = products.get(p);
			String forFile = p.getName() + ";" + p.getUnit() + ";" + p.getCode() + ";" + p.getPrice() + ";" + quantity;
			bw.write(forFile);
			bw.newLine();
		}
		bw.close();
	}
	public void readProducts(String filePath) throws IOException {
		File fl = new File(filePath);
		if(fl.exists() == false) {
			System.out.println("Error: File is not exists");
			return;
		}
		FileReader fr = new FileReader(fl);
		BufferedReader br = new BufferedReader(fr);
		while(true) {
			String fromFile = br.readLine();
			if(fromFile==null) break;
			String[] ar = fromFile.split(";");
			String name = ar[0];
			String unit = ar[1];
			int code = Integer.parseInt(ar[2]);
			double price = Double.parseDouble(ar[3]);
			int quantity = Integer.parseInt(ar[4]);
			Product p = new Product(name, unit, code, price);
			products.put(p, quantity);
		}
		br.close();
	}
}