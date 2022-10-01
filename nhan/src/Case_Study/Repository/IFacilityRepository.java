package Case_Study.Repository;

import Case_Study.Service.impl.FacilityService;
import Case_Study.models.Facility;

import java.util.Map;

public interface IFacilityRepository extends IRepository<Facility>{
    String FILE_NAME="src/Case_Study/Data/facility.dat";
    @Override
    void add(Facility facility);

    @Override
    void display();
    void displayMaintenance();
    Map<Facility, Integer> findAll();
}
