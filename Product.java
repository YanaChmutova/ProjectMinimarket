
public class Product implements Comparable<Product> {
private String name;
private String unit;
private int code;
private double price;

public Product (String name, String unit, int code, double price) {
	super();
	this.name = name;
	this.unit = unit;
	this.code = code;
	this.price = price;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getUnit() {
	return unit;
}

public void setUnit(String unit) {
	this.unit = unit;
}

public int getCode() {
	return code;
}

public void setCode(int code) {
	this.code = code;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

@Override
public String toString() {
	return "name=" + name + ", unit=" + unit + ", code=" + code + ", price=" + price;
}

@Override
public int compareTo(Product other) {
	int res = this.name.compareToIgnoreCase(other.name); //sortiruyet producty po imeni
	if(res==0) res=Integer.compare(this.code, other.code);// esly odinakovie imena, to smotrit po kodu
	return res;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	if (code != other.code)
		return false;
	return true;
}

}
