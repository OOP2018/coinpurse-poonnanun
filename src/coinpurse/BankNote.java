package coinpurse;

public class BankNote implements Valuable{
	
	private double value;
	private String currency;
	private long serialNumber;
	private static long nextSerialNumber = 1000000;
	
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		this.nextSerialNumber++;
	}

	/**
	 * get value of note
	 * @return value of note
	 */
	public double getValue(){
		return this.value;
	}
	
	/**
	 * get currency of note
	 * @return currency of note
	 */
	public String getCurrency(){
		return this.currency;
	}

	public long getSerial(){
		return this.serialNumber;
	}
	/**
	 * check if equals or not
	 * @return true if equal
	 * @return false if not equal
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		return this.currency.equals(((BankNote) obj).currency) && this.value == ((BankNote) obj).value;
	}
	
	/**
	 * compare 2 notes
	 * @return 1 if note a > note b
	 * @return 0 if both equal
	 * @return -1 if note b > note a
	 */
	public int compareTo(Valuable note){
		if(this.value < note.getValue()){
			return -1;
		}
		else if(this.value == note.getValue()){
			return 0;
		}
		else{
			return 1;
		}
		
	}
	
	/**
	 * Get format of note
	 * @return String for note
	 */
	@Override
	public String toString(){
		return value+"-"+currency+" [note] "+serialNumber;
	}

}
