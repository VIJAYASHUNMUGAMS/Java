package com.pkg.view;

class OuterClass {
	class InnerClass extends InnerClassTwo{
		
		int innerClassParam = 3;
		public void InnerMethod() {
			System.out.println("** Message from Inner Method**");
		}
		
		public void InnerMethodTwo() {
			System.out.println("** Message from Inner Method Two Implementation**" + innerClassParam);
		}
	}

	abstract class InnerClassTwo {
		abstract void InnerMethodTwo();
	}

	public static void main(String[] args) {
		OuterClass objOC = new OuterClass();
		objOC.OuterMethod();

		OuterClass.InnerClass objIC = objOC.new InnerClass();
		objIC.InnerMethod();
		objIC.innerClassParam = 4;
		objIC.InnerMethodTwo();
	}

	public void OuterMethod() {
		System.out.println("** Message from Outer Method**");
	}
}

//Check whether the inner class can be abstract - Yes
//Can it be inherited?
//Scope of instance variable within the inner class 
//Scope of local variable within the inner class