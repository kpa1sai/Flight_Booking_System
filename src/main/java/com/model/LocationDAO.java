package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component

public interface LocationDAO {
		public void saveLocation(Location location);
		public boolean deleteLocation(Location location);
		public boolean updateLocation(Location location);
		public Location findLocation(int id);
		
}