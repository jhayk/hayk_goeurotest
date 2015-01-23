package com.goeuro.items;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hayk on 1/23/15.
 */
public class LocationInfoList extends ArrayList<LocationInfo> {

	public LocationInfoList(int initialCapacity) {
		super(initialCapacity);
	}

	public LocationInfoList() {
	}

	public LocationInfoList(Collection<? extends LocationInfo> c) {
		super(c);
	}
}
