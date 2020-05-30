package org.acme.database;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "REPORT_DATA")
public class ReportDataEntity extends PanacheEntity {
}
