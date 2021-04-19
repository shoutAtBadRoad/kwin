import com.kwin.db.DbApplication;
import com.kwin.db.entity.Camera;
import com.kwin.db.service.Imp.CamServiceImpl;
import com.kwin.db.service.Imp.SectorServiceImpl;
import com.kwin.db.service.Imp.SensorServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author JYP
 * @date 2020/11/4
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DbApplication.class)
@TestPropertySource(locations = "classpath:application.yml")
@ActiveProfiles("test")
public class SectorTest {

    @Autowired
    SectorServiceImpl sectorServiceImpl;
    @Autowired
    CamServiceImpl camService;

    @Test
    public void Test1(){
        List<Camera> camera = camService.getAllCamBy2Id(1,1);
        System.out.println(camera);
    }

}
