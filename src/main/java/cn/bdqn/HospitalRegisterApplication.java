package cn.bdqn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.bdqn.dao")
public class HospitalRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalRegisterApplication.class, args);
    }

}
