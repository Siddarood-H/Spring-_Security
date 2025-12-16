package in.logg.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import in.logg.Repository.CustomerRepository;
import in.logg.entity.Customer;

@RestController
public class CustomerController{
@Autowired
private PasswordEncoder passwordEncoder;
@Autowired
private CustomerRepository customerRepo;
@Autowired
private AuthenticationManager authManager;



@PostMapping("/login")
public ResponseEntity<String>login(@RequestBody Customer customer)
{
	UsernamePasswordAuthenticationToken token =new UsernamePasswordAuthenticationToken(customer.getEmail(),customer.getPassword());
	try {
org.springframework.security.core.Authentication auth=authManager.authenticate(token);

if(auth.isAuthenticated())
{
	return new ResponseEntity("welcome Login Successful",HttpStatus.OK);
}
	}catch(Exception e) {
		e.printStackTrace();
	}

	return new ResponseEntity("Invalid Credentials",HttpStatus.BAD_REQUEST);
}


@PostMapping("/customer")
	public ResponseEntity<String> saveCutomer(@RequestBody Customer customer)
	{
		String passencode=passwordEncoder.encode(customer.getPassword());
		customer.setPassword(passencode);
	
		customerRepo.save(customer);
		return new ResponseEntity("customer Fegistered",HttpStatus.CREATED);
	}

}
