package service;

import entity.Classroom;
import repository.GetClassroomRepository;

import java.util.ArrayList;
import java.util.List;

public class ClassroomService {
    private final GetClassroomRepository getClassroomRepository;
    public ClassroomService(){
        getClassroomRepository = new GetClassroomRepository();
    }
    public List<Classroom> getListClassroom(){
        return getClassroomRepository.getListClass();
    }
}
