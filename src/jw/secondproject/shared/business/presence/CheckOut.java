package jw.secondproject.shared.business.presence;

import java.time.LocalDateTime;

import jw.secondproject.shared.business.role.User;

public class CheckOut extends PresenceTimestamp {

	public CheckOut(User owner, LocalDateTime dateTime) {
		super(owner, dateTime);
	}

}
