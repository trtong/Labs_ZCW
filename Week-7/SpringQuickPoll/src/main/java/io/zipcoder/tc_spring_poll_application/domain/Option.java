package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Option {

    private @Id @GeneratedValue @Column(name = "OPTION_ID") Long id;

    private @Column(name = "OPTION_VALUE") String value;

    public Long getId() {
        System.out.println("Returning option ID: " + id.toString());
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        // "id":1,"value":"Yes"}
        return "{\"id\":" + id
                + ",\"value\":\"" + value + "\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Option)) return false;
        Option option = (Option) o;
        return Objects.equals(getId(), option.getId()) &&
                Objects.equals(getValue(), option.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue());
    }
}
