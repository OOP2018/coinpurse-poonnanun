package coinpurse;

/**
 * Banknote represents note (money) with a fixed value, currency and serial number
 * @author Poonnanun Poonpathum
 */
public class BankNote extends Money{

	private long serialNumber;
	private static long nextSerialNumber = 1000000;
	
	public BankNote(double value, String currency){
		super(value, currency);
		this.serialNumber = nextSerialNumber;
		this.nextSerialNumber++;
	}
	
	public BankNote(double value, String currency, long nextSerialNumber){
		super(value, currency);
		this.serialNumber = nextSerialNumber;
		this.nextSerialNumber++;
	}

	/**
	 * get serial of banknotes
	 * @return serial
	 */
	public long getSerial(){
		return this.serialNumber;
	}
	
	/**
	 * Get format of note
	 * @return String for note
	 */
	@Override
	public String toString(){
		return this.getValue()+"-"+this.getCurrency()+" [note] "+this.getSerial();
	}

}
