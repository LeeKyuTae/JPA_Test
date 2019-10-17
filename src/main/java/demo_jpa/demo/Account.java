package demo_jpa.demo;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder @Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Account {
    @Id @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    private Long kakaoId;

    private String name;

    @OneToMany
    @JoinColumn(name = "account_id")
    private List<Sets> setsList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name="account_routinec",
                joinColumns = @JoinColumn(name = "account_id"),
                inverseJoinColumns =@JoinColumn(name = "r_collection_id" ))
    private  List<Routine_C> routineCollection = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKakaoId() {
        return kakaoId;
    }

    public void setKakaoId(Long kakaoId) {
        this.kakaoId = kakaoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sets> getSetsList() {
        return setsList;
    }

    public void setSetsList(List<Sets> setsList) {
        this.setsList = setsList;
    }

    public List<Routine_C> getRoutineCollection() {
        return routineCollection;
    }

    public void setRoutineCollection(List<Routine_C> routineCollection) {
        this.routineCollection = routineCollection;
    }
}
