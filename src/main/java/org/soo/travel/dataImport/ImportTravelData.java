package org.soo.travel.dataImport;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.soo.travel.dao.TravelDao;
import org.soo.travel.dao.TravelDaoImpl;
import org.soo.database.JDBCUtil;
import org.soo.travel.domain.TravelVO;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ImportTravelData {
    public static void main(String[] args)throws CsvValidationException, IOException {
        TravelDao dao = new TravelDaoImpl();
        List<TravelVO> travels = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv"))
                .withType(TravelVO.class)
                .build()
                .parse();
        travels.forEach(travel -> {
            System.out.println(travel);
            dao.insert(travel);
        });
        JDBCUtil.close();
    }
}
