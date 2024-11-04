package com.project.gestionTareas.todo_app_backend.controller;


import com.project.gestionTareas.todo_app_backend.entities.Tarea;
import com.project.gestionTareas.todo_app_backend.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v0/task")
public class TareaController {


    @Autowired
    private TareaService tareaService;

    @GetMapping("/list")
    public List<Tarea> listarTareas(){
        return tareaService.getAllTareas();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<Tarea> listarTareaId(@PathVariable Long id){
        Optional<Tarea> tarea =  tareaService.getTareaById(id);
        return tarea.map(value -> ResponseEntity.ok().body(value))
                .orElse(null);
    }

    @PostMapping("/create")
    public  ResponseEntity<Tarea> guardarTarea(@RequestBody Tarea tarea){
        Tarea tareaGuardada = tareaService.createTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaGuardada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id , @RequestBody Tarea tarea){
        Tarea tareaUpdate = tareaService.updateTarea(id,tarea);
   if (tareaUpdate != null){
       return ResponseEntity.ok().body(tareaUpdate);
   }else {
       return ResponseEntity.notFound().build();
   }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>eliminarTarea(@PathVariable Long id){
        tareaService.deleteTarea(id);
        return ResponseEntity.noContent().build();
    }

}
