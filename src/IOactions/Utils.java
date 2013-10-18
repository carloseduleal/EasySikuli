package IOactions;

/**
 * @author cels
 *
 */
public class Utils {

	private static String calculateCheckerDigit(String num) {
		Integer firstDigit, secondDigit;
		int sum = 0, height = 10;
		for (int i = 0; i < num.length(); i++){
			sum += Integer.parseInt(num.substring(i, i + 1))* height--;
		}
		if (sum % 11 == 0 | sum % 11 == 1) {
			firstDigit = new Integer(0);
		}else {
			firstDigit = new Integer(11 - (sum % 11));
		}
		sum = 0;
		height = 11;
		for (int i = 0; i < num.length(); i++) {
			sum += Integer.parseInt(num.substring(i, i + 1)) * height--;
		}
		sum += firstDigit.intValue() * 2;
		if (sum % 11 == 0 | sum % 11 == 1) {
			secondDigit = new Integer(0);
		} else {
			secondDigit = new Integer(11 - (sum % 11));
		}
		return firstDigit.toString() + secondDigit.toString();
	}

	/**
	 * This method generate a valid CPF number;
	 * 
	 * @return CPF valid number;
	 */
	public static String generateCpf() {
		String initials = "";
		Integer number;
		for (int i = 0; i < 9; i++) {
			number = new Integer((int) (Math.random() * 10));
			initials += number.toString();
		}
		return initials + calculateCheckerDigit(initials);
	}

	/**
	 * This receive a CPF and verify is this CPF is valid.
	 * 
	 * @return 
	 */
	public static boolean validCpf(final String cpf) {
		if (cpf.length() != 11){
			return false;
		}
		String digitNumber = cpf.substring(0, 9);
		return calculateCheckerDigit(digitNumber).equals(cpf.substring(9, 11));
	}

}
