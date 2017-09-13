package jw.secondproject.shared.business.presence;

import java.time.LocalDateTime;

import jw.secondproject.shared.business.role.User;

public class CheckIn extends PresenceTimestamp {

	public CheckIn(User owner, LocalDateTime dateTime) {
		super(owner, dateTime);
		// TODO Auto-generated constructor stub
	}

}
