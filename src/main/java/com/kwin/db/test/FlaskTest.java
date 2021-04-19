package com.kwin.db.test;

import com.kwin.db.entity.Image;
import com.kwin.db.mapper.ImageMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import java.util.Arrays;

/**
 * @author JYP
 * @date 2020/11/8
 **/

@Controller
public class FlaskTest {

    @Autowired
    ImageMapper imageMapper;

    @GetMapping("/putblob")
    @ResponseBody
    public String test1() {
        Integer scale = 1;
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("准备抓取画面....");
//        VideoCapture capture = new VideoCapture();
        Mat mat = new Mat();
        Mat mat1 = new Mat();
        MatOfInt compressParams = new MatOfInt(Imgcodecs.IMWRITE_JPEG_QUALITY, 99);
//        capture.open("E://py/client1/" + i + ".mp4");
        mat = Imgcodecs.imread("E:\\pytorch\\3.png");
        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_RGB2GRAY);
        Imgproc.resize(mat, mat1, new Size(28, 28));
//        HighGui.imshow("ces", mat1);
//        HighGui.waitKey(5);
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".png", mat1, matOfByte, compressParams);
        BASE64Encoder encoder = new BASE64Encoder();
        //返回Base64编码过的字节数组字符串
        String base = encoder.encode(matOfByte.toArray());
//        byte[] img = matOfByte.toArray();
        System.out.println(base);
//        List<Byte> img = matOfByte.toList();
//        System.out.println(img);
//        System.out.println(img.size());
        imageMapper.insertBlob(1, base.getBytes());

            HttpClient client = null;
            HttpResponse response = null;
            try {
//                String uri = "http://www.ytofreight.xyz:5000";
//                String img = getImageStr("E://hzy/src/main/res
//             ources/1.png");
                String uri = "http://localhost:5000/";
                HttpGet httpGet = new HttpGet(uri + "/process?key=" + java.net.URLEncoder.encode(base));
                client = new SSLClient();
                response = client.execute(httpGet);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                System.out.println(result);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "null";
    }

    @GetMapping("getblob")
    @ResponseBody
    public Image getBlob(@RequestParam("id")Integer id){
        Image image = imageMapper.getBlobById(id);
        System.out.println(Arrays.toString(image.getImg()));
        return image;
    }
}
