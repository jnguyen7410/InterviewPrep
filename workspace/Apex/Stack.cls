public class Stack {
	//FILO
	List<SObject> stack;

	public Stack() {
		stack = new List<SObject>();
	}

	public Stack(List<SObject> list) {
		stack = list;
	}

	public SObject peek() {
		return stack.size() > 0 ? stack.get(0) : null;
	}

	public SObject pop() {
		return stack.size() > 0 ? stack.remove(0) : null;
	}

	public SObject push(SObject obj) {
		stack.add(obj, 0)
	}

	public Integer size() {
		return stack.size();
	}

	public boolean isEmpty() {
		return stack.size() == 0;
	}

}