package io.github.julianjupiter.j2hrms.domain;

import javax.persistence.IdClass;
import java.io.Serializable;

@IdClass(UserId.class)
public class UserId implements Serializable {

	private static final long serialVersionUID = 6610095933683919477L;
	private int id;
	private int employeeId;
	private int roleId;

	public UserId() {
		
	}
	
	public UserId(int id, int employeeId, int roleId) {
		this.id = id;
		this.employeeId = employeeId;
		this.roleId = roleId;
	}

	public boolean equals(Object object) {
		if (object instanceof UserId) {
			UserId userId = (UserId) object;
			return this.id == userId.id && this.employeeId == userId.employeeId && this.roleId == userId.roleId;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return (this.id + this.employeeId + this.roleId);
	}

}
