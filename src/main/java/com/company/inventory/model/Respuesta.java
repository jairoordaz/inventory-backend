package com.company.inventory.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Respuesta<T> {
	private String statuscode;
	private String statusmessage;
	private LocalDateTime timestamp;
	private Integer status;
	private T resultset;
	
	public Respuesta(String statuscode,String statusmessage,Integer status) {
		super();
		this.statuscode = statuscode;
		this.statusmessage = statusmessage;
		this.status = status;
	}
}
