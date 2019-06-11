package com.stylefeng.guns;

import com.stylefeng.guns.rest.OrderApplication;
import com.stylefeng.guns.rest.order.util.Ftputil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class GunsRestApplicationTests {
	@Autowired
	private Ftputil ftputil;
	@Test
	public void contextLoads() {
		String fileStrByAddr = ftputil.getFileStrByAddr("seats/cgs.json");
		System.out.println(fileStrByAddr);
	}

}
