package jw.secondproject.shared.business.presence;

import java.time.LocalDateTime;

import jw.secondproject.shared.business.role.User;

public class PresenceTimestamp {

	private User owner;
	
	private LocalDateTime dateTime;
	
	public PresenceTimestamp(User owner, LocalDateTime dateTime) {
		this.owner = owner;
		this.dateTime = dateTime;
	}
		
}
