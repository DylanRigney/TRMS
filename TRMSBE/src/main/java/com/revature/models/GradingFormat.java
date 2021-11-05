package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grading_formats")
public class GradingFormat {

    @Id
    @Column(name = "grading_format_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gradingFormatId;


    @Column(name = "grading_format")
    private String gradingFormat;

    public GradingFormat() {
    }

    public GradingFormat(String gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public GradingFormat(int gradingFormatId, String gradingFormat) {
        this.gradingFormatId = gradingFormatId;
        this.gradingFormat = gradingFormat;
    }

    public int getGradingFormatId() {
        return gradingFormatId;
    }

    public void setGradingFormatId(int gradingFormatId) {
        this.gradingFormatId = gradingFormatId;
    }

    public String getGradingFormat() {
        return gradingFormat;
    }

    public void setGradingFormat(String gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradingFormat that = (GradingFormat) o;
        return gradingFormatId == that.gradingFormatId && Objects.equals(gradingFormat, that.gradingFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradingFormatId, gradingFormat);
    }


    @Override
    public String toString() {
        return "GradingFormat{" +
                "gradingFormatId=" + gradingFormatId +
                ", gradingFormat='" + gradingFormat + '\'' +
                '}';
    }
}
