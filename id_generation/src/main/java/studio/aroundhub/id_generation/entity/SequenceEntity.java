package studio.aroundhub.id_generation.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(
    name = "sequence_generator",
    sequenceName = "my_seq",
    allocationSize = 1)
@Table(name = "sequence")
public class SequenceEntity {

    /**
     * allocationSize 를 설정하지 않았을 경우 아래와 같은 방식으로 식별자를 생성
     * <p>
     * 1. 최초에 DB 시퀀스에서 값을 구함. 이 값을 식별자 구간의 시작 값으로 사용
     * 2. 한 번 더 DB 시퀀스에 값을 구함. 이를 식별자 구간의 끝 값으로 사용
     * 3. 구간의 시작 값부터 끝 값까지 순차적으로 엔티티의 식별 값으로 사용.
     *      이때 메모리에 순차적으로 증가한 값을 보관 --> 이 과정 때문에 allocationSize를 1로 설정하지 않았을 경우, 여러 JVM이 가동되는 가정하에 충돌이 발생하게됨
     * 4. 구간의 끝에 다다르면 DB 시퀀스에 값을 구함.
     *      시퀀스에서 구한 값을 다음 식별자 구간의 끝 값으로 사용한다. 구간 끝 값에서 (allocationSize -1)를 뺀 값을 식별자 구간의 시작 값으로 사용
     * 5. 과정 3과 4를 반복
     */
    /*
    name : 시퀀스 생성기의 이름을 지정. 이 이름은 @GeneratedValue 에서 사용됨
    sequenceName : 식별자(Id)를 생성할 때 사용할 Sequence 이름을 지정
    allocationSize : 시퀀스에서 읽어온 값을 기준으로 몇 개의 식별자를 생성할지 결정. 값은 1로 설정해야 함 (default : 50)
     */
    @Id
    @GeneratedValue(generator = "sequence_generator")
    private Long id;

    private String name;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
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

    public SequenceEntity(String name, LocalDateTime createdAt,
                          LocalDateTime updatedAt) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public SequenceEntity() {

    }
}
