package com.revature.models;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Entity()
@Table(name = "requests")
public class Request {

    @Id
    @Column(name = "request_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "request_datetime")
    private long requestDateTime;

    @Column(name = "work_related_justification")
    private String workRelatedJustification;

    @Column(name = "denial_reason")
    private String denialReason;

    @Column(name = "benco_award_reason")
    private String bencoAwardReason;

//    @Column(name = "projected_reimbursement", columnDefinition = "numeric(6,2)")
//    private BigDecimal projectedReimbursement;

    @Column(name = "approved_reimbursement", columnDefinition = "numeric(7,2)")
    private BigDecimal approvedReimbursement;

//    @Column(name = "has_prior_approval", columnDefinition = "boolean")
//    boolean hasPriorApproval;

    @Column(name = "final_grade")
    private String finalGrade;

    @Column(name = "event_location")
    private String eventLocation;

    @Column(name = "event_date")
    private String eventDate;

    @Column(name = "event_time")
    private String eventTime;

    @Column(name = "event_description")
    private String eventDescription;

    @Column(name = "event_cost", columnDefinition = "numeric(7,2)")
    private BigDecimal eventCost;

    @Column(name = "passing_grade")
    private String passingGrade;

    @Column(name = "emp_supervisor_id")
    private int empSupervisorId;

    @Column(name = "emp_dept_id")
    private int empDeptId;

    @Column(name = "event_type")
    private int eventType;

    @Column(name = "grading_format")
    private int gradingFormat;

    @Column(name = "status_id")
    private int statusId;

    @Column(name = "employee_id")
    private int employeeId;


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(long requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getWorkRelatedJustification() {
        return workRelatedJustification;
    }

    public void setWorkRelatedJustification(String workRelatedJustification) {
        this.workRelatedJustification = workRelatedJustification;
    }

    public String getDenialReason() {
        return denialReason;
    }

    public void setDenialReason(String denialReason) {
        this.denialReason = denialReason;
    }

    public String getBencoAwardReason() {
        return bencoAwardReason;
    }

    public void setBencoAwardReason(String bencoAwardReason) {
        this.bencoAwardReason = bencoAwardReason;
    }

//    public BigDecimal getProjectedReimbursement() {
//        return projectedReimbursement;
//    }

//    public void setProjectedReimbursement(BigDecimal projectedReimbursement) {
//        this.projectedReimbursement = projectedReimbursement;
//    }

    public BigDecimal getApprovedReimbursement() {
        return approvedReimbursement;
    }

    public void setApprovedReimbursement(BigDecimal approvedReimbursement) {
        this.approvedReimbursement = approvedReimbursement;
    }

//    public boolean isHasPriorApproval() {
//        return hasPriorApproval;
//    }

//    public void setHasPriorApproval(boolean hasPriorApproval) {
//        this.hasPriorApproval = hasPriorApproval;
//    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate() {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public BigDecimal getEventCost() {
        return eventCost;
    }

    public void setEventCost(BigDecimal eventCost) {
        this.eventCost = eventCost;
    }

    public String getPassingGrade() {
        return passingGrade;
    }

    public void setPassingGrade(String passingGrade) {
        this.passingGrade = passingGrade;
    }

    public int getEmpSupervisorId() {
        return empSupervisorId;
    }

    public void setEmpSupervisorId(int empSupervisorId) {
        this.empSupervisorId = empSupervisorId;
    }

    public int getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(int empDeptId) {
        this.empDeptId = empDeptId;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public int getGradingFormat() {
        return gradingFormat;
    }

    public void setGradingFormat(int gradingFormat) {
        this.gradingFormat = gradingFormat;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Request() {
    }

    public Request(String employeeName, long requestDateTime, String workRelatedJustification, String denialReason, String bencoAwardReason, BigDecimal approvedReimbursement, String finalGrade, String eventLocation, String eventDate , String eventTime, String eventDescription, BigDecimal eventCost, String passingGrade) {
        this.employeeName = employeeName;
        this.requestDateTime = requestDateTime;
        this.workRelatedJustification = workRelatedJustification;
        this.denialReason = denialReason;
        this.bencoAwardReason = bencoAwardReason;
        //this.projectedReimbursement = projectedReimbursement;
        this.approvedReimbursement = approvedReimbursement;
        //this.hasPriorApproval = hasPriorApproval;
        this.finalGrade = finalGrade;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventCost = eventCost;
        this.passingGrade = passingGrade;
    }

    public Request(String employeeName, long requestDateTime, String workRelatedJustification, String denialReason, String bencoAwardReason, BigDecimal approvedReimbursement, String finalGrade, String eventLocation, String eventDate , String eventTime, String eventDescription, BigDecimal eventCost, String passingGrade, int eventType, int gradingFormat, int statusId, int employeeId) {
        this.employeeName = employeeName;
        this.requestDateTime = requestDateTime;
        this.workRelatedJustification = workRelatedJustification;
        this.denialReason = denialReason;
        this.bencoAwardReason = bencoAwardReason;
        //this.projectedReimbursement = projectedReimbursement;
        this.approvedReimbursement = approvedReimbursement;
        //this.hasPriorApproval = hasPriorApproval;
        this.finalGrade = finalGrade;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventCost = eventCost;
        this.passingGrade = passingGrade;
        this.eventType = eventType;
        this.gradingFormat = gradingFormat;
        this.statusId = statusId;
        this.employeeId = employeeId;
    }

    public Request(int requestId, String employeeName, long requestDateTime, String workRelatedJustification, String denialReason, String bencoAwardReason, BigDecimal approvedReimbursement, String finalGrade, String eventLocation, String eventDate, String eventTime, String eventDescription, BigDecimal eventCost, String passingGrade, int eventType, int gradingFormat, int statusId, int employeeId) {
        this.requestId = requestId;
        this.employeeName = employeeName;
        this.requestDateTime = requestDateTime;
        this.workRelatedJustification = workRelatedJustification;
        this.denialReason = denialReason;
        this.bencoAwardReason = bencoAwardReason;
        //this.projectedReimbursement = projectedReimbursement;
        this.approvedReimbursement = approvedReimbursement;
        //this.hasPriorApproval = hasPriorApproval;
        this.finalGrade = finalGrade;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventDescription = eventDescription;
        this.eventCost = eventCost;
        this.passingGrade = passingGrade;
        this.eventType = eventType;
        this.gradingFormat = gradingFormat;
        this.statusId = statusId;
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return getRequestId() == request.getRequestId() && getRequestDateTime() == request.getRequestDateTime() && getEventType() == request.getEventType() && getGradingFormat() == request.getGradingFormat() && getStatusId() == request.getStatusId() && getEmployeeId() == request.getEmployeeId() && Objects.equals(getEmployeeName(), request.getEmployeeName()) && Objects.equals(getWorkRelatedJustification(), request.getWorkRelatedJustification()) && Objects.equals(getDenialReason(), request.getDenialReason()) && Objects.equals(getBencoAwardReason(), request.getBencoAwardReason()) && Objects.equals(getApprovedReimbursement(), request.getApprovedReimbursement()) && Objects.equals(getFinalGrade(), request.getFinalGrade()) && Objects.equals(getEventLocation(), request.getEventLocation()) && Objects.equals(getEventDate(), request.getEventDate()) && Objects.equals(getEventTime(), request.getEventTime()) && Objects.equals(getEventDescription(), request.getEventDescription()) && Objects.equals(getEventCost(), request.getEventCost()) && Objects.equals(getPassingGrade(), request.getPassingGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRequestId(), getEmployeeName(), getRequestDateTime(), getWorkRelatedJustification(), getDenialReason(), getBencoAwardReason(), getApprovedReimbursement(), getFinalGrade(), getEventLocation(), getEventDate(), getEventTime(), getEventDescription(), getEventCost(), getPassingGrade(), getEventType(), getGradingFormat(), getStatusId(), getEmployeeId());
    }

    @Override
    public String toString() {
        return "Request{" +
                "requestId=" + requestId +
                ", employeeName='" + employeeName + '\'' +
                ", requestDateTime=" + requestDateTime +
                ", workRelatedJustification='" + workRelatedJustification + '\'' +
                ", denialReason='" + denialReason + '\'' +
                ", bencoAwardReason='" + bencoAwardReason + '\'' +
                ", approvedReimbursement=" + approvedReimbursement +
                ", finalGrade='" + finalGrade + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventTime='" + eventTime + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventCost=" + eventCost +
                ", passingGrade='" + passingGrade + '\'' +
                ", eventType=" + eventType +
                ", gradingFormat=" + gradingFormat +
                ", statusId=" + statusId +
                ", employeeId=" + employeeId +
                '}';
    }
}
