package demo_jpa.demo;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Routine_C {
    @Id
    @GeneratedValue
    @Column(name = "r_collection_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "routine_c", cascade = CascadeType.ALL)
    private List<Routine_D> routineDetails = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Routine_D> getRoutineDetails() {
        return routineDetails;
    }

    public void setRoutineDetails(List<Routine_D> routineDetails) {
        this.routineDetails = routineDetails;
    }
    public void AddRoutineD(Routine_D routine_d){
        this.routineDetails.add(routine_d);
    }
}
