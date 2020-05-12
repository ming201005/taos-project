package com.taosproject.taos;

import com.taosproject.taos.components.TaosUtil;
import com.taosproject.taos.entity.IotReceiptUploadData;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@SpringBootTest
class TaosApplicationTests {
    public static TaosUtil util = null;


    @Test
    void add() throws SQLException, ClassNotFoundException {
        this.connection();
        util.insert("v1_001", new IotReceiptUploadData(new Date(), null, "33.3", true, "12", "1234", 12, "22.3", "30", "14", new Date()));
    }

    @Test
    void list() throws IllegalAccessException, SQLException, InstantiationException,ClassNotFoundException {
        this.connection();
        List<IotReceiptUploadData> list = util.getList("select * from  v1_001",IotReceiptUploadData.class);
        System.out.println(list);
    }


    void  connection() throws SQLException, ClassNotFoundException {
        if (util == null) {
            String url = "jdbc:TAOS://39.100.213.73:6030/db";
            String username = "root";
            String password = "taosdata";
            util = new TaosUtil(url, username, password, true);
        }
    }

}
