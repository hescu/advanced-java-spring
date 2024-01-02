package platform.codingnomads.co.springweb.resttemplate.GET.getForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import platform.codingnomads.co.springweb.resttemplate.GET.models.ActivityTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.ExcuseTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.QuoteTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class GetForObjectDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForObjectDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            QuoteTemplate[] randomQuote;
            randomQuote = restTemplate.getForObject("https://zenquotes.io/api/random/", QuoteTemplate[].class);
            System.out.println(Arrays.toString(randomQuote));

            // submit more requests here
            
//            CodingNomadsTasksApiResponse response =
//                    restTemplate.getForObject("http://demo.codingnomads.co:8080/tasks_api/users/5",
//                            CodingNomadsTasksApiResponse.class);
//
//            System.out.println(response.toString());

            ExcuseTemplate[] randomExcuse;
            randomExcuse = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/3", ExcuseTemplate[].class);
            System.out.println(Arrays.toString(randomExcuse));

            Map<String, Object> params = new HashMap<>();
            params.put("type", "social");

            ResponseEntity<ActivityTemplate[]> responseEntity =
                    restTemplate.getForEntity("https://www.boredapi.com/api/activity", ActivityTemplate[].class, params);
            if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
                ActivityTemplate[] activityTemplate = responseEntity.getBody();
                System.out.println(Arrays.toString(activityTemplate));
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

        };
    }
}
