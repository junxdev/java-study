package com.test1;
interface Tinterface {
	String name();
//	String process(String string);
	Object process(Object input);
}

class Waveform {
	 private static long counter;
	 private final long id = counter++;
	 public String toString() { 
		 return "Waveform " + id; 
		 }
}

class Filter {
	
	 public String name() {
		 return getClass().getSimpleName();
	 }
	 
	 public Waveform process(Waveform input) { 
		 return input; 
		}
}

public class Test implements Tinterface {
	
	Filter filter;
	
	public Test(Filter filter) {
		this.filter = filter;
	}
	
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return filter.name();
	}
	@Override
	public String process(Object input) {
		return "Override";
	}
//	public Integer process(Object input) {
//		// TODO Auto-generated method stub
//		return new Integer(5);
//	}

}
