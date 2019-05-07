package io.pivotal.microservices.services.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author Fabian Traxler {@literal <ftraxler@student.tgm.ac.at>}
 * @version 05.03.19
 * @project zentralrechner
 */
public interface WindengineRepository extends MongoRepository<Windengine, String> {

    public List<Windengine> findWindengineByWindengineID(String windengineID);

    public List<Windengine> findWindengineByTimestampAfterAndWindspeedGreaterThanAndPowerLessThan(Date timestamp, double windspeed, double power);

    @Query("{ ?0 : ?1 }")
    public List<Windengine> findByAttributes(String windengineID, String parkrechnerID);


}
