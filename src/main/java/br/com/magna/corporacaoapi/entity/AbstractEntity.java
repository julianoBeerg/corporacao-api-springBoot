package br.com.magna.corporacaoapi.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<T, ID> {

	@Column(name = "USER_DATABASE", nullable = false)
	private String userDatabase = "admin";

	@Column(name = "TIME_STAMP_FIRST_CREATED", nullable = false)
	private ZonedDateTime timeStampFirstCreated;

	@Column(name = "TIME_STAMP_LAST_UPDATE", nullable = false)
	private ZonedDateTime timeStampLastUpdate;

//	@Column(name = "TIME_STAMP_TIME_ZOME", nullable = false)
//	private ZoneId timeStampTimeZone;

	public String getUserDatabase() {
		return userDatabase;
	}

	public void setUserDatabase(String userDatabase) {
		this.userDatabase = userDatabase;
	}

	public ZonedDateTime getTimeStampFirstCreated() {
		return timeStampFirstCreated;
	}

	public void setTimeStampFirstCreated(ZonedDateTime timeStampFirstCreated) {
		this.timeStampFirstCreated = timeStampFirstCreated;
	}

	public ZonedDateTime getTimeStampLastUpdate() {
		return timeStampLastUpdate;
	}

	public void setTimeStampLastUpdate(ZonedDateTime timeStampLastUpdate) {
		this.timeStampLastUpdate = timeStampLastUpdate;
	}

//	public ZoneId getTimeStampTimeZone() {
//		return timeStampTimeZone;
//	}
//
//	public void setTimeStampTimeZone(ZoneId timeStampTimeZone) {
//		this.timeStampTimeZone = timeStampTimeZone;
//	}

	public abstract Long getId();

	public abstract Long setId(ID id);
}
