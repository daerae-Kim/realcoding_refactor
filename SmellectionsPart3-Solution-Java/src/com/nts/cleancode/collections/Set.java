package com.nts.cleancode.collections;

public class Set extends AbstractCollection {
	public void add(Object element) {
		if (contains(element))
			return;

		super.add(element);
	}
}
