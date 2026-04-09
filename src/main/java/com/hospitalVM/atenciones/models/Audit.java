package com.hospitalVM.atenciones.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Audit {

    @Column(name="created_at")
    private LocalDate createAt;

    @Column(name="updated_at")
    private LocalDate updateAt;


    /**
     * Con este metodo genero automaticamente la fecha de creacion de algun elemento
     */
    @PrePersist
    public void  prePersist(){
        this.createAt = LocalDate.now();
    }

    /**
     * Con este metodo genero autmaticamente la fecha de la ultima modificacion
     */
    @PreUpdate
    public void preUpdate(){
        this.updateAt = LocalDate.now();
    }
}
