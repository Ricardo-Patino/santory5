package com.santory5.service.impl;
import com.santory5.dao.calzadoFemeninoDao;
import com.santory5.domain.calzadoFemenino;
import com.santory5.service.calzadoFemeninoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class calzadoFemeninoServiceImpl implements calzadoFemeninoService {
    
    @Autowired
    private calzadoFemeninoDao calzadoFemeninoDao;

    @Override
    @Transactional(readOnly=true)
    public List<calzadoFemenino> getcalzadoFemenino(boolean activos) {
        var lista=calzadoFemeninoDao.findAll();
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public calzadoFemenino getcalzadoFemeninos(calzadoFemenino calzadofemenino) {
        return calzadoFemeninoDao.findById(calzadofemenino.getId_calzadofemenino()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(calzadoFemenino calzadofemenino) {
        calzadoFemeninoDao.save(calzadofemenino);
    }
    
     @Override
    @Transactional
    public void delete(calzadoFemenino calzadofemenino) {
        calzadoFemeninoDao.delete(calzadofemenino);
    }
} 
  