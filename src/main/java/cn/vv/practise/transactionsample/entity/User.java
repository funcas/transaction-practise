package cn.vv.practise.transactionsample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TODO
 *
 * @author funcas
 * @since 1.0
 */
@Entity
@Table(name = "tb_user")
public class User extends IdEntity {


    private String name;
    private Integer age;

    private Long accountId;
    private Integer sex;

    @Column(length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Column(length = 32)
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Column(columnDefinition = "tinyint(1)")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
