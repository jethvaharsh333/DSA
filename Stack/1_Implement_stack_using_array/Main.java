public class Test{
	public static void main(String[] args){
		Stack obj = new Stack(5);

		obj.push(10);
		obj.push(20);
		obj.push(30);
		obj.push(40);
		obj.push(50);
		
		obj.pop();
		obj.pop();
		
		obj.display();
	}
}

class Stack{
	int top;
	int size;
	int value;
	int arr[];

	Stack(int size){
		this.size = size;
		this.top = -1;
		arr = new int[size];
	}

	void push(int value){
		if(top >= size-1){
			System.out.println("Stack full");
			return;
		}

		arr[++top] = value;
	}

	int pop(){
		if(top < 0){
			System.out.println("Stack empty");
			return -1;
		}

		int val = arr[top--];
		return val;
	}

	void display(){
		for(int i=top ; i>=0 ; i--){
			System.out.print(arr[i] + ", ");
		}
	}
}
