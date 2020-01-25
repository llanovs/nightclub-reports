package com.profdev.nightclubs.nightclubsreport.models;

import com.profdev.nightclubs.nightclubsreport.dao.Visitor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "visitors")
public class Visitors implements Visitor {

    @Id
    @Column(name = "visitorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private int visitorId;

    @Column(name = "visitorName")
    private String visitorName;

    public Visitors() {
    }

    public Visitors(String visitorName) {
        this.visitorName = visitorName;
    }

    @Override
    public String getVisitorName() {
        return this.visitorName;
    }

    @Override
    public int getVisitorId() {
        return this.visitorId;
    }

    @Override
    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Visitors visitor = (Visitors) obj;
        return this.getVisitorName().equals(visitor.getVisitorName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + (visitorName == null ? 0 : visitorName.hashCode());
    }

    @Override
    public String toString() {
        return "[" + "id = " + this.visitorId + ", visitorName = " + this.visitorName +"]";
    }
}
