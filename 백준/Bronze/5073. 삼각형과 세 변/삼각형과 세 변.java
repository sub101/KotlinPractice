import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			int num3 = scan.nextInt();
			String result = "";
			if(num1 == 0 && num2 == 0 && num3 == 0)
				break;
			
			int [] arr = {num1,num2,num3};
			Arrays.sort(arr);

			if(arr[2]>= arr[0]+arr[1]) {
				result = "Invalid";
			}
			
			if(result == "" && arr[0]==arr[1] && arr[1] == arr[2] )
				result = "Equilateral";
			else if(result == "" && (arr[0] == arr[1] && arr[1] != arr[2]) || (arr[0] == arr[2] && arr[1] != arr[2]) || (arr[1] == arr[2] && arr[0] != arr[1]))
				result = "Isosceles";
			else if(result == "" && arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2])
				result = "Scalene";
			
			System.out.println(result);
				
			
		}
	}

}