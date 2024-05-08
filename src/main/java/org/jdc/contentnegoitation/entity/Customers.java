package org.jdc.contentnegoitation.entity;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@Setter
@JacksonXmlRootElement(localName = "customers")
@NoArgsConstructor
public class Customers implements Serializable {
    @JacksonXmlProperty(localName = "customer")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Customer> customers=new ArrayList<>();


    public Customers(Iterable<Customer> iterable){
        customers = StreamSupport.stream(iterable.spliterator(),false)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + customers +
                '}';
    }
}
