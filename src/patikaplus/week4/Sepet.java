package patikaplus.week4;

public class Sepet <E extends Object> {
	private Object[] array;

	public Sepet() {
		array = new Object[0];
	}
	
	public Sepet(int length) {
		array = new Object[length];
	}

	public <E> void add(E element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] != null) continue;
			else {
				array[i] = element;
				return;
			}
		}
		array = patikaplus.util.Array.copyAndEnlarge(array, 1, true);
		array[array.length - 1] = element;
	}
	
	@SuppressWarnings("unchecked")
	public <E> E get(int index) {
		try {
			return (E) array[index];
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public void remove(int index) {
		array = patikaplus.util.Array.removeAndNarrow(array, index);
	}
	
	public void set(int index, E element) {
		array[index] = element;
	}
	
	public <E> int indexOf(E element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == (Object) element) return i;
		}
		return -1;
	}
	
	public <E> int lastIndexOf(E element) {
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == (Object) element) return i;
		}
		return -1;
	}
	
	public int size() {
		int sum = 0;
		for (Object o : array) {
			if (o ==null) continue;
			sum++;
		}
		return sum;
	}
	
	public int getCapacity() {
		return array.length;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	@SuppressWarnings("unchecked")
	public <E> boolean contains(E element) {
		for (Object o : array) {
			if (((E) o) == element) return true;
		}
		return false;
	}
	
	public void clear() {
		array = new Object[array.length];
	}
	
	/**
	 * 
	 * @param start inclusive
	 * @param end exclusive
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Sepet<E> subSepet(int start, int end) {
		@SuppressWarnings("unchecked")
		Sepet<E> subSepet = new Sepet<>(end - start);
		for (int i = start; i < end; i++) {
			subSepet.add(array[i]);
		}
		return subSepet;
	}
	
	@SuppressWarnings("unchecked")
	public <E> E[] toArray() {
		return (E[]) array;
	}
	
	@Override
	public String toString() {
		String elements = "";
		for (Object o : array) {
			elements += (o + " ");
		}
		return elements;
	}
}
