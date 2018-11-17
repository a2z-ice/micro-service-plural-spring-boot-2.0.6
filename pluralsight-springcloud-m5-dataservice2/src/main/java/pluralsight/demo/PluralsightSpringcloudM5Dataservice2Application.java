package pluralsight.demo;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import brave.Span;
import brave.Tracer;
import brave.Tracer.SpanInScope;

@SpringBootApplication
@RestController
public class PluralsightSpringcloudM5Dataservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightSpringcloudM5Dataservice2Application.class, args);
	}
	
	@Autowired
	Tracer tracer;
	
	
	
	
	@RequestMapping(value="/customer/{cid}/vehicledetails", method=RequestMethod.GET)
	public @ResponseBody String getCustomerVehicleDetails(@PathVariable Integer cid) throws InterruptedException{
		
		String result;
		Span s = tracer.nextSpan().name("lookupvehicle2");
		
		try (SpanInScope ws = tracer.withSpanInScope(s.start())){
			
			s.tag("customerid", cid.toString());
			
			Thread.sleep(500);
			
			Hashtable<Integer, String> vehicles = new Hashtable<Integer, String>();
			vehicles.put(100, "Lincoln Continental; Plate SNUG30");
			vehicles.put(101, "Chevrolet Camaro; Plate R7TYR43");
			vehicles.put(102, "Volkswagen Beetle; Plate 6CVI3E2");
			
			result = vehicles.get(cid);
			
		} finally {
			s.finish();
		}
		
		
		
		
		return result;
	}
}
