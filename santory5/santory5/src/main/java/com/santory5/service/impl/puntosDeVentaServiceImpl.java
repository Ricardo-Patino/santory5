package com.santory5.service.impl;
import com.santory5.dao.puntosDeVentaDao;
import com.santory5.domain.puntosDeVenta;
import com.santory5.service.puntosDeVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class puntosDeVentaServiceImpl implements puntosDeVentaService {
    
    @Autowired
    private puntosDeVentaDao puntosDeVentaDao;

    @Override
    @Transactional(readOnly=true)
    public List<puntosDeVenta> getpuntosDeVenta(boolean activos) {
        var lista=puntosDeVentaDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public puntosDeVenta getpuntosDeVentass(puntosDeVenta puntosdeventa) {
        return puntosDeVentaDao.findById(puntosdeventa.getId_sucursal()).orElse(null);
    }

    @Override
    @Transactional
    public void save(puntosDeVenta puntosdeventa) {
        puntosDeVentaDao.save(puntosdeventa);
    }

    @Override
    @Transactional
    public void delete(puntosDeVenta puntosdeventa) {
        puntosDeVentaDao.delete(puntosdeventa);
    }
    
    
}
