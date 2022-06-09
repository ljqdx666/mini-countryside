//package com.miniapp.countryside.entity;
//
//import lombok.Data;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.UpdateTimestamp;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.MappedSuperclass;
//import java.util.Date;
//
//@MappedSuperclass
//@Data
//public class BaseEntity {
//
//    @Id
//    @GeneratedValue(generator = "ksuid")
//    @GenericGenerator(name = "ksuid", strategy = "com.miniapp.countryside.utils.KsuidIdentifierGenerator")
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String id;
//
//    @CreationTimestamp
//    private Date createdTime;
//
//    @UpdateTimestamp
//    private Date updatedTime;
//}
