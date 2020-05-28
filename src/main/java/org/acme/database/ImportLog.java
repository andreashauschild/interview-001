package org.acme.database;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "IMPORT_LOG")
public class ImportLog extends PanacheEntity {

    public LocalDateTime importTime;

    public String fileName;

}
