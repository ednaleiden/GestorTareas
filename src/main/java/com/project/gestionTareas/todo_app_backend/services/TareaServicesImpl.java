package com.project.gestionTareas.todo_app_backend.services;

import com.project.gestionTareas.todo_app_backend.entities.Tarea;
import com.project.gestionTareas.todo_app_backend.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServicesImpl implements  TareaService {

    //dependemos de una DAO

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> getAllTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Optional<Tarea> getTareaById(Long id) {
        return tareaRepository.findById(id);
    }

    @Override
    public Tarea createTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }
    @Override
    public  Tarea updateTarea(Long id, Tarea tarea){
        if (tareaRepository.existsById(id)){
        return tareaRepository.save(tarea);
        }
        return null;
    }
    @Override
    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
