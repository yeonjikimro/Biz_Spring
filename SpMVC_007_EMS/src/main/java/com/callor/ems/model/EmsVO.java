package com.callor.ems.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmsVO {

	private long e_seq;
	private String e_from_email;
	private String e_to_email;
	
	private String e_from_name;
	private String e_to_name;
	
	private String e_subject;
	private String e_content;	
	private String e_send_date;
	private String e_send_time;
	
}
