package sutdio.aroundhub.one_to_one.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locker")
public class LockerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne // member 필드가 MemberEntity 와 1:1 연관관계를 가지는 것으로 설정
    @JoinColumn(name = "member_email") // MemberEntity의 식별자인 email을 참조키로 지정
    private MemberEntity member;

    @Column(name = "expire_time")
    private LocalDateTime expireTime;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public LockerEntity(MemberEntity member, LocalDateTime expireTime,
                        LocalDateTime createdAt) {
        this.member = member;
        this.expireTime = expireTime;
        this.createdAt = createdAt;
    }

    public LockerEntity(){

    }

    public Long getId() {
        return id;
    }

    public MemberEntity getMember() {
        return member;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }



}
