DROP TABLE AuthSession;
DROP TABLE Status;

CREATE TABLE Status(
    Id INT(2) NOT NULL AUTO_INCREMENT,
    Description VARCHAR(30) NOT NULL,
    CreatedDate DATE,
    ModifiedDate DATE,
    PRIMARY KEY (Id)
) ENGINE = INNODB;

INSERT INTO Status (Description, CreatedDate, ModifiedDate) VALUES ("Inactive", Now(), Now());
INSERT INTO Status (Description, CreatedDate, ModifiedDate) VALUES ("Active", Now(), Now());

CREATE TABLE AuthSession (
    Id BIGINT(10) NOT NULL AUTO_INCREMENT,
    UserId INT(10) NOT NULL,
    Username VARCHAR(30) NOT NULL,
    SessionId VARCHAR(250) NOT NULL,
    LoginTime DATE NOT NULL,
    LogoutTime DATE,
    StatusId INT(2) NOT NULL,
    CreatedDate DATE,
    ModifiedDate DATE,
    PRIMARY KEY (Id),
    FOREIGN KEY (StatusId) REFERENCES Status(Id)
) ENGINE = INNODB;