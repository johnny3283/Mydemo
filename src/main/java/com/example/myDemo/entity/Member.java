package com.example.myDemo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private int memberNo;

    @Column(name = "member_account")
    private String memberAccount;

    @Column(name = "member_password")
    private String memberPassword;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_phone")
    private String memberPhone;

    @Column(name = "member_nickname")
    private String memberNickname;

    @Column(name = "member_address")
    private String memberAddress;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_state")
    private int memberState;

    public Member() {
    }

    public Member(String memberAccount, String memberPassword, String memberName,
                  String memberPhone, String memberNickname, String memberAddress,
                  String memberEmail, int memberState) {
        this.memberAccount = memberAccount;
        this.memberPassword = memberPassword;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.memberNickname = memberNickname;
        this.memberAddress = memberAddress;
        this.memberEmail = memberEmail;
        this.memberState = memberState;
    }


    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberName=" + memberName +
                ", memberAccount=" + memberAccount +
                ", memberPassword=" + memberPassword +
                ", memberNickname=" + memberNickname +
                ", memberAddress=" + memberAddress +
                ", memberPhone=" + memberPhone +
                ", memberEmail=" + memberEmail +
                ", memberState=" + memberState +
                '}';
    }
}


