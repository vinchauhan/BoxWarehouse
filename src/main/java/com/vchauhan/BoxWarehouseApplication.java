package com.vchauhan;

import com.vchauhan.domain.Box;
import com.vchauhan.domain.Role;
import com.vchauhan.domain.User;
import com.vchauhan.repository.BoxRepository;
import com.vchauhan.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class BoxWarehouseApplication {

	public static void main(String[] args) {

		SpringApplication.run(BoxWarehouseApplication.class, args);
	}

	@Bean
	public InitializingBean insertDefaultUsers(){
		return new InitializingBean() {
			@Autowired
			private UserRepository userRepository;

			@Autowired

			BoxRepository boxRepository;

			@Override
			public void afterPropertiesSet() throws Exception {
				//addInitialBox();
				addUser("admin","admin","admin@boxwarehouse.com","Vineet","Chauhan");
                addUser("user","user","user@boxwarehouse.com","Charlie","Delta");
                addUser("harry","harry","harry@boxwarehouse.com","Harry","Potter");
				//addInitialBox();
				//addInitialBox();

			}

			private void addUser(String username, String password, String email, String firstname, String lastname){

				User user = new User();
				user.setUsername(username);
				user.setPassword(new BCryptPasswordEncoder().encode(password));
				user.setEmail(email);
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setRole(username.equals("admin") ? Role.ROLE_ADMIN : Role.ROLE_USER);
				//user.setBoxes(boxList);
				userRepository.save(user);
				System.out.println("saved test user");

				//Create Boxes

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
				box.setUser(user);

				List<Box> boxList = new ArrayList<Box>();
				boxList.add(box);

				boxRepository.save(box);
			}
            private void addInitialBox() {
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

				boxRepository.save(box);
			}
		};
	}
}
