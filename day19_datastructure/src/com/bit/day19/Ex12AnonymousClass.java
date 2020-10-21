package com.bit.day19;
class Lec05 {
	static Local local = new Local() {
		public void func34() {
			System.out.println("Inner Anonymous Class");
		}
	};
	
	void func01() {
		class Inner {
			void func02() {
				System.out.println("Local Class1");
			}
		}
		Inner inn = new Inner();
		inn.func02();
	}
	
	void func02() {
		class Inner {
			void func22() {
				System.out.println("Local Class2");
			}
		}
		new Inner().func22();
	}
	
	void func03() {
		// 익명 클래스 : 호출하고 즉시 종료되는 클래스이므로 이름을 부여하지 않음
		new Local() {
			public void func34() {
				System.out.println("Local Anonymous Class3");
			}
		}.func34();
	}
	
	Local func04() {
		class Inner implements Local {
			public void func34() {
				System.out.println("Local Class4");
			}
		};
		return new Inner();
	}
}

interface Local {
	void func34();
}

public class Ex12AnonymousClass {
	
	void func01() {
		System.out.println("Ex12");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Lec05 out = new Lec05();
//		out.func01();
//		out.func02();
//		out.func04();
//		
//		Local obj = out.func04();
//		obj.func34();
		
		new Ex12AnonymousClass() {
			public void func01() {
				System.out.println("Anonymous Class");
			}
		}.func01();
		
		Ex12AnonymousClass me = new Ex12AnonymousClass() {
			public void func01() {
				System.out.println("Anonymous Class");
			}
		};
		
		me.func01();
		
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Thread runs");
			}
		}).start();
		
		new Thread(() -> System.out.println("Thread runs")).start();
	}

}
