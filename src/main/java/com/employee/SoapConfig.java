package com.employee;
import com.employee.endpoint.EmployeeEndpoint;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SoapConfig {
    
    @Autowired
    private EmployeeEndpoint employeeEndpoint;
    
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }
    
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), employeeEndpoint);
        endpoint.publish("/EmployeeService"); // Adjust the endpoint URL as needed
        return endpoint;
    }
}