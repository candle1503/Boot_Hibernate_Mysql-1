package com.iu.s1.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

//getter/setter
@Data
@Table(name="memberFile")
@Entity
@DynamicUpdate
public class MemberFileVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fileNum;
	@Column
	private String fileName;
	@Column
	private String oriName;
	
	@OneToOne
	@JoinColumn(name = "id")
	private MemberVO memberVO;

}
