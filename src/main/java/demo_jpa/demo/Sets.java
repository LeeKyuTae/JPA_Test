package demo_jpa.demo;


import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sets {

    @Id
    @GeneratedValue
    @Column(name = "r_sets_id")
    private Long id;


    private Float weight;

    private Integer lap;

    private Integer repeats;

    @ManyToOne
    @JoinColumn(name = "r_details_id")
    private Routine_D routine_details;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getLap() {
        return lap;
    }

    public void setLap(Integer lap) {
        this.lap = lap;
    }

    public Integer getRepeats() {
        return repeats;
    }

    public void setRepeats(Integer repeats) {
        this.repeats = repeats;
    }

    public Routine_D getRoutine_details() {
        return routine_details;
    }

    public void setRoutine_details(Routine_D routine_details) {
        this.routine_details = routine_details;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
