package cn.vv.practise.transactionsample.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TODO
 *
 * @author funcas
 * @since 1.0
 */
@MappedSuperclass
public abstract class IdEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //主键Id
    protected Long id;

    /**
     * 获取主键ID
     *
     * @return String
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20, nullable = false,unique=true)
    public Long getId() {
        return this.id;
    }

    /**
     * 设置主键ID，
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
