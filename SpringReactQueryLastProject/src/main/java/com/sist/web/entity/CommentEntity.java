package com.sist.web.entity;

import java.util.Date;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
/*
 *  NO      NOT NULL NUMBER         
	CNO              NUMBER         
	TYPE             NUMBER         
	ID               VARCHAR2(20)   
	NAME    NOT NULL VARCHAR2(51)   
	MSG     NOT NULL VARCHAR2(4000) 
	REGDATE          DATE    
 */
@Entity
@Table(name="comment_1")
@Data
@DynamicUpdate
@DynamicInsert

public class CommentEntity {
   @Id
   private int no;
   @Column(updatable = false , insertable = true)
   private int cno; // contentid
   @Column(updatable = false , insertable = true)
   private String id;
   @Column(updatable = false , insertable = true)
   private String name;
   private String msg;
   @Column(updatable = false , insertable = true)
   private Date regdate;
}