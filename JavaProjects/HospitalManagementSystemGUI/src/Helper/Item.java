package Helper;

public class Item {
	private int key;
	
	public Item(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	private String value;
	
	@Override
	public String toString() {
		return this.value;
	}
}
