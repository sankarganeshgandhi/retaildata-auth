package com.sgglabs.retail.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * CREATE TABLE AuthSession (
 *     Id BIGINT(10) NOT NULL AUTO_INCREMENT,
 *     UserId INT(10) NOT NULL,
 *     Username VARCHAR(30) NOT NULL,
 *     SessionId VARCHAR(250) NOT NULL,
 *     LoginTime DATE NOT NULL,
 *     LogoutTime DATE,
 *     StatusId INT(2) NOT NULL,
 *     CreatedDate DATE,
 *     ModifiedDate DATE,
 *     PRIMARY KEY (Id),
 *     FOREIGN KEY (StatusId) REFERENCES Status(Id)
 * );
 */
@Entity(name = "AuthSession")
@Table(name = "AuthSession")
public class AuthSession {
    private static final Logger LOG = LoggerFactory.getLogger(AuthSession.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UserId")
    private Integer userId;

    @Column(name = "Username")
    private String userName;

    @Column(name = "SessionId")
    private String sessionId;

    @Column(name = "LoginTime")
    private LocalDate loginTime;

    @Column(name = "LogoutTime")
    private LocalDate logoutTime;

    @Column(name = "StatusId")
    private Integer statusId;

    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @Column(name = "ModifiedDate")
    private LocalDate modifiedDate;

    public AuthSession() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public LocalDate getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDate loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDate getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDate logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthSession that = (AuthSession) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(loginTime, that.loginTime) &&
                Objects.equals(logoutTime, that.logoutTime) &&
                Objects.equals(statusId, that.statusId) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(modifiedDate, that.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, userName, sessionId, loginTime, logoutTime, statusId,
                createdDate, modifiedDate);
    }

    @Override
    public String toString() {
        return "AuthSession{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", statusId='" + statusId + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}