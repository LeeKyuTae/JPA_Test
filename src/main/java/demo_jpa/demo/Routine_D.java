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
public class Routine_D {

    @Id
    @GeneratedValue
    @Column(name = "r_details_id")
    private Long id;

    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="routined_exercise",
            joinColumns = @JoinColumn(name = "r_details_id"),
            inverseJoinColumns =@JoinColumn(name = "exercise_id" ))
    private List<Exercise> exerciseList = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "r_collection_id")
    Routine_C routine_c;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public void AddExerciseList(Exercise exercise){
        this.exerciseList.add(exercise);
    }
}
