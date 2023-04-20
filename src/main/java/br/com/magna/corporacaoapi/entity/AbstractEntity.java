package br.com.magna.corporacaoapi.entity;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<T, ID> {

	@Column(name = "USER_ADMIN_CREATE")
	private String userDatabaseCreate;
	
	@Column(name = "USER_ADMIN_UPDATE")
	private String userDatabaseUpdate;

	@Column(name = "TIMESTAMP_FIRST_CREATED", nullable = false)
	private ZonedDateTime timestampFirstCreated;

	@Column(name = "TIMESTAMP_LAST_UPDATE", nullable = false)
	private ZonedDateTime timestampLastUpdate;

	@Column(name = "TIMESTAMP_TIME_ZOME")
	private ZoneId timestampTimeZone;

	public String getUserDatabaseCreate() {
		return userDatabaseCreate;
	}

	public void setUserDatabaseCreate(String userDatabase) {
		this.userDatabaseCreate = userDatabase;
	}

	public String getUserDatabaseUpdate() {
		return userDatabaseUpdate;
	}

	public void setUserDatabaseUpdate(String userDatabaseUpdate) {
		this.userDatabaseUpdate = userDatabaseUpdate;
	}

	public ZonedDateTime getTimestampFirstCreated() {
		return timestampFirstCreated;
	}

	public void setTimestampFirstCreated(ZonedDateTime timestampFirstCreated) {
		this.timestampFirstCreated = timestampFirstCreated;
	}

	public ZonedDateTime getTimestampLastUpdate() {
		return timestampLastUpdate;
	}

	public void setTimestampLastUpdate(ZonedDateTime timestampLastUpdate) {
		this.timestampLastUpdate = timestampLastUpdate;
	}

	public ZoneId getTimestampTimeZone() {
		return timestampTimeZone;
	}

	public void setTimestampTimeZone(ZoneId timestampTimeZone) {
		this.timestampTimeZone = timestampTimeZone;
	}

	public abstract Long getId();

	public abstract void setId(ID id);
}
