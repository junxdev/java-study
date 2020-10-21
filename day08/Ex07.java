package com.bit.day08; 

class Bank {
	int money;

	public void add(int a) {
		money += a;
	}
	public void minus(int a) {
		money -= a;
	}
	public void print() {
		System.out.println("잔액 : " + money + "원");
	}
}	

class Ex07 { 
 
	public static void main(String[] args) { 
 
		Bank mybank = new Bank();
		mybank.money += 10000;
		mybank.add(10000);
		mybank.print();

		Bank yourbank = new Bank();
		yourbank.minus(5000);
		yourbank.money = 10000;
		yourbank.print();
		System.out.println(); 
 
	} // main end 
 
} // class end 
