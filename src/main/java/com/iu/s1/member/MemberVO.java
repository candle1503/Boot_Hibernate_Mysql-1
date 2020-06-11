package com.iu.s1.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@Table(name="member")
public class MemberVO {
	@Id //primary key
	private String id;
	
	@Column //일반 컬럼명
	private String pw;
	
	@Transient //테이블에서 제외
	private String pwCheck;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String phone;
	
	//mappedBy="Join하는 Entity에 선언된 자기 자신의 Entity 변수명"
	@OneToOne(mappedBy = "memberVO",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private MemberFileVO memberFileVO;

	
	

}
