package com.vchauhan.domain;

import com.vchauhan.repository.BoxRepository;
import com.vchauhan.service.BoxService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Vineet on 9/17/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoxTest {

    @MockBean
    private BoxService boxService;

    @Test
    public void insertBox() {
        final String boxCode = "BHE";
        final String boxSize = "12X12";
        final String boxDetails = "Amazon Box";
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date scannedOn = new Date();

        Box box = new Box();
        box.setBoxCode(boxCode);
        box.setBoxSize(boxSize);
        box.setBoxDetails(boxDetails);
        box.setScannedOn(scannedOn);

        boxService.save(box);

        Box newBox = boxService.findOne(box.getId());

        assertNotNull(newBox);
        assertEquals(boxCode, newBox.getBoxCode());
        assertEquals(boxDetails, newBox.getBoxDetails());


    }

}
