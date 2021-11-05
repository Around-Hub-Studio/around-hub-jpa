package studio.aroundhub.id_generation.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "identity")
public class IdentityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getNumber() {
        return number;
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

    public IdentityEntity(){

    }

    public IdentityEntity(String name, LocalDateTime createdAt,
                          LocalDateTime updatedAt) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
