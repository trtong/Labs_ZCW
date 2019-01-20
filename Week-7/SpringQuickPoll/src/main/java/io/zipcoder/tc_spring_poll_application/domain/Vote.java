package io.zipcoder.tc_spring_poll_application.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Vote {
    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    Long id;

    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    Option option;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "{\"id\":" + id
                + ",\"option\":" + option + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vote)) return false;
        Vote vote = (Vote) o;
        return Objects.equals(getId(), vote.getId()) &&
                Objects.equals(getOption(), vote.getOption());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOption());
    }
}
