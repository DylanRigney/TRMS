package com.revature.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity()
@Table(name = "event_types")
public class EventTypes {

    @Id
    @Column(name = "type_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "reimbursement_pct")
    private BigDecimal reimbursementPct;

    public EventTypes() {
    }

    public EventTypes(String typeName, BigDecimal reimbursementPct) {
        this.typeName = typeName;
        this.reimbursementPct = reimbursementPct;
    }

    public EventTypes(int typeId, String typeName, BigDecimal reimbursementPct) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.reimbursementPct = reimbursementPct;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigDecimal getReimbursementPct() {
        return reimbursementPct;
    }

    public void setReimbursementPct(BigDecimal reimbursementPct) {
        this.reimbursementPct = reimbursementPct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTypes that = (EventTypes) o;
        return typeId == that.typeId && Objects.equals(typeName, that.typeName) && Objects.equals(reimbursementPct, that.reimbursementPct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeId, typeName, reimbursementPct);
    }

    @Override
    public String toString() {
        return "EventTypes{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", reimbursementPct=" + reimbursementPct +
                '}';
    }
}
