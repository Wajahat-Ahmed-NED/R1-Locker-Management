package LockerManagement;

public class Global {

	public static Integer customerId=0;
	public static Integer userId=0;
	public static String accountNum="";
	
	public Global() {
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * @param args
	 */
	public static  String removeSpecialCharacters(String s) {
		return s.replaceAll("[^a-zA-Z0-9]", "");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void accountNum(String string) {
		// TODO Auto-generated method stub
		accountNum=string;
		
	}

}
