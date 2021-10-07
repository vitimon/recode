import java.util.Scanner;
import java.util.Vector;


public class Main {
	public static void main(String[] args){
		int numFilter;
		numFilter = filter();
		Vector<Integer> divisors = new Vector<>();
		if (numFilter%2 == 0){ divisors.add(2);}
		if (numFilter%5 == 0){ divisors.add(5);}
		if (numFilter%10 == 0){ divisors.add(10);}
		if (divisors.size() > 0){
			System.out.println("os divisores são:" + divisors);
		}else {
			System.out.println("NÚMERO NÃO DIVISÍVEL POR 2, 5 OU 10");	
		}	
			
	
	}
	 public static int filter() {
        System.out.println("DIGITE UM NÚMERO: ");	
		Scanner entrada = new Scanner(System.in);
		int num;
		num = entrada.nextInt();
		if (num <101 && num > 0){
			entrada.close();
			return num;			
		} else {
			System.out.println("NÚMERO INVALIDO, MAX 100 MIN 1") ;
			int numberTry;
			numberTry = filter();
			return numberTry;
		}
    }
}																																																																																																																										
