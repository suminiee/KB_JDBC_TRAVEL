package org.soo.dataimport;

import org.soo.dao.TravelDao;
import org.soo.dao.TravelDaoImpl;
import org.soo.database.JDBCUtil;
import org.soo.domain.TravelImageVO;

import java.io.File;

public class ImportImageData {
    public static void main(String[] args) {
        TravelDao dao = new TravelDaoImpl();

        File dir = new File("/Users/soo/Documents/dev/05_MySQL/travelapp/travel-image");
        File[] files = dir.listFiles();

        for (File file : files) {
            String filename = file.getName();
            long travelNo = Long.parseLong(filename.split("-")[0]); // 관광지 no 파일이름에서 잘라오기

            TravelImageVO image = TravelImageVO.builder()
                    .filename(filename)
                    .travelNo(travelNo)
                    .build();

            System.out.println(image);
            dao.insertImage(image);
        }
        JDBCUtil.close();

    }
}
