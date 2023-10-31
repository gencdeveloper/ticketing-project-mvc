package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 *CommandLineRunner, Spring Boot'un sağladığı bir arabirimdir ve Spring uygulamalarını başlatırken veya uygulamanın hazır olduğu belirli bir aşamada kodu çalıştırmak için kullanılır.
 * Bu arabirim, uygulamanızın başlangıç aşamasında özel işlemler gerçekleştirmenize olanak tanır. Genellikle,
 * uygulamanızın başlangıcında bazı veritabanı kayıtlarını başlatmak, servisleri başlatmak veya başka başlangıç işlemlerini gerçekleştirmek için kullanılır.
 * CommandLineRunner arabirimi, yalnızca bir run metodu içerir. Bu metod, uygulama başlatıldığında çağrılır ve başlangıç işlemlerinizi içermelidir.
 * İşte CommandLineRunner'ı uygulama sınıfınızda kullanmanın temel bir örneği:
 * */
@Component // we need to bean
public class DataGenerator implements CommandLineRunner {



    RoleService roleService;
    UserService userService;

    //DataGenerator
    public DataGenerator(RoleService roleService, UserService userService) {//injection through to interface  and constructor
        this.roleService = roleService;
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");

        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@cydeo.com", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@cydeo.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cydeo.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@cydeo.com", "Abc3", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cydeo.com", "Abc4", true, "3256987412", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@cydeo.com", "Abc4", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cydeo.com", "Abc4", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cydeo.com", "Abc4", true, "8881239846", employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);

    }
}
