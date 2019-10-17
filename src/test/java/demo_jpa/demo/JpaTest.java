package demo_jpa.demo;


import demo_jpa.demo.repository.*;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private  AccountRepository accountRepository;
    @Autowired
    private  ExerciseRepository exerciseRepository;
    @Autowired
    private  RoutineCRepository routineCRepository;
    @Autowired
    private  RoutineDRepository routineDRepository;
    @Autowired
    private  SetsRepository setsRepository;

    @Autowired
    private RoutineCService routineCService;

    @Test
    public void InputValue(){
        //Make Three User
        Account account1 = Account.builder().name("이규태").build();
        Account account2 = Account.builder().name("채명준").build();
        Account account3 = Account.builder().name("박준혁").build();

        //Save Account to DB
        accountRepository.save(account1);
        accountRepository.save(account2);
        accountRepository.save(account3);

        //Make Three Exercise
        Exercise exercise1 = Exercise.builder().name("벤치 프레스").build();
        Exercise exercise2 = Exercise.builder().name("데드 리프트").build();
        Exercise exercise3 = Exercise.builder().name("스쿼트").build();

        //Save Exercise to DB
        exerciseRepository.save(exercise1);
        exerciseRepository.save(exercise2);
        exerciseRepository.save(exercise3);

        //Make three Routine_D
        Routine_D rd1 = Routine_D.builder().name("루틴1").build();
  //      rd1.getExerciseList().add(exercise1);
        routineDRepository.save(rd1);

        Routine_D rd2 = Routine_D.builder().name("루틴2").build();
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(exercise1);
        exercises.add(exercise2);
        exercises.add(exercise3);
        rd2.setExerciseList(exercises);
        routineDRepository.save(rd2);

        Routine_D rd3 = Routine_D.builder().name("루틴3").build();
        List<Exercise> exercises3 = new ArrayList<>();
        exercises3.add(exercise3);
        rd3.setExerciseList(exercises3);
        routineDRepository.save(rd3);

     //  Routine_D rd4 = routineDRepository.findById(Long.valueOf(7)).get();
      // rd4.AddExerciseList(exercise1);
      // routineDRepository.save(rd4);

       //Make two Routine_C
        Routine_C rc1 = Routine_C.builder().name("등운동").build();
        ArrayList<Routine_D> rclist = new ArrayList<>();

   //     List<Routine_D> rdLists = routineDRepository.findAll();
    //    for(Routine_D d: rdLists){
     //       System.out.println(d.getName());
     //       rclist.add(d);
     //   }
        Routine_D rd5 = Routine_D.builder().name("루틴5").build();
        rd5.setExerciseList(exercises3);
       // rclist.add(rd5);

        routineCRepository.save(rc1);
        routineCService.updateDetails(Long.valueOf(10), rd3);
        //rclist.add(rd1);
        //rclist.add(rd2);

        //rd1.setRoutine_c(rc1);
        /*
        for(Routine_D d: rdLists){
            d.setRoutine_c(rc1);
        }

         */

        //routineDRepository.save(rd1);


       // Routine_C rc2 = Routine_C.builder().name("가슴운동").build();
       // routineCRepository.save(rc2);


    }
}
