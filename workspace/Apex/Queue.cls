public class Queue {
	//FIFO
	List<SObject> queue;

	public Queue() {
		queue = new List<SObject>();
	}

	public Queue(List<SObject> list) {
		queue = list;
	}

	public SObject peek() {
		return queue.size() > 0 ? queue.get(0) : null;
	}

	public SObject pop() {
		return queue.size() > 0 ? queue.remove(0) : null;
	}

	public SObject push(SObject obj) {
		queue.add(obj);
	}

	public Integer size() {
		return queue.size();
	}

	public boolean isEmpty() {
		return queue.size() == 0;
	}

}