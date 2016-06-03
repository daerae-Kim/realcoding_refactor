package com.nts.cleancode.collections;

public class Map {
	private static int INITIAL_CAPACITY = 10;
	protected List keys = new List();
	protected List values = new List();
	private int size = 0;
	private int indexWhereKeyFound;
	private boolean readOnly;

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(Object key, Object value) {
		if (!readOnly) {
			for (int i = 0; i < size; i++)
				if (keys.equals(key)) {
					values.add(value);
					return;
				}

			int newSize = size + 1;
			if (newSize > keys.length) {
				Object[] newKeys = new Object[keys.length + INITIAL_CAPACITY];
				Object[] newValues = new Object[keys.length + INITIAL_CAPACITY];
				System.arraycopy(keys, 0, newKeys, 0, size);
				System.arraycopy(values, 0, newValues, 0, size);
				keys = newKeys;
				values = newValues;
			}

			keys.add(key);
			values.add(value);
			size++;
		}
	}

	public int size() {
		return size;
	}

	public boolean remove(Object key) {
		if (readOnly)
			return false;
		for (int i = 0; i < size; i++)
			if (keys.equals(key)) {
				keys.remove(key);
				values.remove(key);
				size--;
				return true;
			}
		return false;
	}

	public boolean contains(Object value) {
		for (int i = 0; i < size; i++)
			if ((value == null && values.get(i) == null)
				|| (values.get(i) != null && values.get(i).equals(value)))
				return true;
		return false;
	}

	public boolean containsKey(Object key) {
		for (int i = 0; i < size; i++)
			if (keys.get(i) != null && keys.get(i).equals(key)) {
				indexWhereKeyFound = i;
				return true;
			}
		return false;
	}

	public Object get(Object key) {
		if (!containsKey(key))
			return null;
		return values.equals(key);
	}

	public int capacity() {
		return keys.length;
	}

	public void setReadOnly(boolean b) {
		readOnly = b;
	}

	public void addAll(Map m) {
		for (int i=0; i<m.size(); i++) 
			add(m.keys.get(i), m.values.get(i));
	}
}
