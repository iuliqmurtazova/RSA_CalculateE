package thread.calculation;

import java.math.BigDecimal;
import java.math.MathContext;

public class NeperNumberCalculator  {
	MathContext mc = new MathContext(1000);
	BigDecimal e = new BigDecimal("0",mc);

	public BigDecimal calculateNeperNumberAsynch(int members, int threadNumber) {
		Thread[] thread = new Thread[threadNumber];
		NumberRunnable[] runnables = new NumberRunnable[threadNumber];
		
		for (int t = 0; t < thread.length; t++) {
			runnables[t] = new NumberRunnable(t, members, threadNumber);
			thread[t] = new Thread(runnables[t]);
		}
		for (Thread thread2 : thread) {
			thread2.start();
		}
		
		for (int i=0; i<thread.length; i++) {
			try {
				thread[i].join();
				e = e.add(runnables[i].getE());
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		return e;
	} 
	
}
