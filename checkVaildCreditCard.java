package lab8_2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import lab8_2.creditCardBUMMMMMM.AL;

public class zz {
	public static Boolean isValidLength(String number) {
		int length = number.length();
		if (length >= 13 && length <= 16) {

			return true;
		} else {

			return false;
		}
	}

	public static Boolean isValidIssuer(String number) {

		for (int i = 0; i < number.length(); i++) {
			char firstNumber = number.charAt(0);

			String secondNumber = number.substring(0, 2);

			if (firstNumber == '4') {
				System.out.println("Visa card");
				return true;
			}
			if (firstNumber == '5') {
				System.out.println("Master card");
				return true;
			}
			if (firstNumber == '6') {
				System.out.println("Discover cards");
				return true;
			}

			if (secondNumber.equals("37")) {
				System.out.println("American Express cards");
				return true;
			}
		}
		return false;

	}

	public static int getDigit(Long number) {
		
		String strNum = Long.toString(number);

		int n = 0;
		int multiply = 0;
		int count = 0;
		int odd = 0;
		String str = null;
		char c;
try {
		for (int i = 0; i < strNum.length(); i = i + 2) {
			c = strNum.charAt(i);
			str = "" + c;
			n = Integer.parseInt(str);
			multiply = n * 2;
			if (multiply < 10) {
				odd = odd + multiply;

			}

			if (multiply >= 10) {

				String tooBig = Integer.toString(multiply);
				char[] plstooBig = tooBig.toCharArray();
				for (char zz : plstooBig) {
					String zzz = "" + zz;
					n = Integer.parseInt(zzz);

					count = count + n;

				}
			}

		}
}catch(InputMismatchException ex) {
	
}
		int bye = count + odd + sumOfOddPlace(strNum);

		return bye;

	}

	public static int sumOfEvenPlace(String number) {

		Long num = Long.parseLong(number);

		int z = getDigit(num);

		return z;

	}

	public static int sumOfOddPlace(String number) {

		int n = 0;
		int count = 0;
		for (int i = number.length() - 1; i >= 0; i = i - 2) {
			char odd = number.charAt(i);

			String str = "" + odd;
			n = Integer.parseInt(str);

			count = count + n;

		}

		return count;

	}

	public static void scanner() {
		System.out.println("please enter your card number");


		JFrame frame =  new JFrame("ATM");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,100);
		
		JLabel label  = new JLabel("Enter your credit card number\n");
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JPasswordField j = new JPasswordField(10);
		
	    j.setEchoChar('*');
	    j.addActionListener(new AL());
	    panel.add(label,BorderLayout.WEST);
	    panel.add(j,BorderLayout.EAST);
	    
	}
		static class AL implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				JPasswordField input = (JPasswordField) e.getSource();
				char[] pass =input.getPassword();
				String p =new String(pass); 
				
				
				if (isValid(p) == true && isValidLength(p) == true) {
					System.out.println("Vaild\n");
					
					isValidIssuer(p);
					
					} else if (isValidLength(p) == false) {
					System.out.println(" not valid, card number must be between 13 and 16 ");
				} else if (isValid(p) == false) {
					System.out.println("not vaild,your card number does not exist");
				}
			
			}
		}
		
	
	public static boolean isValid(String number) {

		int checkValid = sumOfEvenPlace(number);

		if (checkValid % 10 == 0) {

			return true;
		} else {

			return false;
		}
	}

	public static void main(String[] args) {
		scanner();
		
		
}
}
