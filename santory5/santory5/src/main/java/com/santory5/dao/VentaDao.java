/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.santory5.dao;

import com.santory5.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rsola
 */
public interface VentaDao extends JpaRepository<Venta, Long>{
    
}
