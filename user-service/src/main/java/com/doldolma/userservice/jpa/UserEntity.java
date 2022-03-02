package com.doldolma.userservice.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "grews")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String nickname;

    @Column
    private String slogan;

    @Column(name="belongsTo")
    private String belongsTo;

    @Column
    private String image;

    @Column(name="createAt")
    private Date createdAt;

    @Column(name="updateAt")
    private Date updatedAt;

    @Column(name="nicknameEng")
    private String nicknameEng;

    @Column
    @ColumnDefault("0")
    private Integer lettersCount;

    @Transient
    private List<String> letters = new ArrayList<>();

}
