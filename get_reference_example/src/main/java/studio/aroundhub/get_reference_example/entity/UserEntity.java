package studio.aroundhub.get_reference_example.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
    // Entity 에서는 final 키워드를 사용하면 안됨
    // 일부 기능에서 예외가 발생하여 정상적으로 동작하지 않을 수 있음
    @Id
    private String email;

    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UserEntity(String email, String name, LocalDateTime createdAt,
                      LocalDateTime updatedAt) {
        this.email = email;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // JPA 규약으로 기본 생성자를 제공해야 함
    public UserEntity(){

    }

    public void changeName(String newName){
        this.name = newName;
        updateDateTime();
    }

    private void updateDateTime(){
        this.updatedAt = LocalDateTime.now();
    }

}
