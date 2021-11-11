package sutdio.aroundhub.one_to_one.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    private String email;

    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public MemberEntity(String email, String name, LocalDateTime createdAt) {
        this.email = email;
        this.name = name;
        this.createdAt = createdAt;
    }

    public MemberEntity(){

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
