/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.santory5.service.impl;

import com.santory5.dao.PromocionesDao;
import com.santory5.domain.Promociones;
import com.santory5.service.PromocionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author USUARIO
 */
@Service
public class PromocionesServiceImpl implements PromocionesService {
    @Autowired
    private PromocionesDao PromocionesDao;

    @Override
    @Transactional(readOnly=true)
    public List<Promociones> getPromociones(boolean activos) {
        var lista=PromocionesDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Promociones getPromocioness(Promociones promociones) {
        return PromocionesDao.findById(promociones.getId_promociones()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Promociones promociones) {
        PromocionesDao.save(promociones);
    }
    
     @Override
    @Transactional
    public void delete(Promociones promociones) {
        PromocionesDao.delete(promociones);
    }
} 
