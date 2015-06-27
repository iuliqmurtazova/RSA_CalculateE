package thread.calculation;

import java.math.BigDecimal;
import java.math.MathContext;

public class NumberRunnable implements Runnable {
	MathContext mc = new MathContext(1000);
	BigDecimal e = new BigDecimal("0",mc);
	final int t2;
	final int threadNumber;
	final int members;
	
	public BigDecimal getE() {
		return e;
	}

	public NumberRunnable(int t, int members, int threads) {
		t2=t;
		threadNumber=threads;
		this.members = members;
	}
	
	public BigDecimal factorial(int x){
		BigDecimal prod = new BigDecimal("1");
		for(int i = x; i > 1; i--)
			prod = prod.multiply(new BigDecimal(i));
		return prod;
	}
	
	public void run(){
		for(int i = t2; i < members; i+=threadNumber){
			synchronized (e){
			e = e.add(BigDecimal.valueOf(2*i+1).divide(factorial(2*i), mc));
			}
		}
	}

}
