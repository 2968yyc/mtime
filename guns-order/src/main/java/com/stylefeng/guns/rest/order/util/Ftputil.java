package com.stylefeng.guns.rest.order.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Author: yyc
 * @Date: 2019/6/9 21:29
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties("ftp")
public class Ftputil {
    private String hostName = "192.168.5.71";
    private Integer port=2100;
    private String userName="ftp";
    private String password="ftp";

    private FTPClient ftpClient = null;
    public void init(){
        try {
            ftpClient = new FTPClient();
            ftpClient.setControlEncoding("utf-8");
            ftpClient.connect(hostName,port);
            ftpClient.login(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("ftp初始化失败", e);
        }

    }

    public String getFileStrByAddr(String fileAdddress){
        BufferedReader bfr = null;
        StringBuffer  stringBuffer = new StringBuffer();
        init();
        try{
            bfr = new BufferedReader(new InputStreamReader(ftpClient.retrieveFileStream(fileAdddress)));

            String readLine=null;
            while (true){
                readLine = bfr.readLine();
                if (readLine==null){
                    break;
                }
                stringBuffer.append(readLine);
            }

        }catch (Exception e){
            e.printStackTrace();
            log.error("获取文件信息失败",e);
        }finally {
            try {
                ftpClient.logout();
            } catch (IOException e) {
                log.error("登出失败",e);
                e.printStackTrace();
            }
            try {
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
                log.error("关流失败",e);
            }
        }
        return stringBuffer.toString();
    }
}
