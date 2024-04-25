package com.santory5.service.impl;
import com.santory5.dao.nuevaColeccionDao;
import com.santory5.domain.nuevaColeccion;
import com.santory5.service.nuevaColeccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class nuevaColeccionServiceImpl implements nuevaColeccionService {
    
    @Autowired
    private nuevaColeccionDao nuevaColeccionDao;

    @Override
    @Transactional(readOnly=true)
    public List<nuevaColeccion> getnuevaColeccion(boolean activos) {
        var lista=nuevaColeccionDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public nuevaColeccion getnuevaColeccions(nuevaColeccion nuevacoleccion) {
        return nuevaColeccionDao.findById(nuevacoleccion.getIdNuevaColeccion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(nuevaColeccion nuevacoleccion) {
        nuevaColeccionDao.save(nuevacoleccion);
    }

    @Override
    @Transactional
    public void delete(nuevaColeccion nuevacoleccion) {
        nuevaColeccionDao.delete(nuevacoleccion);
    }
    
    
}