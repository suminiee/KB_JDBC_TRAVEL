package org.soo.dataimport;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.soo.dao.TravelDao;
import org.soo.dao.TravelDaoImpl;
import org.soo.database.JDBCUtil;
import org.soo.domain.TravelVO;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ImportTravelData {
    public static void main(String[] args) throws CsvValidationException, IOException {
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
