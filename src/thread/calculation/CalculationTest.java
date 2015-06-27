package thread.calculation;

public class CalculationTest {

	public static void main(String[] args) {
		
		int members = 0;
		int threads = 0;
		
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-p")) {
				members = Integer.parseInt(args[i + 1]);
			}
			if (args[i].equals("-t")) {
				threads = Integer.parseInt(args[i + 1]);
			}
		}
		
		NeperNumberCalculator number = new NeperNumberCalculator();
		NumberWriter write = new NumberWriter();
    	
    	long time1 = System.currentTimeMillis();
    	String asynchronousResult = number.calculateNeperNumberAsynch(members, threads).toString();
    	long time1Res = (System.currentTimeMillis()-time1);
    	
    	System.out.println("With asynch calculation e = " + asynchronousResult + 
    					"\nTime for calculation with " + threads + " threads is " + time1Res + "ms");
    	
		write.writing("Asynchronous result: " + asynchronousResult);
	}

}
