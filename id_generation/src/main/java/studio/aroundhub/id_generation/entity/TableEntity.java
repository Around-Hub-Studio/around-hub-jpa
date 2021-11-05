package studio.aroundhub.id_generation.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "table_gen")
public class TableEntity {

    /*
    TableGenerator Comments

    name : 테이블 생성기의 이름. @GeneratedValue의 generator 값으로 사용
    table : id를 생성할 때 사용할 테이블
    pkColumnName : id 생성용 테이블의 주요키 칼럼을 지정
    pkColumnValue : 테이블 생성기가 주요키 칼럼에 사용할 값을 지정. 각 TableGenerator 마다 다른 값을 사용.
    valueColumnName : 생성할 id를 갖는 칼럼을 지정
    initialValue : id 초기값을 지정. id 생성용 테이블에 해당 레코드가 없을 경우 이 속성의 값으로 생성
    allocationSize : id의 할당 크기를 지정.
     */
    /*
    TableGenerator는 아래와 같은 과정을 통해 id값을 생성함

    1. id_generator 테이블에 entity 칼럼 값이 table인 레코드를 구함
      - 레코드가 존재하지 않으면 initialValue인 0에 1을 더한 값을 id 값으로 사용하고 이 값을 id_generator 테이블에 삽입
      - 기존에 레코드가 존재할 경우에는 next_id 값을 가져와서 사용
    2. 다음 id 값(table, id + 1)을 id_generator 테이블에 반영
     */
    @Id
    @TableGenerator(name = "id_generator",
        table = "id_gen",
        pkColumnName = "entity",
        pkColumnValue = "table_gen",
        valueColumnName = "next_id",
        initialValue = 0,
        allocationSize = 1)
    @GeneratedValue(generator = "id_generator")
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

    public TableEntity() {

    }

    public TableEntity(String name, LocalDateTime createdAt,
                       LocalDateTime updatedAt) {
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
