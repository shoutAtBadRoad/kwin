import com.kwin.db.DbApplication;
import com.kwin.db.entity.SensorData;
import com.kwin.db.service.CurrentService;
import com.kwin.db.service.CurrentdtService;
import com.kwin.db.service.SectorService;
import com.kwin.db.service.HistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DbApplication.class)
@TestPropertySource(locations = "classpath:application.yml")
@ActiveProfiles("test")
public class ApplicationServiceTest {

    @Autowired
    private SectorService sectorService;
    @Autowired
    HistService histService;
    @Autowired
    CurrentdtService currentService;

    @Test
    public void testSearchAppList() throws ParseException {

//        List<Double> list = currentService.getCurrentdtList("1100201808081001");
//        System.out.println(list.toString());
//        List<Sector> list = sectorService.getAllSector();
//        sectorService.getSectorById(1);
//        sectorService.updateSectorById(new Sector(1,"邵海东",11,"位于建湖县，年产值xxx。。。。。。"));
//        sectorService.getSectorNum();

//        sectorService.insertHouse(
//                new House("邵鹏泽",2,1+sectorService.getHouseNumBySector(2),2,2,"主要作物：玉米"));
//        sectorService.getHouseNum();
//        sectorService.getAllHouse();
//        sectorService.getHouseNumBySector(1);
//        sectorService.getAllHouseBySector(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String begin = "2020-8-14 12:01:00";
        String end = "2020-8-16 12:01:00";
        List<SensorData> list = histService.getShowDataByTimeAndHouse(begin,end,"1-1");
        System.out.println(list.toString());
    }

    String uri = "http://127.0.0.1:5000/";

//    /**
//     * Get方法
//     */
//    @Test
//    public void test1() {
//        try {
//            CloseableHttpClient client = null;
//            CloseableHttpResponse response = null;
//            try {
//                HttpGet httpGet = new HttpGet(uri);
//
//                client = HttpClients.createDefault();
//                response = client.execute(httpGet);
//                HttpEntity entity = response.getEntity();
//                String result = EntityUtils.toString(entity);
//                System.out.println(result);
//            } finally {
//                if (response != null) {
//                    response.close();
//                }
//                if (client != null) {
//                    client.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}