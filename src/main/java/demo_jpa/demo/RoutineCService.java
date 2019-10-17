package demo_jpa.demo;


import demo_jpa.demo.repository.RoutineCRepository;
import demo_jpa.demo.repository.RoutineDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoutineCService {
    @Autowired
    RoutineCRepository routineCRepository;
    @Autowired
    RoutineDRepository routineDRepository;

    public Routine_C updateDetails(Long id, Routine_D routine_d){
        Routine_C rc = routineCRepository.findById(id).get();
        rc.AddRoutineD(routine_d);
        Routine_D rd = routineDRepository.findById(routine_d.getId()).get();
        rd.setRoutine_c(rc);
        return rc;


    }
}
