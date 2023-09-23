import java.io.IOException;

public class MainMiniMarketProduct {

	public static void main(String[] args) {
	Minimarket mini = new Minimarket("Avoska", "Balfur, 92, Bat-yam");
//    Product p1 = new Product("Apple", "Kilogram", 101, 1.99);
//    Product p2 = new Product("Banana", "Kilogram", 102, 0.99);
//    Product p3 = new Product("Bread", "Loaf", 103, 2.49);
//    Product p4 = new Product("Cheese", "Kilogram", 104, 4.99);
//    Product p5 = new Product("Chicken", "Kilogram", 105, 7.99);
//    Product p6 = new Product("Milk", "Bottle", 106, 1.79);
//    Product p7 = new Product("Rice", "Kilogram", 107, 3.29);	
//    mini.addProduct(p1, 20);
//    mini.addProduct(p2, 10);
//    mini.addProduct(p3, 15);
//    mini.addProduct(p4, 23);
//    mini.addProduct(p5, 25);
//    mini.addProduct(p6, 30);
//    mini.addProduct(p7, 12);
    String folder = "c:\\_qa41\\minimarket\\products";
    String file = "products.txt";
    String filePath = folder + "//" + file;
    try {
		mini.readProducts(filePath);
	} catch (IOException e1) {
		System.out.println(e1.getMessage());
	}
    mini.displayProducts();
    
    try {
		mini.saveProducts(folder, file);
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}	
    
    }

}
